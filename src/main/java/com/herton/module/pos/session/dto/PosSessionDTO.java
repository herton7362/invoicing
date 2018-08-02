package com.herton.module.pos.session.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.herton.dto.BaseDTO;
import com.herton.module.auth.domain.Admin;
import com.herton.module.pos.session.domain.PosSession;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.util.Date;

@Getter
@Setter
@Component
@Accessors(chain = true)
@ApiModel("pos会话")
public class PosSessionDTO extends BaseDTO<PosSessionDTO, PosSession> {
    @ApiModelProperty("会话id")
    private String SessionId;
    @ApiModelProperty("操作员id")
    private String adminId;
    @ApiModelProperty("开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date startDate;
    @ApiModelProperty("结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date endDate;
    @ApiModelProperty("状态")
    private PosSession.Status status;

    @ApiModelProperty("操作员名称")
    private String adminName;
    @ApiModelProperty("状态名称")
    private String statusName;
}
