package com.herton.module.goods.sku.service;

import com.herton.common.AbstractChildCrudService;
import com.herton.module.goods.service.GoodsService;
import com.herton.module.goods.sku.domain.GoodsSku;
import com.herton.module.goods.sku.dto.GoodsSkuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class GoodsSkuServiceImpl extends AbstractChildCrudService<GoodsSku, GoodsSkuDTO> implements GoodsSkuService {
    private final GoodsService goodsService;

    @Override
    public void delete(String id) {
        GoodsSkuDTO goodsSku = findOne(id);
        if(this.checkUsed(id)) {
            goodsSku.setLogicallyDeleted(true);
            save(goodsSku);
        } else {
            super.delete(id);
        }
    }

    @Override
    public void delete(Iterable<? extends GoodsSkuDTO> goodsSkus) {
        for (GoodsSkuDTO skus : goodsSkus) {
            super.delete(skus.getId());
        }
    }

    private boolean checkUsed(String id) {
        return false;
    }

    @Lazy
    @Autowired
    public GoodsSkuServiceImpl(
            GoodsService goodsService
    ) {
        this.goodsService = goodsService;
    }
}
