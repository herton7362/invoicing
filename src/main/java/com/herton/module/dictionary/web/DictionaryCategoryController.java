package com.herton.module.dictionary.web;

import com.herton.common.AbstractCrudController;
import com.herton.common.CrudService;
import com.herton.common.utils.StringUtils;
import com.herton.module.dictionary.domain.DictionaryCategory;
import com.herton.module.dictionary.dto.DictionaryCategoryDTO;
import com.herton.module.dictionary.service.DictionaryCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "字典类别管理")
@RestController
@RequestMapping("/api/dictionaryCategory")
public class DictionaryCategoryController extends AbstractCrudController<DictionaryCategory, DictionaryCategoryDTO> {

    /**
     * 保存
     */
    @ApiOperation(value="保存")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<DictionaryCategoryDTO> save(@RequestBody DictionaryCategoryDTO productCategory) throws Exception {
        if(productCategory.getParent() != null && StringUtils.isNotBlank(productCategory.getParent().getId())) {
            productCategory.setParent(crudService.findOne(productCategory.getParent().getId()).convert());
        } else {
            productCategory.setParent(null);
        }
        productCategory = crudService.save(productCategory);
        return new ResponseEntity<>(productCategory, HttpStatus.OK);
    }

}
