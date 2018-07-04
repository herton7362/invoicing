package com.herton.module.codenumber.dto;

import com.herton.dto.BaseDTO;
import com.herton.module.codenumber.domain.CodeNumber;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ApiModel("编号管理")
public class CodeNumberDTO extends BaseDTO<CodeNumber> {
    @ApiModelProperty(value = "业务类型")
    private CodeNumber.BusinessType businessType;
    @ApiModelProperty(value = "下一个编码")
    private String nextCode;
}
