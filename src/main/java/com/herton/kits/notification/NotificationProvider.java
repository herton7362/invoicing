package com.herton.kits.notification;

import com.herton.kits.notification.message.NotificationMessage;

/**
 * @author tang he
 * @param <T>
 */
public interface NotificationProvider<T extends NotificationMessage> {
     boolean send(T message) throws Exception;
}
