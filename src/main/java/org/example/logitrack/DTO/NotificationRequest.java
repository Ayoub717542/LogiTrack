package org.example.logitrack.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationRequest {

        private String message;
        private String type;
        private Long orderId;
    }

