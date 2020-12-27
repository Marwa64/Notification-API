package com.module.notification.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.module.notification.notificationData.Template;

@RestController
public class TemplateGetController {
	//http://localhost:8083/get/template
	@RequestMapping(method = RequestMethod.GET, value = "/get/template")
	
	@ResponseBody
	public String welcome() {
		return "Welcome!";
	}
}
