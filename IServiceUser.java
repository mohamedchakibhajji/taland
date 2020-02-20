/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entity.user;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Amine
 */
public interface IServiceUser {
    public void addUser(user u) throws SQLException;
    public ArrayList<user> getAllP() throws SQLException;
    public user getById(int id) throws SQLException ;   
    public void updateUser(user u);
    public void deleteUser(user u);
    
    
}
