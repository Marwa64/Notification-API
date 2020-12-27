package com.module.notification.notificationData;

import java.io.IOException;

public class Notification {
	String subject;
	String channel;
	String receiver;
	MessageInfo info;
	
	Notification (String receiver, String subject, String channel, MessageInfo info){
		this.receiver = receiver;
		this.subject = subject;
		this.channel = channel;
		this.info = info;
	}
	
	public String createMessage() throws IOException {
		Template template = null;
		TemplateDataInterface db = new TemplateDataFile();
		SearchCriteria criteria = new SearchCriteria();
		criteria.setTemplateName(info.templateName);
		template = db.SearchTemplate(criteria);
		String [] splitTemp = template.getContent().split(" ");
		String message = "";
		for (int i = 0; i < splitTemp.length; i++) {
			if (splitTemp[i].equals("%n")) {
				splitTemp[i] = info.name;
			} else if (splitTemp[i].equals("%p1")) {
				splitTemp[i] = info.placeholder1;
			} else if (splitTemp[i].equals("%p2")) {
				splitTemp[i] = info.placeholder2;
			}
		}
		for (int j = 0; j < splitTemp.length; j++) {
			message += splitTemp[j] + " ";
		}
		return message;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() throws IOException {
		return createMessage();
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
}
