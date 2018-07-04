package com.herton.module.basicdata.store.dto;

import com.herton.dto.BaseDTO;
import com.herton.module.basicdata.store.domain.Counter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ApiModel("收银台")
public class CounterDTO extends BaseDTO<CounterDTO, Counter> {
    @ApiModelProperty(value = "收银台名称")
    private String name;
    @ApiModelProperty(value = "收银台编号")
    private String code;
    @ApiModelProperty(value = "门店id")
    private String StoreId;
}
