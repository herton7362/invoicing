package com.herton.module.address.domain;

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
public class Address extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    private Address parent;
    @Column(length = 100)
    private String name;
    @Column(length = 50)
    private String level;

    public enum Level {
        PROVINCE,
        CITY,
        AREA,
        COUNTY
    }
}
