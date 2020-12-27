package com.module.notification.controllers;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.module.notification.notificationData.*;


@RestController
public class NotificationController {
	
    ArrayList<Notification> mailNotifications = new ArrayList<Notification>();
    ArrayList<Notification> smsNotifications = new ArrayList<Notification>();

	//http://localhost:8083/notifications/create
	@PostMapping(value = "/notifications/create")
	
	@ResponseBody
	public ResponseEntity<Notification> addNotification(@RequestBody Notification notification) throws IOException {
		if (notification.getChannel().equalsIgnoreCase("email")) {
			mailNotifications.add(notification);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		if (notification.getChannel().equalsIgnoreCase("sms")) {
			smsNotifications.add(notification);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} 
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
