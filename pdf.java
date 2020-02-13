/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author amine
 */
public class pdf {
        public static void main(String args[]) throws Exception 
    {
        Document document=new Document();
       PdfWriter.getInstance(document,new FileOutputStream("C:\\Users\\Amine\\Documents\\NetBeansProjects\\Taland\\listusers.pdf"));
       document.open();
       PdfPTable table=new PdfPTable(6);
       table.addCell("id");
       table.addCell("firstname");
       table.addCell("lastname");
       table.addCell("email");
       table.addCell("birthdate");
       table.addCell("username");


       
       
       Class.forName("com.mysql.jdbc.Driver");
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/taland", "root", "");
       Statement st=con.createStatement();
       ResultSet rs=st.executeQuery("Select * from users order by id ");
       while(rs.next()){
       table.addCell(rs.getString("id"));
       table.addCell(rs.getString("firstname"));
       table.addCell(rs.getString("lastname"));
       table.addCell(rs.getString("email"));
       table.addCell(rs.getString("birthdate"));
       table.addCell(rs.getString("username"));

       }
       document.add(table);
       document.close();
   }
    }