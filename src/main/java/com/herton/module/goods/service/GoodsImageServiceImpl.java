package com.herton.module.goods.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.module.goods.domain.GoodsImage;
import com.herton.module.goods.domain.GoodsImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class GoodsImageServiceImpl extends AbstractCrudService<GoodsImage> implements GoodsImageService {
    private final GoodsImageRepository goodsImageRepository;
    @Override
    protected PageRepository<GoodsImage> getRepository() {
        return goodsImageRepository;
    }

    @Autowired
    public GoodsImageServiceImpl(GoodsImageRepository goodsImageRepository) {
        this.goodsImageRepository = goodsImageRepository;
    }
}
