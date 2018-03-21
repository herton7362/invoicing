package com.herton.module.goods.property.service;

import com.herton.common.CrudService;
import com.herton.module.goods.property.domain.GoodsPropertyGroup;
import com.herton.module.goods.property.web.GoodsPropertyGroupSaveParam;

public interface GoodsPropertyGroupService extends CrudService<GoodsPropertyGroup> {
    /**
     * 保存属性组
     * @param goodsPropertyGroupSaveParam 参数
     */
    void save(GoodsPropertyGroupSaveParam goodsPropertyGroupSaveParam) throws Exception;
}
