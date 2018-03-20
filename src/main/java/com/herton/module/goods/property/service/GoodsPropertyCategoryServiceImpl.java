package com.herton.module.goods.property.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.module.goods.property.domain.GoodsPropertyCategory;
import com.herton.module.goods.property.domain.GoodsPropertyCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class GoodsPropertyCategoryServiceImpl extends AbstractCrudService<GoodsPropertyCategory> implements GoodsPropertyCategoryService {
    private final GoodsPropertyCategoryRepository goodsPropertyTypeRepository;
    @Override
    protected PageRepository<GoodsPropertyCategory> getRepository() {
        return goodsPropertyTypeRepository;
    }

    @Autowired
    public GoodsPropertyCategoryServiceImpl(GoodsPropertyCategoryRepository goodsPropertyTypeRepository) {
        this.goodsPropertyTypeRepository = goodsPropertyTypeRepository;
    }
}
