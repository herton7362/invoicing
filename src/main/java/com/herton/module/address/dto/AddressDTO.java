package com.herton.module.address.dto;

import com.herton.dto.BaseDTO;
import com.herton.module.address.domain.Address;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ApiModel("地址")
public class AddressDTO extends BaseDTO<Address> {
    @ApiModelProperty(value = "上级地址")
    private Address parent;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "级别")
    private String level;
}
