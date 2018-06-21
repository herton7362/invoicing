package com.herton.module.address.web;

import com.herton.common.AbstractReadController;
import com.herton.common.CrudService;
import com.herton.module.address.domain.Address;
import com.herton.module.address.service.AddressService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "游客地址接口，无权限过滤")
@RestController
@RequestMapping("/address")
public class GuestAddressController extends AbstractReadController<Address> {
}
