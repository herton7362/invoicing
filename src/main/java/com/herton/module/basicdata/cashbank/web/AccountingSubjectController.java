package com.herton.module.basicdata.cashbank.web;

import com.herton.common.AbstractCrudController;
import com.herton.common.CrudService;
import com.herton.module.basicdata.cashbank.domain.AccountingSubject;
import com.herton.module.basicdata.cashbank.dto.AccountingSubjectDTO;
import com.herton.module.basicdata.cashbank.service.AccountingSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "会计科目管理")
@RestController
@RequestMapping("/api/accountingSubject")
public class AccountingSubjectController extends AbstractCrudController<AccountingSubject, AccountingSubjectDTO> {
    protected AccountingSubjectService getService() {
        return (AccountingSubjectService) crudService;
    }

    /**
     * 修改期初金额
     */
    @ApiOperation(value="修改期初金额")
    @RequestMapping(value = "/openingBalance/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> editOpeningBalance(@PathVariable String id, @RequestBody EditOpeningBalanceParam editOpeningBalanceParam) throws Exception {
        getService().editOpeningBalance(id, editOpeningBalanceParam);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
