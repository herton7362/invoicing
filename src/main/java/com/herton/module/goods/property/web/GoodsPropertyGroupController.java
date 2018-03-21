package com.herton.module.goods.property.web;

import com.herton.common.AbstractCrudController;
import com.herton.common.CrudService;
import com.herton.module.goods.property.domain.GoodsProperty;
import com.herton.module.goods.property.domain.GoodsPropertyGroup;
import com.herton.module.goods.property.service.GoodsPropertyGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "商品属组管理")
@RestController
@RequestMapping("/api/goodsPropertyGroup")
public class GoodsPropertyGroupController extends AbstractCrudController<GoodsPropertyGroup> {
    private final GoodsPropertyGroupService goodsPropertyGroupService;
    @Override
    protected CrudService<GoodsPropertyGroup> getService() {
        return goodsPropertyGroupService;
    }

    /**
     * 保存
     */
    @ApiOperation(value="保存")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<GoodsPropertyGroup> save(@RequestBody GoodsPropertyGroupSaveParam goodsPropertyGroupSaveParam) throws Exception {
        goodsPropertyGroupService.save(goodsPropertyGroupSaveParam);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Autowired
    public GoodsPropertyGroupController(GoodsPropertyGroupService goodsPropertyGroupService) {
        this.goodsPropertyGroupService = goodsPropertyGroupService;
    }
}
