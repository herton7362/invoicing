package com.herton.module.orderform.transfer.dto;

import com.herton.dto.SimpleDTOConverter;
import com.herton.module.goods.domain.GoodsRepository;
import com.herton.module.goods.sku.dto.GoodsSkuDTO;
import com.herton.module.goods.sku.service.GoodsSkuService;
import com.herton.module.orderform.transfer.domain.TransferOrderSku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransferOrderSkuDTOConverter extends SimpleDTOConverter<TransferOrderSkuDTO, TransferOrderSku> {
    private final GoodsRepository goodsRepository;
    private final GoodsSkuService goodsSkuService;

    @Override
    protected TransferOrderSkuDTO doBackward(TransferOrderSku transferOrderSku) {
        TransferOrderSkuDTO transferOrderSkuDTO = super.doBackward(transferOrderSku);
        transferOrderSkuDTO.setGoods(goodsRepository.findOne(transferOrderSkuDTO.getGoodsId()));
        GoodsSkuDTO goodsSkuDTO = goodsSkuService.findOne(transferOrderSkuDTO.getSkuId());
        if(goodsSkuDTO != null) {
            transferOrderSkuDTO.setAttributeName(goodsSkuDTO.getAttributeName());
        }
        return transferOrderSkuDTO;
    }

    @Autowired
    public TransferOrderSkuDTOConverter(GoodsRepository goodsRepository, GoodsSkuService goodsSkuService) {
        this.goodsRepository = goodsRepository;
        this.goodsSkuService = goodsSkuService;
    }
}
