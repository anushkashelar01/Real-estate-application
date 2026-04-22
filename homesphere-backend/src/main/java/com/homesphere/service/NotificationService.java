package com.homesphere.service;

import com.homesphere.model.Notification;

import java.util.List;

public interface NotificationService {

    Notification createNotification(Notification notification);

    List<Notification> getUserNotifications(Long userId);

    void markAsRead(Long id);

    void deleteNotification(Long id);
}