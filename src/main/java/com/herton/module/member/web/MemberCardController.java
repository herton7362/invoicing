package com.herton.module.member.web;

import com.herton.common.AbstractCrudController;
import com.herton.common.CrudService;
import com.herton.module.member.domain.MemberCard;
import com.herton.module.member.service.MemberCardService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "会员卡管理")
@RestController
@RequestMapping("/api/memberCard")
public class MemberCardController extends AbstractCrudController<MemberCard> {
    private final MemberCardService memberCardService;
    @Override
    protected CrudService<MemberCard> getService() {
        return memberCardService;
    }

    @Autowired
    public MemberCardController(MemberCardService memberCardService) {
        this.memberCardService = memberCardService;
    }
}
