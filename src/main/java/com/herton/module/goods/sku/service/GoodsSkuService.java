package com.herton.module.goods.sku.service;

import com.herton.common.CrudService;
import com.herton.module.goods.sku.domain.GoodsSku;
import com.herton.module.goods.sku.dto.GoodsSkuDTO;

import java.util.List;

public interface GoodsSkuService extends CrudService<GoodsSku, GoodsSkuDTO> {
    /**
     * 刷新商品sku，如果sku未被使用则删除，如果被占用则改为停用
     * @param goodsId 商品id
     * @param goodsPropertyValueIdsList 商品属性id列表，注意顺序
     * @throws Exception
     */
    void refreshGoodsSkuByRaw(String goodsId, List<List<String>> goodsPropertyValueIdsList) throws Exception;

    /**
     * 刷新商品sku，如果sku未被使用则删除，如果被占用则改为停用
     * @param goodsId 商品id
     * @param goodsPropertyValueIdsList 商品属性组合id集合，用逗号分隔 如：红色，M码
     * @throws Exception
     */
    void refreshGoodsSkuByFormatted(String goodsId, List<String> goodsPropertyValueIdsList) throws Exception;

    void save(Boolean isCreate, String goodsId, List<GoodsSkuDTO> goodsSkuParams) throws Exception;
}
