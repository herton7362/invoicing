package com.herton.dto;

import com.herton.common.ChildCurdService;
import com.herton.common.CrudService;
import com.herton.common.utils.ReflectionUtils;
import com.herton.common.utils.SpringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 可以根据Parent和Children注解来保存数据
 * 例：
 * <code>
 * public class GoodsDTO extends BaseDTO<GoodsDTO, Goods> {
 *
 * @Children(service = GoodsAttributeService.class)
 * private List<GoodsAttributeDTO> goodsAttributes;
 * // 省略get set
 * }
 * <p>
 * public class GoodsAttributeDTO extends BaseDTO<GoodsAttributeDTO, GoodsAttribute> {
 * @Parent private String goodsId;
 * // 省略get set
 * }
 * <p>
 * GoodsDTO dto = new GoodsDTO();
 * // 省略赋值
 * CascadePersistHelper.saveChildren(dto);则会相应的将goodsAttributes也进行保存
 * </code>
 */
public class CascadePersistHelper {
    public static <D extends BaseDTO> void saveChildren(D d) {
        List<Field> childrenFields = BaseDTO.getChildrenFields(d.getClass());
        if (!childrenFields.isEmpty()) {
            for (Field childrenField : childrenFields) {
                saveChildren(d, childrenField);
            }
        }
    }

    /**
     * 保存实体d中的子集，需要在DTO中在子集上使用@Children注解并指明service类
     * @param d 父实体
     * @param childrenField 子集的字段
     */
    private static <D extends BaseDTO> void saveChildren(final D d, Field childrenField) {
        Children children = childrenField.getAnnotation(Children.class);
        ChildCurdService childCurdService = SpringUtils.getBean(children.service());
        List list = (List) ReflectionUtils.getFieldValue(d, childrenField.getName());
        ParameterizedType type = (ParameterizedType) childrenField.getGenericType();
        Type[] genericTypes = type.getActualTypeArguments();
        saveAsChildren(d, (Class<D>) genericTypes[0], list, childCurdService);
    }

    /**
     * 先删除新传入集合中有的旧集合没有的数据
     * 再更新新集合在旧集合中的数据
     * 然后新增新集合有的旧集合没有的数据
     * @param parent      父对象
     * @param dList       子对象集合
     * @param crudService 子对象service类
     * @param <P>         父对象
     * @param <D>         子对象
     * @return 保存的子对象
     */
    public static <P extends BaseDTO,
            D extends BaseDTO> List<D> saveAsChildren(P parent, Class<D> childClass,
                                                      List<D> dList, CrudService crudService) {
        Field parentField = BaseDTO.getParentField(childClass);
        String parentFieldName = parentField.getName();
        if (dList != null) {
            for (D d : dList) {
                ReflectionUtils.setFieldValue(d, parentFieldName, parent.getId());
            }
        }

        Map<String, String> params = new HashMap<>();
        params.put(parentFieldName, parent.getId());
        List<D> oldList = crudService.findAll(params);
        if (oldList == null || oldList.isEmpty()) {
            return crudService.save(dList);
        }

        crudService.delete(filterNoneIncludes(oldList, dList));
        crudService.save(filterIncludes(dList, oldList));
        crudService.save(filterNoneIncludes(dList, oldList));
        return dList;
    }

    private static <D extends BaseDTO> List<D> filterNoneIncludes(List<D> source, List<D> sample) {
        if (source == null) {
            return null;
        }
        if (sample == null) {
            return source;
        }
        return source.stream().filter(old -> sample.stream().noneMatch(d -> d.equals(old)))
                .collect(Collectors.toList());
    }

    private static <D extends BaseDTO> List<D> filterIncludes(List<D> source, List<D> sample) {
        if (source == null) {
            return null;
        }
        if (sample == null) {
            return null;
        }
        return source.stream().filter(data -> sample.stream().anyMatch(d -> d.equals(data)))
                .map(data -> {
                    Field[] fields = ReflectionUtils.getDeclaredFields(BaseDTO.class);
                    D old = sample.stream().filter(d -> d.equals(data)).findFirst().get();
                    for (Field field : fields) {
                        ReflectionUtils.setFieldValue(data, field.getName(),
                                ReflectionUtils.getFieldValue(old, field.getName()));
                    }
                    return data;
                })
                .collect(Collectors.toList());
    }
}
