package com.module.notification.notificationData;

import java.io.IOException;

public class Notification {
	String subject;
	String channel;
	String receiver;
	String message;
	String name;
	String placeholder1;
	String placeholder2;
	String templateName;
	
	public void createMessage() throws IOException {
		Template template = null;
		TemplateDataInterface db = new TemplateDataFile();
		SearchCriteria criteria = new SearchCriteria();
		criteria.setTemplateName(templateName);
		template = db.SearchTemplate(criteria);
		if (template != null) {
			String [] splitTemp = template.getContent().split(" ");
			String message = "";
			for (int i = 0; i < splitTemp.length; i++) {
				if (splitTemp[i].equals("%n")) {
					splitTemp[i] = name;
				} else if (splitTemp[i].equals("%p1")) {
					splitTemp[i] = placeholder1;
				} else if (splitTemp[i].equals("%p2")) {
					splitTemp[i] = placeholder2;
				}
			}
			for (int j = 0; j < splitTemp.length; j++) {
				message += splitTemp[j] + " ";
			}
			this.message = message;
		} else {
			this.message = "";
		}
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPlaceholder1(String placeholder1) {
		this.placeholder1 = placeholder1;
	}
	public void setPlaceholder2(String placeholder2) {
		this.placeholder2 = placeholder2;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
}
