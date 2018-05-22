package com.herton.module.basicdata.businessrelatedunit.web;

import com.herton.common.AbstractCrudController;
import com.herton.common.CrudService;
import com.herton.module.basicdata.businessrelatedunit.domain.BusinessRelatedUnit;
import com.herton.module.basicdata.businessrelatedunit.service.BusinessRelatedUnitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "往来单位管理")
@RestController
@RequestMapping("/api/businessRelatedUnit")
public class BusinessRelatedUnitController extends AbstractCrudController<BusinessRelatedUnitService, BusinessRelatedUnit> {
    private BusinessRelatedUnitService getService() {
        return (BusinessRelatedUnitService) crudService;
    }
    /**
     * 修改期初应收应付款
     */
    @ApiOperation(value="修改期初应收应付款")
    @RequestMapping(value = "/editReceivablePayableAmount/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> editReceivablePayableAmount(@PathVariable String id, @RequestBody EditReceivablePayableAmountParam editReceivablePayableAmountParam) throws Exception {
        getService().editReceivablePayableAmount(id, editReceivablePayableAmountParam);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 设置信用额度
     */
    @ApiOperation(value="设置信用额度")
    @RequestMapping(value = "/editCreditLine/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> editCreditLine(@PathVariable String id, @RequestBody EditCreditLineParam editCreditLineParam) throws Exception {
        getService().editCreditLine(id, editCreditLineParam);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
