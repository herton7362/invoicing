package com.herton.module.goods.property.web;

import com.herton.common.AbstractCrudController;
import com.herton.common.CrudService;
import com.herton.module.goods.property.domain.GoodsPropertyCategory;
import com.herton.module.goods.property.service.GoodsPropertyCategoryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "商品属性类别管理")
@RestController
@RequestMapping("/api/goodsPropertyCategory")
public class GoodsPropertyCategoryController extends AbstractCrudController<GoodsPropertyCategory> {
    private final GoodsPropertyCategoryService goodsPropertyCategoryService;
    @Override
    protected CrudService<GoodsPropertyCategory> getService() {
        return goodsPropertyCategoryService;
    }

    @Autowired
    public GoodsPropertyCategoryController(GoodsPropertyCategoryService goodsPropertyCategoryService) {
        this.goodsPropertyCategoryService = goodsPropertyCategoryService;
    }
}
