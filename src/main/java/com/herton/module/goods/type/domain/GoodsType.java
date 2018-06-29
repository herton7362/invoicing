package com.herton.module.goods.type.domain;

import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Setter
@Getter
@ApiModel("商品类型")
public class GoodsType extends BaseEntity {
    @ApiModelProperty(value = "类型名称")
    @Column(length = 100)
    private String name;
}
