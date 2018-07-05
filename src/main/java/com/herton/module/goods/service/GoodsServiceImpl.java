package com.herton.module.goods.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.utils.StringUtils;
import com.herton.exceptions.InvalidParamException;
import com.herton.module.goods.domain.Goods;
import com.herton.module.goods.domain.GoodsAttribute;
import com.herton.module.goods.dto.GoodsDTO;
import com.herton.module.goods.sku.service.GoodsSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Transactional
public class GoodsServiceImpl extends AbstractCrudService<Goods, GoodsDTO> implements GoodsService {
    private final GoodsSkuService goodsSkuService;
    private final GoodsAttributeService goodsAttributeService;
    private final GoodsSupplierService goodsSupplierService;

    @Override
    public GoodsDTO save(GoodsDTO goodsDTO) throws Exception {
        if(StringUtils.isBlank(goodsDTO.getName())) {
            throw new InvalidParamException("商品名称不能为空");
        }
        if(StringUtils.isBlank(goodsDTO.getCode())) {
            throw new InvalidParamException("商品编码不能为空");
        }
        Boolean isCreate = true;
        List<GoodsAttribute> newGoodsAttributes = new ArrayList<>();
        if(StringUtils.isNotBlank(goodsDTO.getId())) {
            isCreate = false;
        }
        super.save(goodsDTO);
        if(StringUtils.isNotBlank(goodsDTO.getGoodsTypeId())) {
            goodsAttributeService.saveAsChildren(goodsDTO.getGoodsAttributes()
                    .stream().map(dto -> {
                        dto.setGoodsId(goodsDTO.getId());
                        return dto;
                    }).collect(Collectors.toList()));
            goodsSkuService.saveAsChildren(goodsDTO.getGoodsSkus().stream().map(dto -> {
                dto.setGoodsId(goodsDTO.getId());
                return dto;
            }).collect(Collectors.toList()));
        } else {
            Map<String, String> param = new HashMap<>();
            param.put("goodsId", goodsDTO.getId());
            goodsAttributeService.deleteByCondition(param);
            goodsSkuService.deleteByCondition(param);
        }
        goodsSupplierService.saveAsChildren(goodsDTO.getGoodsSuppliers().stream().map(dto -> {
            dto.setGoodsId(goodsDTO.getId());
            return dto;
        }).collect(Collectors.toList()));
        cache.remove(goodsDTO.getId());
        return findOne(goodsDTO.getId());
    }


    @Override
    public void delete(String id) throws Exception {
        Map<String, String> param = new HashMap<>();
        param.put("goodsId", id);
        goodsAttributeService.deleteByCondition(param);
        goodsSkuService.deleteByCondition(param);
        goodsSupplierService.deleteByCondition(param);
        super.delete(id);
    }

    @Override
    public void delete(Iterable<? extends GoodsDTO> goodses) throws Exception {
        for (GoodsDTO goods : goodses) {
            delete(goods.getId());
        }
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
