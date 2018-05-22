package com.herton.module.goods.type.web;

import com.herton.common.AbstractCrudController;
import com.herton.common.CrudService;
import com.herton.common.PageParam;
import com.herton.common.PageResult;
import com.herton.module.goods.type.domain.GoodsType;
import com.herton.module.goods.type.service.GoodsTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Api(value = "商品类型管理")
@RestController
@RequestMapping("/api/goodsType")
public class GoodsTypeController extends AbstractCrudController<GoodsTypeService, GoodsType> {

    private GoodsTypeService getService() {
        return (GoodsTypeService) crudService;
    }

    @Override
    public ResponseEntity<?> searchPagedList(PageParam pageParam, HttpServletRequest request) throws Exception {
        Map<String, String[]> param = request.getParameterMap();
        if(pageParam.isPageAble()) {
            PageResult<GoodsTypeResult> page = getService().findAllTranslated(pageParam.getPageRequest(), param);
            return new ResponseEntity<>(page, HttpStatus.OK);
        }
        List<GoodsTypeResult> list = getService().findAllTranslated(param);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * 查询一个
     */
    public ResponseEntity<GoodsTypeResult> getOne(@PathVariable String id) throws Exception {
        return new ResponseEntity<>(getService().getOneTranslated(id), HttpStatus.OK);
    }
}
