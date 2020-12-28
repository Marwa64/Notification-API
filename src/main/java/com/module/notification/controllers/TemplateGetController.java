package com.module.notification.controllers;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	//http://localhost:8083/template/get/{id}
	@GetMapping(value = "/template/get/{id}")
	@ResponseBody
	public Template retriveTemplate(@PathVariable("id") int templateID) throws IOException {
		return templateDB.getTemplate(templateID);
	}
	@GetMapping(value = "/template/get")
	@ResponseBody
	public ArrayList<Template> retriveAllTemplates() throws IOException {
		return templateDB.getAllTemplates();
	}
}
