package com.module.notification.notificationData;
import java.io.*;

public class TemplateDataFile implements TemplateDataInterface {

    public TemplateDataFile() throws IOException {
    }


    public boolean equals(Object criteraObject, Object templateObject) {

        if (criteraObject != null && templateObject != null) {
            if (criteraObject.equals(templateObject)) return true;
        } else if (criteraObject == null) return true;

        return false;
    }

    @Override
    public boolean addTemplate(Template t) throws IOException {
        FileWriter myWriter = new FileWriter("templates.txt", true);

        myWriter.write(t.ID + " - " + t.language + " - " + t.templateName + " - " + t.content);
        myWriter.write("\n");
        myWriter.close();


        return true;

    }

    public Template updateTemplate(int ID, Template template) throws IOException {
        if(deleteTemplate(ID)) {
            template.setID(ID);
            System.out.println("Here2");

            if(addTemplate(template)) return template;
        }

        return null;
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
    public boolean deleteTemplate(int templateId) throws IOException {
        File templates = new File("templates.txt");
        FileReader reader = new FileReader(templates);
        BufferedReader br = new BufferedReader(reader);



        File tempFile = new File("tempFile.txt");
        FileWriter tempWriter = new FileWriter(tempFile);



        String name, content, language, line;
        int id;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(" - ");
            id = Integer.parseInt(data[0]);
            language = data[1];
            name = data[2];
            content = data[3];
            if (id != templateId) {
                tempWriter.write(id + " - " + language + " - " + name + " - " + content);
                tempWriter.write("\n");
            }

        }

        reader.close();
        br.close();
        tempWriter.close();

        if(templates.delete()) {
            if (tempFile.renameTo(templates)) {
            return true;
            }
        }


        return false;

    }


    @Override
    public Template SearchTemplate(SearchCriteria criteria) throws IOException {
        String templateName, content, line;
        String language;
        int ID;
        FileReader reader = new FileReader("templates.txt");
        BufferedReader br = new BufferedReader(reader);
        while ((line = br.readLine()) != null) {
            String[] data = line.split(" - ");
            ID = Integer.parseInt(data[0]);
            language = data[1];
            templateName = data[2];
            content = data[3];
            if (equals(criteria.ID, ID) && equals(criteria.content, content) && equals(criteria.language, language) && equals(criteria.templateName, templateName)) {
                br.close();
                reader.close();
                Template temp = new Template();
                temp.setContent(content);
                temp.setID(ID);
                temp.setLanguage(language);
                temp.setTemplateName(templateName);
                return temp;
            }

        }
        reader.close();
        br.close();
        return null;
    }




}

