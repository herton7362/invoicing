package com.herton.module.basicdata.store.dto;

import com.herton.dto.BaseDTO;
import com.herton.module.basicdata.store.domain.Store;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ApiModel("门店")
public class StoreDTO extends BaseDTO<Store> {
    @ApiModelProperty(value = "门店名称")
    private String name;
    @ApiModelProperty(value = "门店编码")
    private String code;
    @ApiModelProperty(value = "仓库id")
    private String warehouseId;
    @ApiModelProperty(value = "开始营业时间")
    private String startBusinessTime;
    @ApiModelProperty(value = "关闭营业时间")
    private String closeBusinessTime;
    @ApiModelProperty(value = "门店介绍")
    private String description;
    @ApiModelProperty(value = "店长id")
    private String storeManagerId;
    @ApiModelProperty(value = "门店地址id")
    private String addressId;
    @ApiModelProperty(value = "邮编")
    private String zipCode;
    @ApiModelProperty(value = "详细地址")
    private String detailAddress;
    @ApiModelProperty(value = "联系人")
    private String linkman;
    @ApiModelProperty(value = "手机")
    private String mobile;
    @ApiModelProperty(value = "固定电话")
    private String telephone;
    @ApiModelProperty(value = "传真")
    private String fax;
    @ApiModelProperty(value = "备注")
    private String remark;
}
