package com.herton.module.goods.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.module.goods.domain.GoodsAttribute;
import com.herton.module.goods.domain.GoodsAttributeRepository;
import com.herton.module.goods.web.GoodsSaveParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Transactional
public class GoodsAttributeServiceImpl extends AbstractCrudService<GoodsAttributeRepository, GoodsAttribute>
        implements GoodsAttributeService {
    @Override
    public List<GoodsAttribute> save(Boolean isCreate, String goodsId, List<GoodsAttribute> goodsAttributes) throws Exception {
        List<GoodsAttribute> newGoodsAttributes = new ArrayList<>();
        if(isCreate) {
            for (GoodsAttribute goodsAttribute : goodsAttributes) {
                goodsAttribute.setGoodsId(goodsId);
                save(goodsAttribute);
                newGoodsAttributes.add(goodsAttribute);
            }
        } else {
            Map<String, String> params = new HashMap<>();
            params.put("goodsId", goodsId);
            List<GoodsAttribute> oldGoodsAttributes = findAll(params);

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
                            delete(goodsAttribute.getId());
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
                            save(goodsAttribute);
                            newGoodsAttributes.add(goodsAttribute);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
        }
        return newGoodsAttributes;
    }
}
