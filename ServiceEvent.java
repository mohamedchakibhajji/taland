/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Entity.Event;
import Interfaces.IServiceEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.sql.Date;
import java.util.List;
import utils.MaConnection;
/**
 *
 * @author ASUS_ROG
 */
public class ServiceEvent implements IServiceEvent {
    Connection cnx;

    public ServiceEvent() {
        cnx = MaConnection.getInstance().getConnection();
    }
    @Override
    public void addEvent(Event e) throws SQLException {
         Statement stm = cnx.createStatement();
        String query = "INSERT INTO `events` (`idEvent`, `name`, `description`, `location`, `date`, `price_event`, `etat_event`, `spec_max`, `idU`)"
                + "     VALUES (NULL, '"+e.getName()+"', '"+e.getDescription()+"', '"+e.getLocation()+"', '"+e.getDate()+"', '"+e.getPrice_event()+"','"+e.getEtat_event()+"','"+e.getSpec_max()+"','"+e.getIdU()+"')";
        stm.executeUpdate(query); 
    }

    @Override
    public List<Event> getEvents() throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "select * from `events`";
        ResultSet rst = stm.executeQuery(query);
        
        List<Event> events = new ArrayList<>();
        
        while (rst.next()) {
            
            Event e2 = new Event();
            
            e2.setIdEvent(rst.getInt("idEvent"));
            e2.setName(rst.getString("name"));
            e2.setDescription(rst.getString("description"));
            e2.setLocation(rst.getString("location"));
            e2.setDate(rst.getDate("date"));
            e2.setPrice_event(rst.getFloat("price_event"));
            e2.setEtat_event(rst.getInt("etat_event"));
            e2.setSpec_max(rst.getInt("spec_max"));
            e2.setIdU(rst.getInt("idU"));

            events.add(e2);
        }
     return events;
    }

    @Override
    public List<Event> TrierEvents(int i) throws SQLException {
        Statement stm = cnx.createStatement();
        
        String query;
        if (i==1) {
            query = "select * from `events` ORDER BY name ASC";
        }else if (i==2) {
            query = "select * from `events` ORDER BY date ASC";
        } else if (i==3) {
            query = "select * from `events` ORDER BY price_event ASC";
        }
        else{
            query = "select * from `events` ORDER BY name DESC";
        }
          
        ResultSet rst = stm.executeQuery(query);
        
        List<Event> events = new ArrayList<>();
        
        while (rst.next()) {
            Event e2 = new Event();
            
            e2.setIdEvent(rst.getInt("idEvent"));
            e2.setName(rst.getString("name"));
            e2.setDescription(rst.getString("description"));
            e2.setLocation(rst.getString("location"));
            e2.setDate(rst.getDate("date"));
            e2.setPrice_event(rst.getFloat("price_event"));
            e2.setEtat_event(rst.getInt("etat_event"));
            e2.setSpec_max(rst.getInt("spec_max"));
            e2.setIdU(rst.getInt("idU"));
            
            events.add(e2);
        }
     return events;
    }

    
    
    @Override
    public Event getById(int id) throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "select * from `events` where idEvent= '"+id+"'";
        ResultSet rst = stm.executeQuery(query);
        
        Event result = new Event();
        
        while (rst.next()) {
            
            result.setIdEvent(rst.getInt("idEvent"));
            result.setName(rst.getString("name"));
            result.setDescription(rst.getString("description"));
            result.setLocation(rst.getString("location"));
            result.setDate(rst.getDate("date"));
            result.setPrice_event(rst.getFloat("price_event"));
            result.setEtat_event(rst.getInt("etat_event"));
            result.setSpec_max(rst.getInt("spec_max"));
            result.setIdU(rst.getInt("idU"));
            
        }
     return result;
    }

    @Override
    public void deleteEvent(Event e) throws SQLException {
         Statement stm = cnx.createStatement();
        String query = "DELETE FROM events where idEvent= '"+e.getIdEvent()+"'";
        stm.executeUpdate(query);    
    }

    @Override
    public void deleteEvent(int id) throws SQLException {
         Statement stm = cnx.createStatement();
        String query = "DELETE FROM events where idEvent= '"+id+"'";
        stm.executeUpdate(query);   
    }

    @Override
    public void updateEvent(Event e,int id) throws SQLException {
         Statement stm = cnx.createStatement();
        String query = "UPDATE events SET name= '"+e.getName()+"', description= '"+e.getDescription()+"', location= '"+e.getLocation()+"', date= '"+e.getDate()+"', price_event= '"+e.getPrice_event()+"', etat_event= '"+e.getEtat_event()+"', spec_max= '"+e.getSpec_max()+"' WHERE idEvent='"+e.getIdEvent()+"'";
        
        if (id == e.getIdU()) {
            stm.executeUpdate(query);         
            System.out.println("Event Updated !");
        }else{
            System.out.println("You are not allowed to update this event");        
        }
       
    }

    @Override
    public void SearchEvents(String charac) {
           String requete="select * from events where name LIKE '%"+charac+"%' or description LIKE '%"+charac+"%' or location LIKE '%"+charac+"%' or price_event LIKE '%"+charac+"%'" ;

        try {
            Statement stm=cnx.createStatement();
            ResultSet rst=stm.executeQuery(requete);  

     while(rst.next()) 
    {       
        //System.out.println("Event : "+rst.getString("description")+"\tMedia :"+rst.getString("source")+"\tNombre de J'aime :"+rst.getInt("nbrlikes") );
 
            Event result = new Event();
            
            result.setIdEvent(rst.getInt("idEvent"));
            result.setName(rst.getString("name"));
            result.setDescription(rst.getString("description"));
            result.setLocation(rst.getString("location"));
            result.setDate(rst.getDate("date"));
            result.setPrice_event(rst.getFloat("price_event"));
            result.setEtat_event(rst.getInt("etat_event"));
            result.setSpec_max(rst.getInt("spec_max"));
            result.setIdU(rst.getInt("idU"));
            
            System.out.println(result);  
    }
        } catch (SQLException ex) {
            System.out.println("No Event Available !");
        }      
    }
    

    
}
