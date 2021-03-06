package com.herton.module.dictionary.web;

import com.herton.common.AbstractCrudController;
import com.herton.common.CrudService;
import com.herton.common.utils.StringUtils;
import com.herton.module.dictionary.domain.Dictionary;
import com.herton.module.dictionary.domain.DictionaryCategory;
import com.herton.module.dictionary.dto.DictionaryCategoryDTO;
import com.herton.module.dictionary.dto.DictionaryDTO;
import com.herton.module.dictionary.service.DictionaryCategoryService;
import com.herton.module.dictionary.service.DictionaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "字典管理")
@RestController
@RequestMapping("/api/dictionary")
public class DictionaryController extends AbstractCrudController<Dictionary, DictionaryDTO> {
    private final DictionaryCategoryService dictionaryCategoryService;

    /**
     * 保存
     */
    @ApiOperation(value="保存")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<DictionaryDTO> save(@RequestBody DictionaryDTO product) throws Exception {
        if(product.getDictionaryCategory() != null && StringUtils.isNotBlank(product.getDictionaryCategory().getId())) {
            product.setDictionaryCategory((DictionaryCategory) dictionaryCategoryService.findOne(product.getDictionaryCategory().getId()).convert());
        } else {
            product.setDictionaryCategory(null);
        }
        product = crudService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    /**
     * 根据code获取字典
     */
    @ApiOperation(value="根据code获取字典")
    @RequestMapping(value= "/code/{code}", method = RequestMethod.GET)
    public ResponseEntity<List<DictionaryDTO>> getByCode(@PathVariable String code) throws Exception {
        Map<String, String[]> params = new HashMap<>();
        params.put("code", new String[]{code});
        List<DictionaryCategoryDTO> dictionaryCategories  =  dictionaryCategoryService.findAll(params);
        List<DictionaryDTO> dictionaries = new ArrayList<>();
        if(dictionaryCategories != null && !dictionaryCategories.isEmpty()) {
            params.clear();
            params.put("sort", new String[]{"sortNumber,updatedDate"});
            params.put("order", new String[]{"asc,desc"});
            params.put("dictionaryCategory.id", new String[]{dictionaryCategories.get(0).getId()});
            dictionaries = crudService.findAll(params);
        }
        return new ResponseEntity<>(dictionaries, HttpStatus.OK);
    }

    @Autowired
    public DictionaryController(
            DictionaryCategoryService dictionaryCategoryService
    ) {
        this.dictionaryCategoryService = dictionaryCategoryService;
    }
}
