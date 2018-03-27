package com.herton.module.goods.property.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.common.PageResult;
import com.herton.module.goods.property.domain.GoodsProperty;
import com.herton.module.goods.property.domain.GoodsPropertyRepository;
import com.herton.module.goods.property.web.GoodsPropertyResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Transactional
public class GoodsPropertyServiceImpl extends AbstractCrudService<GoodsProperty> implements GoodsPropertyService {
    private final GoodsPropertyRepository goodsPropertyRepository;
    private final GoodsPropertyValueService goodsPropertyValueService;
    private final GoodsPropertyCategoryService goodsPropertyCategoryService;
    @Override
    protected PageRepository<GoodsProperty> getRepository() {
        return goodsPropertyRepository;
    }

    @Override
    public PageResult<GoodsPropertyResult> findAllTranslated(PageRequest pageRequest, Map<String, ?> param) throws Exception {
        PageResult<GoodsProperty> page = super.findAll(pageRequest, param);
        PageResult<GoodsPropertyResult> pageResult = new PageResult<>();
        pageResult.setSize(page.getSize());
        pageResult.setTotalElements(page.getTotalElements());
        pageResult.setContent(translateResults(page.getContent()));
        return pageResult;
    }

    @Override
    public List<GoodsPropertyResult> findAllTranslated(Map<String, ?> param) throws Exception {
        return this.translateResults(super.findAll(param));
    }

    private GoodsPropertyResult translateResult(GoodsProperty goodsProperty) throws Exception {
        GoodsPropertyResult goodsPropertyResult = new GoodsPropertyResult();
        Map<String, String> param = new HashMap<>();
        param.put("goodsPropertyId", goodsProperty.getId());
        BeanUtils.copyProperties(goodsProperty, goodsPropertyResult);
        goodsPropertyResult.setGoodsPropertyValues(goodsPropertyValueService.findAll(param));
        goodsPropertyResult.setGoodsPropertyCategories(goodsPropertyCategoryService.findAll(param));
        return goodsPropertyResult;
    }

    private List<GoodsPropertyResult> translateResults(List<GoodsProperty> goodsProperties) throws Exception {
        List<GoodsPropertyResult> goodsPropertyGroups = new ArrayList<>();
        for (GoodsProperty goodsProperty : goodsProperties) {
            goodsPropertyGroups.add(this.translateResult(goodsProperty));
        }
        return goodsPropertyGroups;
    }

    @Override
    public GoodsPropertyResult findOneTranslated(String id) throws Exception {
        return this.translateResult(super.findOne(id));
    }

    @Autowired
    public GoodsPropertyServiceImpl(
            GoodsPropertyRepository goodsPropertyRepository,
            GoodsPropertyValueService goodsPropertyValueService,
            GoodsPropertyCategoryService goodsPropertyCategoryService
    ) {
        this.goodsPropertyRepository = goodsPropertyRepository;
        this.goodsPropertyValueService = goodsPropertyValueService;
        this.goodsPropertyCategoryService = goodsPropertyCategoryService;
    }
}
