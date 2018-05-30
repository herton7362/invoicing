package com.herton.module.goods.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageResult;
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
        Boolean isCreate = true;
        List<GoodsAttribute> newGoodsAttributes = new ArrayList<>();
        if(StringUtils.isNotBlank(goodsSaveParam.getId())) {
            isCreate = false;
        }
        Goods goods = new Goods();
        BeanUtils.copyProperties(goodsSaveParam, goods);
        super.save(goods);
        if(StringUtils.isNotBlank(goods.getGoodsTypeId())) {
            List<GoodsAttribute> goodsAttributes =
                    goodsAttributeService.save(isCreate, goods.getId(), goodsSaveParam.getGoodsAttributes());
            goodsSkuService.save(isCreate, goods.getId(), goodsSaveParam.getGoodsSkus(), goodsAttributes);
        } else {
            Map<String, String> param = new HashMap<>();
            param.put("goodsId", goods.getId());
            goodsAttributeService.delete(goodsAttributeService.findAll(param));
            goodsSkuService.delete(goodsSkuService.findAll(param));
        }
        goodsSupplierService.save(isCreate, goods.getId(), goodsSaveParam.getGoodsSuppliers());
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
        goodsResult.setGoodsSuppliers(goodsSupplierService.findAll(param));
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
