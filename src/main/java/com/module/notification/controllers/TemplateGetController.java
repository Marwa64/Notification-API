package com.module.notification.controllers;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.module.notification.notificationData.Template;
import com.module.notification.notificationData.TemplateDataFile;
import com.module.notification.notificationData.TemplateDataInterface;

@RestController
public class TemplateGetController {
	final TemplateDataInterface templateDB;
	
	public TemplateGetController() throws IOException{
		this.templateDB = new TemplateDataFile();
	}
	//http://localhost:8083/templates/get?id={id}
	@GetMapping(value = "/templates/get")
	
	@ResponseBody
	public Template retriveTemplate(@RequestParam("id") int templateID) throws IOException {
		Template template = templateDB.getTemplate(templateID);
		return template;
	}
}
