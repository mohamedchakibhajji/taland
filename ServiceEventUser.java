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
import Entity.EventUser;
import Entity.Event;
import java.util.ArrayList;
import java.util.List;
import Interfaces.IServiceEventUser ;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MaConnection;

public class ServiceEventUser implements IServiceEventUser {
    
     Connection cnx;
    private Statement st;
    private PreparedStatement ps1;
    private PreparedStatement ps2;
    private ResultSet rs;
private ResultSet rs2;
    public ServiceEventUser() {
        cnx = MaConnection.getInstance().getConnection();
    }

    @Override
    public void reserverplace(EventUser c) {
       
         ServiceEvent ps=new ServiceEvent();
      int i = 0 ;
       int y = 0;
        
       if( dejaparticipe( c.getIdevent(),c.getIdu()) == 0)
        {        
        try {
    {   
                String[] args = null;
               ;
        String req="insert into eventUser (idEvent,idU) values(?,?)";
        String req2="Update events Set nbrspectateurevent=nbrspectateurevent+1 where idEvent ="+c.getIdevent();
        String req3="Select * from events where idEvent = "+c.getIdevent();
            ps2=cnx.prepareStatement(req);
            ps1=cnx.prepareStatement(req2);
             
            ps2.setInt   (1, c.getIdevent());
            ps2.setInt   (2, c.getIdu());   
             Statement stm = cnx.createStatement();
             rs=st.executeQuery(req3);
             
       
     while(rs.next())
           
    {              
        i=rs.getInt("nbrspectateurevent");
        y=rs.getInt("spec_max");
      
    }
        
  } 
    
           if (i<=y-1)
           {
           ps1.executeUpdate();
           ps2.executeUpdate();
           }
           
          else
           {
               System.out.println("Désolé Mais Nombre max reached");
           }
        } catch (SQLException ex) {
           
        }
        }
        else 
            System.out.println("TU AS DEJA PARTICIPE!!!");
    }

    @Override
    public int dejaparticipe(int idevent, int idu) {
      int i=0; 

         String req="select  *  from eventuser where idU = "+idu+" and idevent = "+idevent;
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

    
    public void supprimerparticipation(int idevent, int id) {
        
         Servicecompetition ps=new Servicecompetition();
      int i = 0 ;
      int y = 0;
     
 
           try {  
                String q ="delete from eventuser where idevent="+idevent+" and idU="+id;
                 String req2="Update events Set nbrspectateurevent=nbrspectateurevent-1 where idevent ="+idevent;
                 
             st=cnx.createStatement();
        
      
       st.executeUpdate(req2);
        st.executeUpdate(q);
    
    
               System.out.println("tu as supprimé ta participation");
          
            
        } catch (SQLException ex) {
               System.out.println("Bisous");
        }
        
    }

    

    
    
    
    
}