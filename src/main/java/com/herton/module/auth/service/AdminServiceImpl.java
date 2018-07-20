package com.herton.module.auth.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.common.PageResult;
import com.herton.entity.BaseUser;
import com.herton.module.auth.domain.Admin;
import com.herton.module.auth.domain.AdminRepository;
import com.herton.module.auth.dto.AdminDTO;
import org.hibernate.SQLQuery;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@Transactional
public class AdminServiceImpl extends AbstractCrudService<Admin, AdminDTO> implements AdminService, UserService {
    private final EntityManager entityManager;
    private final AdminRepository adminRepository;

    @Override
    public PageResult<AdminDTO> findAll(PageRequest pageRequest, Map<String, ?> param) {
        Page<Admin> page = pageRepository.findAll(new AdminSpecification(param), pageRequest);
        List<AdminDTO> dList = new ArrayList<>();
        for (Admin admin : page.getContent()) {
            dList.add(baseDTO.convertFor(admin));
        }
        PageResult pageResult = new PageResult(page);
        pageResult.setContent(dList);
        return pageResult;
    }

    @Override
    public AdminDTO save(AdminDTO admin) {
        if(admin.getId() == null) {
            if(admin.getPassword() == null) {
                admin.setPassword("123456");
            }
            admin.setPassword(new BCryptPasswordEncoder().encode(admin.getPassword()));
        } else {
            if(admin.getPassword() == null) {
                Admin temp = pageRepository.findOne(admin.getId());
                admin.setPassword(temp.getPassword());
            } else {
                admin.setPassword(new BCryptPasswordEncoder().encode(admin.getPassword()));
            }
        }
        return super.save(admin);
    }

    @Override
    public BaseUser findOneByLoginName(String account) {
        return adminRepository.findOneByLoginName(account);
    }

    @Override
    public BaseUser findOneByLoginNameAndClientId(String account, String clientId) {
        return adminRepository.findOneByLoginNameAndClientId(account, clientId);
    }

    class AdminSpecification extends SimpleSpecification {

        AdminSpecification(Map<String, ?> params) {
            super(params, false);
        }

        @Override
        public Predicate toPredicate(Root<Admin> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            Predicate predicate = super.toPredicate(root, criteriaQuery, criteriaBuilder);
            List<Predicate> predicates = new ArrayList<>();
            if(params.containsKey("roleId")) {
                Query query = entityManager.createNativeQuery("select ar.admin_id from admin_roles ar where ar.role_id=:roleId");
                query.setParameter("roleId", params.get("roleId")[0]);
                query.unwrap(SQLQuery.class).setResultTransformer(new ResultTransformer() {
                    @Override
                    public Object transformTuple(Object[] objects, String[] strings) {
                        return objects[0];
                    }

                    @Override
                    public List transformList(List list) {
                        return list;
                    }
                });
                List list = query.getResultList();
                if(!list.isEmpty()) {
                    predicates.add(criteriaBuilder.in(root.get("id")).value(list));
                } else {
                    predicates.add(criteriaBuilder.isNull(root.get("id")));
                }
            }
            predicates.add(predicate);
            return criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
        }
    }

    @Autowired
    public AdminServiceImpl(
            EntityManager entityManager,
            AdminRepository adminRepository
    ) {
        this.entityManager = entityManager;
        this.adminRepository = adminRepository;
    }
}
