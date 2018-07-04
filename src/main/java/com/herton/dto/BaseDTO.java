package com.herton.dto;

import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseDTO<D extends BaseDTO, E extends BaseEntity> {
    @ApiModelProperty(value = "主键")
    private String id;
    @ApiModelProperty(value = "排序号")
    private Integer sortNumber;
    @ApiModelProperty(value = "是否逻辑删除")
    private Boolean logicallyDeleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getSortNumber() {
        return sortNumber;
    }

    public void setSortNumber(Integer sortNumber) {
        this.sortNumber = sortNumber;
    }

    public Boolean getLogicallyDeleted() {
        return logicallyDeleted;
    }

    public void setLogicallyDeleted(Boolean logicallyDeleted) {
        this.logicallyDeleted = logicallyDeleted;
    }

    @Autowired
    protected  DTOConverter<D, E> converter;

    @SuppressWarnings("unchecked")
    public E convert() {
        return converter.convert((D) this);
    }
    public D convertFor(E e) {
        return converter.reverse().convert(e);
    }
}
