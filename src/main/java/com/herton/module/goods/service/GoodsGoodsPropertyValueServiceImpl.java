package com.herton.module.goods.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.module.goods.domain.GoodsGoodsPropertyValue;
import com.herton.module.goods.domain.GoodsGoodsPropertyValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class GoodsGoodsPropertyValueServiceImpl extends AbstractCrudService<GoodsGoodsPropertyValue> implements GoodsGoodsPropertyValueService {
    private final GoodsGoodsPropertyValueRepository goodsGoodsPropertyValueRepository;
    @Override
    protected PageRepository<GoodsGoodsPropertyValue> getRepository() {
        return goodsGoodsPropertyValueRepository;
    }

    @Autowired
    public GoodsGoodsPropertyValueServiceImpl(GoodsGoodsPropertyValueRepository goodsGoodsPropertyValueRepository) {
        this.goodsGoodsPropertyValueRepository = goodsGoodsPropertyValueRepository;
    }
}
