package com.herton.dto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.ParameterizedType;

@Slf4j
public class SimpleDTOConverter<A, B> extends DTOConverter<A, B> {
    Class<B> clazzB;
    Class<A> clazzA;

    public SimpleDTOConverter() {
        clazzB = (Class<B>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        clazzA = (Class<A>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    protected B doForward(A a) {
        try {
            B b = clazzB.newInstance();
            BeanUtils.copyProperties(a, b);
            return b;
        } catch (InstantiationException e) {
            log.error("DTO转换出现错误", e);
        } catch (IllegalAccessException e) {
            log.error("DTO转换出现错误", e);
        }
        return null;
    }

    @Override
    protected A doBackward(B b) {

        try {
            A a = clazzA.newInstance();
            BeanUtils.copyProperties(b, a);
            return a;
        } catch (InstantiationException e) {
            log.error("DTO转换出现错误", e);
        } catch (IllegalAccessException e) {
            log.error("DTO转换出现错误", e);
        }
        return null;
    }
}
