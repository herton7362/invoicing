package com.herton.module.goods.dto;

import com.herton.dto.SimpleDTOConverter;
import com.herton.module.goods.domain.Goods;
import com.herton.module.goods.service.GoodsAttributeService;
import com.herton.module.goods.service.GoodsSupplierService;
import com.herton.module.goods.sku.service.GoodsSkuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class GoodsDTOConverter extends SimpleDTOConverter<GoodsDTO, Goods> {
    private final GoodsSkuService goodsSkuService;
    private final GoodsAttributeService goodsAttributeService;
    private final GoodsSupplierService goodsSupplierService;

    @Override
    protected GoodsDTO doBackward(Goods goods) {
        GoodsDTO goodsDTO = super.doBackward(goods);
        Map<String, String> param = new HashMap<>();
        param.put("goodsId", goods.getId());
        try {
            goodsDTO.setGoodsAttributes(goodsAttributeService.findAll(param));
            goodsDTO.setGoodsSkus(goodsSkuService.findAll(param));
            goodsDTO.setGoodsSuppliers(goodsSupplierService.findAll(param));
        } catch (Exception e) {
            log.error("DTO转换出错", e);
        }

        return goodsDTO;
    }

    @Autowired
    public GoodsDTOConverter(
            GoodsSkuService goodsSkuService,
            GoodsAttributeService goodsAttributeService,
            GoodsSupplierService goodsSupplierService
            ) {
        this.goodsSkuService = goodsSkuService;
        this.goodsAttributeService = goodsAttributeService;
        this.goodsSupplierService = goodsSupplierService;
    }
}
