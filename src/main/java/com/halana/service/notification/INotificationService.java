package com.halana.service.notification;

import com.halana.model.notification.Notification;
import com.halana.service.IBaseService;

import java.util.List;

public interface INotificationService extends IBaseService<Notification> {
    List<Notification> findAllByReceiverIdOrderByIdDesc(Long id);
}
