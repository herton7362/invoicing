package com.herton.module.goods.property.web;

import com.herton.common.AbstractCrudController;
import com.herton.common.CrudService;
import com.herton.module.goods.property.domain.GoodsPropertyGroup;
import com.herton.module.goods.property.service.GoodsPropertyGroupService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "商品属组管理")
@RestController
@RequestMapping("/api/goodsPropertyGroup")
public class GoodsPropertyGroupController extends AbstractCrudController<GoodsPropertyGroup> {
    private final GoodsPropertyGroupService goodsPropertyGroupService;
    @Override
    protected CrudService<GoodsPropertyGroup> getService() {
        return goodsPropertyGroupService;
    }

    @Autowired
    public GoodsPropertyGroupController(GoodsPropertyGroupService goodsPropertyGroupService) {
        this.goodsPropertyGroupService = goodsPropertyGroupService;
    }
}
