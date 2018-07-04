package com.herton.module.dictionary.dto;

import com.herton.dto.BaseDTO;
import com.herton.module.dictionary.domain.Dictionary;
import com.herton.module.dictionary.domain.DictionaryCategory;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ApiModel("数据字典")
public class DictionaryDTO extends BaseDTO<Dictionary> {
    @ApiModelProperty(value = "字典类别")
    private DictionaryCategory dictionaryCategory;
    @ApiModelProperty("字典名称")
    private String name;
    @ApiModelProperty("字典代码")
    private String code;
}
