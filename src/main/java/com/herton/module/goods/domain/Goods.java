package com.herton.module.goods.domain;

import com.herton.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Setter
@Getter
public class Goods extends BaseEntity {
    @Column(length = 36)
    private String goodsCategoryId;
    @Column(length = 200)
    private String barcode;
    @Column(length = 200)
    private String name;
    @Column(length = 50)
    private String code;
    @Column(length = 50)
    private String shortname;
    @Column(length = 50)
    private String pinyin;
    @Column(length = 36)
    private String brandId;
    @Column(length = 36)
    private String goodsTypeId;
    @Column(length = 50)
    private String madeAddress;
    private String coverImageId;
    @Column(length = 100)
    private String standard;
    @Column(length = 100)
    private String model;
    @Column(length = 11, scale = 2, precision = 13)
    private Double retailPrice;
    @Column(length = 11, scale = 2, precision = 13)
    private Double weight;
    @Column(length = 11, scale = 2, precision = 13)
    private Double length;
    @Column(length = 11, scale = 2, precision = 13)
    private Double width;
    @Column(length = 11, scale = 2, precision = 13)
    private Double height;
    @Column(length = 11, scale = 2, precision = 13)
    private Double costPrice;
    @Column(length = 11, scale = 2, precision = 13)
    private Double stockNumber;
    @Column(length = 11, scale = 2, precision = 13)
    private Double stockWarnNumber;
    @Column(length = 200)
    private String remark;
}
