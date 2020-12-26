package com.module.notification.notificationData;

public class Notification {
	String subject;
	String message;
	String channel;
	String receiver;
	
	public Notification (){
		subject = "";
		message = "";
		channel = "";
		receiver = "";
	}
	
	public Notification (String receiver, String name, String placeholder1, String placeholder2, String subject, String template, String channel){
		this.receiver = receiver;
		this.subject = subject;
		this.channel = channel;
		createMessage(name, placeholder1, placeholder2, template);
	}
	
	public void createMessage(String name, String placeholder1, String placeholder2, String template) {
		String [] splitTemp = template.split(" ");
		String updatedTemplate = "";
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
			updatedTemplate += splitTemp[j] + " ";
		}
		this.message = updatedTemplate;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
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
}
