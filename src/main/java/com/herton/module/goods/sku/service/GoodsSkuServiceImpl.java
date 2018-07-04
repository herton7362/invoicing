package com.herton.module.goods.sku.service;

import com.herton.common.AbstractCrudService;
import com.herton.module.goods.service.GoodsService;
import com.herton.module.goods.sku.domain.GoodsSku;
import com.herton.module.goods.sku.dto.GoodsSkuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Component
@Transactional
public class GoodsSkuServiceImpl extends AbstractCrudService<GoodsSku, GoodsSkuDTO> implements GoodsSkuService {
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
        List<GoodsSkuDTO> goodsSkus = findAll(param);

        Set<String> oldGoodsPropertyValueIdsSet = new HashSet<>();
        Map<String, String> propertyValueSkuIdMap = new HashMap<>();
        for (GoodsSkuDTO skus : goodsSkus) {
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
        GoodsSkuDTO goodsSku;
        for (int i = 0, l = goodsPropertyValueIdsList.size(); i < l; i++) {
            goodsSku = new GoodsSkuDTO();
            goodsSku.setGoodsId(goodsId);
            goodsSku.setGoodsAttributeIds(goodsPropertyValueIdsList.get(i));
            goodsSku.setSortNumber(i);
            save(goodsSku);
        }
    }

    @Override
    public void save(Boolean isCreate,
                     String goodsId,
                     List<GoodsSkuDTO> goodsSkus) throws Exception {

        if(isCreate) {
            for (GoodsSkuDTO goodsSku : goodsSkus) {
                goodsSku.setGoodsId(goodsId);
                save(goodsSku);
            }
        } else {
            Map<String, String> params = new HashMap<>();
            params.put("goodsId", goodsId);
            List<GoodsSkuDTO> oldGoodsSkus = findAll(params);
            oldGoodsSkus
                    .stream()
                    .filter(goodsSku -> goodsSkus
                            .stream()
                            .noneMatch(sku -> {
                                String[] attrIds1 = goodsSku.getGoodsAttributeIds().split(",");
                                String[] attrIds2 = sku.getGoodsAttributeIds().split(",");
                                return arrayMatches(attrIds1, attrIds2);
                            }))
                    .forEach(goodsSku -> {
                        try {
                            delete(goodsSku.getId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });

            for (GoodsSkuDTO goodsSku : goodsSkus) {
                final Optional<GoodsSkuDTO> oldGoodsSkuOptional = oldGoodsSkus
                        .stream()
                        .filter(sku -> {
                            String[] attrIds1 = goodsSku.getGoodsAttributeIds().split(",");
                            String[] attrIds2 = sku.getGoodsAttributeIds().split(",");
                            return arrayMatches(attrIds1, attrIds2);
                        })
                        .findFirst();

                if(oldGoodsSkuOptional.isPresent()) {
                    final GoodsSkuDTO oldGoodsSku = oldGoodsSkuOptional.get();
                    goodsSku.setId(oldGoodsSku.getId());
                    goodsSku.setSortNumber(oldGoodsSku.getSortNumber());
                    goodsSku.setLogicallyDeleted(oldGoodsSku.getLogicallyDeleted());
                    save(goodsSku);
                } else {
                    goodsSku.setGoodsId(goodsId);
                    save(goodsSku);
                }
            }
        }
    }

    private Boolean arrayMatches(String[] arry1, String[] arr2) {
        List<String> attrIdList1 = Arrays.asList(arry1);
        List<String> attrIdList2 = Arrays.asList(arr2);
        return attrIdList1
                .stream()
                .allMatch(attrIdList2::contains);
    }

    @Override
    public void delete(String id) throws Exception {
        GoodsSkuDTO goodsSku = findOne(id);
        if(this.checkUsed(id)) {
            goodsSku.setLogicallyDeleted(true);
            save(goodsSku);
        } else {
            super.delete(id);
        }
    }

    @Override
    public void delete(Iterable<? extends GoodsSkuDTO> goodsSkus) throws Exception {
        for (GoodsSkuDTO skus : goodsSkus) {
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
