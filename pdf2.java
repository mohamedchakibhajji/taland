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
public class pdf2 {
        public static void main(String args[]) throws Exception 
    {
        Document document=new Document();
       PdfWriter.getInstance(document,new FileOutputStream("C:\\Users\\Amine\\Documents\\NetBeansProjects\\Taland\\carte.pdf"));
       document.open();
       com.itextpdf.text.Paragraph p = new com.itextpdf.text.Paragraph();
            p.add("Talent Card");
            p.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            document.add(p);
            document.add(com.itextpdf.text.Image.getInstance("C:\\Users\\Amine\\Documents\\NetBeansProjects\\Taland\\capture.png"));
            document.add(com.itextpdf.text.Image.getInstance("C:\\Users\\Amine\\Documents\\NetBeansProjects\\Taland\\codeqr.png"));


       
       
       
       document.close();
   }
    }