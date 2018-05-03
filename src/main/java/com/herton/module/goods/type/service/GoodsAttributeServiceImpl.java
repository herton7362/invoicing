package com.herton.module.goods.type.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.module.goods.type.domain.GoodsAttribute;
import com.herton.module.goods.type.domain.GoodsAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class GoodsAttributeServiceImpl extends AbstractCrudService<GoodsAttribute> implements GoodsAttributeService {
    private final GoodsAttributeRepository goodsAttributeRepository;
    @Override
    protected PageRepository<GoodsAttribute> getRepository() {
        return goodsAttributeRepository;
    }

    @Autowired
    public GoodsAttributeServiceImpl(GoodsAttributeRepository goodsAttributeRepository) {
        this.goodsAttributeRepository = goodsAttributeRepository;
    }
}
