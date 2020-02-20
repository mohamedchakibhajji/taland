/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Siwar
 */
public class Magasin {

    private int id, userId,category;

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    private String name, abbreviation, location;

    //getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    //Construtors

    public Magasin() {
    }

    public Magasin(int id, int userId, int category, String name, String abbreviation, String location) {
        this.id = id;
        this.userId = userId;
        this.category = category;
        this.name = name;
        this.abbreviation = abbreviation;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Magasin{" + "id=" + id + ", userId=" + userId + ", category=" + category + ", name=" + name + ", abbreviation=" + abbreviation + ", location=" + location + '}';
    }

  

   

   

}
