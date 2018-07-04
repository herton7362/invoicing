package com.herton.module.goods.sku.dto;

import com.herton.dto.SimpleDTOConverter;
import com.herton.module.goods.dto.GoodsAttributeDTO;
import com.herton.module.goods.service.GoodsAttributeService;
import com.herton.module.goods.service.GoodsService;
import com.herton.module.goods.sku.domain.GoodsSku;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class GoodsSkuDTOConverter extends SimpleDTOConverter<GoodsSkuDTO, GoodsSku> {
    private final GoodsService goodsService;
    private final GoodsAttributeService goodsAttributeService;
    @Override
    protected GoodsSku doForward(GoodsSkuDTO goodsSkuDTO) {
        GoodsSku goodsSku = super.doForward(goodsSkuDTO);
        return goodsSku;
    }

    @Override
    protected GoodsSkuDTO doBackward(GoodsSku goodsSku) {
        GoodsSkuDTO goodsSkuDTO = super.doBackward(goodsSku);
        try {
            goodsSkuDTO.setGoods(goodsService.findOne(goodsSku.getGoodsId()));
            String[] goodsAttrIds = goodsSku.getGoodsAttributeIds().split(",");
            List<String> goodsAttrIdList = Arrays.asList(goodsAttrIds);
            goodsSkuDTO.setGoodsAttributes(String.join(",", goodsAttrIdList
                    .stream()
                    .map(goodsAttrId -> {
                        try {
                            GoodsAttributeDTO goodsAttribute = goodsAttributeService.findOne(goodsAttrId);
                            return goodsAttribute.getGoodsTypeAttributeId() + ":" + goodsAttribute.getGoodsTypeAttributeValue();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return "";
                    })
                    .collect(Collectors.toList())));
        } catch (Exception e) {
            log.error("商品sku DTO 转换出错", e);
        }
        return goodsSkuDTO;
    }

    @Autowired
    public GoodsSkuDTOConverter(
            GoodsService goodsService,
            GoodsAttributeService goodsAttributeService
    ) {
        this.goodsService = goodsService;
        this.goodsAttributeService = goodsAttributeService;
    }
}
