package com.herton.module.codenumber.web;

import com.herton.module.codenumber.service.CodeNumberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "编号管理")
@RestController
@RequestMapping("/api/codeNumber")
public class CodeNumberController {
    private final CodeNumberService codeNumberService;

    /**
     * 根据业务获取编号
     */
    @ApiOperation(value="根据业务获取编号")
    @RequestMapping(value = "/type/{businessType}", method = RequestMethod.GET)
    public ResponseEntity<String> generateCode(@PathVariable String businessType) throws Exception {
        return new ResponseEntity<>(codeNumberService.getCodeByBusinessType(businessType), HttpStatus.OK);
    }

    @Autowired
    public CodeNumberController(CodeNumberService codeNumberService) {
        this.codeNumberService = codeNumberService;
    }
}
