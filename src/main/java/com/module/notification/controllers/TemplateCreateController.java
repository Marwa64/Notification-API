package com.module.notification.controllers;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.module.notification.notificationData.*;


@RestController
public class TemplateCreateController {
	
	final TemplateDataInterface templateDB;
	
	public TemplateCreateController() throws IOException{
		this.templateDB = new TemplateDataFile();
	}

	//http://localhost:8083/templates/create
	@PostMapping(value = "/templates/create")
	
	@ResponseBody
	public ResponseEntity<Template> saveTemplate(@RequestBody Template template) throws IOException {
		templateDB.addTemplate(template);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}



