package com.herton.module.orderform.purchase.dto;

import com.herton.common.utils.StringUtils;
import com.herton.dto.SimpleDTOConverter;
import com.herton.module.goods.domain.GoodsRepository;
import com.herton.module.goods.dto.GoodsAttributeDTO;
import com.herton.module.goods.service.GoodsAttributeService;
import com.herton.module.goods.sku.dto.GoodsSkuDTO;
import com.herton.module.goods.sku.service.GoodsSkuService;
import com.herton.module.goods.type.dto.GoodsTypeAttributeDTO;
import com.herton.module.goods.type.service.GoodsTypeAttributeService;
import com.herton.module.orderform.purchase.domain.PurchaseOrderSku;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class PurchaseOrderSkuDTOConverter extends SimpleDTOConverter<PurchaseOrderSkuDTO, PurchaseOrderSku> {
    private final GoodsRepository goodsRepository;
    private final GoodsSkuService goodsSkuService;
    private final GoodsAttributeService goodsAttributeService;
    private final GoodsTypeAttributeService goodsTypeAttributeService;
    @Override
    protected PurchaseOrderSkuDTO doBackward(PurchaseOrderSku purchaseOrderSku) {
        PurchaseOrderSkuDTO purchaseOrderSkuDTO = super.doBackward(purchaseOrderSku);
        purchaseOrderSkuDTO.setGoods(goodsRepository.findOne(purchaseOrderSkuDTO.getGoodsId()));
        GoodsSkuDTO goodsSkuDTO = goodsSkuService.findOne(purchaseOrderSkuDTO.getSkuId());
        String goodsAttributeIds = goodsSkuDTO.getGoodsAttributeIds();
        List<String> attributeName = new ArrayList<>();
        if(StringUtils.isNotBlank(goodsAttributeIds)) {
            String[] goodsAttributeIdArray = goodsAttributeIds.split(",");
            for (String goodsAttributeId : goodsAttributeIdArray) {
                GoodsAttributeDTO goodsAttributeDTO = goodsAttributeService.findOne(goodsAttributeId);
                if(goodsAttributeDTO == null) {
                    continue;
                }
                GoodsTypeAttributeDTO goodsTypeAttributeDTO = goodsTypeAttributeService
                        .findOne(goodsAttributeDTO.getGoodsTypeAttributeId());
                if(goodsTypeAttributeDTO == null) {
                    continue;
                }

                attributeName.add(String.format("%s：%s",
                        goodsTypeAttributeDTO.getName(), goodsAttributeDTO.getGoodsTypeAttributeValue()));
            }
            purchaseOrderSkuDTO.setAttributeName(String.join("，", attributeName));
        }
        return purchaseOrderSkuDTO;
    }

    @Autowired
    public PurchaseOrderSkuDTOConverter(
            GoodsRepository goodsRepository,
            GoodsSkuService goodsSkuService,
            GoodsAttributeService goodsAttributeService,
            GoodsTypeAttributeService goodsTypeAttributeService
    ) {
        this.goodsRepository = goodsRepository;
        this.goodsSkuService = goodsSkuService;
        this.goodsAttributeService = goodsAttributeService;
        this.goodsTypeAttributeService = goodsTypeAttributeService;
    }
}
