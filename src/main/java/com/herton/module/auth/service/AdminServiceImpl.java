package com.herton.module.auth.service;

import com.herton.common.AbstractCrudService;
import com.herton.entity.BaseUser;
import com.herton.module.auth.domain.Admin;
import com.herton.module.auth.domain.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class AdminServiceImpl extends AbstractCrudService<Admin> implements AdminService, UserService {
    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin save(Admin admin) throws Exception {
        if(admin.getId() == null) {
            if(admin.getPassword() == null) {
                admin.setPassword("123456");
            }
            admin.setPassword(new BCryptPasswordEncoder().encode(admin.getPassword()));
        } else {
            if(admin.getPassword() == null) {
                Admin temp = adminRepository.findOne(admin.getId());
                admin.setPassword(temp.getPassword());
            } else {
                admin.setPassword(new BCryptPasswordEncoder().encode(admin.getPassword()));
            }
        }
        return super.save(admin);
    }

    @Override
    public BaseUser findOneByLoginName(String account) throws Exception {
        return adminRepository.findOneByLoginName(account);
    }

    @Override
    public BaseUser findOneByLoginNameAndClientId(String account, String clientId) throws Exception {
        return adminRepository.findOneByLoginNameAndClientId(account, clientId);
    }

    @Override
    protected AdminRepository getRepository() {
        return adminRepository;
    }

}
