package com.herton.module.goods.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.module.goods.domain.GoodsPrice;
import com.herton.module.goods.domain.GoodsPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class GoodsPriceServiceImpl extends AbstractCrudService<GoodsPrice> implements GoodsPriceService {
    private final GoodsPriceRepository goodsPriceRepository;
    @Override
    protected PageRepository<GoodsPrice> getRepository() {
        return goodsPriceRepository;
    }

    @Autowired
    public GoodsPriceServiceImpl(GoodsPriceRepository goodsPriceRepository) {
        this.goodsPriceRepository = goodsPriceRepository;
    }
}
