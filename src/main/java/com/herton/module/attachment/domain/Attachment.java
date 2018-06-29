package com.herton.module.attachment.domain;

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
@ApiModel("附件")
public class Attachment extends BaseEntity {
    @ApiModelProperty(value = "附件存储路径")
    @Column(length = 500)
    private String path;
    @ApiModelProperty(value = "附件名称")
    @Column(length = 200)
    private String name;
    @ApiModelProperty(value = "附件格式")
    @Column(length = 50)
    private String format;
    @ApiModelProperty(value = "附件大小")
    private Long size;
}
