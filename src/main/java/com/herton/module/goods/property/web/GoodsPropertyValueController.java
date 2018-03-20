package com.herton.module.goods.property.web;

import com.herton.common.AbstractCrudController;
import com.herton.common.CrudService;
import com.herton.module.goods.property.domain.GoodsPropertyValue;
import com.herton.module.goods.property.service.GoodsPropertyValueService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "商品属性值管理")
@RestController
@RequestMapping("/api/goodsPropertyValue")
public class GoodsPropertyValueController extends AbstractCrudController<GoodsPropertyValue> {
    private final GoodsPropertyValueService goodsPropertyValueService;
    @Override
    protected CrudService<GoodsPropertyValue> getService() {
        return goodsPropertyValueService;
    }

    @Autowired
    public GoodsPropertyValueController(GoodsPropertyValueService goodsPropertyValueService) {
        this.goodsPropertyValueService = goodsPropertyValueService;
    }
}
