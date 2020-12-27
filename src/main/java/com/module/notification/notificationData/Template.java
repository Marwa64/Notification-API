package com.module.notification.notificationData;

public class Template {

int ID;
String templateName, content;
Language language;


    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setLanguage(String language) {

        this.language.setName(language);
    }

    public Language getLanguage() {
        return language;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getTemplateName() {
        return templateName;
    }
}

