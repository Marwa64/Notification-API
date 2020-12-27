package com.module.notification.notificationData;
import java.io.*;

public class TemplateDataFile implements TemplateDataInterface {
    File templates = new File("templates.txt");
    FileWriter myWriter = new FileWriter("templates.txt", true);
    FileReader reader = new FileReader("templates.txt");

    public TemplateDataFile() throws IOException {
    }


    public boolean equals(Object criteraObject, Object templateObject) {

        if (criteraObject != null && templateObject != null) {
            if (criteraObject.equals(templateObject)) return true;
        } else if (criteraObject == null) return true;

        return false;
    }

    @Override
    public void addTemplate(Template t) throws IOException {
        myWriter = new FileWriter("templates.txt", true);
        myWriter.write(t.ID + " - " + t.language + " - " + t.templateName + " - " + t.content);
        myWriter.write("\n");
        myWriter.close();

    }

    public void updateTemplate(int ID, String language, String newName, String newContent) throws IOException {
        deleteTemplate(ID);
        Template t =new Template();
        t.setID(ID);
        t.setTemplateName(newName);
        t.setContent(newContent);
        t.setLanguage(language);
        addTemplate(t);
    }

    @Override
    public Template getTemplate(int templateId) throws IOException {
        Template t = new Template();
        SearchCriteria c = new SearchCriteria();
        c.setID(templateId);
        t = SearchTemplate(c);

        return t;
    }

    @Override
    public void deleteTemplate(int templateId) throws IOException {
        File tempFile = new File("tempFile.txt");
        FileWriter tempWriter = new FileWriter("tempFile.txt");
        String name, content, language, line;
        int id;
         reader = new FileReader("templates.txt");
        BufferedReader br = new BufferedReader(reader);
        while ((line = br.readLine()) != null) {
            String[] data = line.split(" - ");
            id = Integer.parseInt(data[0]);
            language = data[1];
            name = data[2];
            content = data[3];
            if (id != templateId) {
                tempWriter.write(language + " - " + name + " - " + content);
                tempWriter.write("\n");
            }

        }
        br.close();
        tempWriter.close();

        if (!templates.delete())
            System.out.println("Could not delete file");


        if (!tempFile.renameTo(templates))
            System.out.println("Could not rename file");

    }


    @Override
    public Template SearchTemplate(SearchCriteria criteria) throws IOException {
        String templateName, content, line;
        String language;
        int ID;
        reader = new FileReader("templates.txt");
        BufferedReader br = new BufferedReader(reader);
        while ((line = br.readLine()) != null) {
            String[] data = line.split(" - ");
            ID = Integer.parseInt(data[0]);
            language = data[1];
            templateName = data[2];
            content = data[3];
            if (equals(criteria.ID, ID) && equals(criteria.content, content) && equals(criteria.language, language) && equals(criteria.templateName, templateName)) {
                Template temp = new Template();
                temp.setContent(content);
                temp.setID(ID);
                temp.setLanguage(language);
                temp.setTemplateName(templateName);
                return temp;
            }

        }


        return null;
    }


}

