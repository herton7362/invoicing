package com.herton.module.goods.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.common.PageResult;
import com.herton.common.utils.CacheUtils;
import com.herton.common.utils.StringUtils;
import com.herton.exceptions.BusinessException;
import com.herton.module.goods.domain.*;
import com.herton.module.goods.sku.service.GoodsSkuService;
import com.herton.module.goods.web.GoodsResult;
import com.herton.module.goods.web.GoodsSaveParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Component
@Transactional
public class GoodsServiceImpl extends AbstractCrudService<Goods> implements GoodsService {
    private final GoodsRepository goodsRepository;
    private final GoodsPriceService goodsPriceService;
    private final GoodsImageService goodsImageService;
    private final GoodsGoodsPropertyService goodsGoodsPropertyService;
    private final GoodsGoodsPropertyValueService goodsGoodsPropertyValueService;
    private final GoodsSkuService goodsSkuService;
    private final CacheUtils cache = CacheUtils.getInstance();
    @Override
    protected PageRepository<Goods> getRepository() {
        return goodsRepository;
    }

    private String concatTranslatedKey(String id) {
        return id + "_translated";
    }

    @Override
    public void save(GoodsSaveParam goodsSaveParam) throws Exception {
        if(StringUtils.isBlank(goodsSaveParam.getName())) {
            throw new BusinessException("商品名称不能为空");
        }
        if(StringUtils.isBlank(goodsSaveParam.getCode())) {
            throw new BusinessException("商品编码不能为空");
        }
        Goods goods = new Goods();
        BeanUtils.copyProperties(goodsSaveParam, goods);
        super.save(goods);
        GoodsPrice goodsPrice = new GoodsPrice();
        BeanUtils.copyProperties(goodsSaveParam.getBasicGoodsPrice(), goodsPrice);
        goodsPrice.setSortNumber(0);
        goodsPrice.setGoodsId(goods.getId());
        goodsPriceService.save(goodsPrice);
        GoodsPrice assistGoodsPrice1 = new GoodsPrice();
        BeanUtils.copyProperties(goodsSaveParam.getAssistGoodsPrice1(), assistGoodsPrice1);
        assistGoodsPrice1.setSortNumber(1);
        assistGoodsPrice1.setGoodsId(goods.getId());
        goodsPriceService.save(assistGoodsPrice1);
        GoodsPrice assistGoodsPrice2 = new GoodsPrice();
        BeanUtils.copyProperties(goodsSaveParam.getAssistGoodsPrice2(), assistGoodsPrice2);
        assistGoodsPrice2.setSortNumber(1);
        assistGoodsPrice2.setGoodsId(goods.getId());
        goodsPriceService.save(assistGoodsPrice2);
        GoodsImage goodsImage = new GoodsImage();
        BeanUtils.copyProperties(goodsSaveParam.getGoodsCoverImage(), goodsImage);
        goodsImage.setGoodsId(goods.getId());
        goodsImage.setSortNumber(0);
        goodsImageService.save(goodsImage);
        goodsImage = new GoodsImage();
        BeanUtils.copyProperties(goodsSaveParam.getGoodsAttached1Image(), goodsImage);
        goodsImage.setGoodsId(goods.getId());
        goodsImage.setSortNumber(1);
        goodsImageService.save(goodsImage);
        goodsImage = new GoodsImage();
        BeanUtils.copyProperties(goodsSaveParam.getGoodsAttached2Image(), goodsImage);
        goodsImage.setGoodsId(goods.getId());
        goodsImage.setSortNumber(2);
        goodsImageService.save(goodsImage);
        goodsImage = new GoodsImage();
        BeanUtils.copyProperties(goodsSaveParam.getGoodsAttached3Image(), goodsImage);
        goodsImage.setGoodsId(goods.getId());
        goodsImage.setSortNumber(3);
        goodsImageService.save(goodsImage);
        goodsImage = new GoodsImage();
        BeanUtils.copyProperties(goodsSaveParam.getGoodsAttached4Image(), goodsImage);
        goodsImage.setGoodsId(goods.getId());
        goodsImage.setSortNumber(4);
        goodsImageService.save(goodsImage);
        List<GoodsSaveParam.GoodsGoodsPropertyParam> goodsGoodsProperties = goodsSaveParam.getGoodsGoodsProperties();
        this.deleteUnusedGoodsProperties(goods.getId(), goodsGoodsProperties);
        GoodsGoodsProperty goodsGoodsProperty;
        List<List<String>> goodsPropertyValueIdsList = new ArrayList<>();
        List<String> goodsPropertyValueIds;
        for (int i = 0; i < goodsGoodsProperties.size(); i++) {
            goodsGoodsProperty = new GoodsGoodsProperty();
            BeanUtils.copyProperties(goodsGoodsProperties.get(i), goodsGoodsProperty);
            goodsGoodsProperty.setSortNumber(i);
            goodsGoodsProperty.setGoodsId(goods.getId());
            goodsGoodsPropertyService.save(goodsGoodsProperty);
            List<GoodsGoodsPropertyValue> goodsGoodsPropertyValues = goodsGoodsProperties.get(i).getGoodsGoodsPropertyValues();
            this.deleteUnusedGoodsPropertyValues(goodsGoodsProperty.getId(), goodsGoodsPropertyValues);
            goodsPropertyValueIds = new ArrayList<>();
            for (int j = 0; j < goodsGoodsPropertyValues.size(); j++) {
                goodsGoodsPropertyValues.get(j).setSortNumber(j);
                goodsGoodsPropertyValues.get(j).setGoodsGoodsPropertyId(goodsGoodsProperty.getId());
                goodsGoodsPropertyValueService.save(goodsGoodsPropertyValues.get(j));
                goodsPropertyValueIds.add(goodsGoodsPropertyValues.get(j).getGoodsPropertyValueId());
            }
            goodsPropertyValueIdsList.add(goodsPropertyValueIds);
        }
        goodsSkuService.refreshGoodsSkuByRaw(goods.getId(), goodsPropertyValueIdsList);
        cache.set(goods.getId(), goods);
        cache.set(concatTranslatedKey(goods.getId()), findOneTranslated(goods.getId()));
    }

    private void deleteUnusedGoodsProperties(String goodsId,
                                             List<GoodsSaveParam.GoodsGoodsPropertyParam> goodsGoodsPropertyParams) throws Exception {
        Map<String, String> param = new HashMap<>();
        param.put("goodsId", goodsId);
        List<GoodsGoodsProperty> goodsGoodsProperties = goodsGoodsPropertyService.findAll(param);
        Set<String> oldIds = new HashSet<>();
        Set<String> newIds = new HashSet<>();
        Map<String, GoodsSaveParam.GoodsGoodsPropertyParam> goodsGoodsPropertyParamMap = new HashMap<>();
        goodsGoodsProperties.forEach(goodsGoodsProperty -> oldIds.add(goodsGoodsProperty.getGoodsPropertyId()));
        goodsGoodsPropertyParams.forEach(goodsGoodsPropertyParam -> {
            newIds.add(goodsGoodsPropertyParam.getGoodsPropertyId());
            goodsGoodsPropertyParamMap.put(goodsGoodsPropertyParam.getGoodsPropertyId(), goodsGoodsPropertyParam);
        });

        oldIds.removeAll(newIds);
        for (GoodsGoodsProperty goodsGoodsProperty : goodsGoodsProperties) {
            if(oldIds.contains(goodsGoodsProperty.getGoodsPropertyId())) {
                goodsGoodsPropertyService.delete(goodsGoodsProperty.getId());
                param.clear();
                param.put("goodsGoodsPropertyId", goodsGoodsProperty.getId());
                goodsGoodsPropertyValueService.delete(goodsGoodsPropertyValueService.findAll(param));
            } else {
                BeanUtils.copyProperties(goodsGoodsProperty, goodsGoodsPropertyParamMap.get(goodsGoodsProperty.getGoodsPropertyId()));
            }
        }
    }

    private void deleteUnusedGoodsPropertyValues(String goodsGoodsPropertyId,
                                                 List<GoodsGoodsPropertyValue> goodsGoodsPropertyValues) throws Exception {
        Map<String, String> param = new HashMap<>();
        param.put("goodsGoodsPropertyId", goodsGoodsPropertyId);
        List<GoodsGoodsPropertyValue> goodsGoodsPropertyValues1 = goodsGoodsPropertyValueService.findAll(param);
        Set<String> oldIds = new HashSet<>();
        Set<String> newIds = new HashSet<>();
        Map<String, GoodsGoodsPropertyValue> goodsGoodsPropertyValueMap = new HashMap<>();
        goodsGoodsPropertyValues1.forEach(goodsGoodsPropertyValue -> oldIds.add(goodsGoodsPropertyValue.getGoodsPropertyValueId()));
        goodsGoodsPropertyValues.forEach(goodsGoodsPropertyValue -> {
            newIds.add(goodsGoodsPropertyValue.getGoodsPropertyValueId());
            goodsGoodsPropertyValueMap.put(goodsGoodsPropertyValue.getGoodsPropertyValueId(), goodsGoodsPropertyValue);
        });
        oldIds.removeAll(newIds);
        for (GoodsGoodsPropertyValue goodsGoodsPropertyValue : goodsGoodsPropertyValues1) {
            if(oldIds.contains(goodsGoodsPropertyValue.getGoodsPropertyValueId())) {
                goodsGoodsPropertyValueService.delete(goodsGoodsPropertyValue.getId());
            } else {
                BeanUtils.copyProperties(goodsGoodsPropertyValue,
                        goodsGoodsPropertyValueMap.get(goodsGoodsPropertyValue.getGoodsPropertyValueId()));
            }
        }
    }

    @Override
    public PageResult<GoodsResult> findAllTranslated(PageRequest pageRequest, Map<String, ?> param) throws Exception {
        PageResult<Goods> page = super.findAll(pageRequest, param);
        PageResult<GoodsResult> pageResult = new PageResult<>();
        pageResult.setSize(page.getSize());
        pageResult.setTotalElements(page.getTotalElements());
        pageResult.setContent(translateResults(page.getContent()));
        return pageResult;
    }

    @Override
    public List<GoodsResult> findAllTranslated(Map<String, ?> param) throws Exception {
        return translateResults(super.findAll(param));
    }

    @Override
    public GoodsResult findOneTranslated(String id) throws Exception {
        if(cache.get(concatTranslatedKey(id)) != null) {
            return (GoodsResult) cache.get(concatTranslatedKey(id));
        }
        Goods goods = super.findOne(id);
        GoodsResult goodsResult = translateResult(goods);
        cache.set(concatTranslatedKey(id), goodsResult);
        return goodsResult;
    }

    @Override
    public void delete(String id) throws Exception {
        Map<String, String> param = new HashMap<>();
        param.put("goodsId", id);
        goodsPriceService.delete(goodsPriceService.findAll(param));
        goodsImageService.delete(goodsImageService.findAll(param));
        goodsSkuService.delete(goodsSkuService.findAll(param));
        super.delete(id);
        cache.remove(concatTranslatedKey(id));
        cache.remove(id);
    }

    @Override
    public void delete(Iterable<? extends Goods> goodses) throws Exception {
        for (Goods goods : goodses) {
            delete(goods.getId());
        }
    }

    private GoodsResult translateResult(Goods goods) throws Exception {
        GoodsResult goodsResult = new GoodsResult();
        PageRequest pageRequest = new PageRequest(0, Integer.MAX_VALUE, new Sort(Sort.Direction.ASC, "sortNumber"));
        BeanUtils.copyProperties(goods, goodsResult);
        Map<String, String> param = new HashMap<>();
        param.put("goodsId", goods.getId());
        PageResult<GoodsPrice> goodsPricePageResult  = goodsPriceService.findAll(pageRequest, param);
        List<GoodsPrice> goodsPrices = goodsPricePageResult.getContent();
        GoodsResult.GoodsPriceResult goodsPriceResult = new GoodsResult.GoodsPriceResult();
        BeanUtils.copyProperties(goodsPrices.get(0), goodsPriceResult);
        goodsResult.setBasicGoodsPrice(goodsPriceResult);
        goodsPriceResult = new GoodsResult.GoodsPriceResult();
        BeanUtils.copyProperties(goodsPrices.get(1), goodsPriceResult);
        goodsResult.setAssistGoodsPrice1(goodsPriceResult);
        goodsPriceResult = new GoodsResult.GoodsPriceResult();
        BeanUtils.copyProperties(goodsPrices.get(2), goodsPriceResult);
        goodsResult.setAssistGoodsPrice2(goodsPriceResult);
        PageResult<GoodsImage> goodsImagePageResult = goodsImageService.findAll(pageRequest, param);
        List<GoodsImage> goodsImages = goodsImagePageResult.getContent();
        GoodsResult.GoodsImageResult goodsImageResult = new GoodsResult.GoodsImageResult();
        BeanUtils.copyProperties(goodsImages.get(0), goodsImageResult);
        goodsResult.setGoodsCoverImage(goodsImageResult);
        goodsImageResult = new GoodsResult.GoodsImageResult();
        BeanUtils.copyProperties(goodsImages.get(1), goodsImageResult);
        goodsResult.setGoodsAttached1Image(goodsImageResult);
        goodsImageResult = new GoodsResult.GoodsImageResult();
        BeanUtils.copyProperties(goodsImages.get(2), goodsImageResult);
        goodsResult.setGoodsAttached2Image(goodsImageResult);
        goodsImageResult = new GoodsResult.GoodsImageResult();
        BeanUtils.copyProperties(goodsImages.get(3), goodsImageResult);
        goodsResult.setGoodsAttached3Image(goodsImageResult);
        goodsImageResult = new GoodsResult.GoodsImageResult();
        BeanUtils.copyProperties(goodsImages.get(4), goodsImageResult);
        goodsResult.setGoodsAttached4Image(goodsImageResult);

        List<GoodsGoodsProperty> goodsGoodsProperties = goodsGoodsPropertyService.findAll(param);
        List<GoodsResult.GoodsGoodsPropertyResult> goodsGoodsPropertyResults = new ArrayList<>();
        GoodsResult.GoodsGoodsPropertyResult goodsGoodsPropertyResult;
        for (GoodsGoodsProperty goodsGoodsProperty : goodsGoodsProperties) {
            goodsGoodsPropertyResult = new GoodsResult.GoodsGoodsPropertyResult();
            BeanUtils.copyProperties(goodsGoodsProperty, goodsGoodsPropertyResult);
            param.clear();
            param.put("goodsGoodsPropertyId", goodsGoodsProperty.getId());
            goodsGoodsPropertyResult.setGoodsGoodsPropertyValues(goodsGoodsPropertyValueService.findAll(param));
            goodsGoodsPropertyResults.add(goodsGoodsPropertyResult);
        }
        goodsResult.setGoodsGoodsProperties(goodsGoodsPropertyResults);
        return goodsResult;
    }

    private List<GoodsResult> translateResults(List<Goods> goodses) throws Exception {
        List<GoodsResult> goodsResults = new ArrayList<>();
        for (Goods goods : goodses) {
            goodsResults.add(this.translateResult(goods));
        }
        return goodsResults;
    }

    @Lazy
    @Autowired
    public GoodsServiceImpl(
            GoodsRepository goodsRepository,
            GoodsPriceService goodsPriceService,
            GoodsImageService goodsImageService,
            GoodsGoodsPropertyService goodsGoodsPropertyService,
            GoodsGoodsPropertyValueService goodsGoodsPropertyValueService,
            GoodsSkuService goodsSkuService
    ) {
        this.goodsRepository = goodsRepository;
        this.goodsPriceService = goodsPriceService;
        this.goodsImageService = goodsImageService;
        this.goodsGoodsPropertyService = goodsGoodsPropertyService;
        this.goodsGoodsPropertyValueService = goodsGoodsPropertyValueService;
        this.goodsSkuService = goodsSkuService;
    }
}
