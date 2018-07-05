package com.herton.common;

import com.herton.common.utils.ReflectionUtils;
import com.herton.dto.BaseDTO;
import com.herton.dto.ParentField;
import com.herton.entity.BaseEntity;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractChildCrudService<E extends BaseEntity, D extends BaseDTO<D, E>>
        extends AbstractCrudService<E, D> implements ChildCurdService<E, D> {
    @Override
    public List<D> saveAsChildren(List<D> dList) throws Exception {
        if(dList == null || dList.isEmpty()) {
            return dList;
        }

        Field[] fields = ReflectionUtils.getDeclaredFields(baseDTO.getClass());

        Field parentField = null;
        for (Field field : fields) {
            if(field.getAnnotation(ParentField.class) != null) {
                parentField = field;
                break;
            }
        }
        if(parentField == null) {
            throw new RuntimeException("实体" + baseDTO.toString() + "需要@ParnetField注解来指定父级字段");
        }
        String parentId = (String) ReflectionUtils.getFieldValue(dList.get(0), parentField.getName());
        String parentFieldName = parentField.getName();
        for (D d : dList) {
            if(ReflectionUtils.getFieldValue(d, parentFieldName) == null) {
                throw new RuntimeException("属性" + parentFieldName + "不能为空");
            }
        }
        Map<String, String> params = new HashMap<>();
        params.put(parentFieldName, parentId);
        List<D> oldList = findAll(params);
        if(oldList == null || oldList.isEmpty()) {
            return save(dList);
        }

        delete(filterNoneIncludes(oldList, dList));
        save(filterNoneIncludes(dList, oldList));
        return dList;
    }

    private List<D> filterNoneIncludes(List<D> source, List<D> sample) {
        return source.stream().filter(old -> sample.stream().noneMatch(d -> d.equals(old)))
                .collect(Collectors.toList());
    }
}
