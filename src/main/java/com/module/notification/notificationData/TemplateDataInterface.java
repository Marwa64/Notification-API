package com.module.notification.notificationData;

import java.io.IOException;

class SearchCriteria {
    int ID;
    String templateName, content;
    String language;

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

}

public interface TemplateDataInterface {
    boolean addTemplate(Template t) throws IOException;
    Template updateTemplate(int ID, Template template) throws IOException;
    Template getTemplate(int templateId) throws IOException;
    boolean deleteTemplate(int templateId) throws IOException;
    Template SearchTemplate(SearchCriteria criteria) throws IOException;

}
