package com.herton.module.goods.service;

import com.herton.common.CrudService;
import com.herton.module.goods.domain.GoodsAttribute;
import com.herton.module.goods.dto.GoodsAttributeDTO;

import java.util.List;

public interface GoodsAttributeService extends CrudService<GoodsAttribute, GoodsAttributeDTO> {
    void save(Boolean isCreate, String goodsId, List<GoodsAttributeDTO> goodsAttributes) throws Exception;
}
