package com.herton.module.basicdata.businessrelatedunit.dto;

import com.herton.dto.BaseDTO;
import com.herton.module.basicdata.businessrelatedunit.domain.BusinessRelatedUnit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ApiModel("往来单位")
public class BusinessRelatedUnitDTO extends BaseDTO<BusinessRelatedUnit> {
    @ApiModelProperty(value = "单位名称")
    private String name;
    @ApiModelProperty(value = "单位编号")
    private String code;
    @ApiModelProperty(value = "简名")
    private String shortname;
    @ApiModelProperty(value = "拼音码")
    private String pinyin;
    @ApiModelProperty(value = "类型")
    private BusinessRelatedUnit.Type type;
    @ApiModelProperty(value = "税号")
    private String taxNumber;
    @ApiModelProperty(value = "税率（%）")
    private Integer taxRate;
    @ApiModelProperty(value = "联系人")
    private String linkman;
    @ApiModelProperty(value = "电话")
    private String telephone;
    @ApiModelProperty(value = "手机")
    private String mobile;
    @ApiModelProperty(value = "电子邮件")
    private String email;
    @ApiModelProperty(value = "价格等级")
    private String priceLevel;
    @ApiModelProperty(value = "地址")
    private String detailAddress;
    @ApiModelProperty(value = "开户银行")
    private String depositBank;
    @ApiModelProperty(value = "银行账号")
    private String bankAccount;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "期初应付款")
    private Double openingPayableAmount = 0D;
    @ApiModelProperty(value = "期初应收款")
    private Double openingReceivableAmount = 0D;
    @ApiModelProperty(value = "当前应付款")
    private Double nowPayableAmount = 0D;
    @ApiModelProperty(value = "当前应收款")
    private Double nowReceivableAmount = 0D;
    @ApiModelProperty(value = "信用额度")
    private Double creditLine;
    @ApiModelProperty(value = "信用额度启用状态")
    private Boolean creditLineEnable = false;
}
