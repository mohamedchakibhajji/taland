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
public class Basket {
    private int id;
    private int userId;
    private double total;

    public Basket() {
    }

    public Basket(int id, int userId, double total) {
        this.id = id;
        this.userId = userId;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Basket{" + "id=" + id + ", userId=" + userId + ", total=" + total + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
}
