/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Message;
import Interfaces.IServiceDeals;
import Interfaces.IServiceMessage;
import utils.MaConnection;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.objects.NativeRegExp;

/**
 *
 * @author acer
 */
public class ServiceMessage implements IServiceMessage{
        private Connection cnx;
    private Statement st;
    private PreparedStatement pst;
    private PreparedStatement pst1;
    private ResultSet rs;
    public ServiceMessage()
  {
      cnx=MaConnection.getInstance().getConnection();
      
  }
    
    @Override
    public void addMessage(Message m )  {
     
        try {    
    {   
        String req="insert into message (idmessage,idU,idreceiver,contenu,etatmessage) values(?,?,?,?,?)";
     
            pst1=cnx.prepareStatement(req);
            pst1.setInt(1, m.getIdmessage()); 
            pst1.setInt(2, m.getIdU()); 
            pst1.setInt(3, m.getIdreceiver());
            pst1.setString(4, m.getContenu()); 
            pst1.setInt(5, m.getEtatmessage()); 
            
           
  } 
          
       
           pst1.executeUpdate();
        } catch (SQLException ex) {
            
        }
        
    }
    
    
    @Override
     public void displayMessage() throws SQLException{
     
       String req="select * from message ";
        try {
            Statement stm = cnx.createStatement();
            ResultSet rs=stm.executeQuery(req);
       
     while(rs.next())
    
       
       System.out.println("Fromc"+rs.getInt("idU") +"  ---> TO :"+rs.getInt("idreceiver")+ " ====== " +  rs.getString("contenu") );
 
      
  
        } catch (SQLException ex) {
            Logger.getLogger(ServiceMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
