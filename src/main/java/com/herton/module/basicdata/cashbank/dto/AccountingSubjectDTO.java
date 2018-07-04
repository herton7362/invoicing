package com.herton.module.basicdata.cashbank.dto;

import com.herton.dto.BaseDTO;
import com.herton.module.basicdata.cashbank.domain.AccountingSubject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ApiModel("会计科目")
public class AccountingSubjectDTO extends BaseDTO<AccountingSubjectDTO, AccountingSubject> {
    @ApiModelProperty(value = "科目名称")
    private String name;
    @ApiModelProperty(value = "科目编号")
    private String code;
    @ApiModelProperty(value = "科目简名")
    private String shortname;
    @ApiModelProperty(value = "拼音码")
    private String pinyin;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "期初余额")
    private Double openingBalance = 0D;
    @ApiModelProperty(value = "期末余额")
    private Double endingBalance = 0D;
    @ApiModelProperty(value = "会计科目类型")
    private AccountingSubject.Type type;
}
