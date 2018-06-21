package com.herton.module.goods.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.module.goods.domain.GoodsSupplier;
import com.herton.module.goods.domain.GoodsSupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Transactional
public class GoodsSupplierServiceImpl extends AbstractCrudService<GoodsSupplier>
        implements GoodsSupplierService {
    @Override
    public void save(Boolean isCreate, String goodsId, List<GoodsSupplier> goodsSuppliers) throws Exception {
        if(isCreate) {
            for (GoodsSupplier goodsSupplier : goodsSuppliers) {
                goodsSupplier.setGoodsId(goodsId);
                save(goodsSupplier);
            }
        } else {
            Map<String, String> params = new HashMap<>();
            params.put("goodsId", goodsId);
            List<GoodsSupplier> oldGoodsSuppliers = findAll(params);

            oldGoodsSuppliers
                    .stream()
                    .filter(goodsSupplier -> goodsSuppliers
                            .stream()
                            .noneMatch(supplier ->
                                    supplier.getBusinessRelatedUnitId().equals(goodsSupplier.getBusinessRelatedUnitId())))
                    .forEach(goodsSupplier -> {
                        try {
                            delete(goodsSupplier.getId());
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
                            save(goodsSupplier);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
        }
    }
}
