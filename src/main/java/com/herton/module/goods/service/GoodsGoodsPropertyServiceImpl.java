package com.herton.module.goods.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.module.goods.domain.GoodsGoodsProperty;
import com.herton.module.goods.domain.GoodsGoodsPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class GoodsGoodsPropertyServiceImpl extends AbstractCrudService<GoodsGoodsProperty> implements GoodsGoodsPropertyService {
    private final GoodsGoodsPropertyRepository goodsGoodsPropertyRepository;
    @Override
    protected PageRepository<GoodsGoodsProperty> getRepository() {
        return goodsGoodsPropertyRepository;
    }

    @Autowired
    public GoodsGoodsPropertyServiceImpl (GoodsGoodsPropertyRepository goodsGoodsPropertyRepository) {
        this.goodsGoodsPropertyRepository = goodsGoodsPropertyRepository;
    }
}
