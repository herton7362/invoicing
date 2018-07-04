package com.herton.module.attachment.domain;

import com.herton.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Setter
@Getter
public class Attachment extends BaseEntity {
    @Column(length = 500)
    private String path;
    @Column(length = 200)
    private String name;
    @Column(length = 50)
    private String format;
    private Long size;
}
