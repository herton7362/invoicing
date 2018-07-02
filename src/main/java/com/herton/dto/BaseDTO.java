package com.herton.dto;

public abstract class BaseDTO<T> {
    public abstract T convert();
    public abstract BaseDTO convertFor(T t);
}
