package com.module.notification.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.module.notification.notificationData.Template;

@RestController
public class TemplateCreateController {
	
	//private final TemplateDataInterface templateDB = new TemplateDataFile();
	
	@PostMapping(
		value = "/create/template",
		consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, //This is to allow use to accept
		produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} // and produce JSON and XML 
			)
	
	/*@ResponseBody
	public TemplateDataInterface saveTemplate(@RequestBody Template template) {
		return TemplateDataFile.addTemplate(template);
	}*/
	@ResponseBody
    public String postBody(@RequestBody String fullName) {
        return "Hello " + fullName;
    }
}
