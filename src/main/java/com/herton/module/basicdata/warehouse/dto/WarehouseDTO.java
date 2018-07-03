package com.herton.module.basicdata.warehouse.dto;

import com.herton.dto.BaseDTO;
import com.herton.module.basicdata.warehouse.domain.Warehouse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ApiModel("仓库")
public class WarehouseDTO extends BaseDTO<Warehouse> {
    @ApiModelProperty(value = "仓库名称")
    private String name;
    @ApiModelProperty(value = "仓库编号")
    private String code;
    @ApiModelProperty(value = "仓库简名")
    private String shortname;
    @ApiModelProperty(value = "拼音码")
    private String pinyin;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "联系人")
    private String linkman;
    @ApiModelProperty(value = "联系电话")
    private String telephone;
    @ApiModelProperty(value = "邮政编码")
    private String zipCode;
    @ApiModelProperty(value = "地址")
    private String addressId;
    @ApiModelProperty(value = "发货地址")
    private String shippingAddress;
}
