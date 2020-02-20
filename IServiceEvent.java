/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

import java.sql.SQLException;
import java.util.List;
import Entity.Event;
import java.util.Date;

/**
 *
 * @author ASUS_ROG
 */
public interface IServiceEvent {
    
    public void addEvent(Event p) throws SQLException;

    public List<Event> getEvents() throws SQLException;
    
    public List<Event> TrierEvents(int i) throws SQLException;

    public Event getById(int id) throws SQLException;

    public void deleteEvent(Event p) throws SQLException;

    public void deleteEvent(int id) throws SQLException;

    public void updateEvent(Event p,int id) throws SQLException; 
    
    public void SearchEvents(String character) ;
    
    
}
