package com.halana.controller;

import com.halana.model.notification.Notification;
import com.halana.service.notification.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private INotificationService notificationService;

    @GetMapping("/{id}")
    public ResponseEntity<List<Notification>> getAll(@PathVariable Long id) {
        return new ResponseEntity<>(notificationService.findAllByReceiverIdOrderByIdDesc(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public void readNotification(@PathVariable Long id) {
        Notification notification = notificationService.findById(id).get();
        notification.setStatus(true);
        notificationService.save(notification);
    }

}
