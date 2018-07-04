package com.herton.module.auth.domain;

import com.herton.entity.BaseUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * 管理员
 * @author tang he
 * @since 1.0.0
 */
@Entity
@Setter
@Getter
public class Admin extends BaseUser {
    @Column(length = 20)
    private String name;
    @Column(length = 200)
    private String avatar;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="admin_roles",joinColumns={@JoinColumn(name="admin_id")},inverseJoinColumns={@JoinColumn(name="role_id")})
    private List<Role> roles;
}
