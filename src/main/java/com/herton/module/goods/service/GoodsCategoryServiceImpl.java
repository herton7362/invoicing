package com.herton.module.goods.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.exceptions.BusinessException;
import com.herton.module.goods.domain.GoodsCategory;
import com.herton.module.goods.domain.GoodsCategoryRepository;
import com.herton.module.goods.property.domain.GoodsProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Component
@Transactional
public class GoodsCategoryServiceImpl extends AbstractCrudService<GoodsCategory> implements GoodsCategoryService {
    private final GoodsCategoryRepository goodsCategoryRepository;
    private final GoodsService goodsService;
    @Override
    protected PageRepository<GoodsCategory> getRepository() {
        return goodsCategoryRepository;
    }

    @Override
    public void delete(String id) throws Exception {
        this.checkUsed(id);
        super.delete(id);
    }

    @Override
    public void delete(Iterable<? extends GoodsCategory> goodsCategories) throws Exception {
        for (GoodsCategory goodsCategory : goodsCategories) {
            this.checkUsed(goodsCategory.getId());
        }
        super.delete(goodsCategories);
    }

    private void checkUsed(String id) throws Exception {
        Map<String, String> param = new HashMap<>();
        param.put("goodsCategoryId", id);
        Long count = goodsService.count(param);
        if(count > 0) {
            throw new BusinessException("当前类别已经被商品使用，不能删除");
        }
        param.clear();
        param.put("parentId", id);
        count = count(param);
        if(count > 0) {
            throw new BusinessException("请先删除当前类别的子类别");
        }
    }

    @Autowired
    public GoodsCategoryServiceImpl(
            GoodsCategoryRepository goodsCategoryRepository,
            GoodsService goodsService
    ) {
        this.goodsCategoryRepository = goodsCategoryRepository;
        this.goodsService = goodsService;
    }
}
