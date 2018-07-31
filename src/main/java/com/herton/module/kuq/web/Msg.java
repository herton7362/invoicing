package com.herton.module.kuq.web;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Msg {
    private String post_type; // 上报类型 message(收到消息) | notice(群、讨论组变动等通知类事件) | request(加好友请求、加群请求／邀请)
    private String message_type; // 消息类型
    private String sub_type; // 消息子类型，正常消息是 normal，匿名消息是 anonymous，系统提示（如「管理员已禁止群内匿名聊天」）是 notice
    private Long message_id; // 消息 ID
    private Long group_id; // 群号
    private Long user_id; // 发送者 QQ 号
    private Object anonymous; // 匿名信息，如果不是匿名消息则为 null
    private String message; // 消息内容
    private String raw_message; // 原始消息内容
    private Integer font; // 字体
}
