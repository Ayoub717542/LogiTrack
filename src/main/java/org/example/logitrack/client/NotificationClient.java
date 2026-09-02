package org.example.logitrack.client;

import org.example.logitrack.DTO.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "notification-service",
        url = "${notification.service.url}"
)
public interface NotificationClient {
    @PostMapping("/api/notifications")
    void createNotification(
            @RequestBody NotificationRequest request
    );
}