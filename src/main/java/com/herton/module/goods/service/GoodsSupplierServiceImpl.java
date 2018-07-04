package com.herton.module.goods.service;

import com.herton.common.AbstractCrudService;
import com.herton.module.goods.domain.GoodsSupplier;
import com.herton.module.goods.dto.GoodsSupplierDTO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Transactional
public class GoodsSupplierServiceImpl extends AbstractCrudService<GoodsSupplier, GoodsSupplierDTO>
        implements GoodsSupplierService {
    @Override
    public void save(Boolean isCreate, String goodsId, List<GoodsSupplierDTO> goodsSuppliers) throws Exception {
        if(isCreate) {
            for (GoodsSupplierDTO goodsSupplier : goodsSuppliers) {
                goodsSupplier.setGoodsId(goodsId);
                save(goodsSupplier);
            }
        } else {
            Map<String, String> params = new HashMap<>();
            params.put("goodsId", goodsId);
            List<GoodsSupplierDTO> oldGoodsSuppliers = findAll(params);
            deleteNewNoneMatchOld(oldGoodsSuppliers, goodsSuppliers);
            addOldNoneMatchNew(goodsId, oldGoodsSuppliers, goodsSuppliers);
        }
    }

    private void deleteNewNoneMatchOld(List<GoodsSupplierDTO> oldGoodsSuppliers,
                                       List<GoodsSupplierDTO> goodsSuppliers) throws Exception {
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
    }

    private void addOldNoneMatchNew(String goodsId, List<GoodsSupplierDTO> oldGoodsSuppliers,
                                    List<GoodsSupplierDTO> goodsSuppliers) throws Exception {
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
