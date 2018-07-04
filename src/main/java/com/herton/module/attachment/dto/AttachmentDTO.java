package com.herton.module.attachment.dto;

import com.herton.dto.BaseDTO;
import com.herton.module.attachment.domain.Attachment;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ApiModel("附件")
public class AttachmentDTO extends BaseDTO<Attachment> {
    @ApiModelProperty(value = "附件存储路径")
    private String path;
    @ApiModelProperty(value = "附件名称")
    private String name;
    @ApiModelProperty(value = "附件格式")
    private String format;
    @ApiModelProperty(value = "附件大小")
    private Long size;
}
