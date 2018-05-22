package com.herton.module.goods.sku.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.common.PageResult;
import com.herton.module.goods.service.GoodsService;
import com.herton.module.goods.sku.domain.GoodsSku;
import com.herton.module.goods.sku.domain.GoodsSkuRepository;
import com.herton.module.goods.sku.web.GoodsSkuResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Component
@Transactional
public class GoodsSkuServiceImpl extends AbstractCrudService<GoodsSkuRepository, GoodsSku> implements GoodsSkuService {
    private final GoodsService goodsService;

    @Override
    public void refreshGoodsSkuByRaw(String goodsId, List<List<String>> goodsPropertyValueIdsList) throws Exception {
        List<List<String>> result = new ArrayList<>();
        List<String> goodsPropertyValueIds = new ArrayList<>();
        if(goodsPropertyValueIdsList != null && goodsPropertyValueIdsList.size() > 0) {
            recursiveGoodsPropertyValueIdsList(0, goodsPropertyValueIdsList, null, result);
            for (List<String> strings : result) {
                goodsPropertyValueIds.add(String.join(",", strings));
            }
        } else {
            goodsPropertyValueIds.add(null);
        }

        refreshGoodsSkuByFormatted(goodsId, goodsPropertyValueIds);
    }

    private void recursiveGoodsPropertyValueIdsList(int index,
                                                    List<List<String>> goodsPropertyValueIdsList,
                                                    List<String> goodsPropertyValueIds,
                                                    List<List<String>> result) {
        List<String> temp;
        for (String valueIds : goodsPropertyValueIdsList.get(index)) {
            temp = new ArrayList<>();
            if(goodsPropertyValueIds != null) {
                temp.addAll(goodsPropertyValueIds);
            }
            temp.add(valueIds);
            // 如果递归到最后一个属性的值则将拼装好的数组放到结果里面
            if(index == goodsPropertyValueIdsList.size() - 1) {
                result.add(temp);
            } else {
                recursiveGoodsPropertyValueIdsList(index + 1, goodsPropertyValueIdsList, temp, result);
            }
        }
    }

    @Override
    public void refreshGoodsSkuByFormatted(String goodsId, List<String> goodsPropertyValueIdsList) throws Exception {
        Map<String, String> param = new HashMap<>();
        param.put("goodsId", goodsId);
        List<GoodsSku> goodsSkus = findAll(param);

        Set<String> oldGoodsPropertyValueIdsSet = new HashSet<>();
        Map<String, String> propertyValueSkuIdMap = new HashMap<>();
        for (GoodsSku skus : goodsSkus) {
            oldGoodsPropertyValueIdsSet.add(skus.getGoodsAttributeIds());
            propertyValueSkuIdMap.put(skus.getGoodsAttributeIds(), skus.getId());
        }

        Set<String> temp = new HashSet<>();
        temp.addAll(oldGoodsPropertyValueIdsSet);

        temp.removeAll(goodsPropertyValueIdsList);

        for (String goodsPropertyValueIds : temp) {
            delete(propertyValueSkuIdMap.get(goodsPropertyValueIds));
        }

        goodsPropertyValueIdsList.removeAll(oldGoodsPropertyValueIdsSet);
        GoodsSku goodsSku;
        for (int i = 0, l = goodsPropertyValueIdsList.size(); i < l; i++) {
            goodsSku = new GoodsSku();
            goodsSku.setGoodsId(goodsId);
            goodsSku.setGoodsAttributeIds(goodsPropertyValueIdsList.get(i));
            goodsSku.setSortNumber(i);
            save(goodsSku);
        }
    }

    @Override
    public PageResult<GoodsSkuResult> findAllTranslated(PageRequest pageRequest, Map<String, ?> param) throws Exception {
        PageResult<GoodsSku> page = super.findAll(pageRequest, param);
        PageResult<GoodsSkuResult> pageResult = new PageResult<>();
        pageResult.setSize(page.getSize());
        pageResult.setTotalElements(page.getTotalElements());
        pageResult.setContent(translateResults(page.getContent()));
        return pageResult;
    }

    @Override
    public List<GoodsSkuResult> findAllTranslated(Map<String, ?> param) throws Exception {
        return translateResults(super.findAll(param));
    }

    @Override
    public GoodsSkuResult findOneTranslated(String id) throws Exception {
        return translateResult(super.findOne(id));
    }

    private GoodsSkuResult translateResult(GoodsSku goodsSku) throws Exception {
        GoodsSkuResult goodsSkuResult = new GoodsSkuResult();
        BeanUtils.copyProperties(goodsSku, goodsSkuResult);
        goodsSkuResult.setGoods(goodsService.findOne(goodsSku.getGoodsId()));
        return goodsSkuResult;
    }

    private List<GoodsSkuResult> translateResults(List<GoodsSku> goodsSkus) throws Exception {
        List<GoodsSkuResult> goodsSkuResults = new ArrayList<>();
        for (GoodsSku goodsSku : goodsSkus) {
            goodsSkuResults.add(this.translateResult(goodsSku));
        }
        return goodsSkuResults;
    }

    @Override
    public void delete(String id) throws Exception {
        GoodsSku goodsSku = findOne(id);
        if(this.checkUsed(id)) {
            goodsSku.setLogicallyDeleted(true);
            save(goodsSku);
        } else {
            super.delete(id);
        }
    }

    @Override
    public void delete(Iterable<? extends GoodsSku> goodsSkus) throws Exception {
        for (GoodsSku skus : goodsSkus) {
            super.delete(skus.getId());
        }
    }

    private boolean checkUsed(String id) {
        return false;
    }

    @Lazy
    @Autowired
    public GoodsSkuServiceImpl(
            GoodsService goodsService
    ) {
        this.goodsService = goodsService;
    }
}
