package com.herton.module.basicdata.store.domain;

import com.herton.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Setter
@Getter
public class Counter extends BaseEntity {
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String code;
    @Column(length = 36)
    private String StoreId;
}
