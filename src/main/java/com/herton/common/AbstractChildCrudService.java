package com.herton.common;

import com.herton.common.utils.ReflectionUtils;
import com.herton.dto.BaseDTO;
import com.herton.dto.Parent;
import com.herton.entity.BaseEntity;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractChildCrudService<E extends BaseEntity, D extends BaseDTO<D, E>>
        extends AbstractCrudService<E, D> implements ChildCurdService<E, D> {
    @Override
    public List<D> saveAsChildren(String parentId, List<D> dList) throws Exception {
        Field parentField = baseDTO.getParentField((Class<D>) baseDTO.getClass());
        String parentFieldName = parentField.getName();
        if(dList != null) {
            for (D d : dList) {
                ReflectionUtils.setFieldValue(d, parentFieldName, parentId);
            }
        }

        Map<String, String> params = new HashMap<>();
        params.put(parentFieldName, parentId);
        List<D> oldList = findAll(params);
        if(oldList == null || oldList.isEmpty()) {
            return save(dList);
        }

        delete(filterNoneIncludes(oldList, dList));
        save(filterIncludes(dList, oldList));
        save(filterNoneIncludes(dList, oldList));
        return dList;
    }

    private List<D> filterNoneIncludes(List<D> source, List<D> sample) {
        if(source == null) {
            return null;
        }
        if(sample == null) {
            return source;
        }
        return source.stream().filter(old -> sample.stream().noneMatch(d -> d.equals(old)))
                .collect(Collectors.toList());
    }

    private List<D> filterIncludes(List<D> source, List<D> sample) {
        if(source == null) {
            return null;
        }
        if(sample == null) {
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
