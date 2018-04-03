package com.herton.module.goods.sku.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.module.goods.sku.domain.GoodsSku;
import com.herton.module.goods.sku.domain.GoodsSkuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class GoodsSkuServiceImpl extends AbstractCrudService<GoodsSku> implements GoodsSkuService {
    private final GoodsSkuRepository goodsSkuRepository;
    @Override
    protected PageRepository<GoodsSku> getRepository() {
        return goodsSkuRepository;
    }

    @Autowired
    public GoodsSkuServiceImpl(GoodsSkuRepository goodsSkuRepository) {
        this.goodsSkuRepository = goodsSkuRepository;
    }
}
