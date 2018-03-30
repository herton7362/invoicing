package com.herton.module.goods.property.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.common.PageResult;
import com.herton.exceptions.BusinessException;
import com.herton.module.goods.property.domain.GoodsProperty;
import com.herton.module.goods.property.domain.GoodsPropertyRepository;
import com.herton.module.goods.property.web.GoodsPropertyResult;
import com.herton.module.goods.service.GoodsGoodsPropertyService;
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
    private final GoodsGoodsPropertyService goodsGoodsPropertyService;
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

    @Override
    public void delete(String id) throws Exception {
        this.checkUsed(id);
        this.deleteGoodsPropertyValue(id);
        super.delete(id);
    }

    @Override
    public void delete(Iterable<? extends GoodsProperty> goodsProperties) throws Exception {
        for (GoodsProperty goodsProperty : goodsProperties) {
            this.checkUsed(goodsProperty.getId());
            this.deleteGoodsPropertyValue(goodsProperty.getId());
        }
        super.delete(goodsProperties);
    }

    private void deleteGoodsPropertyValue(String id) throws Exception {
        Map<String, String> param = new HashMap<>();
        param.put("goodsPropertyId", id);
        goodsPropertyValueService.delete(goodsPropertyValueService.findAll(param));
    }

    private void checkUsed(String id) throws Exception {
        Map<String, String> param = new HashMap<>();
        param.put("goodsPropertyId", id);
        Long count = goodsGoodsPropertyService.count(param);
        if(count > 0) {
            throw new BusinessException("当前属性已经被商品使用，不能删除");
        }
    }

    @Autowired
    public GoodsPropertyServiceImpl(
            GoodsPropertyRepository goodsPropertyRepository,
            GoodsPropertyValueService goodsPropertyValueService,
            GoodsPropertyCategoryService goodsPropertyCategoryService,
            GoodsGoodsPropertyService goodsGoodsPropertyService
    ) {
        this.goodsPropertyRepository = goodsPropertyRepository;
        this.goodsPropertyValueService = goodsPropertyValueService;
        this.goodsPropertyCategoryService = goodsPropertyCategoryService;
        this.goodsGoodsPropertyService = goodsGoodsPropertyService;
    }
}
