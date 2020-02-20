/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import com.itextpdf.text.BadElementException;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.*;
import java.awt.AWTException;
import java.io.*;
/**
 *
 * @author Chekib
 */
public class pdf {
      public static void main(String competition , String nom , String prenom) throws FileNotFoundException, DocumentException, BadElementException, IOException, AWTException, InterruptedException 
    {
          String[] args = null;
        
        webcam.main(args);
        Document document=new  Document();
        PdfWriter.getInstance(document, new FileOutputStream("ticket.pdf"));
        document.open();
        Image img = Image.getInstance("ticket.png");
        
        document.add(new Paragraph("Compétition : "+ competition));
        document.add(new Paragraph("Nom : " + nom));
        document.add(new Paragraph("Prénom : " + prenom));
           document.add(img);
       
        document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------- "));
      Notification.main(args);
        document.close();
     Thread.sleep(5000);
     Process pro=Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler ticket.pdf");
    
    }
    
    
}
