package com.herton.module.auth.web;

import com.herton.common.AbstractCrudController;
import com.herton.common.CrudService;
import com.herton.common.PageParam;
import com.herton.common.PageResult;
import com.herton.module.auth.domain.Module;
import com.herton.module.auth.domain.Role;
import com.herton.module.auth.service.RoleService;
import com.herton.module.goods.web.GoodsResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Api(value = "角色管理")
@RestController
@RequestMapping("/api/role")
public class RoleController extends AbstractCrudController<RoleService, Role> {
    private RoleService getService() {
        return (RoleService) crudService;
    }
    /**
     * 查询
     */
    @ApiOperation(value="分页如果不传页数则按照条件查询", notes = "可以传查询条件例：name=张三，查询条件使用or分割")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "currentPage", value = "当前页数", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页页数", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序属性，多个用逗号隔开", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "order", value = "排序方向，多个用逗号隔开", dataType = "String", paramType = "query")
    })
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> searchPagedList(@ModelAttribute PageParam pageParam, HttpServletRequest request) throws Exception {
        Map<String, String[]> param = request.getParameterMap();
        if(pageParam.isPageAble()) {
            PageResult<RoleResult> page = getService().findAllTranslated(pageParam.getPageRequest(), param);
            return new ResponseEntity<>(page, HttpStatus.OK);
        }
        List<RoleResult> list = getService().findAllTranslated(param);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * 加载权限（已授权的模块）
     */
    @ApiOperation(value="加载权限（已授权的模块）")
    @RequestMapping(value = "/authorizations/{roleId}", method = RequestMethod.GET)
    public ResponseEntity<List<Module>> authorizations(@PathVariable String roleId) throws Exception {
        Role role = getService().findOne(roleId);
        return new ResponseEntity<>(role.getModules(), HttpStatus.OK);
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
}
