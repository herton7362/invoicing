package com.herton.dto;

import com.herton.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseDTO<E extends BaseEntity> {
    @Autowired
    protected  DTOConverter<BaseDTO<E>, E> converter;
    public E convert() {
        return converter.convert(this);
    }
    public <D extends BaseDTO<E>> D convertFor(E e) {
        return (D) converter.reverse().convert(e);
    }
}
