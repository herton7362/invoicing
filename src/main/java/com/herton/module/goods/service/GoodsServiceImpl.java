package com.herton.module.goods.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageResult;
import com.herton.common.utils.StringUtils;
import com.herton.exceptions.InvalidParamException;
import com.herton.module.goods.domain.Goods;
import com.herton.module.goods.domain.GoodsAttribute;
import com.herton.module.goods.domain.GoodsRepository;
import com.herton.module.goods.domain.GoodsSupplier;
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
public class GoodsServiceImpl extends AbstractCrudService<GoodsRepository, Goods> implements GoodsService {
    private final GoodsSkuService goodsSkuService;
    private final GoodsAttributeService goodsAttributeService;
    private final GoodsSupplierService goodsSupplierService;

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
        if(StringUtils.isNotBlank(goods.getGoodsTypeId())) {
            List<GoodsAttribute> goodsAttributes = saveAttributes(goods.getId(), goodsSaveParam);
            saveSkus(goods.getId(), goodsSaveParam, goodsAttributes);
        } else {
            Map<String, String> param = new HashMap<>();
            param.put("goodsId", goods.getId());
            goodsAttributeService.delete(goodsAttributeService.findAll(param));
            goodsSkuService.delete(goodsSkuService.findAll(param));
        }
        saveSuppliers(goods.getId(), goodsSaveParam);
    }

    private List<GoodsAttribute> saveAttributes(String goodsId, GoodsSaveParam goodsSaveParam) throws Exception {
        List<GoodsAttribute> goodsAttributes = goodsSaveParam.getGoodsAttributes();
        Boolean isCreate = true;
        List<GoodsAttribute> newGoodsAttributes = new ArrayList<>();
        if(StringUtils.isNotBlank(goodsSaveParam.getId())) {
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
            String[] attrs = goodsSkuParam.getGoodsAttributes().split(",");
            List<String> attrList = Arrays.asList(attrs);
            List<String> goodsAttributeIds  = goodsAttributes
                    .stream()
                    .filter(goodsAttribute -> attrList
                            .stream()
                            .anyMatch(attr -> goodsAttribute.getGoodsTypeAttributeId().equals(attr.split(":")[0])
                                    && goodsAttribute.getGoodsTypeAttributeValue().equals(attr.split(":")[1])))
                    .map(goodsAttribute -> goodsAttribute.getId())
                    .collect(Collectors.toList());
            goodsSku.setGoodsAttributeIds(String.join(",", goodsAttributeIds));
            goodsSkus.add(goodsSku);
        });
        Boolean isCreate = true;
        if(StringUtils.isNotBlank(goodsSaveParam.getId())) {
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
                            .noneMatch(sku -> {
                                String[] attrIds1 = goodsSku.getGoodsAttributeIds().split(",");
                                String[] attrIds2 = sku.getGoodsAttributeIds().split(",");
                                return arrayMatches(attrIds1, attrIds2);
                            }))
                    .forEach(goodsSku -> {
                        try {
                            goodsSkuService.delete(goodsSku.getId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });

            for (GoodsSku goodsSku : goodsSkus) {
                final Optional<GoodsSku> oldGoodsSkuOptional = oldGoodsSkus
                        .stream()
                        .filter(sku -> {
                            String[] attrIds1 = goodsSku.getGoodsAttributeIds().split(",");
                            String[] attrIds2 = sku.getGoodsAttributeIds().split(",");
                            return arrayMatches(attrIds1, attrIds2);
                        })
                        .findFirst();

                if(oldGoodsSkuOptional.isPresent()) {
                    final GoodsSku oldGoodsSku = oldGoodsSkuOptional.get();
                    goodsSku.setId(oldGoodsSku.getId());
                    goodsSku.setSortNumber(oldGoodsSku.getSortNumber());
                    goodsSku.setLogicallyDeleted(oldGoodsSku.getLogicallyDeleted());
                    goodsSku.setCreatedDate(oldGoodsSku.getCreatedDate());
                    goodsSku.setCreateUserId(oldGoodsSku.getCreateUserId());
                    goodsSku.setClientId(oldGoodsSku.getClientId());
                    goodsSku.setUpdatedDate(oldGoodsSku.getUpdatedDate());
                    goodsSkuService.save(goodsSku);
                } else {
                    goodsSku.setGoodsId(goodsId);
                    goodsSkuService.save(goodsSku);
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

    private void saveSuppliers(String goodsId, GoodsSaveParam goodsSaveParam) throws Exception {
        List<GoodsSupplier> goodsSuppliers = new ArrayList<>();
        Boolean isCreate = true;
        if(StringUtils.isNotBlank(goodsSaveParam.getId())) {
            isCreate = false;
        }
        if(goodsSaveParam.getGoodsSuppliers() != null) {
            goodsSuppliers.addAll(goodsSaveParam.getGoodsSuppliers());
        }
        if(isCreate) {
            for (GoodsSupplier goodsSupplier : goodsSuppliers) {
                goodsSupplier.setGoodsId(goodsId);
                goodsSupplierService.save(goodsSupplier);
            }
        } else {
            Map<String, String> params = new HashMap<>();
            params.put("goodsId", goodsId);
            List<GoodsSupplier> oldGoodsSuppliers = goodsSupplierService.findAll(params);

            oldGoodsSuppliers
                    .stream()
                    .filter(goodsSupplier -> goodsSuppliers
                            .stream()
                            .noneMatch(supplier ->
                                    supplier.getBusinessRelatedUnitId().equals(goodsSupplier.getBusinessRelatedUnitId())))
                    .forEach(goodsSupplier -> {
                        try {
                            goodsSupplierService.delete(goodsSupplier.getId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });

            goodsSuppliers.stream().filter(goodsSupplier -> oldGoodsSuppliers
                    .stream()
                    .noneMatch(supplier ->
                            supplier.getBusinessRelatedUnitId().equals(goodsSupplier.getBusinessRelatedUnitId())))
                    .forEach(goodsSupplier -> {
                        try {
                            goodsSupplier.setGoodsId(goodsId);
                            goodsSupplierService.save(goodsSupplier);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
        }
    }

    @Override
    public PageResult<GoodsResult> findAllTranslated(PageRequest pageRequest, Map<String, ?> param) throws Exception {
        PageResult<Goods> page = new PageResult<>(pageRepository.findAll(new GoodsSpecification(param), pageRequest));
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
        goodsAttributeService.delete(goodsAttributeService.findAll(param));
        goodsSkuService.delete(goodsSkuService.findAll(param));
        goodsSupplierService.delete(goodsSupplierService.findAll(param));
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
        goodsResult.setGoodsAttributes(goodsAttributeService.findAll(param));
        List<GoodsSku> goodsSkus = goodsSkuService.findAll(param);
        List<GoodsResult.GoodsSkuResult> goodsSkuResults = new ArrayList<>();
        GoodsResult.GoodsSkuResult goodsSkuResult;
        for (GoodsSku goodsSku : goodsSkus) {
            goodsSkuResult = new GoodsResult.GoodsSkuResult();
            BeanUtils.copyProperties(goodsSku, goodsSkuResult);
            String[] goodsAttrIds = goodsSku.getGoodsAttributeIds().split(",");
            List<String> goodsAttrIdList = Arrays.asList(goodsAttrIds);
            goodsSkuResult.setGoodsAttributes(String.join(",", goodsAttrIdList
                    .stream()
                    .map(goodsAttrId -> {
                        try {
                            GoodsAttribute goodsAttribute = goodsAttributeService.findOne(goodsAttrId);
                            return goodsAttribute.getGoodsTypeAttributeId() + ":" + goodsAttribute.getGoodsTypeAttributeValue();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return "";
                    })
                    .collect(Collectors.toList())));
            goodsSkuResults.add(goodsSkuResult);
        }
        goodsResult.setGoodsSkus(goodsSkuResults);
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
                predicates.add(criteriaBuilder.like(root.get("barcode"), "%"+ value[0] +"%"));
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
            GoodsSkuService goodsSkuService,
            GoodsAttributeService goodsAttributeService,
            GoodsSupplierService goodsSupplierService
    ) {
        this.goodsSkuService = goodsSkuService;
        this.goodsAttributeService = goodsAttributeService;
        this.goodsSupplierService = goodsSupplierService;
    }
}
