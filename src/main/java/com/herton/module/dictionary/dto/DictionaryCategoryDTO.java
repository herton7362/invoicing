package com.herton.module.dictionary.dto;

import com.herton.dto.BaseDTO;
import com.herton.module.dictionary.domain.DictionaryCategory;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ApiModel("字典类别")
public class DictionaryCategoryDTO extends BaseDTO<DictionaryCategoryDTO, DictionaryCategory> {
    @ApiModelProperty(value = "上级类别")
    private DictionaryCategory parent;
    @ApiModelProperty("类别名称")
    private String name;
    @ApiModelProperty("类别代码")
    private String code;
}
