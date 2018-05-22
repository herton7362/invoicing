package com.herton.module.goods.type.web;

import com.herton.common.AbstractCrudController;
import com.herton.common.CrudService;
import com.herton.module.goods.type.domain.GoodsTypeAttribute;
import com.herton.module.goods.type.service.GoodsTypeAttributeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "商品属性管理")
@RestController
@RequestMapping("/api/goodsTypeAttribute")
public class GoodsTypeAttributeController extends AbstractCrudController<GoodsTypeAttributeService, GoodsTypeAttribute> {
}
