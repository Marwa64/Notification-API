package com.module.notification.controllers;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.module.notification.notificationData.TemplateDataFile;
import com.module.notification.notificationData.TemplateDataInterface;



@Controller
public class TemplateDeleteController {

	final TemplateDataInterface templateDB;

	public TemplateDeleteController() throws IOException{
		this.templateDB = new TemplateDataFile();
	}

	//http://localhost:8083/templates/delete?id={id}
	@RequestMapping(method = RequestMethod.DELETE, value="/template/delete/{tempID}")

	@ResponseBody
	public void deleteTemplate(@PathVariable("tempID") int tempID) throws IOException {		
		templateDB.deleteTemplate(tempID);		
	}	
}