package com.herton.module.goods.dto;

import com.herton.dto.SimpleDTOConverter;
import com.herton.module.goods.domain.GoodsAttribute;
import org.springframework.stereotype.Component;

@Component
public class GoodsAttributeDTOConverter extends SimpleDTOConverter<GoodsAttributeDTO, GoodsAttribute> {
}
