package com.module.notification.notificationData;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class TemplateDataSQL implements TemplateDataInterface {
	@Override
    public boolean addTemplate(Template t) throws IOException{
    	if (!t.getTemplateName().equals(null) && !t.getContent().equals(null) && !t.getLanguage().equals(null)) {
    		try{  
    			Class.forName("com.mysql.cj.jdbc.Driver");  
    			Connection con=DriverManager.getConnection( "jdbc:mysql://db4free.net:3306/notificationapi","marwaomar","123456789");
    			Statement stmt = con.createStatement();
    			String sql = "INSERT INTO templates (templateName, content, language) " +"VALUES ('"+ t.getTemplateName() +"', '"+ t.getContent() +"', '"+ t.getLanguage() +"')";
    			stmt.executeUpdate(sql);
    			con.close(); 
    			return true;
    		} catch(Exception e){ 
    			System.out.println(e);
    		}  
    	} 
		return false;
    }
	
	@Override
    public Template updateTemplate(int ID, Template template) throws IOException{
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection( "jdbc:mysql://db4free.net:3306/notificationapi","marwaomar","123456789");
			Statement stmt = con.createStatement();
			String sql = "UPDATE templates SET templateName='" + template.getTemplateName() +"', content='"+ template.getContent() +"', language='"+ template.getLanguage() +"' WHERE id=" + ID;
			stmt.executeUpdate(sql);
			con.close(); 
			template.setID(ID);
			return template;
		} catch(Exception e){ 
			System.out.println(e);
		}  
		return null;
    }
	
	@Override
    public Template getTemplate(int templateId) throws IOException{
    	Template temp = new Template();
		try{
			  Class.forName("com.mysql.cj.jdbc.Driver"); 
			  Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/notificationapi","marwaomar","123456789");

		      Statement stmt = con.createStatement();
		      String sql = "SELECT * FROM templates WHERE id=" + templateId;
		      ResultSet rs = stmt.executeQuery(sql);
		      while(rs.next()){
                 temp.setID(rs.getInt("id"));
                 temp.setTemplateName(rs.getString("templateName"));
                 temp.setContent(rs.getString("content"));
                 temp.setLanguage(rs.getString("language"));
                 return temp;
		      }
		      rs.close();
		      con.close();
	   } catch(Exception e){
	      e.printStackTrace();
	   }
    	return null;
    }
	
	@Override
    public ArrayList<Template> getAllTemplates() throws IOException{
    	ArrayList<Template> list = new ArrayList<Template>();
		try{
			  Class.forName("com.mysql.cj.jdbc.Driver"); 
			  Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/notificationapi","marwaomar","123456789");

		      Statement stmt = con.createStatement();
		      String sql = "SELECT * FROM templates ";
		      ResultSet rs = stmt.executeQuery(sql);
		      while(rs.next()){
		       Template temp = new Template();
               temp.setID(rs.getInt("id"));
               temp.setTemplateName(rs.getString("templateName"));
               temp.setContent(rs.getString("content"));
               temp.setLanguage(rs.getString("language"));
               list.add(temp);
		      }
		      rs.close();
		      con.close();
	   } catch(Exception e){
	      e.printStackTrace();
	   }
    	return list;
    }
	
	@Override
    public boolean deleteTemplate(int templateId) throws IOException{
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection( "jdbc:mysql://db4free.net:3306/notificationapi","marwaomar","123456789");
			Statement stmt = con.createStatement();
			 String sql = "DELETE FROM templates WHERE id=" + templateId;
			stmt.executeUpdate(sql);
			con.close(); 
			return true;
		} catch(Exception e){ 
			System.out.println(e);
		}  
		return false;
    }
	
    public boolean equals(Object criteraObject, Object templateObject) {

        if (criteraObject != null && templateObject != null) {
            if (criteraObject.equals(templateObject)) return true;
        } else if (criteraObject == null) return true;

        return false;
    }
    
	@Override
	public Template SearchTemplate(SearchCriteria criteria) throws IOException{
		try{
			  Class.forName("com.mysql.cj.jdbc.Driver"); 
			  Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/notificationapi","marwaomar","123456789");

		      Statement stmt = con.createStatement();
		      String sql = "SELECT * FROM templates";
		      ResultSet rs = stmt.executeQuery(sql);
		      while(rs.next()){
		         Template temp = new Template();
	             temp.setID(rs.getInt("id"));
	             temp.setTemplateName(rs.getString("templateName"));
	             temp.setContent(rs.getString("content"));
	             temp.setLanguage(rs.getString("language"));
	             if (equals(criteria.ID, temp.getID()) || equals(criteria.content, temp.getContent()) && equals(criteria.language, temp.getLanguage()) && equals(criteria.templateName, temp.getTemplateName())) {
	            	 return temp;
	             }
		      }
		      rs.close();
		      con.close();
	   } catch(Exception e){
	      e.printStackTrace();
	   }
    	return null;
    }
}
