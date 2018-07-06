package com.herton.dto;

import com.herton.common.ChildCurdService;
import com.herton.common.utils.ReflectionUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 针对一对多关系，在dto保存的时候可以自动将该注解标注的值保存
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Children {
    /**
     * 当前子类的service类
     * @return
     */
    Class<? extends ChildCurdService> service();
}
