package com.herton.module.basicdata.member.web;

import com.herton.common.AbstractCrudController;
import com.herton.common.CrudService;
import com.herton.module.basicdata.member.domain.MemberCard;
import com.herton.module.basicdata.member.service.MemberCardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "会员卡管理")
@RestController
@RequestMapping("/api/memberCard")
public class MemberCardController extends AbstractCrudController<MemberCard> {
    private final MemberCardService memberCardService;
    @Override
    protected CrudService<MemberCard> getService() {
        return memberCardService;
    }

    /**
     * 充值
     */
    @ApiOperation(value="充值")
    @RequestMapping(value = "/balance/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> changeBalance(@PathVariable String id, @RequestBody ChangeBalanceParam changeBalanceParam) throws Exception {
        memberCardService.changeBalance(id, changeBalanceParam);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 积分转换储值
     */
    @ApiOperation(value="积分转换储值")
    @RequestMapping(value = "/exchangePoints/toBalance/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> exchangePointsToBalance(@PathVariable String id,
                                                     @RequestBody ExchangePointsToBalanceParam exchangePointsToBalanceParam) throws Exception {
        memberCardService.exchangePointsToBalance(id, exchangePointsToBalanceParam);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 变更积分
     */
    @ApiOperation(value="变更积分")
    @RequestMapping(value = "/points/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> changePoints(@PathVariable String id, @RequestBody ChangePointsParam changePointsParam) throws Exception {
        memberCardService.changePoints(id, changePointsParam);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Autowired
    public MemberCardController(MemberCardService memberCardService) {
        this.memberCardService = memberCardService;
    }
}
