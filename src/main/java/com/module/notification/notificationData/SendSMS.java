package com.module.notification.notificationData;

import java.util.Random;

public class SendSMS implements SendNotification{
	@Override
	public boolean send(Notification notification) {
		Random rn = new Random();
		int max = 2, min = 1;
		int num = rn.nextInt(max - min + 1) + min;
		if (num == 1) {
			return true;
		}
		return false;
	}
}