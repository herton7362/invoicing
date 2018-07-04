package com.herton.module.auth.web;

import com.herton.common.AbstractCrudController;
import com.herton.common.CrudService;
import com.herton.module.auth.domain.Module;
import com.herton.module.auth.dto.ModuleDTO;
import com.herton.module.auth.service.ModuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "模块管理")
@RestController
@RequestMapping("/api/module")
public class ModuleController extends AbstractCrudController<Module, ModuleDTO> {

    /**
     * 保存
     */
    @ApiOperation(value="保存")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ModuleDTO> save(@RequestBody ModuleDTO module) throws Exception {
        if(module.getParent() != null && StringUtils.isNotBlank(module.getParent().getId())) {
            module.setParent(crudService.findOne(module.getParent().getId()).convert());
        } else {
            module.setParent(null);
        }
        module = crudService.save(module);
        return new ResponseEntity<>(module, HttpStatus.OK);
    }
}
