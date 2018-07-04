package com.herton.module.goods.domain;

import com.herton.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Setter
@Getter
public class GoodsCategory extends BaseEntity {
    @Column(length = 36)
    private String parentId;
    @Column(length = 50)
    private String name;
}
