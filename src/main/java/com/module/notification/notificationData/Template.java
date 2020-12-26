package com.module.notification.notificationData;
import java.io.*;
import java.util.ArrayList;

public class Template {
    static int ID=0;
    File templates = new File("templates.txt");
    FileWriter myWriter = new FileWriter("templates.txt");


    public Template() throws IOException {
//        myWriter.write("ID - Language - Type - Content\n");
//        myWriter.close();
    }


    public String getContent(String templateName) throws IOException {
        String name,content,language,line,ID;
        FileReader file = new FileReader("templates.txt");
        BufferedReader br = new BufferedReader(file);
        while ((line = br.readLine())!= null){
            String[] data = line.split(" - ");
            ID= data[0];
            language = data[1];
            name = data[2];
            content = data[3];
            if (templateName.equalsIgnoreCase(name))return content;

        }

        return "NOT FOUND";
    }

    public  String getContent(int id) throws IOException {
        String type,content,language,line;
        int ID;
        FileReader file = new FileReader("templates.txt");
        BufferedReader br = new BufferedReader(file);
        while ((line = br.readLine())!= null){
            String[] data = line.split(" - ");
            ID= Integer.parseInt(data[0]);
            language = data[1];
            type = data[2];
            content = data[3];
            if (id==ID)return content;

        }

        return "NOT FOUND";

    }

    public void addTemplate(String Language , String templateName , String content) throws IOException {
        myWriter = new FileWriter("templates.txt",true);
        myWriter.write(ID++ + " - "+Language+" - "+templateName+" - " + content);
        myWriter.write("\n");
        myWriter.close();



    }

    public void updateTemplate(int ID , String language ,String newName ,String newContent) throws IOException {
        removeTemplate(ID);
        addTemplate(language,newName,newContent);
    }



    public void removeTemplate(int ID) throws IOException {
        File tempFile= new File("tempFile.txt");
        FileWriter tempWriter = new FileWriter("tempFile.txt");
        String name,content,language,line;
        int id;
        FileReader file = new FileReader("templates.txt");
        BufferedReader br = new BufferedReader(file);
        while ((line = br.readLine())!= null){
            String[] data = line.split(" - ");
            id= Integer.parseInt(data[0]);
            language = data[1];
            name = data[2];
            content = data[3];
            if (id != ID) {
                tempWriter.write(language+" - "+name+" - " + content);
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



}
