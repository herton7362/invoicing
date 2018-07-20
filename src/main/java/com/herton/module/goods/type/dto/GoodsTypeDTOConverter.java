package com.herton.module.goods.type.dto;

import com.herton.dto.SimpleDTOConverter;
import com.herton.module.goods.type.domain.GoodsType;
import com.herton.module.goods.type.service.GoodsTypeAttributeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class GoodsTypeDTOConverter extends SimpleDTOConverter<GoodsTypeDTO, GoodsType> {
    private final GoodsTypeAttributeService goodsTypeAttributeService;

    @Override
    protected GoodsTypeDTO doBackward(GoodsType goodsType) {
        GoodsTypeDTO goodsTypeDTO = super.doBackward(goodsType);
        Map<String, String> param = new HashMap<>();
        param.put("goodsTypeId", goodsType.getId());
        goodsTypeDTO.setGoodsTypeAttributes(goodsTypeAttributeService.findAll(param));
        return goodsTypeDTO;
    }

    @Autowired
    public GoodsTypeDTOConverter(GoodsTypeAttributeService goodsTypeAttributeService) {
        this.goodsTypeAttributeService = goodsTypeAttributeService;
    }
}
