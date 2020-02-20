/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Basket;
import Entity.Product;
import Entity.Users;
import Interfaces.IServiceBasket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MaConnection;

/**
 *
 * @author Siwar
 */
public class ServiceBasket implements IServiceBasket {

    //variable de connexion avec la base de données
    Connection cnx;
    Users loggedInUser ;
    Basket myBasket;

    public ServiceBasket() throws SQLException {
        loggedInUser = new Users(9, "Hajji", "Chekib", "chekib.hajji@esprit.tn", "chekib123", 0, "21/02/1998", "chekib", "photo3", 0, "2/9/2020", "bio");
      //  this.myBasket = getMyBasket();
        cnx = MaConnection.getInstance().getConnection();
    }

    @Override
    public void createBasket() throws SQLException {
        String querry = "INSERT INTO `basket`(`id`,`userId`,`total`) VALUES(NULL,'" + loggedInUser.getId() + "','" + 0 + "')";
        Statement stm = cnx.createStatement();
        stm.executeUpdate(querry);
    }

    @Override
    public List<Basket> getBaskets() throws SQLException {
        String querry = "SELECT * FROM `basket`";
        List<Basket> allBaskets = new ArrayList<>();
        Statement stm = cnx.createStatement();
        ResultSet rs = stm.executeQuery(querry);
        while (rs.next()) {
            Basket b = new Basket();
            b.setId(rs.getInt(1));
            b.setUserId(rs.getInt(2));
            b.setTotal(rs.getDouble(3));
            allBaskets.add(b);
        }
        return allBaskets;
    }

    @Override
    public Basket getMyBasket() throws SQLException {
        String querry = "SELECT * FROM `basket` WHERE `userId`=" + loggedInUser.getId();        
        Statement stm = cnx.createStatement();
        ResultSet rs = stm.executeQuery(querry);
        Basket b = new Basket(rs.getInt(1), rs.getInt(2), rs.getDouble(3));
        return b;
    }

    @Override
    public void cleanBasket() throws SQLException {
        String querry = "DELETE FROM `basketproduit` WHERE `userId`=" + loggedInUser.getId();
        Statement stm = cnx.createStatement();
        stm.executeUpdate(querry);
    }

    @Override
    public double getTotal() throws SQLException {
        String querry = "SELECT * FROM `produit` JOIN `basketproduct` ON `produit`.`id`=`basketproduct`.`productId`"
                + "JOIN `basket` ON `basket`.`userId`=" + loggedInUser.getId();
        Statement stm = cnx.createStatement();
        ResultSet rs = stm.executeQuery(querry);
        List<Product> listOfProducts = new ArrayList<>();
        while (rs.next()) {
            Product p = new Product();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString(2));
            p.setCategory(rs.getInt(3));
            p.setPrice(rs.getFloat(4));
            listOfProducts.add(p);
        }
        double total = listOfProducts.stream().mapToDouble(p -> p.getPrice()).reduce(0, (a, b) -> a + b);
        return total;
    }

    @Override
    public void deleteFromBasket(Product p) throws SQLException {
//        String querry = "DELETE FROM `basketproduct` WHERE `basketId`=" + myBasket.getId() + "AND `productId`=" + p.getId();
//        Statement stm = cnx.createStatement();
//        stm.executeUpdate(querry);
    }

}
