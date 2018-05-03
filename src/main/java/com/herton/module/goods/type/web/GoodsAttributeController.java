package com.herton.module.goods.type.web;

import com.herton.common.AbstractCrudController;
import com.herton.common.CrudService;
import com.herton.module.goods.type.domain.GoodsAttribute;
import com.herton.module.goods.type.service.GoodsAttributeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "商品属性管理")
@RestController
@RequestMapping("/api/goodsAttribute")
public class GoodsAttributeController extends AbstractCrudController<GoodsAttribute> {
    private final GoodsAttributeService goodsAttributeService;
    @Override
    protected CrudService<GoodsAttribute> getService() {
        return goodsAttributeService;
    }

    @Autowired
    public GoodsAttributeController(GoodsAttributeService goodsAttributeService) {
        this.goodsAttributeService = goodsAttributeService;
    }
}
