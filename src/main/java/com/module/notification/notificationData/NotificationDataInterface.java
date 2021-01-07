package com.module.notification.notificationData;

import java.io.IOException;
import java.util.ArrayList;

public interface NotificationDataInterface {
	
    public void addNotification(Notification notification) throws IOException;
    public ArrayList<Notification> GetMailNotifications() throws IOException;
    public ArrayList<Notification> GetSMSNotifications() throws IOException;
}