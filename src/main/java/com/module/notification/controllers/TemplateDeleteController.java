package com.module.notification.controllers;

import java.io.IOException;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.module.notification.notificationData.TemplateDataFile;
import com.module.notification.notificationData.TemplateDataInterface;



@RestController
public class TemplateDeleteController {

	final TemplateDataInterface templateDB;

	public TemplateDeleteController() throws IOException{
		this.templateDB = new TemplateDataFile();
	}

	//http://localhost:8083/template/delete/{id}
	@DeleteMapping(value="/template/delete/{id}")

	@ResponseBody
	public void deleteTemplate(@PathVariable("id") int tempID) throws IOException {
		templateDB.deleteTemplate(tempID);
	}
}