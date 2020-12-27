package com.module.notification.controllers;

import com.module.notification.notificationData.Template;
import com.module.notification.notificationData.TemplateDataFile;
import com.module.notification.notificationData.TemplateDataInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class TemplateUpdateController {
    final TemplateDataInterface templateDB;


    public TemplateUpdateController() throws IOException {
        this.templateDB = new TemplateDataFile();
    }


    @PutMapping("/template/update")

    @ResponseBody
    public Template update(@RequestBody Template template, @RequestParam("id") int templateID) throws IOException {
        Template updatedTemplate = templateDB.updateTemplate(templateID,template);
        if(updatedTemplate==null) return null;

        else return template;
    }


}
