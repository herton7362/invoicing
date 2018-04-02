package com.herton.module.auth.domain;


import com.herton.common.PageRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends PageRepository<Role> {
    @Query(value = "select count(*) from admin_roles ar where ar.role_id=?1", nativeQuery = true)
    Integer getStaffAccountMount(String id);
}
