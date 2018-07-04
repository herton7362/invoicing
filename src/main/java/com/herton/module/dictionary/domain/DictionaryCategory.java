package com.herton.module.dictionary.domain;

import com.herton.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Setter
@Getter
public class DictionaryCategory extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    private DictionaryCategory parent;
    @Column(length = 100)
    private String name;
    @Column(length = 100)
    private String code;
}
