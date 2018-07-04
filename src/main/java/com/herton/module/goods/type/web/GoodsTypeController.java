package com.herton.module.goods.type.web;

import com.herton.common.AbstractCrudController;
import com.herton.module.goods.type.domain.GoodsType;
import com.herton.module.goods.type.dto.GoodsTypeDTO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "商品类型管理")
@RestController
@RequestMapping("/api/goodsType")
public class GoodsTypeController extends AbstractCrudController<GoodsType, GoodsTypeDTO> {
}
