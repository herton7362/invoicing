package com.herton.module.goods.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.module.goods.domain.GoodsCategory;
import com.herton.module.goods.domain.GoodsCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class GoodsCategoryServiceImpl extends AbstractCrudService<GoodsCategory> implements GoodsCategoryService {
    private final GoodsCategoryRepository goodsCategoryRepository;
    @Override
    protected PageRepository<GoodsCategory> getRepository() {
        return goodsCategoryRepository;
    }

    @Autowired
    public GoodsCategoryServiceImpl(GoodsCategoryRepository goodsCategoryRepository) {
        this.goodsCategoryRepository = goodsCategoryRepository;
    }
}
