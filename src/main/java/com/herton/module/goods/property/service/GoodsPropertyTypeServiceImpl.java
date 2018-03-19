package com.herton.module.goods.property.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.module.goods.property.domain.GoodsPropertyType;
import com.herton.module.goods.property.domain.GoodsPropertyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class GoodsPropertyTypeServiceImpl extends AbstractCrudService<GoodsPropertyType> implements GoodsPropertyTypeService {
    private final GoodsPropertyTypeRepository goodsPropertyTypeRepository;
    @Override
    protected PageRepository<GoodsPropertyType> getRepository() {
        return goodsPropertyTypeRepository;
    }

    @Autowired
    public GoodsPropertyTypeServiceImpl(GoodsPropertyTypeRepository goodsPropertyTypeRepository) {
        this.goodsPropertyTypeRepository = goodsPropertyTypeRepository;
    }
}
