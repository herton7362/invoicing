package com.herton.module.goods.property.web;

import com.herton.common.AbstractCrudController;
import com.herton.common.CrudService;
import com.herton.common.PageParam;
import com.herton.common.PageResult;
import com.herton.module.goods.property.domain.GoodsProperty;
import com.herton.module.goods.property.service.GoodsPropertyService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Api(value = "商品属性管理")
@RestController
@RequestMapping("/api/goodsProperty")
public class GoodsPropertyController extends AbstractCrudController<GoodsProperty> {
    private GoodsPropertyService goodsPropertyService;
    @Override
    protected CrudService<GoodsProperty> getService() {
        return goodsPropertyService;
    }

    public ResponseEntity<?> searchPagedList(@ModelAttribute PageParam pageParam, HttpServletRequest request) throws Exception {
        Map<String, String[]> param = request.getParameterMap();
        if(pageParam.isPageAble()) {
            PageResult<GoodsPropertyResult> page = goodsPropertyService.findAllTranslated(pageParam.getPageRequest(), param);
            return new ResponseEntity<>(page, HttpStatus.OK);
        }
        List<GoodsPropertyResult> list = goodsPropertyService.findAllTranslated(param);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    public ResponseEntity<GoodsPropertyResult> getOne(@PathVariable String id) throws Exception {
        return new ResponseEntity<>(goodsPropertyService.findOneTranslated(id), HttpStatus.OK);
    }

    @Autowired
    public GoodsPropertyController(GoodsPropertyService goodsPropertyService) {
        this.goodsPropertyService = goodsPropertyService;
    }
}
