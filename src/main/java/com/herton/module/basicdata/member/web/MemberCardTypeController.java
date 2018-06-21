package com.herton.module.basicdata.member.web;

import com.herton.common.AbstractCrudController;
import com.herton.common.CrudService;
import com.herton.module.basicdata.member.domain.MemberCardType;
import com.herton.module.basicdata.member.service.MemberCardTypeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "会员卡类型管理")
@RestController
@RequestMapping("/api/memberCardType")
public class MemberCardTypeController extends AbstractCrudController<MemberCardType> {
}
