package com.module.notification.controllers;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.module.notification.notificationData.*;

@RestController
public class TemplateController {
	final TemplateDataInterface templateDB;
	
	public TemplateController() throws IOException {
		this.templateDB = new TemplateDataSQL();
	}

	//http://localhost:8083/template/create
	@PostMapping(value = "/template/create")
	@ResponseBody
	public ResponseEntity<Template> saveTemplate(@RequestBody Template template) throws IOException {
		templateDB.addTemplate(template);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
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
	
	//http://localhost:8083/template/update?id={id}
    @PutMapping("/template/update")
    @ResponseBody
    public Template update(@RequestBody Template template, @RequestParam("id") int templateID) throws IOException {
        Template updatedTemplate = templateDB.updateTemplate(templateID,template);
        if(updatedTemplate==null) return null;

        else return template;
    }
    
	//http://localhost:8083/template/delete/{id}
	@DeleteMapping(value="/template/delete/{id}")
	@ResponseBody
	public void deleteTemplate(@PathVariable("id") int tempID) throws IOException {
		templateDB.deleteTemplate(tempID);
	}
	
}
