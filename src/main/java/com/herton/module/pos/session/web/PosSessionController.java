package com.herton.module.pos.session.web;

import com.herton.common.AbstractCrudController;
import com.herton.entity.BaseUser;
import com.herton.exceptions.ForbiddenException;
import com.herton.exceptions.UnauthorizedException;
import com.herton.module.auth.UserThread;
import com.herton.module.pos.session.domain.PosSession;
import com.herton.module.pos.session.dto.PosSessionDTO;
import com.herton.module.pos.session.service.PosSessionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "pos会话管理")
@RestController
@RequestMapping("/api/posSession")
public class PosSessionController extends AbstractCrudController<PosSession, PosSessionDTO> {
    private final PosSessionService posSessionService;

    /**
     * 打开会话
     */
    @ApiOperation(value="打开会话")
    @RequestMapping(value = "/open", method = RequestMethod.POST)
    public ResponseEntity<PosSessionDTO> open() throws Exception {
        BaseUser user = UserThread.getInstance().get();
        if(user == null) {
            throw new UnauthorizedException("用户未登录");
        }
        if(!BaseUser.UserType.ADMIN.name().equals(user.getUserType())) {
            throw new ForbiddenException("用户无权限");
        }
        return new ResponseEntity<>(posSessionService.open(user.getId()), HttpStatus.CREATED);
    }

    /**
     * 关闭会话
     */
    @ApiOperation(value="关闭会话")
    @RequestMapping(value = "/close/{id}", method = RequestMethod.POST)
    public ResponseEntity<PosSessionDTO> close(@PathVariable String id) throws Exception {
        return new ResponseEntity<>(posSessionService.close(id), HttpStatus.CREATED);
    }

    public PosSessionController(PosSessionService posSessionService) {
        this.posSessionService = posSessionService;
    }
}
