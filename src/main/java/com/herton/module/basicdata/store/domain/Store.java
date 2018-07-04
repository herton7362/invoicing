package com.herton.module.basicdata.store.domain;

import com.herton.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Setter
@Getter
public class Store extends BaseEntity {
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String code;
    @Column(length = 36)
    private String warehouseId;
    @Column(length = 8)
    private String startBusinessTime;
    @Column(length = 8)
    private String closeBusinessTime;
    @Column(length = 200)
    private String description;
    @Column(length = 36)
    private String storeManagerId;
    @Column(length = 36)
    private String addressId;
    @Column(length = 20)
    private String zipCode;
    @Column(length = 400)
    private String detailAddress;
    @Column(length = 20)
    private String linkman;
    @Column(length = 20)
    private String mobile;
    @Column(length = 20)
    private String telephone;
    @Column(length = 20)
    private String fax;
    @Column(length = 200)
    private String remark;
}
