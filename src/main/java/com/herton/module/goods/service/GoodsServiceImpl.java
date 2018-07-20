package com.herton.module.goods.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.utils.StringUtils;
import com.herton.exceptions.InvalidParamException;
import com.herton.module.goods.domain.Goods;
import com.herton.module.goods.dto.GoodsDTO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@Transactional
public class GoodsServiceImpl extends AbstractCrudService<Goods, GoodsDTO> implements GoodsService {
    @Override
    public GoodsDTO save(GoodsDTO goodsDTO) {
        if(StringUtils.isBlank(goodsDTO.getName())) {
            throw new InvalidParamException("商品名称不能为空");
        }
        if(StringUtils.isBlank(goodsDTO.getCode())) {
            throw new InvalidParamException("商品编码不能为空");
        }
        return super.save(goodsDTO);
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
}
