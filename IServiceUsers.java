/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entity.Users;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Amine
 */
public interface IServiceUsers  {
    
    public void addUsers(Users u) throws SQLException;
    
    public void displayUsers() throws SQLException;

    public List<Users> getUsers() throws SQLException;

    public Users getById(int id) throws SQLException;

    public void deleteUsers(Users u) throws SQLException;

    public void deleteUsers(int id) throws SQLException;

    public void updateUsers(int id,String email,String username) throws SQLException;
    
    public void rechercherUtilisateurparUsername(String username);
    
    public void rechercherUtilisateurparcaractere(String caractere) ;
    
    public int login(String username,String password );
    
    public void trier();
    
}
