package com.herton.module.orderform.web;

import com.herton.common.PageParam;
import com.herton.common.PageResult;
import com.herton.module.orderform.service.PurchaseOrderService;
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

@Api(value = "采购订单单管理")
@RestController
@RequestMapping("/api/purchaseOrder")
public class PurchaseOrderController {
    private final PurchaseOrderService purchaseOrderService;

    /**
     * 保存
     */
    @ApiOperation(value="保存")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody PurchaseOrderSaveParam purchaseOrderSaveParam) throws Exception {
        purchaseOrderService.save(purchaseOrderSaveParam);
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
            PageResult<PurchaseOrderResult> page = purchaseOrderService.findAllTranslated(pageParam.getPageRequest(), param);
            return new ResponseEntity<>(page, HttpStatus.OK);
        }
        List<PurchaseOrderResult> list = purchaseOrderService.findAllTranslated(param);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @Autowired
    public PurchaseOrderController(PurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
    }
}
