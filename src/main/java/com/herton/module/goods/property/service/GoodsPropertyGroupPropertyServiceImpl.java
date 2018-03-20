package com.herton.module.goods.property.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.module.goods.property.domain.GoodsPropertyGroupProperty;
import com.herton.module.goods.property.domain.GoodsPropertyGroupPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class GoodsPropertyGroupPropertyServiceImpl extends AbstractCrudService<GoodsPropertyGroupProperty> implements GoodsPropertyGroupPropertyService {
    private final GoodsPropertyGroupPropertyRepository goodsPropertyGroupPropertyRepository;
    @Override
    protected PageRepository<GoodsPropertyGroupProperty> getRepository() {
        return goodsPropertyGroupPropertyRepository;
    }

    @Autowired
    public GoodsPropertyGroupPropertyServiceImpl(GoodsPropertyGroupPropertyRepository goodsPropertyGroupPropertyRepository) {
        this.goodsPropertyGroupPropertyRepository = goodsPropertyGroupPropertyRepository;
    }
}
