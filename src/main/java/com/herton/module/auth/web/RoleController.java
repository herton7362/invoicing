package com.herton.module.auth.web;

import com.herton.common.AbstractCrudController;
import com.herton.module.auth.domain.Role;
import com.herton.module.auth.dto.ModuleDTO;
import com.herton.module.auth.dto.RoleDTO;
import com.herton.module.auth.service.ModuleService;
import com.herton.module.auth.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "角色管理")
@RestController
@RequestMapping("/api/role")
public class RoleController extends AbstractCrudController<Role, RoleDTO> {
    private final ModuleService moduleService;
    private RoleService getService() {
        return (RoleService) crudService;
    }

    /**
     * 加载权限（已授权的模块）
     */
    @ApiOperation(value="加载权限（已授权的模块）")
    @RequestMapping(value = "/authorizations/{roleId}", method = RequestMethod.GET)
    public ResponseEntity<List<ModuleDTO>> authorizations(@PathVariable String roleId) throws Exception {
        Map<String, String> param = new HashMap<>();
        param.put("roleId", roleId);
        param.put("logicallyDeleted", "false");
        param.put("order", "asc");
        param.put("sort", "sortNumber");
        return new ResponseEntity<>(moduleService.findAll(param), HttpStatus.OK);
    }

    /**
     * 授权
     */
    @ApiOperation(value="授权")
    @RequestMapping(value = "/authorize", method = RequestMethod.POST)
    public ResponseEntity<?> authorize(@RequestBody AuthorizeParam authorizeParam) throws Exception {
        getService().authorize(authorizeParam.getRoleId(), authorizeParam.getModuleIds());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Autowired
    public RoleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }
}
