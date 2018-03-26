package com.herton.module.goods.service;

import com.herton.common.CrudService;
import com.herton.common.PageResult;
import com.herton.module.goods.domain.Goods;
import com.herton.module.goods.property.web.GoodsPropertyGroupResult;
import com.herton.module.goods.web.GoodsResult;
import com.herton.module.goods.web.GoodsSaveParam;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;

public interface GoodsService extends CrudService<Goods> {
    void save(GoodsSaveParam goodsSaveParam) throws Exception;
    /**
     * 分页查询，并且转译结果
     * @param pageRequest 分页条件
     * @param param 查询条件
     * @return {@link GoodsResult} spring boot 分页类
     */
    PageResult<GoodsResult> findAllTranslated(PageRequest pageRequest, Map<String, ?> param) throws Exception;
    /**
     * 查询，并且转译结果
     * @param param 查询条件
     * @return {@link GoodsResult} spring boot 分页类
     */
    List<GoodsResult> findAllTranslated(Map<String, ?> param) throws Exception;
    /**
     * 根据id查询一个
     * @param id 主键
     * @return 实体
     */
    GoodsResult findOneTranslated(String id) throws Exception;
}
