package com.herton.module.goods.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.common.PageResult;
import com.herton.common.utils.CacheUtils;
import com.herton.common.utils.StringUtils;
import com.herton.exceptions.InvalidParamException;
import com.herton.module.goods.domain.*;
import com.herton.module.goods.sku.domain.GoodsSku;
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

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;
import java.util.stream.Collectors;

@Component
@Transactional
public class GoodsServiceImpl extends AbstractCrudService<Goods> implements GoodsService {
    private final GoodsRepository goodsRepository;
    private final GoodsPriceService goodsPriceService;
    private final GoodsImageService goodsImageService;
    private final GoodsSkuService goodsSkuService;
    private final GoodsAttributeService goodsAttributeService;
    @Override
    protected PageRepository<Goods> getRepository() {
        return goodsRepository;
    }

    @Override
    public void save(GoodsSaveParam goodsSaveParam) throws Exception {
        if(StringUtils.isBlank(goodsSaveParam.getName())) {
            throw new InvalidParamException("商品名称不能为空");
        }
        if(StringUtils.isBlank(goodsSaveParam.getCode())) {
            throw new InvalidParamException("商品编码不能为空");
        }
        Goods goods = new Goods();
        BeanUtils.copyProperties(goodsSaveParam, goods);
        super.save(goods);
        savePrice(goods.getId(), goodsSaveParam);
        saveImage(goods.getId(), goodsSaveParam);
        List<GoodsAttribute> goodsAttributes = saveAtrributes(goods.getId(), goodsSaveParam);
        saveSkus(goods.getId(), goodsSaveParam, goodsAttributes);
    }

    private void savePrice(String goodsId, GoodsSaveParam goodsSaveParam) throws Exception {
        GoodsPrice goodsPrice = new GoodsPrice();
        BeanUtils.copyProperties(goodsSaveParam.getBasicGoodsPrice(), goodsPrice);
        goodsPrice.setSortNumber(0);
        goodsPrice.setGoodsId(goodsId);
        goodsPriceService.save(goodsPrice);
        GoodsPrice assistGoodsPrice1 = new GoodsPrice();
        BeanUtils.copyProperties(goodsSaveParam.getAssistGoodsPrice1(), assistGoodsPrice1);
        assistGoodsPrice1.setSortNumber(1);
        assistGoodsPrice1.setGoodsId(goodsId);
        goodsPriceService.save(assistGoodsPrice1);
        GoodsPrice assistGoodsPrice2 = new GoodsPrice();
        BeanUtils.copyProperties(goodsSaveParam.getAssistGoodsPrice2(), assistGoodsPrice2);
        assistGoodsPrice2.setSortNumber(1);
        assistGoodsPrice2.setGoodsId(goodsId);
        goodsPriceService.save(assistGoodsPrice2);
    }

    private void saveImage(String goodsId, GoodsSaveParam goodsSaveParam) throws Exception {
        GoodsImage goodsImage = new GoodsImage();
        BeanUtils.copyProperties(goodsSaveParam.getGoodsCoverImage(), goodsImage);
        goodsImage.setGoodsId(goodsId);
        goodsImage.setSortNumber(0);
        goodsImageService.save(goodsImage);
        goodsImage = new GoodsImage();
        BeanUtils.copyProperties(goodsSaveParam.getGoodsAttached1Image(), goodsImage);
        goodsImage.setGoodsId(goodsId);
        goodsImage.setSortNumber(1);
        goodsImageService.save(goodsImage);
        goodsImage = new GoodsImage();
        BeanUtils.copyProperties(goodsSaveParam.getGoodsAttached2Image(), goodsImage);
        goodsImage.setGoodsId(goodsId);
        goodsImage.setSortNumber(2);
        goodsImageService.save(goodsImage);
        goodsImage = new GoodsImage();
        BeanUtils.copyProperties(goodsSaveParam.getGoodsAttached3Image(), goodsImage);
        goodsImage.setGoodsId(goodsId);
        goodsImage.setSortNumber(3);
        goodsImageService.save(goodsImage);
        goodsImage = new GoodsImage();
        BeanUtils.copyProperties(goodsSaveParam.getGoodsAttached4Image(), goodsImage);
        goodsImage.setGoodsId(goodsId);
        goodsImage.setSortNumber(4);
        goodsImageService.save(goodsImage);
    }

    private List<GoodsAttribute> saveAtrributes(String goodsId, GoodsSaveParam goodsSaveParam) throws Exception {
        List<GoodsAttribute> goodsAttributes = goodsSaveParam.getGoodsAttributes();
        Boolean isCreate = true;
        Goods old = null;
        List<GoodsAttribute> newGoodsAttributes = new ArrayList<>();
        if(StringUtils.isNotBlank(goodsSaveParam.getId())) {
            old = findOne(goodsSaveParam.getId());
            isCreate = false;
        }
        if(isCreate) {
            for (GoodsAttribute goodsAttribute : goodsAttributes) {
                goodsAttribute.setGoodsId(goodsId);
                goodsAttributeService.save(goodsAttribute);
                newGoodsAttributes.add(goodsAttribute);
            }
        } else {
            Map<String, String> params = new HashMap<>();
            params.put("goodsId", goodsId);
            List<GoodsAttribute> oldGoodsAttributes = goodsAttributeService.findAll(params);

            newGoodsAttributes.addAll(oldGoodsAttributes);
            oldGoodsAttributes
                    .stream()
                    .filter(goodsAttribute -> goodsAttributes
                            .stream()
                            .noneMatch(attr ->
                                    attr.getGoodsTypeAttributeId().equals(goodsAttribute.getGoodsTypeAttributeId())
                                            && attr.getGoodsTypeAttributeValue().equals(goodsAttribute.getGoodsTypeAttributeValue())
                            ))
                    .forEach(goodsAttribute -> {
                        try {
                            newGoodsAttributes.remove(goodsAttribute);
                            goodsAttributeService.delete(goodsAttribute.getId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });

            goodsAttributes.stream().filter(goodsAttribute -> oldGoodsAttributes
                    .stream()
                    .noneMatch(attr ->
                            attr.getGoodsTypeAttributeId().equals(goodsAttribute.getGoodsTypeAttributeId())
                                    && attr.getGoodsTypeAttributeValue().equals(goodsAttribute.getGoodsTypeAttributeValue())
                    ))
                    .forEach(goodsAttribute -> {
                        try {
                            goodsAttribute.setGoodsId(goodsId);
                            goodsAttributeService.save(goodsAttribute);
                            newGoodsAttributes.add(goodsAttribute);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
        }
        return newGoodsAttributes;
    }

    private void saveSkus(String goodsId, GoodsSaveParam goodsSaveParam, List<GoodsAttribute> goodsAttributes) throws Exception {
        List<GoodsSaveParam.GoodsSkuParam> goodsSkuParams = goodsSaveParam.getGoodsSkus();
        List<GoodsSku> goodsSkus = new ArrayList<>();
        goodsSkuParams.forEach(goodsSkuParam -> {
            GoodsSku goodsSku = new GoodsSku();
            BeanUtils.copyProperties(goodsSkuParam, goodsSku);
            String[] values = goodsSkuParam.getGoodsAttributeValues().split(",");
            List<String> valueList = Arrays.asList(values);
            List<String> goodsAttributeIds  = goodsAttributes
                    .stream()
                    .filter(goodsAttribute -> valueList.contains(goodsAttribute.getGoodsTypeAttributeValue()))
                    .map(goodsAttribute -> goodsAttribute.getId())
                    .collect(Collectors.toList());
            goodsSku.setGoodsAttributeIds(String.join(",", goodsAttributeIds));
            goodsSkus.add(goodsSku);
        });
        Boolean isCreate = true;
        Goods old = null;
        if(StringUtils.isNotBlank(goodsSaveParam.getId())) {
            old = findOne(goodsSaveParam.getId());
            isCreate = false;
        }
        if(isCreate) {
            for (GoodsSku goodsSku : goodsSkus) {
                goodsSku.setGoodsId(goodsId);
                goodsSkuService.save(goodsSku);
            }
        } else {
            Map<String, String> params = new HashMap<>();
            params.put("goodsId", goodsId);
            List<GoodsSku> oldGoodsSkus = goodsSkuService.findAll(params);
            oldGoodsSkus
                    .stream()
                    .filter(goodsSku -> goodsSkus
                            .stream()
                            .noneMatch(sku ->goodsSku.getGoodsAttributeIds().equals(sku.getGoodsAttributeIds())))
                    .forEach(goodsSku -> {
                        try {
                            goodsSkuService.delete(goodsSku.getId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });

            goodsSkus.stream().filter(goodsSku -> oldGoodsSkus
                    .stream()
                    .noneMatch(sku ->goodsSku.getGoodsAttributeIds().equals(sku.getGoodsAttributeIds())))
                    .forEach(goodsSku -> {
                        try {
                            goodsSku.setGoodsId(goodsId);
                            goodsSkuService.save(goodsSku);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
        }
    }

    @Override
    public PageResult<GoodsResult> findAllTranslated(PageRequest pageRequest, Map<String, ?> param) throws Exception {
        PageResult<Goods> page = new PageResult<>(getRepository().findAll(new GoodsSpecification(param), pageRequest));
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
        Goods goods = super.findOne(id);
        return translateResult(goods);
    }

    @Override
    public void delete(String id) throws Exception {
        Map<String, String> param = new HashMap<>();
        param.put("goodsId", id);
        goodsPriceService.delete(goodsPriceService.findAll(param));
        goodsImageService.delete(goodsImageService.findAll(param));
        goodsSkuService.delete(goodsSkuService.findAll(param));
        super.delete(id);
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
        goodsResult.setGoodsAttributes(goodsAttributeService.findAll(param));
        return goodsResult;
    }

    private List<GoodsResult> translateResults(List<Goods> goodses) throws Exception {
        List<GoodsResult> goodsResults = new ArrayList<>();
        for (Goods goods : goodses) {
            goodsResults.add(this.translateResult(goods));
        }
        return goodsResults;
    }

    class GoodsSpecification extends SimpleSpecification {

        GoodsSpecification(Map<String, ?> params) {
            super(params, false);
        }

        @Override
        public Predicate toPredicate(Root<Goods> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            Predicate predicate = super.toPredicate(root, criteriaQuery, criteriaBuilder);
            List<Predicate> predicates = new ArrayList<>();
            if(params.containsKey("quickSearch")) {
                String[] value = params.get("quickSearch");
                predicates.add(criteriaBuilder.like(root.get("name"), "%"+ value[0] +"%"));
                predicates.add(criteriaBuilder.like(root.get("code"), "%"+ value[0] +"%"));
                predicates.add(criteriaBuilder.like(root.get("shortname"), "%"+ value[0] +"%"));
                predicates.add(criteriaBuilder.like(root.get("pinyin"), "%"+ value[0] +"%"));
                predicates.add(criteriaBuilder.like(root.get("remark"), "%"+ value[0] +"%"));
                Predicate predicateTemp = criteriaBuilder.or(predicates.toArray(new Predicate[]{}));
                predicates.clear();
                predicates.add(predicateTemp);
            }
            predicates.add(predicate);
            return criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
        }
    }

    @Lazy
    @Autowired
    public GoodsServiceImpl(
            GoodsRepository goodsRepository,
            GoodsPriceService goodsPriceService,
            GoodsImageService goodsImageService,
            GoodsSkuService goodsSkuService,
            GoodsAttributeService goodsAttributeService
    ) {
        this.goodsRepository = goodsRepository;
        this.goodsPriceService = goodsPriceService;
        this.goodsImageService = goodsImageService;
        this.goodsSkuService = goodsSkuService;
        this.goodsAttributeService = goodsAttributeService;
    }
}
