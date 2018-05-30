package com.herton.module.goods.service;

import com.herton.common.CrudService;
import com.herton.module.goods.domain.GoodsAttribute;
import com.herton.module.goods.web.GoodsSaveParam;

import java.util.List;

public interface GoodsAttributeService extends CrudService<GoodsAttribute> {
    List<GoodsAttribute> save(Boolean isCreate, String goodsId, List<GoodsAttribute> goodsAttributes) throws Exception;
}
