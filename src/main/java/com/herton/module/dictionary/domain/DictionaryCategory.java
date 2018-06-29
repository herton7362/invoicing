package com.herton.module.dictionary.domain;

import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Setter
@Getter
@ApiModel("字典类别")
public class DictionaryCategory extends BaseEntity {
    @ApiModelProperty(value = "上级类别")
    @ManyToOne(fetch = FetchType.EAGER)
    private DictionaryCategory parent;
    @ApiModelProperty("类别名称")
    @Column(length = 100)
    private String name;
    @ApiModelProperty("类别代码")
    @Column(length = 100)
    private String code;
}
