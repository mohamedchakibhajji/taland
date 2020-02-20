/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entity.Category;
import Entity.Magasin;
import Entity.user;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Siwar
 */
public interface IServiceMagasin {
    public void addMagasin(Magasin m)throws SQLException;
    public void deleteMagasin(Magasin m)throws SQLException;
    public List<Magasin> getMagasins()throws SQLException;
    public void updateLocation(Magasin m, String newLocation)throws SQLException;
    public List<Magasin> getUserMagasins(user u)throws SQLException;
    public List<Magasin> getMagasinsByCategory(Category c)throws SQLException;
    public Magasin getMagasinById(Magasin m)throws SQLException;
    
}
