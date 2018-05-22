package com.herton.module.basicdata.store.web;

import com.herton.common.AbstractCrudController;
import com.herton.common.CrudService;
import com.herton.module.basicdata.store.domain.Store;
import com.herton.module.basicdata.store.service.StoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "门店管理")
@RestController
@RequestMapping("/api/store")
public class StoreController extends AbstractCrudController<StoreService, Store> {
    private StoreService getService() {
        return (StoreService) crudService;
    }
    /**
     * 获取收银台数量
     */
    @ApiOperation(value="获取收银台数量")
    @RequestMapping(value = "/counterCount/{id}", method = RequestMethod.GET)
    public ResponseEntity<Integer> getCounterCount(@PathVariable String id) throws Exception {
        return new ResponseEntity<>(getService().getCounterCount(id), HttpStatus.OK);
    }
}
