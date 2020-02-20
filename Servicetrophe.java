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

import Entity.trophe;
import utils.MaConnection;
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
public class Servicetrophe {
    
     private Connection cnx;
    private Statement st;

    public Servicetrophe() {
  
      cnx=MaConnection.getInstance().getConnection();

    }
    private PreparedStatement pst;
    private ResultSet rs;
    
     public int tropheexiste(int idu,int idcomp)
     {
          int i=0; 
       
         String req="select  *  from trophe where idu = "+idu+" and idcomp = "+idcomp;
       try {
            st=cnx.createStatement();
             
            rs=st.executeQuery(req);
      
     while(rs.next())
           
    {              
       i=i+1;     
    }
        } catch (SQLException ex) {
            Logger.getLogger(Servicetrophe.class.getName()).log(Level.SEVERE, null, ex);
           
        }
    
         return i;
         
     }
       
    public void affectertrohpe(trophe t)
  {  
      Servicecompetition ps=new Servicecompetition();
      int i = 0 ;
      int y = 0;
      if (ps.getcompetition(t.getIdcomp()).isEmpty()== true)
      {
          System.out.println("Verifier L'ID Compétition");
      }
      else 
      
      
        if( tropheexiste(t.getIdu(),t.getIdcomp()) == 0)
        {     
            
        try {
             
    {   
        
        String req="insert into trophe (idcomp,idu) values(?,?)";
     
            pst=cnx.prepareStatement(req);
            pst.setInt(1, t.getIdcomp()); //1ere pt d'interrogation 
            pst.setInt(2, t.getIdu());
    
  } 
          
       
           pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Servicetrophe.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        }
        else 
            System.out.println("Trophe affecte deja !!");
  } 
     
     public List<trophe> affichertrophe(int idu) {
     List<trophe> list=new ArrayList<>();
       String req="select * from trophe where idu ="+idu;
        try {
            st=cnx.createStatement();
            rs=st.executeQuery(req);
         
     while(rs.next())
     {
       list.add(new trophe(rs.getInt("idcomp"),rs.getInt("idu")));
 
      
   }
        } catch (SQLException ex) {
            Logger.getLogger(Servicetrophe.class.getName()).log(Level.SEVERE, null, ex);
          
        }
        return list;
       
    }
     
        public void supprimertrophe(int idcomp , int id) 
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
                String q ="delete from trophe where idcomp="+idcomp+" and idu="+id;
                
             st=cnx.createStatement();
        st.executeUpdate(q);
               System.out.println("tu as supprimé le trophe ");
        
        } catch (SQLException ex) {
            Logger.getLogger(Servicetrophe.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }      

 
     
}
