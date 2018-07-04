package com.herton.module.goods.dto;

import com.herton.dto.SimpleDTOConverter;
import com.herton.module.goods.domain.GoodsCategory;
import org.springframework.stereotype.Component;

@Component
public class GoodsCategoryDTOConverter extends SimpleDTOConverter<GoodsCategoryDTO, GoodsCategory> {
}
