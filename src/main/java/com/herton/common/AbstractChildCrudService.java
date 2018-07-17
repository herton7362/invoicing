package com.herton.common;

import com.herton.common.utils.ReflectionUtils;
import com.herton.dto.BaseDTO;
import com.herton.dto.CascadePersistHelper;
import com.herton.dto.Parent;
import com.herton.entity.BaseEntity;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractChildCrudService<E extends BaseEntity, D extends BaseDTO<D, E>>
        extends AbstractCrudService<E, D> implements ChildCurdService<E, D> {
    @Override
    public <P extends BaseDTO> List<D> saveAsChildren(P parent, List<D> dList) throws Exception {

        return CascadePersistHelper.saveAsChildren(parent, _getGenericType(), dList, this);
    }

    private Class<D> _getGenericType() {
        Type genericType = this.getClass().getGenericSuperclass();
        ParameterizedType type = (ParameterizedType)genericType;
        Type[] genericTypes = type.getActualTypeArguments();
        return (Class<D>) genericTypes[0];
    }

}
