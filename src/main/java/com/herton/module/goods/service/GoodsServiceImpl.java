package com.herton.module.goods.service;

import com.herton.common.AbstractCrudService;
import com.herton.common.PageRepository;
import com.herton.common.PageResult;
import com.herton.common.utils.StringUtils;
import com.herton.exceptions.BusinessException;
import com.herton.module.goods.domain.Goods;
import com.herton.module.goods.domain.GoodsImage;
import com.herton.module.goods.domain.GoodsPrice;
import com.herton.module.goods.domain.GoodsRepository;
import com.herton.module.goods.web.GoodsResult;
import com.herton.module.goods.web.GoodsSaveParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
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
        if(StringUtils.isBlank(goodsSaveParam.getName())) {
            throw new BusinessException("商品名称不能为空");
        }
        if(StringUtils.isBlank(goodsSaveParam.getCode())) {
            throw new BusinessException("商品编码不能为空");
        }
        Goods goods = new Goods();
        BeanUtils.copyProperties(goodsSaveParam, goods);
        super.save(goods);
        GoodsPrice goodsPrice = new GoodsPrice();
        BeanUtils.copyProperties(goodsSaveParam.getBasicGoodsPrice(), goodsPrice);
        goodsPrice.setSortNumber(0);
        goodsPrice.setGoodsId(goods.getId());
        goodsPriceService.save(goodsPrice);
        GoodsPrice assistGoodsPrice1 = new GoodsPrice();
        BeanUtils.copyProperties(goodsSaveParam.getAssistGoodsPrice1(), assistGoodsPrice1);
        assistGoodsPrice1.setSortNumber(1);
        assistGoodsPrice1.setGoodsId(goods.getId());
        goodsPriceService.save(assistGoodsPrice1);
        GoodsPrice assistGoodsPrice2 = new GoodsPrice();
        BeanUtils.copyProperties(goodsSaveParam.getAssistGoodsPrice2(), assistGoodsPrice2);
        assistGoodsPrice2.setSortNumber(1);
        assistGoodsPrice2.setGoodsId(goods.getId());
        goodsPriceService.save(assistGoodsPrice2);
        GoodsImage goodsImage = new GoodsImage();
        BeanUtils.copyProperties(goodsSaveParam.getGoodsCoverImage(), goodsImage);
        goodsImage.setGoodsId(goods.getId());
        goodsImage.setSortNumber(0);
        goodsImageService.save(goodsImage);
        goodsImage = new GoodsImage();
        BeanUtils.copyProperties(goodsSaveParam.getGoodsAttached1Image(), goodsImage);
        goodsImage.setGoodsId(goods.getId());
        goodsImage.setSortNumber(1);
        goodsImageService.save(goodsImage);
        goodsImage = new GoodsImage();
        BeanUtils.copyProperties(goodsSaveParam.getGoodsAttached2Image(), goodsImage);
        goodsImage.setGoodsId(goods.getId());
        goodsImage.setSortNumber(2);
        goodsImageService.save(goodsImage);
        goodsImage = new GoodsImage();
        BeanUtils.copyProperties(goodsSaveParam.getGoodsAttached3Image(), goodsImage);
        goodsImage.setGoodsId(goods.getId());
        goodsImage.setSortNumber(3);
        goodsImageService.save(goodsImage);
        goodsImage = new GoodsImage();
        BeanUtils.copyProperties(goodsSaveParam.getGoodsAttached4Image(), goodsImage);
        goodsImage.setGoodsId(goods.getId());
        goodsImage.setSortNumber(4);
        goodsImageService.save(goodsImage);
    }

    @Override
    public PageResult<GoodsResult> findAllTranslated(PageRequest pageRequest, Map<String, ?> param) throws Exception {
        PageResult<Goods> page = super.findAll(pageRequest, param);
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
        param.clear();
        param.put("goodsId", id);
        goodsImageService.delete(goodsImageService.findAll(param));
        super.delete(id);
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
        return goodsResult;
    }

    private List<GoodsResult> translateResults(List<Goods> goodses) throws Exception {
        List<GoodsResult> goodsResults = new ArrayList<>();
        for (Goods goods : goodses) {
            goodsResults.add(this.translateResult(goods));
        }
        return goodsResults;
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
