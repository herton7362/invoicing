package com.herton.module.basicdata.member.web;

import com.herton.common.AbstractCrudController;
import com.herton.common.CrudService;
import com.herton.common.utils.NumberUtils;
import com.herton.common.utils.StringUtils;
import com.herton.module.basicdata.member.domain.Member;
import com.herton.module.basicdata.member.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "会员管理")
@RestController
@RequestMapping("/api/member")
public class MemberController extends AbstractCrudController<MemberService, Member> {
    protected MemberService getService() {
        return (MemberService) crudService;
    }

    /**
     * 查询账户储值余额
     */
    @ApiOperation(value="查询账户储值余额")
    @RequestMapping(value = "/balance/{id}", method = RequestMethod.GET)
    public ResponseEntity<Double> getBalance(@PathVariable String id) throws Exception {
        return new ResponseEntity<>(getService().getBalance(id), HttpStatus.OK);
    }

    /**
     * 查询账户积分
     */
    @ApiOperation(value="查询账户积分")
    @RequestMapping(value = "/points/{id}", method = RequestMethod.GET)
    public ResponseEntity<Integer> getPoints(@PathVariable String id) throws Exception {
        return new ResponseEntity<>(getService().getPoints(id), HttpStatus.OK);
    }

    /**
     * 获取会员卡数量
     */
    @ApiOperation(value="获取会员卡数量")
    @RequestMapping(value = "/cardCount/{id}", method = RequestMethod.GET)
    public ResponseEntity<Integer> getCardCount(@PathVariable String id) throws Exception {
        return new ResponseEntity<>(getService().getCardCount(id), HttpStatus.OK);
    }
}
