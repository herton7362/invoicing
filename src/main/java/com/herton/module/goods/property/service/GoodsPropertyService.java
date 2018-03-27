package com.herton.module.goods.property.service;

import com.herton.common.CrudService;
import com.herton.common.PageResult;
import com.herton.module.goods.property.domain.GoodsProperty;
import com.herton.module.goods.property.web.GoodsPropertyResult;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;

public interface GoodsPropertyService extends CrudService<GoodsProperty> {
    /**
     * 分页查询
     * @param pageRequest 分页参数
     * @param param 查询参数
     * @return 转义后的分页结果
     */
    PageResult<GoodsPropertyResult> findAllTranslated(PageRequest pageRequest, Map<String, ?> param) throws Exception;

    /**
     * 不分页查询
     * @param param 查询参数
     * @return 转义后的列表结果
     */
    List<GoodsPropertyResult> findAllTranslated(Map<String, ?> param) throws Exception;

    /**
     * 查询一个并转义
     * @param id 主键
     * @return 转义后的结果
     */
    GoodsPropertyResult findOneTranslated(String id) throws Exception;
}
