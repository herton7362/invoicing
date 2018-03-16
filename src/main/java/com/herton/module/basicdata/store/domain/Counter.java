package com.herton.module.basicdata.store.domain;

import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@ApiModel("收银台")
public class Counter extends BaseEntity {
    @ApiModelProperty(value = "收银台名称")
    @Column(length = 50)
    private String name;
    @ApiModelProperty(value = "收银台编号")
    @Column(length = 50)
    private String code;
    @ApiModelProperty(value = "门店id")
    @Column(length = 36)
    private String StoreId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStoreId() {
        return StoreId;
    }

    public void setStoreId(String storeId) {
        StoreId = storeId;
    }
}
