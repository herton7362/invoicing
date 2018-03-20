package com.herton.module.goods.property.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.module.goods.property.domain.GoodsProperty;
import com.herton.module.goods.property.domain.GoodsPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class GoodsPropertyServiceImpl extends AbstractCrudService<GoodsProperty> implements GoodsPropertyService {
    private final GoodsPropertyRepository goodsPropertyCategoryRepository;
    @Override
    protected PageRepository<GoodsProperty> getRepository() {
        return goodsPropertyCategoryRepository;
    }

    @Autowired
    public GoodsPropertyServiceImpl(GoodsPropertyRepository goodsPropertyCategoryRepository) {
        this.goodsPropertyCategoryRepository = goodsPropertyCategoryRepository;
    }
}
