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
public class BusinessRelatedUnitController extends AbstractCrudController<BusinessRelatedUnit> {
    private final BusinessRelatedUnitService businessRelatedUnitService;
    @Override
    protected CrudService<BusinessRelatedUnit> getService() {
        return businessRelatedUnitService;
    }

    /**
     * 修改期初应收应付款
     */
    @ApiOperation(value="修改期初应收应付款")
    @RequestMapping(value = "/editReceivablePayableAmount/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> editReceivablePayableAmount(@PathVariable String id, @RequestBody EditReceivablePayableAmountParam editReceivablePayableAmountParam) throws Exception {
        businessRelatedUnitService.editReceivablePayableAmount(id, editReceivablePayableAmountParam);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Autowired
    public BusinessRelatedUnitController(BusinessRelatedUnitService businessRelatedUnitService) {
        this.businessRelatedUnitService = businessRelatedUnitService;
    }
}
