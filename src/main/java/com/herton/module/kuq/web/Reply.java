package com.herton.module.kuq.web;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reply {
    private String reply; // 要回复的内容
    private Boolean auto_escape; // 消息内容是否作为纯文本发送（即不解析 CQ 码），只在 reply 字段是字符串时有效
    private Boolean at_sender; // 是否要在回复开头 at 发送者（自动添加），发送者是匿名用户时无效
    private Boolean delete; // 撤回该条消息
    private Boolean kick; // 把发送者踢出群组（需要登录号权限足够），不拒绝此人后续加群请求，发送者是匿名用户时无效
    private Boolean ban; // 把发送者禁言 ban_duration 指定时长，对匿名用户也有效
    private Long ban_duration; // 禁言时长
}
