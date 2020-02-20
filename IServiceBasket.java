/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entity.Basket;
import Entity.Product;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Siwar
 */
public interface IServiceBasket {
    public void createBasket()throws SQLException;
    public List<Basket> getBaskets()throws SQLException;
    public Basket getMyBasket()throws SQLException;
    public void cleanBasket()throws SQLException;
    public double getTotal()throws SQLException;
    public void deleteFromBasket(Product p)throws SQLException;
    
    
}
