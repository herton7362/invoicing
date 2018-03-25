package com.herton.module.goods.web;

import com.herton.common.PageParam;
import com.herton.common.PageResult;
import com.herton.module.auth.domain.Admin;
import com.herton.module.goods.property.web.GoodsPropertyGroupResult;
import com.herton.module.goods.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Api(value = "商品管理")
@RestController
@RequestMapping("/api/goods")
public class GoodsController {
    private final GoodsService goodsService;
    /**
     * 保存
     */
    @ApiOperation(value="保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody GoodsSaveParam goodsSaveParam) throws Exception {
        goodsService.save(goodsSaveParam);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 查询
     */
    @ApiOperation(value="分页如果不传页数则按照条件查询", notes = "可以传查询条件例：name=张三，查询条件使用or分割")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "currentPage", value = "当前页数", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页页数", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序属性，多个用逗号隔开", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "order", value = "排序方向，多个用逗号隔开", dataType = "String", paramType = "query")
    })
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> searchPagedList(@ModelAttribute PageParam pageParam, HttpServletRequest request) throws Exception {
        Map<String, String[]> param = request.getParameterMap();
        if(pageParam.isPageAble()) {
            PageResult<GoodsResult> page = goodsService.findAllTranslated(pageParam.getPageRequest(), param);
            return new ResponseEntity<>(page, HttpStatus.OK);
        }
        List<GoodsResult> list = goodsService.findAllTranslated(param);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @Autowired
    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }
}
