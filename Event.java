/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;

/**
 *
 * @author ASUS_ROG
 */
public class Event {
    private int idEvent;
    private String name;
    private String description;
    private String location;
    private Date date;
    private float price_event;
    private int etat_event;
    private int spec_max;
    private int idU;
    
    
    
    //java.sql.date date=new java.sql.date(new java.util.date().getTime());

    public Event() {
    }

    public Event(int idEvent, String name, String description, String location, Date date, float price_event, int etat_event, int spec_max, int idU) {
        this.idEvent = idEvent;
        this.name = name;
        this.description = description;
        this.location = location;
        this.date = date;
        this.price_event = price_event;
        this.etat_event = etat_event;
        this.spec_max = spec_max;
        this.idU = idU;
    }

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getPrice_event() {
        return price_event;
    }

    public void setPrice_event(float price_event) {
        this.price_event = price_event;
    }

    public int getEtat_event() {
        return etat_event;
    }

    public void setEtat_event(int etat_event) {
        this.etat_event = etat_event;
    }

    public int getSpec_max() {
        return spec_max;
    }

    public void setSpec_max(int spec_max) {
        this.spec_max = spec_max;
    }

    @Override
    public String toString() {
        return "Event{" + "idEvent=" + idEvent + ", name=" + name + ", description=" + description + ", location=" + location + ", date=" + date + ", price_event=" + price_event + ", etat_event=" + etat_event + ", spec_max=" + spec_max + ", idU=" + idU + '}';
    }


    
    
    
}
