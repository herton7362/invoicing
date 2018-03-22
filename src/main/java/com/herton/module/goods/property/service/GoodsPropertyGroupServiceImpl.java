package com.herton.module.goods.property.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.common.PageResult;
import com.herton.module.goods.property.domain.*;
import com.herton.module.goods.property.web.GoodsPropertyGroupResult;
import com.herton.module.goods.property.web.GoodsPropertyGroupSaveParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Transactional
public class GoodsPropertyGroupServiceImpl extends AbstractCrudService<GoodsPropertyGroup> implements GoodsPropertyGroupService {
    private final GoodsPropertyGroupRepository goodsPropertyGroupRepository;
    private final GoodsPropertyGroupPropertyService goodsPropertyGroupPropertyService;
    private final GoodsPropertyGroupPropertyValueService goodsPropertyGroupPropertyValueService;
    private final GoodsPropertyService goodsPropertyService;
    private final GoodsPropertyValueService goodsPropertyValueService;
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
        List<String> goodsPropertyIds = goodsPropertyGroupSaveParam.getGoodsPropertyIds();
        GoodsPropertyGroupProperty goodsPropertyGroupProperty;
        for (String groupPropertyId : goodsPropertyIds) {
            goodsPropertyGroupProperty = new GoodsPropertyGroupProperty();
            goodsPropertyGroupProperty.setGoodsPropertyGroupId(result.getId());
            goodsPropertyGroupProperty.setGoodsPropertyId(groupPropertyId);
            goodsPropertyGroupPropertyService.save(goodsPropertyGroupProperty);
        }
        param.clear();
        param.put("goodsPropertyGroupId", result.getId());
        goodsPropertyGroupPropertyValueService.delete(goodsPropertyGroupPropertyValueService.findAll(param));
        List<String> goodsPropertyValueIds = goodsPropertyGroupSaveParam.getGoodsPropertyValueIds();
        GoodsPropertyGroupPropertyValue goodsPropertyGroupPropertyValue;
        for (String groupPropertyValueId : goodsPropertyValueIds) {
            goodsPropertyGroupPropertyValue = new GoodsPropertyGroupPropertyValue();
            goodsPropertyGroupPropertyValue.setGoodsPropertyGroupId(result.getId());
            goodsPropertyGroupPropertyValue.setGoodsPropertyValueId(groupPropertyValueId);
            goodsPropertyGroupPropertyValueService.save(goodsPropertyGroupPropertyValue);
        }
    }

    @Override
    public PageResult<GoodsPropertyGroupResult> findAllTranslated(PageRequest pageRequest, Map<String, ?> param) throws Exception {
        PageResult<GoodsPropertyGroup> page = super.findAll(pageRequest, param);
        PageResult<GoodsPropertyGroupResult> pageResult = new PageResult<>();
        pageResult.setSize(page.getSize());
        pageResult.setTotalElements(page.getTotalElements());
        pageResult.setContent(translateResult(page.getContent()));
        return pageResult;
    }

    @Override
    public List<GoodsPropertyGroupResult> findAllTranslated(Map<String, ?> param) throws Exception {
        return translateResult(super.findAll(param));
    }

    private List<GoodsPropertyGroupResult> translateResult(List<GoodsPropertyGroup> goodsPropertyGroups) throws Exception {
        List<GoodsPropertyGroupResult> goodsPropertyGroupResults = new ArrayList<>();
        GoodsPropertyGroupResult goodsPropertyGroupResult;
        GoodsProperty goodsProperty;
        GoodsPropertyValue goodsPropertyValue;
        Map<String, List<GoodsPropertyGroupResult.GoodsPropertyValueResult>> goodsPropertyValueResultMap;
        Map<String, String> param = new HashMap<>();
        List<GoodsPropertyGroupResult.GoodsPropertyResult> goodsPropertyResults;
        List<GoodsPropertyGroupProperty> goodsPropertyGroupProperties;
        List<GoodsPropertyGroupPropertyValue> goodsPropertyGroupPropertyValues;
        List<String> ids;
        for (GoodsPropertyGroup goodsPropertyGroup : goodsPropertyGroups) {
            goodsPropertyGroupResult = new GoodsPropertyGroupResult();
            goodsPropertyResults = new ArrayList<>();
            param.clear();
            param.put("goodsPropertyGroupId", goodsPropertyGroup.getId());
            BeanUtils.copyProperties(goodsPropertyGroup, goodsPropertyGroupResult);
            goodsPropertyGroupProperties = goodsPropertyGroupPropertyService.findAll(param);
            ids = new ArrayList<>();
            for (GoodsPropertyGroupProperty goodsPropertyGroupProperty : goodsPropertyGroupProperties) {
                ids.add(goodsPropertyGroupProperty.getGoodsPropertyId());
            }
            goodsPropertyGroupResult.setGoodsPropertyIds(ids);
            param.clear();
            param.put("goodsPropertyGroupId", goodsPropertyGroup.getId());
            goodsPropertyGroupPropertyValues = goodsPropertyGroupPropertyValueService.findAll(param);
            ids = new ArrayList<>();
            for (GoodsPropertyGroupPropertyValue goodsPropertyGroupPropertyValue : goodsPropertyGroupPropertyValues) {
                ids.add(goodsPropertyGroupPropertyValue.getGoodsPropertyValueId());
            }
            goodsPropertyGroupResult.setGoodsPropertyValueIds(ids);
            goodsPropertyGroupResults.add(goodsPropertyGroupResult);
            List<String> goodsPropertyIds = goodsPropertyGroupResult.getGoodsPropertyIds();
            for (String goodsPropertyId : goodsPropertyIds) {
                goodsProperty =  goodsPropertyService.findOne(goodsPropertyId);
                GoodsPropertyGroupResult.GoodsPropertyResult goodsPropertyResult = goodsPropertyGroupResult.new GoodsPropertyResult();
                BeanUtils.copyProperties(goodsProperty, goodsPropertyResult);
                goodsPropertyResults.add(goodsPropertyResult);
            }
            goodsPropertyGroupResult.setGoodsPropertyResults(goodsPropertyResults);
            List<String> goodsPropertyValueIds = goodsPropertyGroupResult.getGoodsPropertyValueIds();
            goodsPropertyValueResultMap = new HashMap<>();
            for (String goodsPropertyValueId : goodsPropertyValueIds) {
                goodsPropertyValue = goodsPropertyValueService.findOne(goodsPropertyValueId);
                GoodsPropertyGroupResult.GoodsPropertyValueResult goodsPropertyValueResult = goodsPropertyGroupResult.new GoodsPropertyValueResult();
                BeanUtils.copyProperties(goodsPropertyValue, goodsPropertyValueResult);
                if(!goodsPropertyValueResultMap.containsKey(goodsPropertyValueResult.getGoodsPropertyId())) {
                    goodsPropertyValueResultMap.put(goodsPropertyValueResult.getGoodsPropertyId(), new ArrayList<>());
                }
                goodsPropertyValueResultMap.get(goodsPropertyValueResult.getGoodsPropertyId()).add(goodsPropertyValueResult);
            }
            for (GoodsPropertyGroupResult.GoodsPropertyResult goodsPropertyResult : goodsPropertyGroupResult.getGoodsPropertyResults()) {
                goodsPropertyResult.setGoodsPropertyValueResults(goodsPropertyValueResultMap.get(goodsPropertyResult.getId()));
            }
        }
        return goodsPropertyGroupResults;
    }

    @Autowired
    public GoodsPropertyGroupServiceImpl(
            GoodsPropertyGroupRepository goodsPropertyGroupRepository,
            GoodsPropertyGroupPropertyService goodsPropertyGroupPropertyService,
            GoodsPropertyGroupPropertyValueService goodsPropertyGroupPropertyValueService,
            GoodsPropertyService goodsPropertyService,
            GoodsPropertyValueService goodsPropertyValueService
    ) {
        this.goodsPropertyGroupRepository = goodsPropertyGroupRepository;
        this.goodsPropertyGroupPropertyService = goodsPropertyGroupPropertyService;
        this.goodsPropertyGroupPropertyValueService = goodsPropertyGroupPropertyValueService;
        this.goodsPropertyService = goodsPropertyService;
        this.goodsPropertyValueService = goodsPropertyValueService;
    }
}
