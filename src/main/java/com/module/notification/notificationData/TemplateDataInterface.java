package com.module.notification.notificationData;

import java.io.IOException;

class SearchCriteria {
    int ID;
    String templateName, content;
    Language language;

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

}

public interface TemplateDataInterface {
    void addTemplate(Template t) throws IOException;
    void updateTemplate(int ID , String language ,String newName ,String newContent) throws IOException;
    Template getTemplate(int templateId) throws IOException;
    void deleteTemplate(int templateId) throws IOException;
    Template SearchTemplate(SearchCriteria criteria) throws IOException;

}
