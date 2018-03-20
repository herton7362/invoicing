package com.herton.module.goods.property.web;

import com.herton.common.AbstractCrudController;
import com.herton.common.CrudService;
import com.herton.module.goods.property.domain.GoodsProperty;
import com.herton.module.goods.property.service.GoodsPropertyService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "商品属性管理")
@RestController
@RequestMapping("/api/goodsProperty")
public class GoodsPropertyController extends AbstractCrudController<GoodsProperty> {
    private GoodsPropertyService goodsPropertyService;
    @Override
    protected CrudService<GoodsProperty> getService() {
        return goodsPropertyService;
    }

    @Autowired
    public GoodsPropertyController(GoodsPropertyService goodsPropertyService) {
        this.goodsPropertyService = goodsPropertyService;
    }
}
