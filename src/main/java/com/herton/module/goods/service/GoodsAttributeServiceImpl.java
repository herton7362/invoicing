package com.herton.module.goods.service;

import com.herton.common.AbstractCrudService;
import com.herton.module.goods.domain.GoodsAttribute;
import com.herton.module.goods.dto.GoodsAttributeDTO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Transactional
public class GoodsAttributeServiceImpl extends AbstractCrudService<GoodsAttribute, GoodsAttributeDTO>
        implements GoodsAttributeService {
    @Override
    public void save(Boolean isCreate, String goodsId, List<GoodsAttributeDTO> goodsAttributes) throws Exception {
        if(isCreate) {
            for (GoodsAttributeDTO goodsAttribute : goodsAttributes) {
                goodsAttribute.setGoodsId(goodsId);
                save(goodsAttribute);
            }
        } else {
            Map<String, String> params = new HashMap<>();
            params.put("goodsId", goodsId);
            List<GoodsAttributeDTO> oldGoodsAttributes = findAll(params);

            deleteNewNoneMatchOld(oldGoodsAttributes, goodsAttributes);
            addOldNoneMatchNew(goodsId, oldGoodsAttributes, goodsAttributes);

        }
    }

    private void deleteNewNoneMatchOld(List<GoodsAttributeDTO> oldGoodsAttributes,
                                       List<GoodsAttributeDTO> goodsAttributes) throws Exception {
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
                        delete(goodsAttribute.getId());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }

    private void addOldNoneMatchNew(String goodsId,
                                    List<GoodsAttributeDTO> oldGoodsAttributes,
                                    List<GoodsAttributeDTO> goodsAttributes) throws Exception {
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
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }
}
