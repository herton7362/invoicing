package com.herton.module.auth.web;

import com.herton.common.AbstractCrudController;
import com.herton.module.auth.AdminThread;
import com.herton.module.auth.domain.Admin;
import com.herton.module.auth.domain.Module;
import com.herton.module.auth.domain.Role;
import com.herton.module.auth.dto.AdminDTO;
import com.herton.module.auth.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Api(value = "管理员管理")
@RestController
@RequestMapping("/api/admin")
public class AdminController extends AbstractCrudController<Admin, AdminDTO> {
    private final RoleService roleService;

    /**
     * 获取当前用户菜单
     */
    @ApiOperation(value="获取当前用户菜单")
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/menus", method = RequestMethod.GET)
    public ResponseEntity<List<Module>> menus() throws Exception {
        Admin admin = AdminThread.getInstance().get();
        AdminDTO adminDTO = crudService.findOne(admin.getId());
        final List<Module> modulesNew = new ArrayList<>();
        List<Role> roles = adminDTO.getRoles();
        roles.forEach(role -> modulesNew.addAll(role.getModules()));
        List<Module> result = modulesNew
                .stream()
                .filter(module -> Module.Type.MENU.name().equals(module.getType()))
                .sorted(Comparator.comparing(Module::getSortNumber))
                .collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Autowired
    public AdminController(
            RoleService roleService
    ) {
        this.roleService = roleService;
    }

}
