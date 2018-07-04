package com.herton.module.auth.domain;

import com.herton.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * 模块
 * @author tang he
 * @since 1.0.0
 */
@Entity
@Setter
@Getter
public class Module extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    private Module parent;
    @Column(length = 50)
    private String name;
    @Column(length = 100)
    private String code;
    @Column(length = 500)
    private String url;
    @Column(length = 10)
    private String type;
    @Column(length = 500)
    private String naviNamePath;
    @Column(length = 500)
    private String naviIdPath;
    @Column(length = 100)
    private String icon;

    public enum Type {
        MENU, FUNCTION
    }
}
