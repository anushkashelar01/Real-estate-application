package com.homesphere.controller;

import com.homesphere.model.Notification;
import com.homesphere.service.NotificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    // 🔔 Create Notification
    @PostMapping
    public Notification create(@RequestBody Notification notification) {
        return notificationService.createNotification(notification);
    }

    // 📥 Get all notifications for user
    @GetMapping("/{userId}")
    public List<Notification> getUserNotifications(@PathVariable Long userId) {
        return notificationService.getUserNotifications(userId);
    }

    // ✅ Mark as read
    @PutMapping("/read/{id}")
    public String markAsRead(@PathVariable Long id) {
        notificationService.markAsRead(id);
        return "Marked as read";
    }

    // ❌ Delete notification
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return "Deleted successfully";
    }
}