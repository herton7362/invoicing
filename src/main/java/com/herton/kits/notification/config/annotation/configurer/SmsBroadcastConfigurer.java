package com.herton.kits.notification.config.annotation.configurer;

import com.herton.kits.notification.NotificationProvider;
import com.herton.kits.notification.config.annotation.NotificationBuilder;
import com.herton.kits.notification.config.annotation.builder.NotificationProviders;
import com.herton.kits.notification.config.annotation.configurer.provider.AlidayuProviderConfigurer;
import com.herton.kits.notification.config.annotation.configurer.provider.IpyyProviderConfigurer;
import com.herton.kits.notification.message.SmsBroadcastMessage;
import com.herton.kits.notification.provider.SmsBroadcastAlidayuProvider;

/**
 * 推广短信配置，需要注入 {@link NotificationProviders} 用来获取通知提供商的配置
 * @param <B> 当前正在构建的Builder
 * @param <H> 当前的消息类型，用来确定 {@link NotificationProvider} 的具体类型
 */
public class SmsBroadcastConfigurer<B extends NotificationBuilder, H extends SmsBroadcastMessage> extends NotificationTypeConfigurer<B, H> {
    private NotificationProviders providerConfigurer;
    public SmsBroadcastConfigurer(NotificationProviders providerConfigurer) {
        this.providerConfigurer = providerConfigurer;
    }

    /**
     * 配置为阿里大鱼通知提供商
     * @return {@link VoiceVerifyCodeConfigurer}
     */
    public SmsBroadcastConfigurer<B, H> alidayuProvider() throws Exception {
        this.setProvider(new SmsBroadcastAlidayuProvider<>(providerConfigurer.getConfigurer(AlidayuProviderConfigurer.class)));
        return this;
    }
}
