/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Category;
import Entity.Magasin;
import Entity.Product;
import Interfaces.IServiceProduct;
import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;

import java.util.List;
import java.util.stream.Collectors;
import utils.MaConnection;

/**
 *
 * @author Siwar
 */
public class ServiceProduct implements IServiceProduct {

    //vairable de la connexion avec la base de données
    Connection cnx;

    //elaborer la connexion
    public ServiceProduct() {
        cnx = MaConnection.getInstance().getConnection();
    }
    //CRUD

    @Override
    public void addProduct(Product p) throws SQLException {
        java.sql.Date dateFormat = new java.sql.Date(new java.util.Date().getTime());
        String querry = "INSERT INTO `produit` (`id`, `name`, `category`, `price`,`userId`,`date`) VALUES (NULL, '"
                + p.getName() + "', '" + p.getCategory() + "', '" + p.getPrice() + "','1','" + dateFormat + "')";
        Statement stm = (Statement) cnx.createStatement();
        stm.executeUpdate(querry);
        System.out.println("insertion de " + p.getName() + " bien faite");
    }

    @Override
    public void deleteProduct(Product p) throws SQLException {
        String querry = "DELETE FROM `produit` WHERE id=" + p.getId();
        Statement stm = cnx.createStatement();
        stm.executeUpdate(querry);

    }

    @Override
    public List<Product> getProducts() throws SQLException {
        String querry = "SELECT * FROM `produit`";
        Statement stm = (Statement) cnx.createStatement();
        ResultSet rs = stm.executeQuery(querry);
        List<Product> products = new ArrayList<>();
        while (rs.next()) {
            Product p = new Product();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString(2));
            p.setCategory(rs.getInt(3));
            p.setPrice(rs.getFloat(4));
            products.add(p);
        }
        return products;
    }

    @Override
    public void updatePrice(Product p, float newPrice) throws SQLException {
        String querry = "UPDATE `produit` SET `price` = '" + newPrice + "' WHERE `produit`.`id` = " + p.getId();
        Statement stm = cnx.createStatement();
        stm.executeUpdate(querry);
        System.out.println("update price de produit " + p.getName() + " bien faite");
    }

    @Override
    public List<Product> getProductsByCategory(Category c) throws SQLException {
        String querry = "SELECT * FROM `produit` WHERE `category`=" + c.getId();
        Statement stm = cnx.createStatement();
        ResultSet rs = stm.executeQuery(querry);
        List<Product> productsByCategory = new ArrayList<>();
        while (rs.next()) {
            Product p = new Product();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString(2));
            p.setCategory(rs.getInt(3));
            p.setPrice(rs.getFloat(4));
            productsByCategory.add(p);
        }
        return productsByCategory;

    }

    @Override
    public List<Product> getProductsByPriceRange(float f1, float f2) throws SQLException {
        String querry = "SELECT * FROM `produit` WHERE `price` BETWEEN " + f1 + " AND " + f2;
        Statement stm = cnx.createStatement();
        ResultSet rs = stm.executeQuery(querry);
        List<Product> productsByPriceRange = new ArrayList<>();
        while (rs.next()) {
            Product p = new Product();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString(2));
            p.setCategory(rs.getInt(3));
            p.setPrice(rs.getFloat(4));
            productsByPriceRange.add(p);
        }
        return productsByPriceRange;
    }

    @Override
    public Product getProductById(Product p) throws SQLException {
        String querry = "SELECT * FROM `produit` WHERE `id`=" + p.getId();
        Statement stm = cnx.createStatement();
        ResultSet rs = stm.executeQuery(querry);
        if (rs.next()) {
            Product p1 = new Product();
            p1.setId(rs.getInt("id"));
            p1.setName(rs.getString(2));
            p1.setCategory(rs.getInt(3));
            p1.setPrice(rs.getFloat(4));
            return p1;
        }
        return null;
    }

    @Override
    public List<Product> getProductsSortedByPriceIncreasing() throws SQLException {
        String querry = "SELECT * FROM `produit`";
        Statement stm = (Statement) cnx.createStatement();
        ResultSet rs = stm.executeQuery(querry);
        List<Product> products = new ArrayList<>();
        while (rs.next()) {
            Product p = new Product();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString(2));
            p.setCategory(rs.getInt(3));
            p.setPrice(rs.getFloat(4));
            products.add(p);
        }
        List<Product> sortedList = new ArrayList<>();
        sortedList = products.stream().sorted(Comparator.comparing(Product::getPrice))
                .collect(Collectors.toList());
//                .sorted((p1, p2) -> p1.compareTo(p2))
//                .collect(Collectors.toList());
        return sortedList;
    }

    @Override
    public List<Product> getProductsSortedByName() throws SQLException {
        String querry = "SELECT * FROM `produit`";
        Statement stm = (Statement) cnx.createStatement();
        ResultSet rs = stm.executeQuery(querry);
        List<Product> products = new ArrayList<>();
        while (rs.next()) {
            Product p = new Product();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString(2));
            p.setCategory(rs.getInt(3));
            p.setPrice(rs.getFloat(4));
            products.add(p);
        }
        List<Product> sortedListByName = new ArrayList<>();
        sortedListByName = products.stream().sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList());

//                products.stream()
//                .sorted()
//                .collect(Collectors.toList());
        return sortedListByName;
    }

    @Override
    public List<Product> getProductsSortedByPriceDecreasing() throws SQLException {
        String querry = "SELECT * FROM `produit`";
        Statement stm = (Statement) cnx.createStatement();
        ResultSet rs = stm.executeQuery(querry);
        List<Product> products = new ArrayList<>();
        while (rs.next()) {
            Product p = new Product();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString(2));
            p.setCategory(rs.getInt(3));
            p.setPrice(rs.getFloat(4));
            products.add(p);
        }
        List<Product> sortedList = new ArrayList<>();
        sortedList = products.stream().sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());
//                .sorted((p1, p2) -> p1.compareTo(p2))
//                .collect(Collectors.toList());
        return sortedList;
    }

    @Override
    public List<Product> getProductsSortedByNameReversed() throws SQLException {
        String querry = "SELECT * FROM `produit`";
        Statement stm = (Statement) cnx.createStatement();
        ResultSet rs = stm.executeQuery(querry);
        List<Product> products = new ArrayList<>();
        while (rs.next()) {
            Product p = new Product();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString(2));
            p.setCategory(rs.getInt(3));
            p.setPrice(rs.getFloat(4));
            products.add(p);
        }
        List<Product> sortedListByName = new ArrayList<>();
        sortedListByName = products.stream().sorted(Comparator.comparing(Product::getName).reversed())
                .collect(Collectors.toList());

//                products.stream()
//                .sorted()
//                .collect(Collectors.toList());
        return sortedListByName;
    }

    @Override
    public void addToBasket(Product p) throws SQLException {
        ServiceBasket SB=new ServiceBasket();
        int myBasket=SB.getMyBasket().getId();
    String querry="INSERT INTO `basketproduit`(`basketId`,`productId`) VALUES ('"+myBasket+"','"+p.getId()+"')"; 
    }

}
