package com.herton.module.goods.domain;

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
@ApiModel("商品分类")
public class GoodsCategory extends BaseEntity {
    @ApiModelProperty(value = "上级分类id")
    @Column(length = 36)
    private String parentId;
    @ApiModelProperty(value = "名称")
    @Column(length = 50)
    private String name;
}
