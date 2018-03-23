package com.herton.module.goods.property.service;

import com.herton.common.CrudService;
import com.herton.common.PageResult;
import com.herton.module.goods.property.domain.GoodsPropertyGroup;
import com.herton.module.goods.property.web.GoodsPropertyGroupResult;
import com.herton.module.goods.property.web.GoodsPropertyGroupSaveParam;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;

public interface GoodsPropertyGroupService extends CrudService<GoodsPropertyGroup> {
    /**
     * 保存属性组
     * @param goodsPropertyGroupSaveParam 参数
     */
    void save(GoodsPropertyGroupSaveParam goodsPropertyGroupSaveParam) throws Exception;

    /**
     * 分页查询，并且转译结果
     * @param pageRequest 分页条件
     * @param param 查询条件
     * @return {@link GoodsPropertyGroupResult} spring boot 分页类
     */
    PageResult<GoodsPropertyGroupResult> findAllTranslated(PageRequest pageRequest, Map<String, ?> param) throws Exception;

    /**
     * 列表查询，并且转译结果
     * @param param 查询条件
     * @return 实体列表
     */
    List<GoodsPropertyGroupResult> findAllTranslated(Map<String, ?> param) throws Exception;

    /**
     * 根据id查询一个
     * @param id 主键
     * @return 实体
     */
    GoodsPropertyGroupResult findOneTranslated(String id) throws Exception;
}
