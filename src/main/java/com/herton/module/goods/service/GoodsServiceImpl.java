package com.herton.module.goods.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.common.PageResult;
import com.herton.module.goods.domain.Goods;
import com.herton.module.goods.domain.GoodsRepository;
import com.herton.module.goods.web.GoodsResult;
import com.herton.module.goods.web.GoodsSaveParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Component
@Transactional
public class GoodsServiceImpl extends AbstractCrudService<Goods> implements GoodsService {
    private final GoodsRepository goodsRepository;
    private final GoodsPriceService goodsPriceService;
    private final GoodsImageService goodsImageService;
    @Override
    protected PageRepository<Goods> getRepository() {
        return goodsRepository;
    }

    @Override
    public void save(GoodsSaveParam goodsSaveParam) throws Exception {
        super.save(goodsSaveParam);
        goodsSaveParam.getBasicGoodsPriceParam().setSortNumber(0);
        goodsPriceService.save(goodsSaveParam.getBasicGoodsPriceParam());
        goodsSaveParam.getAssistGoodsPriceParam1().setSortNumber(1);
        goodsPriceService.save(goodsSaveParam.getAssistGoodsPriceParam1());
        goodsSaveParam.getAssistGoodsPriceParam2().setSortNumber(2);
        goodsPriceService.save(goodsSaveParam.getAssistGoodsPriceParam2());
        List<GoodsSaveParam.GoodsImageParam> goodsImageParams = goodsSaveParam.getGoodsImageParams();
        for (GoodsSaveParam.GoodsImageParam goodsImageParam : goodsImageParams) {
            goodsImageService.save(goodsImageParam);
        }

    }

    @Override
    public PageResult<GoodsResult> findAllTranslated(PageRequest pageRequest, Map<String, String[]> param) {
        return null;
    }

    @Override
    public List<GoodsResult> findAllTranslated(Map<String, String[]> param) {
        return null;
    }

    @Autowired
    public GoodsServiceImpl(
            GoodsRepository goodsRepository,
            GoodsPriceService goodsPriceService,
            GoodsImageService goodsImageService
    ) {
        this.goodsRepository = goodsRepository;
        this.goodsPriceService = goodsPriceService;
        this.goodsImageService = goodsImageService;
    }
}
