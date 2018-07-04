package com.herton.module.goods.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageResult;
import com.herton.common.utils.StringUtils;
import com.herton.exceptions.InvalidParamException;
import com.herton.module.goods.domain.GoodsCategory;
import com.herton.module.goods.dto.GoodsCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Component
@Transactional
public class GoodsCategoryServiceImpl extends AbstractCrudService<GoodsCategory, GoodsCategoryDTO>
        implements GoodsCategoryService {
    private final GoodsService goodsService;

    @Override
    public List<GoodsCategoryDTO> findAll(Map<String, ?> param) throws Exception {
        List<GoodsCategoryDTO> list = super.findAll(param);
        if(param.containsKey("cascadeParent")) {
            cascadeParent(list);
        }
        if(param.containsKey("extraData")) {
            String extraData = ((String[])param.get("extraData"))[0];
            if(StringUtils.isNotBlank(extraData)) {
                addExtraData(list, extraData);
            }
        }
        return list;
    }

    private void cascadeParent(List<GoodsCategoryDTO> list) throws Exception {
        Set<String> parentIds = new HashSet<>();

        list.forEach(item -> {
            if(list.stream().noneMatch(i -> i.getId().equals(item.getParentId())))
                parentIds.add(item.getParentId());
        });
        List<GoodsCategoryDTO> newList = new ArrayList<>();
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

    private void addExtraData(List<GoodsCategoryDTO> list, String extraData) throws Exception {
        if(!list.stream().anyMatch(data->data.getId().equals(extraData))) {
            list.add(findOne(extraData));
        }
    }

    @Override
    public PageResult<GoodsCategoryDTO> findAll(PageRequest pageRequest, Map<String, ?> param) throws Exception {
        PageResult<GoodsCategoryDTO> pageResult = super.findAll(pageRequest, param);
        if(param.containsKey("cascadeParent")) {
            List<GoodsCategoryDTO> list = new ArrayList<>(pageResult.getContent());
            cascadeParent(list);
            if(param.containsKey("extraData")) {
                String extraData = ((String[])param.get("extraData"))[0];
                if(StringUtils.isNotBlank(extraData)) {
                    addExtraData(list, extraData);
                }
            }
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
    public void delete(Iterable<? extends GoodsCategoryDTO> goodsCategories) throws Exception {
        for (GoodsCategoryDTO goodsCategory : goodsCategories) {
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
            GoodsService goodsService
    ) {
        this.goodsService = goodsService;
    }
}
