package com.herton.module.goods.web;

import com.herton.common.AbstractCrudController;
import com.herton.common.CrudService;
import com.herton.module.goods.domain.GoodsCategory;
import com.herton.module.goods.service.GoodsCategoryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "商品管理")
@RestController
@RequestMapping("/api/goodsCategory")
public class GoodsCategoryController extends AbstractCrudController<GoodsCategory> {
    private final GoodsCategoryService goodsCategoryService;
    @Override
    protected CrudService<GoodsCategory> getService() {
        return goodsCategoryService;
    }

    @Autowired
    public GoodsCategoryController(GoodsCategoryService goodsCategoryService) {
        this.goodsCategoryService = goodsCategoryService;
    }
}
