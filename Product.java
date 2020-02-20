/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;

/**
 *
 * @author Siwar
 */
public class Product {

    private int id;
    private String name;
    private int category;
    private float price;
    private int userId;
    private Date date;

   

    public int getMagasinId() {
        return userId;
    }

    public void setMagasinId(int userId) {
        this.userId = userId;
    }

    //Constructors
   public Product(int id, String name, int category, float price, int userId, Date date) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.userId = userId;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

   
    public Product() {
    }

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

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", userId=" + userId + ", date=" + date + '}';
    }

    


    

}
