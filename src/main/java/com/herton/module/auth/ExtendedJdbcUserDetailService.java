package com.herton.module.auth;

import com.herton.entity.BaseUser;
import com.herton.module.auth.JdbcUserDetailService;
import com.herton.module.auth.UserThread;
import com.herton.module.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class ExtendedJdbcUserDetailService extends JdbcUserDetailService implements UserDetailsService {
    private final UserService adminService;
    @Autowired
    public ExtendedJdbcUserDetailService(
            UserService adminService
    ) {
        super(adminService);
        this.adminService = adminService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BaseUser user;
        try {
            user = adminService.findOneByLoginName(username);
        } catch (Exception e) {
            throw new UsernameNotFoundException(String.format("username: %s not found", username));
        }

        if(user == null) {
            throw new UsernameNotFoundException(String.format("username: %s not found", username));
        }
        return new User(username, user.getPassword(), Collections.singletonList(new SimpleGrantedAuthority(user.getUserType())));
    }
}
