package com.herton.module.goods.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.common.PageResult;
import com.herton.exceptions.InvalidParamException;
import com.herton.module.goods.domain.GoodsCategory;
import com.herton.module.goods.domain.GoodsCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
    public List<GoodsCategory> findAll(Map<String, ?> param) throws Exception {
        List<GoodsCategory> list = super.findAll(param);
        if(param.containsKey("cascadeParent")) {
            cascadeParent(list);
        }
        return list;
    }

    private void cascadeParent(List<GoodsCategory> list) throws Exception {
        Set<String> parentIds = new HashSet<>();

        list.forEach(item -> {
            if(list.stream().noneMatch(i -> i.getId().equals(item.getParentId())))
                parentIds.add(item.getParentId());
        });
        List<GoodsCategory> newList = new ArrayList<>();
        for (String parentId : parentIds) {
            if(parentId != null)
                newList.add(findOne(parentId));
        }
        if(newList.isEmpty()) {
            return;
        }
        list.addAll(newList);
        cascadeParent(newList);
    }

    @Override
    public PageResult<GoodsCategory> findAll(PageRequest pageRequest, Map<String, ?> param) throws Exception {
        PageResult<GoodsCategory> pageResult = super.findAll(pageRequest, param);
        if(param.containsKey("cascadeParent")) {
            List<GoodsCategory> list = new ArrayList<>(pageResult.getContent());
            cascadeParent(list);
            pageResult.setContent(list);
        }
        return pageResult;
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
            throw new InvalidParamException("当前类别已经被商品使用，不能删除");
        }
        param.clear();
        param.put("parentId", id);
        count = count(param);
        if(count > 0) {
            throw new InvalidParamException("请先删除当前类别的子类别");
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
