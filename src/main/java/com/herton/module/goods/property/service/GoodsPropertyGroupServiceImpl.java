package com.herton.module.goods.property.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.module.goods.property.domain.GoodsPropertyGroup;
import com.herton.module.goods.property.domain.GoodsPropertyGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class GoodsPropertyGroupServiceImpl extends AbstractCrudService<GoodsPropertyGroup> implements GoodsPropertyGroupService {
    private final GoodsPropertyGroupRepository goodsPropertyGroupRepository;
    @Override
    protected PageRepository<GoodsPropertyGroup> getRepository() {
        return goodsPropertyGroupRepository;
    }

    @Autowired
    public GoodsPropertyGroupServiceImpl(GoodsPropertyGroupRepository goodsPropertyGroupRepository) {
        this.goodsPropertyGroupRepository = goodsPropertyGroupRepository;
    }
}
