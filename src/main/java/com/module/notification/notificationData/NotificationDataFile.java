package com.module.notification.notificationData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class NotificationDataFile implements NotificationDataInterface{
	
	private File email= new File ("emailNotifications.txt");
	private File sms = new File ("smsNotifications.txt");
	
	@Override
    public void addNotification(Notification notification) throws IOException {
		FileWriter myWriter = null;
		if (notification.getChannel().equalsIgnoreCase("email")) {
			myWriter = new FileWriter("emailNotifications.txt", true);
		} else if (notification.getChannel().equalsIgnoreCase("sms")) {
			myWriter = new FileWriter("smsNotifications.txt", true);
		}
        notification.createMessage();
        myWriter.write(notification.getSubject() + " - " + notification.getChannel() + " - " + notification.getReceiver() + " - " + notification.getMessage());
        myWriter.write("\n");
        myWriter.close();
    }
	@Override
    public ArrayList<Notification> GetMailNotifications() throws IOException{
    	ArrayList<Notification> mailNotifications = new ArrayList<Notification>();
        FileReader reader = new FileReader(email);
        BufferedReader br = new BufferedReader(reader);

        Notification n = new Notification();
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(" - ");
            n.setSubject(data[0]);
            n.setChannel(data[1]);
            n.setReceiver(data[2]);
            n.setMessage(data[3]);
            mailNotifications.add(n);
        }
        reader.close();
        br.close();
    	return mailNotifications;
    }
	@Override
    public ArrayList<Notification> GetSMSNotifications() throws IOException{
    	ArrayList<Notification> smsNotifications = new ArrayList<Notification>();
        FileReader reader = new FileReader(sms);
        BufferedReader br = new BufferedReader(reader);

        Notification n = new Notification();
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(" - ");
            n.setSubject(data[0]);
            n.setChannel(data[1]);
            n.setReceiver(data[2]);
            n.setMessage(data[3]);
            smsNotifications.add(n);
        }
        reader.close();
        br.close();
    	return smsNotifications;
    }
}
