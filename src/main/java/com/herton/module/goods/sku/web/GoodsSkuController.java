package com.herton.module.goods.sku.web;

import com.herton.common.AbstractCrudController;
import com.herton.common.CrudService;
import com.herton.module.goods.sku.domain.GoodsSku;
import com.herton.module.goods.sku.service.GoodsSkuService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "商品sku管理")
@RestController
@RequestMapping("/api/goodsSku")
public class GoodsSkuController extends AbstractCrudController<GoodsSku> {
    private final GoodsSkuService goodsSkuService;
    @Override
    protected CrudService<GoodsSku> getService() {
        return goodsSkuService;
    }

    @Autowired
    public GoodsSkuController(GoodsSkuService goodsSkuService) {
        this.goodsSkuService = goodsSkuService;
    }
}
