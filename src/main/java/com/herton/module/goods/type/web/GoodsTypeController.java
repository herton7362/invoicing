package com.herton.module.goods.type.web;

import com.herton.common.AbstractCrudController;
import com.herton.common.CrudService;
import com.herton.common.PageParam;
import com.herton.common.PageResult;
import com.herton.module.goods.type.domain.GoodsType;
import com.herton.module.goods.type.service.GoodsTypeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Api(value = "商品类型管理")
@RestController
@RequestMapping("/api/goodsType")
public class GoodsTypeController extends AbstractCrudController<GoodsType> {
    private final GoodsTypeService goodsTypeService;
    @Override
    protected CrudService<GoodsType> getService() {
        return goodsTypeService;
    }


    @Override
    public ResponseEntity<?> searchPagedList(PageParam pageParam, HttpServletRequest request) throws Exception {
        Map<String, String[]> param = request.getParameterMap();
        if(pageParam.isPageAble()) {
            PageResult<GoodsTypeResult> page = goodsTypeService.findAllTranslated(pageParam.getPageRequest(), param);
            return new ResponseEntity<>(page, HttpStatus.OK);
        }
        List<GoodsTypeResult> list = goodsTypeService.findAllTranslated(param);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @Autowired
    public GoodsTypeController(GoodsTypeService goodsTypeService) {
        this.goodsTypeService = goodsTypeService;
    }
}