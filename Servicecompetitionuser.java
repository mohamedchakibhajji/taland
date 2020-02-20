/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

/**
 *
 * @author Chekib
 */
import Entity.competitionuser;
import Entity.competition;
import Entity.trophe;
import utils.mail;
import utils.MaConnection;
import utils.Notification;
import utils.pdf;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chekib
 */
public class Servicecompetitionuser {
      private Connection cnx;
    private Statement st;
    private PreparedStatement pst;
     private PreparedStatement pst1;
    
    private ResultSet rs;
    public Servicecompetitionuser()
  {
      cnx=MaConnection.getInstance().getConnection();
      
  }
    
      public void reserverplacespec(competitionuser c) throws DocumentException, AWTException, BadElementException, IOException, FileNotFoundException, InterruptedException
  {  
        Servicecompetition ps=new Servicecompetition();
      int i = 0 ;
      int y = 0;
      if (ps.getcompetition(c.getIdcomp()).isEmpty()== true)
      {
          System.out.println("Verifier L'ID Compétition");
      }
      else 
        if( dejaparticipe( c.getIdcomp(),c.getIdu()) == 0)
        {        
        try {
    {   
                String[] args = null;
               pdf.main("Karaoke","Aziz","Farhan");
        String req="insert into competitionuser (idcomp,idu,type) values(?,?,'spectateur')";
        String req2="Update competition Set nbrspec=nbrspec+1 where idcomp ="+c.getIdcomp();
        String req3="Select * from competition";
            pst1=cnx.prepareStatement(req);
             pst=cnx.prepareStatement(req2);
             
            pst1.setInt   (1, c.getIdcomp());
            pst1.setInt   (2, c.getIdu());   
             Statement stm = cnx.createStatement();
             rs=st.executeQuery(req3);
             
       
     while(rs.next())
           
    {              
        i=rs.getInt("nbrspec");
        y=rs.getInt("nbrmaxspec");
    }
    
  } 
           
    
           if (i<=y)
           {
           pst1.executeUpdate();
           pst.executeUpdate();
           }
           
          else
           {
               System.out.println("Désolé Mais Nombre max reached");
           }
        } catch (SQLException ex) {
            Logger.getLogger(Servicecompetitionuser.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else 
            System.out.println("TU AS DEJA PARTICIPE!!!");
  } 
    
      
    public void reserverplace(competitionuser c) throws Exception
  {  
       Servicecompetition ps=new Servicecompetition();
      int i = 0 ;
      int y = 0;
      if (ps.getcompetition(c.getIdcomp()).isEmpty()== true)
      {
          System.out.println("Verifier L'ID Compétition");
      }
      else 
        if( dejaparticipe( c.getIdcomp(),c.getIdu()) == 0)
        {        
        try {
    {   
              //  String[] args = null;
       // mail.main(args);
        String req="insert into competitionuser (idcomp,idu,type) values(?,?,'participant')";
        String req2="Update competition Set nbrparticipant=nbrparticipant+1 where idcomp ="+c.getIdcomp();
        String req3="Select * from competition";
            pst1=cnx.prepareStatement(req);
             pst=cnx.prepareStatement(req2);
             
            pst1.setInt   (1, c.getIdcomp());
            pst1.setInt   (2, c.getIdu());   
             Statement stm = cnx.createStatement();
             rs=st.executeQuery(req3);
             
       
     while(rs.next())
           
    {              
        i=rs.getInt("nbrparticipant");
        y=rs.getInt("nbrmaxpar");
    }
    
  } 
           
    
           if (i<=y)
           {
                pst1.executeUpdate();
           
           pst.executeUpdate();
           }
           
          else
           {
               System.out.println("Désolé Mais Nombre max reached");
           }
        } catch (SQLException ex) {
            Logger.getLogger(Servicecompetitionuser.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else 
            System.out.println("TU AS DEJA PARTICIPE!!!");
  } 
    
       public int dejaparticipe(int idcomp,int idu)
     {
          int i=0; 

         String req="select  *  from competitionuser where idu = "+idu+" and idcomp = "+idcomp;
       try {
            st=cnx.createStatement();
            rs=st.executeQuery(req);
       
     while(rs.next())
           
    {              
       i=i+1;     
    }
        } catch (SQLException ex) {
            Logger.getLogger(Servicecompetitionuser.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return i;
         
     }
       
        public void supprimerparticipation(int idcomp , int id) 
    {
       
         Servicecompetition ps=new Servicecompetition();
      int i = 0 ;
      int y = 0;
      if (ps.getcompetition(idcomp).isEmpty()== true)
      {
          System.out.println("Verifier L'ID Compétition");
      }
      else 
           try {  
                String q ="delete from competitionuser where idcomp="+idcomp+" and idu="+id;
                 String req2="Update competition Set nbrparticipant=nbrparticipant-1 where idcomp ="+idcomp;
                 
             st=cnx.createStatement();
        
      
       st.executeUpdate(req2);
        st.executeUpdate(q);
    
    
               System.out.println("tu as supprimé ta participation");
          
            
        } catch (SQLException ex) {
            Logger.getLogger(Servicecompetitionuser.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }      

        
    
          public void supprimerparticipationspec(int idcomp , int id) 
    {
       
        Servicecompetition ps=new Servicecompetition();
      if (ps.getcompetition(idcomp).isEmpty()== true)
      {
          System.out.println("Verifier L'ID Compétition");
      }
      else
           try {  
                String q ="delete from competitionuser where idcomp="+idcomp+" and idu="+id;
                 String req2="Update competition Set nbrspec=nbrmaxspec-1 where idcomp ="+idcomp;
                 
             st=cnx.createStatement();
        
      
       st.executeUpdate(req2);
        st.executeUpdate(q);
    
    
               System.out.println("tu as supprimé ta participation au spec");
          
            
        } catch (SQLException ex) {
            Logger.getLogger(Servicecompetitionuser.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }      

     
    
}

