package com.herton.module.goods.sku.service;

import com.herton.common.CrudService;
import com.herton.common.PageResult;
import com.herton.module.goods.sku.domain.GoodsSku;
import com.herton.module.goods.sku.web.GoodsSkuResult;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface GoodsSkuService extends CrudService<GoodsSku> {
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
     * @param goodsPropertyValueIdsSet 商品属性组合id集合，用逗号分隔 如：红色，M码
     * @throws Exception
     */
    void refreshGoodsSkuByFormatted(String goodsId, List<String> goodsPropertyValueIdsList) throws Exception;

    /**
     * 分页查询，并且转译结果
     * @param pageRequest 分页条件
     * @param param 查询条件
     * @return {@link GoodsSkuResult} spring boot 分页类
     */
    PageResult<GoodsSkuResult> findAllTranslated(PageRequest pageRequest, Map<String, ?> param) throws Exception;

    /**
     * 查询，并且转译结果
     * @param param 查询条件
     * @return {@link GoodsSkuResult} spring boot 分页类
     */
    List<GoodsSkuResult> findAllTranslated(Map<String, ?> param) throws Exception;
}
