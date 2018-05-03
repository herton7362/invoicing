package com.herton.module.goods.type.service;

import com.herton.common.CrudService;
import com.herton.common.PageResult;
import com.herton.module.goods.type.domain.GoodsType;
import com.herton.module.goods.type.web.GoodsTypeResult;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;

public interface GoodsTypeService extends CrudService<GoodsType> {
    /**
     * 分页查询
     * @param pageRequest 分页参数
     * @param param 查询条件
     * @return 分页结果
     */
    PageResult<GoodsTypeResult> findAllTranslated(PageRequest pageRequest, Map<String, String[]> param) throws Exception;

    /**
     * 不分页查询
     * @param param 查询条件
     * @return 结果
     */
    List<GoodsTypeResult> findAllTranslated(Map<String, String[]> param) throws Exception;
}
