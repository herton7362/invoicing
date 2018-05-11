package com.herton.module.goods.type.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.common.PageResult;
import com.herton.module.goods.type.domain.GoodsType;
import com.herton.module.goods.type.domain.GoodsTypeRepository;
import com.herton.module.goods.type.web.GoodsTypeResult;
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
public class GoodsTypeServiceImpl extends AbstractCrudService<GoodsType> implements GoodsTypeService {
    private final GoodsTypeRepository goodsTypeRepository;
    private final GoodsTypeAttributeService goodsTypeAttributeService;
    @Override
    protected PageRepository<GoodsType> getRepository() {
        return goodsTypeRepository;
    }

    @Override
    public PageResult<GoodsTypeResult> findAllTranslated(PageRequest pageRequest, Map<String, String[]> param) throws Exception {
        PageResult<GoodsType> page = super.findAll(pageRequest, param);
        PageResult<GoodsTypeResult> pageResult = new PageResult<>();
        pageResult.setSize(page.getSize());
        pageResult.setTotalElements(page.getTotalElements());
        pageResult.setContent(translateResults(page.getContent()));
        return pageResult;
    }

    @Override
    public List<GoodsTypeResult> findAllTranslated(Map<String, String[]> param) throws Exception {
        return translateResults(super.findAll(param));
    }

    @Override
    public GoodsTypeResult getOneTranslated(String id) throws Exception {
        return translateResult(super.findOne(id));
    }

    private GoodsTypeResult translateResult(GoodsType goodsType) throws Exception {
        GoodsTypeResult goodsTypeResult = new GoodsTypeResult();
        Map<String, String> param = new HashMap<>();
        param.put("goodsTypeId", goodsType.getId());
        BeanUtils.copyProperties(goodsType, goodsTypeResult);
        goodsTypeResult.setGoodsTypeAttributes(goodsTypeAttributeService.findAll(param));
        return goodsTypeResult;
    }

    private List<GoodsTypeResult> translateResults(List<GoodsType> goodsTypes) throws Exception {
        List<GoodsTypeResult> goodsTypeResults = new ArrayList<>();
        for (GoodsType goodsType : goodsTypes) {
            goodsTypeResults.add(this.translateResult(goodsType));
        }
        return goodsTypeResults;
    }

    @Autowired
    public GoodsTypeServiceImpl(
            GoodsTypeRepository goodsTypeRepository,
            GoodsTypeAttributeService goodsTypeAttributeService
    ) {
        this.goodsTypeRepository = goodsTypeRepository;
        this.goodsTypeAttributeService = goodsTypeAttributeService;
    }
}
