package com.herton.common;

import com.herton.dto.BaseDTO;
import com.herton.entity.BaseEntity;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 提供基本增删改查
 * @author tang he
 * @since 1.0.1
 * @param <E> 实现增删改查的实体
 * @param <D> DTO对象
 */
public abstract class AbstractCrudController<E extends BaseEntity, D extends BaseDTO<D, E>> extends AbstractReadController<E, D> {
    /**
     * 保存
     */
    @ApiOperation(value="保存")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<D> save(@RequestBody D d) throws Exception {
        d = crudService.save(d);
        return new ResponseEntity<>(d, HttpStatus.CREATED);
    }

    /**
     * 删除
     */
    @ApiOperation(value="删除默认为逻辑删除")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable String id) throws Exception {
        String[] ids = id.split(",");
        for (String s : ids) {
            crudService.delete(s);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * 调整排序
     */
    @ApiOperation(value="调整排序")
    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public ResponseEntity<?> sort(@RequestBody List<E> ts) throws Exception {
        crudService.sort(ts);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * 启用
     */
    @ApiOperation(value="启用")
    @RequestMapping(value = "/enable/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> enable(@PathVariable String id) throws Exception {
        crudService.enable(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * 停用
     */
    @ApiOperation(value="停用")
    @RequestMapping(value = "/disable/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> disable(@PathVariable String id) throws Exception {
        crudService.disable(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
