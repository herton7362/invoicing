package com.herton.module.goods.dto;

import com.herton.dto.SimpleDTOConverter;
import com.herton.module.goods.domain.GoodsSupplier;
import org.springframework.stereotype.Component;

@Component
public class GoodsSupplierDTOConverter extends SimpleDTOConverter<GoodsSupplierDTO, GoodsSupplier> {
}
