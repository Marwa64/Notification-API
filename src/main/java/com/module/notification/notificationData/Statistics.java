package com.module.notification.notificationData;
import java.util.*;
import java.util.Map.Entry;

public class Statistics {
	static Scanner in = new Scanner(System.in);
	Map<String,Integer> allTemplates=new HashMap<String,Integer>();
	Map<String,Integer> allReceivers=new HashMap<String,Integer>();
	String topReceiver, topTemplate;
	int sentNotifications, failedNotifications;
	
	public Statistics() {
		topReceiver = "";
		topTemplate = "";
		sentNotifications = 0;
		failedNotifications = 0;
	}
	
	public void checkTopReceiver(String receiver) {
		if (allReceivers.containsKey(receiver)) {
			allReceivers.put(receiver, allReceivers.get(receiver) + 1);
			if (topReceiver.equals("")) {
				topReceiver = receiver;
			} else {
		        for (Entry<String, Integer> iterate : allReceivers.entrySet()) { 
		        	if (allReceivers.get(topReceiver) <= iterate.getValue()) {
		        		topReceiver = iterate.getKey();
		        	}
		        } 	
			}
		} else {
			allReceivers.put(receiver, 1);
		}
	}
	public void checkTopTemplate(String templateName) {
		if (allTemplates.containsKey(templateName)) {
			allTemplates.put(templateName, allReceivers.get(templateName) + 1);
			if (topTemplate.equals("")) {
				topTemplate = templateName;
			} else {
		        for (Entry<String, Integer> iterate : allTemplates.entrySet()) { 
		        	if (allTemplates.get(topTemplate) <= iterate.getValue()) {
		        		topTemplate = iterate.getKey();
		        	}
		        } 	
			}
		} else {
			allTemplates.put(templateName, 1);
		}
	}
	public void incrementSent() {
		sentNotifications++;
	}
	public void incrementFailed() {
		failedNotifications++;
	}
	public String getTopReceiver() {
		return topReceiver;
	}
	public String getTopTemplate() {
		return topTemplate;
	}
	public int getSentNum() {
		return sentNotifications;
	}
	public int getFailedNum() {
		return failedNotifications;
	}
}
