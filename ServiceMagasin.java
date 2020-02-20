/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Category;
import Entity.Magasin;
import Entity.user;
import Interfaces.IServiceMagasin;
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
public class ServiceMagasin implements IServiceMagasin {

    //variable de connexion avec la base de données
    Connection cnx;

    //elaborer la connexion
    public ServiceMagasin() {
        cnx = MaConnection.getInstance().getConnection();
    }

    //CRUD
    @Override
    public void addMagasin(Magasin m) throws SQLException {
        String querry = "INSERT INTO `magasin` (`id`, `name`, `abbreviation`, `location`, `userId`,`category`) "
                + "VALUES (NULL, '" + m.getName() + "', '" + m.getAbbreviation() + "', '"
                + m.getLocation() + "','1'," + m.getCategory() + ")";
        Statement stm = (Statement) cnx.createStatement();
        stm.executeUpdate(querry);
        System.out.println("insertion de " + m.getName() + " bien faite");
    }

    @Override
    public void deleteMagasin(Magasin m) throws SQLException {
        String querry = "DELETE FROM `magasin` WHERE id=" + m.getId();
        Statement stm = (Statement) cnx.createStatement();
        stm.executeUpdate(querry);
        System.out.println("supprission de " + m.getName() + " est faite");

    }

    @Override
    public List<Magasin> getMagasins() throws SQLException {
        String querry = "SELECT * FROM `magasin`";
        Statement stm = (Statement) cnx.createStatement();
        ResultSet rs = stm.executeQuery(querry);
        List<Magasin> magasins = new ArrayList<>();
        while (rs.next()) {
            Magasin m = new Magasin();
            m.setId(rs.getInt("id"));
            m.setName(rs.getString(2));
            m.setAbbreviation(rs.getString(3));
            m.setLocation(rs.getString(4));
            m.setUserId(rs.getInt(5));
            m.setCategory(rs.getInt("category"));
            magasins.add(m);
        }
        return magasins;
    }

    @Override
    public void updateLocation(Magasin m, String newLocation) throws SQLException {
        String querry = "UPDATE `magasin` SET `location` = '" + newLocation + "' WHERE `magasin`.`id` =" + m.getId();
        Statement stm = cnx.createStatement();
        stm.executeUpdate(querry);
        System.out.println("update Location de magasin " + m.getName() + " done");
    }

    @Override
    public List<Magasin> getUserMagasins(user u) throws SQLException {
        List<Magasin> userMagasins = new ArrayList<>();
        String querry = "SELECT * FROM `magasin` WHERE `userId`=" + u.getId();
        Statement stm = cnx.createStatement();
        ResultSet rs = stm.executeQuery(querry);
        while (rs.next()) {
            Magasin m = new Magasin();
            m.setId(rs.getInt("id"));
            m.setName(rs.getString(2));
            m.setAbbreviation(rs.getString(3));
            m.setLocation(rs.getString(4));
            m.setUserId(rs.getInt(5));
            m.setCategory(rs.getInt("category"));
            userMagasins.add(m);

        }
        return userMagasins;
    }

    @Override
    public List<Magasin> getMagasinsByCategory(Category c) throws SQLException {
        List<Magasin> magasinsByCategory = new ArrayList<>();
        String querry = "SELECT * FROM `magasin` WHERE `category`=" + c.getId();
        Statement stm = cnx.createStatement();
        ResultSet rs = stm.executeQuery(querry);
        while (rs.next()) {
            Magasin m = new Magasin();
            m.setId(rs.getInt("id"));
            m.setName(rs.getString(2));
            m.setAbbreviation(rs.getString(3));
            m.setLocation(rs.getString(4));
            m.setUserId(rs.getInt(5));
            m.setCategory(rs.getInt("category"));
            magasinsByCategory.add(m);
        }
        return magasinsByCategory;
    }

    @Override
    public Magasin getMagasinById(Magasin m) throws SQLException {
      String querry="SELECT * FROM `magasin` WHERE `id`="+m.getId();
    Statement stm=cnx.createStatement();
    ResultSet rs=stm.executeQuery(querry);
    if(rs.next()){
     Magasin m1 = new Magasin();
            m1.setId(rs.getInt("id"));
            m1.setName(rs.getString(2));
            m1.setAbbreviation(rs.getString(3));
            m1.setLocation(rs.getString(4));
            m1.setUserId(rs.getInt(5));
            m1.setCategory(rs.getInt("category"));
            return m1;
    }
    return null;
    
    }

}
