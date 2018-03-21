package com.herton.module.goods.property.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.module.goods.property.domain.GoodsPropertyGroup;
import com.herton.module.goods.property.domain.GoodsPropertyGroupProperty;
import com.herton.module.goods.property.domain.GoodsPropertyGroupPropertyValue;
import com.herton.module.goods.property.domain.GoodsPropertyGroupRepository;
import com.herton.module.goods.property.web.GoodsPropertyGroupSaveParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Transactional
public class GoodsPropertyGroupServiceImpl extends AbstractCrudService<GoodsPropertyGroup> implements GoodsPropertyGroupService {
    private final GoodsPropertyGroupRepository goodsPropertyGroupRepository;
    private final GoodsPropertyGroupPropertyService goodsPropertyGroupPropertyService;
    private final GoodsPropertyGroupPropertyValueService goodsPropertyGroupPropertyValueService;
    @Override
    protected PageRepository<GoodsPropertyGroup> getRepository() {
        return goodsPropertyGroupRepository;
    }

    @Override
    public void save(GoodsPropertyGroupSaveParam goodsPropertyGroupSaveParam) throws Exception {
        GoodsPropertyGroup goodsPropertyGroup = new GoodsPropertyGroup();
        BeanUtils.copyProperties(goodsPropertyGroupSaveParam, goodsPropertyGroup);
        GoodsPropertyGroup result = goodsPropertyGroupRepository.save(goodsPropertyGroup);
        Map<String, String> param = new HashMap<>();
        param.put("goodsPropertyGroupId", result.getId());
        goodsPropertyGroupPropertyService.delete(goodsPropertyGroupPropertyService.findAll(param));
        List<String> GroupPropertyIds = goodsPropertyGroupSaveParam.getGroupPropertyId();
        GoodsPropertyGroupProperty goodsPropertyGroupProperty;
        for (String groupPropertyId : GroupPropertyIds) {
            goodsPropertyGroupProperty = new GoodsPropertyGroupProperty();
            goodsPropertyGroupProperty.setGoodsPropertyGroupId(result.getId());
            goodsPropertyGroupProperty.setGoodsPropertyId(groupPropertyId);
            goodsPropertyGroupPropertyService.save(goodsPropertyGroupProperty);
        }
        param.clear();
        param.put("goodsPropertyGroupId", result.getId());
        goodsPropertyGroupPropertyValueService.delete(goodsPropertyGroupPropertyValueService.findAll(param));
        List<String> GroupPropertyValueIds = goodsPropertyGroupSaveParam.getGroupPropertyValueId();
        GoodsPropertyGroupPropertyValue goodsPropertyGroupPropertyValue;
        for (String groupPropertyValueId : GroupPropertyValueIds) {
            goodsPropertyGroupPropertyValue = new GoodsPropertyGroupPropertyValue();
            goodsPropertyGroupPropertyValue.setGoodsPropertyGroupId(result.getId());
            goodsPropertyGroupPropertyValue.setGoodsPropertyValueId(groupPropertyValueId);
            goodsPropertyGroupPropertyValueService.save(goodsPropertyGroupPropertyValue);
        }
    }

    @Autowired
    public GoodsPropertyGroupServiceImpl(
            GoodsPropertyGroupRepository goodsPropertyGroupRepository,
            GoodsPropertyGroupPropertyService goodsPropertyGroupPropertyService,
            GoodsPropertyGroupPropertyValueService goodsPropertyGroupPropertyValueService
    ) {
        this.goodsPropertyGroupRepository = goodsPropertyGroupRepository;
        this.goodsPropertyGroupPropertyService = goodsPropertyGroupPropertyService;
        this.goodsPropertyGroupPropertyValueService = goodsPropertyGroupPropertyValueService;
    }
}
