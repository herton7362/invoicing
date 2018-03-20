package com.herton.module.goods.property.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.module.goods.property.domain.GoodsPropertyValue;
import com.herton.module.goods.property.domain.GoodsPropertyValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class GoodsPropertyValueServiceImpl extends AbstractCrudService<GoodsPropertyValue> implements GoodsPropertyValueService {
    private final GoodsPropertyValueRepository goodsPropertyRepository;
    @Override
    protected PageRepository<GoodsPropertyValue> getRepository() {
        return goodsPropertyRepository;
    }

    @Autowired
    public GoodsPropertyValueServiceImpl(GoodsPropertyValueRepository goodsPropertyRepository) {
        this.goodsPropertyRepository = goodsPropertyRepository;
    }
}
