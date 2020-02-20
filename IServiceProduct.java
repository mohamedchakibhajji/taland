/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entity.Category;
import Entity.Product;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Siwar
 */
public interface IServiceProduct {

    public void addProduct(Product p) throws SQLException;

    public void deleteProduct(Product p) throws SQLException;

    public List<Product> getProducts() throws SQLException;

    public void updatePrice(Product p, float newPrice) throws SQLException;

    public List<Product> getProductsByCategory(Category c) throws SQLException;

    public List<Product> getProductsByPriceRange(float f1, float f2) throws SQLException;

    public Product getProductById(Product p) throws SQLException;

    public List<Product> getProductsSortedByPriceIncreasing() throws SQLException;

    public List<Product> getProductsSortedByPriceDecreasing() throws SQLException;

    public List<Product> getProductsSortedByName() throws SQLException;

    public List<Product> getProductsSortedByNameReversed() throws SQLException;
    
    public void addToBasket(Product p)throws SQLException;

}
