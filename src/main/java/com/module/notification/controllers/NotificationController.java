package com.module.notification.controllers;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.module.notification.notificationData.*;


@RestController
public class NotificationController {
    
    NotificationDataInterface db = new NotificationDataFile();
    
	//http://localhost:8083/notification/send
	@PostMapping(value = "/notification/send")
	@ResponseBody
	public ResponseEntity<Notification> addNotification(@RequestBody Notification notification) throws IOException {
		if (notification.getChannel().equalsIgnoreCase("email") || (notification.getChannel().equalsIgnoreCase("sms"))) {
			db.addNotification(notification);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping(value = "/notification/get/email")
	@ResponseBody
	public ArrayList<Notification> retriveAllMail() throws IOException {
		return db.GetMailNotifications();
	}
	
	@GetMapping(value = "/notification/get/sms")
	@ResponseBody
	public ArrayList<Notification> retriveAllSMS() throws IOException {
		return db.GetSMSNotifications();
	}
}
