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
@ApiModel("数据字典")
public class Dictionary extends BaseEntity {
    @ApiModelProperty(value = "字典类别")
    @ManyToOne(fetch = FetchType.EAGER)
    private DictionaryCategory dictionaryCategory;
    @ApiModelProperty("字典名称")
    @Column(length = 100)
    private String name;
    @ApiModelProperty("字典代码")
    @Column(length = 100)
    private String code;
}
