package com.herton.module.goods.property.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.common.PageResult;
import com.herton.common.utils.StringUtils;
import com.herton.module.goods.property.domain.*;
import com.herton.module.goods.property.web.GoodsPropertyGroupResult;
import com.herton.module.goods.property.web.GoodsPropertyGroupSaveParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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

        List<GoodsPropertyGroupSaveParam.GoodsPropertyGroupPropertyParam> goodsPropertyGroupPropertyParams =
                goodsPropertyGroupSaveParam.getGoodsPropertyGroupProperties();
        this.deleteUnusedGroupProperties(result.getId(), goodsPropertyGroupPropertyParams);
        GoodsPropertyGroupProperty goodsPropertyGroupProperty;
        List<GoodsPropertyGroupPropertyValue> goodsPropertyGroupPropertyValues;
        GoodsPropertyGroupSaveParam.GoodsPropertyGroupPropertyParam goodsPropertyGroupPropertyParam;
        GoodsPropertyGroupPropertyValue goodsPropertyGroupPropertyValue;
        for (int i = 0; i < goodsPropertyGroupPropertyParams.size(); i++) {
            goodsPropertyGroupPropertyParam = goodsPropertyGroupPropertyParams.get(i);
            goodsPropertyGroupProperty = new GoodsPropertyGroupProperty();
            BeanUtils.copyProperties(goodsPropertyGroupPropertyParam, goodsPropertyGroupProperty);
            goodsPropertyGroupProperty.setGoodsPropertyGroupId(result.getId());
            goodsPropertyGroupProperty.setSortNumber(i);
            goodsPropertyGroupPropertyService.save(goodsPropertyGroupProperty);

            goodsPropertyGroupPropertyValues = goodsPropertyGroupPropertyParam.getGoodsPropertyGroupPropertyValues();
            this.deleteUnusedGroupPropertyValues(goodsPropertyGroupProperty.getId(), goodsPropertyGroupPropertyValues);
            for (int j = 0; j < goodsPropertyGroupPropertyValues.size(); j++) {
                goodsPropertyGroupPropertyValue = goodsPropertyGroupPropertyValues.get(j);
                goodsPropertyGroupPropertyValue.setGoodsPropertyGroupId(result.getId());
                goodsPropertyGroupPropertyValue.setGoodsPropertyGroupPropertyId(goodsPropertyGroupProperty.getId());
                goodsPropertyGroupPropertyValue.setSortNumber(j);
                goodsPropertyGroupPropertyValueService.save(goodsPropertyGroupPropertyValue);
            }
        }

    }

    private void deleteUnusedGroupProperties(String goodsPropertyGroupId,
                              List<GoodsPropertyGroupSaveParam.GoodsPropertyGroupPropertyParam> goodsPropertyGroupPropertyParams) throws Exception {
        Map<String, String> param = new HashMap<>();
        param.put("goodsPropertyGroupId", goodsPropertyGroupId);
        List<GoodsPropertyGroupProperty> goodsPropertyGroupProperties = goodsPropertyGroupPropertyService.findAll(param);
        Set<String> oldIds = new HashSet<>();
        Set<String> newIds = new HashSet<>();
        goodsPropertyGroupProperties.forEach(goodsPropertyGroupProperty -> oldIds.add(goodsPropertyGroupProperty.getId()));
        goodsPropertyGroupPropertyParams.forEach(goodsPropertyGroupPropertyParam -> newIds.add(goodsPropertyGroupPropertyParam.getId()));
        oldIds.removeAll(newIds);
        for (String id : oldIds) {
            goodsPropertyGroupPropertyService.delete(id);
            param.clear();
            param.put("goodsPropertyGroupPropertyId", id);
            goodsPropertyGroupPropertyValueService.delete(goodsPropertyGroupPropertyValueService.findAll(param));
        }
    }

    private void deleteUnusedGroupPropertyValues(String goodsPropertyGroupPropertyId,
                                                 List<GoodsPropertyGroupPropertyValue> goodsPropertyGroupPropertyValues) throws Exception {
        Map<String, String> param = new HashMap<>();
        param.put("goodsPropertyGroupPropertyId", goodsPropertyGroupPropertyId);
        List<GoodsPropertyGroupPropertyValue> goodsPropertyGroupPropertyValues1 = goodsPropertyGroupPropertyValueService.findAll(param);
        Set<String> oldIds = new HashSet<>();
        Set<String> newIds = new HashSet<>();
        goodsPropertyGroupPropertyValues1.forEach(goodsPropertyGroupPropertyValue -> oldIds.add(goodsPropertyGroupPropertyValue.getId()));
        goodsPropertyGroupPropertyValues.forEach(goodsPropertyGroupPropertyValue -> newIds.add(goodsPropertyGroupPropertyValue.getId()));
        oldIds.removeAll(newIds);
        for (String id : oldIds) {
            goodsPropertyGroupPropertyValueService.delete(id);
        }
    }

    @Override
    public PageResult<GoodsPropertyGroupResult> findAllTranslated(PageRequest pageRequest,
                                                                  Map<String, ?> param) throws Exception {
        PageResult<GoodsPropertyGroup> page = super.findAll(pageRequest, param);
        PageResult<GoodsPropertyGroupResult> pageResult = new PageResult<>();
        pageResult.setSize(page.getSize());
        pageResult.setTotalElements(page.getTotalElements());
        pageResult.setContent(translateResults(page.getContent()));
        return pageResult;
    }

    @Override
    public List<GoodsPropertyGroupResult> findAllTranslated(Map<String, ?> param) throws Exception {
        return translateResults(super.findAll(param));
    }

    @Override
    public GoodsPropertyGroupResult findOneTranslated(String id) throws Exception {
        GoodsPropertyGroup goodsPropertyGroup = super.findOne(id);
        return this.translateResult(goodsPropertyGroup);
    }

    private List<String> findGoodsPropertyIds(String goodsPropertyGroupId) throws Exception {
        Map<String, String> param = new HashMap<>();
        param.put("goodsPropertyGroupId", goodsPropertyGroupId);
        List<GoodsPropertyGroupProperty> goodsPropertyGroupProperties = goodsPropertyGroupPropertyService.findAll(param);
        List<String> ids = new ArrayList<>();
        for (GoodsPropertyGroupProperty goodsPropertyGroupProperty : goodsPropertyGroupProperties) {
            ids.add(goodsPropertyGroupProperty.getGoodsPropertyId());
        }
        return ids;
    }

    private List<String> findGoodsPropertyValueIds(String goodsPropertyGroupId) throws Exception {
        Map<String, String> param = new HashMap<>();
        param.put("goodsPropertyGroupId", goodsPropertyGroupId);
        List<GoodsPropertyGroupPropertyValue> goodsPropertyGroupPropertyValues =
                goodsPropertyGroupPropertyValueService.findAll(param);
        List<String> ids = new ArrayList<>();
        for (GoodsPropertyGroupPropertyValue goodsPropertyGroupPropertyValue : goodsPropertyGroupPropertyValues) {
            ids.add(goodsPropertyGroupPropertyValue.getGoodsPropertyValueId());
        }
        return ids;
    }

    private List<GoodsPropertyGroupResult.GoodsPropertyResult> translateGoodsPropertyResults(
            List<String> goodsPropertyIds) throws Exception {
        GoodsProperty goodsProperty;
        List<GoodsPropertyGroupResult.GoodsPropertyResult> goodsPropertyResults = new ArrayList<>();
        for (String goodsPropertyId : goodsPropertyIds) {
            goodsProperty =  goodsPropertyService.findOne(goodsPropertyId);
            GoodsPropertyGroupResult.GoodsPropertyResult goodsPropertyResult = new GoodsPropertyGroupResult.GoodsPropertyResult();
            BeanUtils.copyProperties(goodsProperty, goodsPropertyResult);
            goodsPropertyResults.add(goodsPropertyResult);
        }
        return goodsPropertyResults;
    }

    private Map<String, List<GoodsPropertyGroupResult.GoodsPropertyValueResult>> translateGoodsPropertyValueResults(
            List<String> goodsPropertyValueIds) throws Exception {
        GoodsPropertyValue goodsPropertyValue;
        Map<String, List<GoodsPropertyGroupResult.GoodsPropertyValueResult>> goodsPropertyValueResultMap = new HashMap<>();
        for (String goodsPropertyValueId : goodsPropertyValueIds) {
            goodsPropertyValue = goodsPropertyValueService.findOne(goodsPropertyValueId);
            GoodsPropertyGroupResult.GoodsPropertyValueResult goodsPropertyValueResult =
                    new GoodsPropertyGroupResult.GoodsPropertyValueResult();
            BeanUtils.copyProperties(goodsPropertyValue, goodsPropertyValueResult);
            if(!goodsPropertyValueResultMap.containsKey(goodsPropertyValueResult.getGoodsPropertyId())) {
                goodsPropertyValueResultMap.put(goodsPropertyValueResult.getGoodsPropertyId(), new ArrayList<>());
            }
            goodsPropertyValueResultMap.get(goodsPropertyValueResult.getGoodsPropertyId()).add(goodsPropertyValueResult);
        }
        return goodsPropertyValueResultMap;
    }

    private GoodsPropertyGroupResult translateResult(GoodsPropertyGroup goodsPropertyGroup) throws Exception {
        GoodsPropertyGroupResult goodsPropertyGroupResult = new GoodsPropertyGroupResult();
        BeanUtils.copyProperties(goodsPropertyGroup, goodsPropertyGroupResult);
        goodsPropertyGroupResult.setGoodsPropertyIds(this.findGoodsPropertyIds(goodsPropertyGroup.getId()));
        goodsPropertyGroupResult.setGoodsPropertyValueIds(this.findGoodsPropertyValueIds(goodsPropertyGroup.getId()));
        goodsPropertyGroupResult.setGoodsPropertyResults(this.translateGoodsPropertyResults(goodsPropertyGroupResult.getGoodsPropertyIds()));
        Map<String, List<GoodsPropertyGroupResult.GoodsPropertyValueResult>> goodsPropertyValueResultMap =
                this.translateGoodsPropertyValueResults(goodsPropertyGroupResult.getGoodsPropertyValueIds());
        for (GoodsPropertyGroupResult.GoodsPropertyResult goodsPropertyResult : goodsPropertyGroupResult.getGoodsPropertyResults()) {
            goodsPropertyResult.setGoodsPropertyValueResults(goodsPropertyValueResultMap.get(goodsPropertyResult.getId()));
        }
        return goodsPropertyGroupResult;
    }

    private List<GoodsPropertyGroupResult> translateResults(List<GoodsPropertyGroup> goodsPropertyGroups) throws Exception {
        List<GoodsPropertyGroupResult> goodsPropertyGroupResults = new ArrayList<>();
        for (GoodsPropertyGroup goodsPropertyGroup : goodsPropertyGroups) {
            goodsPropertyGroupResults.add(this.translateResult(goodsPropertyGroup));
        }
        return goodsPropertyGroupResults;
    }

    @Override
    public void delete(String id) throws Exception {
        Map<String, String> param = new HashMap<>();
        param.put("goodsPropertyGroupId", id);
        goodsPropertyGroupPropertyService.delete(goodsPropertyGroupPropertyService.findAll(param));
        param.clear();
        param.put("goodsPropertyGroupId", id);
        goodsPropertyGroupPropertyValueService.delete(goodsPropertyGroupPropertyValueService.findAll(param));
        super.delete(id);
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
