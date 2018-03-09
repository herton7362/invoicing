package com.herton.kits.notification.config.annotation.configuration;

import com.herton.entity.BaseUser;
import com.herton.kits.notification.config.annotation.configurer.SendConfigurer;
import com.herton.kits.notification.message.NotificationMessageType;

public abstract class NotificationKitConfigurerAdaptor implements NotificationKitConfigurer {

    @Override
    public void configure(SendConfigurer sendConfigurer) throws Exception {
        sendConfigurer.setSendFilter((BaseUser destUser, NotificationMessageType messageType) -> true);
    }

}
