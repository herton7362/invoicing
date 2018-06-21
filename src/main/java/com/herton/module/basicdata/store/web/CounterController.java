package com.herton.module.basicdata.store.web;

import com.herton.common.AbstractCrudController;
import com.herton.common.CrudService;
import com.herton.module.basicdata.store.domain.Counter;
import com.herton.module.basicdata.store.service.CounterService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "收银台管理")
@RestController
@RequestMapping("/api/storeCounter")
public class CounterController extends AbstractCrudController<Counter> {
}
