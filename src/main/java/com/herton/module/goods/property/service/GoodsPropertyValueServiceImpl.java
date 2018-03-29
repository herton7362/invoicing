package com.herton.module.goods.property.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.exceptions.BusinessException;
import com.herton.module.goods.domain.GoodsGoodsPropertyValue;
import com.herton.module.goods.property.domain.GoodsPropertyValue;
import com.herton.module.goods.property.domain.GoodsPropertyValueRepository;
import com.herton.module.goods.service.GoodsGoodsPropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Transactional
public class GoodsPropertyValueServiceImpl extends AbstractCrudService<GoodsPropertyValue> implements GoodsPropertyValueService {
    private final GoodsPropertyValueRepository goodsPropertyRepository;
    private final GoodsGoodsPropertyValueService goodsGoodsPropertyValueService;
    private final GoodsPropertyGroupPropertyValueService goodsPropertyGroupPropertyValueService;
    @Override
    protected PageRepository<GoodsPropertyValue> getRepository() {
        return goodsPropertyRepository;
    }

    @Override
    public void delete(String id) throws Exception {
        this.checkUsed(id);
        this.deleteGoodsPropertyGroupPropertyValue(id);
        super.delete(id);
    }

    @Override
    public void delete(Iterable<? extends GoodsPropertyValue> goodsPropertyValues) throws Exception {
        for (GoodsPropertyValue goodsPropertyValue : goodsPropertyValues) {
            this.checkUsed(goodsPropertyValue.getId());
            this.deleteGoodsPropertyGroupPropertyValue(goodsPropertyValue.getId());
        }
        super.delete(goodsPropertyValues);
    }

    private void checkUsed(String id) throws Exception {
        Map<String, String> param = new HashMap<>();
        param.put("goodsPropertyValueId", id);
        Long count = goodsGoodsPropertyValueService.count(param);
        if(count > 0) {
            throw new BusinessException("当前属性已经被商品使用，不能删除");
        }
    }

    private void deleteGoodsPropertyGroupPropertyValue(String id) throws Exception {
        Map<String, String> param = new HashMap<>();
        param.put("goodsPropertyValueId", id);
        goodsPropertyGroupPropertyValueService.delete(goodsPropertyGroupPropertyValueService.findAll(param));
    }

    @Autowired
    public GoodsPropertyValueServiceImpl(
            GoodsPropertyValueRepository goodsPropertyRepository,
            GoodsGoodsPropertyValueService goodsGoodsPropertyValueService,
            GoodsPropertyGroupPropertyValueService goodsPropertyGroupPropertyValueService
    ) {
        this.goodsPropertyRepository = goodsPropertyRepository;
        this.goodsGoodsPropertyValueService = goodsGoodsPropertyValueService;
        this.goodsPropertyGroupPropertyValueService = goodsPropertyGroupPropertyValueService;
    }
}
