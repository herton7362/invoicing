package com.herton.module.goods.property.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.module.goods.property.domain.GoodsPropertyGroupPropertyValue;
import com.herton.module.goods.property.domain.GoodsPropertyGroupPropertyValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class GoodsPropertyGroupPropertyValueServiceImpl extends AbstractCrudService<GoodsPropertyGroupPropertyValue>
        implements GoodsPropertyGroupPropertyValueService {
    private final GoodsPropertyGroupPropertyValueRepository goodsPropertyGroupPropertyValueRepository;
    @Override
    protected PageRepository<GoodsPropertyGroupPropertyValue> getRepository() {
        return goodsPropertyGroupPropertyValueRepository;
    }

    @Autowired
    public GoodsPropertyGroupPropertyValueServiceImpl(
            GoodsPropertyGroupPropertyValueRepository goodsPropertyGroupPropertyValueRepository
    ) {
        this.goodsPropertyGroupPropertyValueRepository = goodsPropertyGroupPropertyValueRepository;
    }
}
