package com.herton.common;

import com.herton.entity.BaseEntity;
import com.herton.entity.BaseUser;
import com.herton.module.auth.UserThread;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.Date;

public class ExtendedJpaRepository<T extends BaseEntity> extends SimpleJpaRepository<T, String> implements PageRepository<T> {
    /**
     * Creates a new {@link ExtendedJpaRepository} for the given {@link JpaEntityInformation} and {@link EntityManager}.
     *
     * @param entityInformation must not be {@literal null}.
     * @param entityManager must not be {@literal null}.
     */
    public ExtendedJpaRepository(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    @Override
    @Transactional
    public <S extends T> S save(S entity) {
        Assert.notNull(entity, "entity need be initialized");
        if (StringUtils.isEmpty(entity.getId())) {
            entity.setCreatedDate(new Date());
            BaseUser user = UserThread.getInstance().get();
            if(user != null) {
                entity.setCreateUserId(user.getId());
            }
        }

        if(entity.getCreateUserId() == null || entity.getCreatedDate() == null) {
            T old = findOne(entity.getId());
            entity.setCreateUserId(old.getCreateUserId());
            entity.setCreatedDate(old.getCreatedDate());
        }

        entity.setClientId(UserThread.getInstance().getClientId());

        entity.setSortNumber(entity.getSortNumber() == null?0: entity.getSortNumber());
        if(entity.getLogicallyDeleted() == null) {
            entity.setLogicallyDeleted(false);
        }
        entity.setUpdatedDate(new Date());
        return super.save(entity);
    }
}
