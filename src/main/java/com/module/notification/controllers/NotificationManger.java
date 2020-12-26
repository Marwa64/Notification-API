package com.module.notification.controllers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.module.notification.notificationData.Notification;
import com.module.notification.notificationData.Template;
import com.module.notification.notificationData.Statistics;

@Controller
public class NotificationManger {
    ArrayList<Notification> allNotifications = new ArrayList<Notification>();
    static Statistics stat = new Statistics();

    public void createNotification(String receiver, String name, String templateName, String placeholder1, String placeholder2 , String channel) throws IOException{
    	Template template = new Template();
    	String content = template.getContent(templateName);
    	if (!content.equals("NOT FOUND")) {
    	   	stat.checkTopReceiver(receiver);
        	stat.checkTopTemplate(templateName);
            Notification notifi = new Notification(receiver, name, placeholder1, placeholder2, templateName, content, channel);
            allNotifications.add(notifi);
    	} else {
    		System.out.println("Invalid Template Type");
    	}
    }

    public Statistics getStat(){
      return stat;
    }


    /*public void send(){
    	SendNotification sender;
    	for (int i = 0; i < allNotifications.size(); i++) {
    		if (allNotifications.get(i).getChannel().equalsIgnoreCase("email")) {
    			sender = new SendEmail();
    		} else {
    			sender = new SendSMS();
    		}
    		sender.send(allNotifications.get(i));
    		if (sender.isSent()) {
    			stat.incrementSent();
    		} else {
    			stat.incrementFailed();
    		}
    	}

    }*/


}
