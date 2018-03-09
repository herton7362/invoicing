package com.herton.module.auth.web;

import com.herton.common.AbstractCrudController;
import com.herton.common.CrudService;
import com.herton.module.auth.domain.Module;
import com.herton.module.auth.domain.Role;
import com.herton.module.auth.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "角色管理")
@RestController
@RequestMapping("/api/role")
public class RoleController extends AbstractCrudController<Role> {
    private final RoleService roleService;

    @Override
    protected CrudService<Role> getService() {
        return roleService;
    }

    /**
     * 加载权限（已授权的模块）
     */
    @ApiOperation(value="加载权限（已授权的模块）")
    @RequestMapping(value = "/authorizations/{roleId}", method = RequestMethod.GET)
    public ResponseEntity<List<Module>> authorizations(@PathVariable String roleId) throws Exception {
        Role role = roleService.findOne(roleId);
        return new ResponseEntity<>(role.getModules(), HttpStatus.OK);
    }

    /**
     * 授权
     */
    @ApiOperation(value="授权")
    @RequestMapping(value = "/authorize", method = RequestMethod.POST)
    public ResponseEntity<?> authorize(@RequestBody AuthorizeParam authorizeParam) throws Exception {
        roleService.authorize(authorizeParam.getRoleId(), authorizeParam.getModuleIds());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
}
