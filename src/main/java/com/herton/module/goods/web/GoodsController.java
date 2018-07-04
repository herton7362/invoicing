package com.herton.module.goods.web;

import com.herton.common.AbstractCrudController;
import com.herton.module.goods.domain.Goods;
import com.herton.module.goods.dto.GoodsDTO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "商品管理")
@RestController
@RequestMapping("/api/goods")
public class GoodsController extends AbstractCrudController<Goods, GoodsDTO> {
}
