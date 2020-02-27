/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.user;
import Interfaces.IServiceUser;
import Controller.InscriptionController;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import utils.MaConnection;

/**
 *
 * @author Amine
 */
public class ServiceUser implements IServiceUser{
    private Connection cnx;
    private Statement stm;
    private PreparedStatement pst;
    private PreparedStatement pst1;
    private ResultSet rs;

    public ServiceUser() {
        cnx = MaConnection.getInstance().getConnection();
        

    }
    
    public int authentification(user u){
        int test = 0;
          try {
          String req="select `id`,`username`, `password`  from fos_user";
          
              stm = cnx.createStatement();
              
           rs=  stm.executeQuery(req);

          while (rs.next() && (test==0)) {
            if (u.getUsername().equals((rs.getString("username"))) && (rs.getString("password").equals(u.getPassword())) ){
                System.out.println("asasasas");
                 test=rs.getInt(1);
                 System.out.println(test);
            }
            
            else{
           System.out.println("erreur");

            test=0;
            }
         
    
         
          }
    }   catch (SQLException ex) {
              System.out.println("erreur de test");
        }
        return test;
        }
    
 
    
    @Override
    public void addUser(user u) throws SQLException{
      
            String usernamea="'"+u.getUsername()+"'";
            String emaila="'"+u.getEmail()+"'";
            String firstnamea="'"+u.getFirstname()+"'";
            String lastnamea="'"+u.getLastname()+"'";
            String passworda="'"+u.getPassword()+"'";
            String birthdatea="'"+u.getBirthdate()+"'";
            String biographya="'"+u.getBiography()+"'";
            String sexea="'"+u.getSexe()+"'";
            String rolesa="'"+u.getRoles()+"'";
            String statusa="'"+u.getStatus()+"'";
            String strikea="'"+u.getStrike()+"'";
            String ratinga="'"+u.getRating()+"'";
             System.out.println("jhcvhgvhvhj");
            try{
                String  x;
                System.out.println("iyfucu");
               
                System.out.println("jvjvj");
               // System.out.println(x);
                System.out.println("jhcvhgvhvhj))))))))))))");
         // InputStream imgg=new FileInputStream(new File(x));
            System.out.println("jhcvhgvhvhè_--------j");
              String req = "INSERT INTO fos_user (firstname, lastname,username,email,password,birthdate,biography,sexe,roles,status,strike,rating,picture) "
                       + "VALUES ('"+u.getFirstname()+"', '"+u.getLastname()+"', '"+u.getUsername()+"', '"+u.getEmail()+"' , '"+u.getPassword()+"', '"+u.getBirthdate()+"', '"+u.getBiography()+"', '"+u.getSexe()+"', '"+u.getRoles()+"', '"+u.getStatus()+"', '"+u.getStrike()+"', '"+u.getRating()+"','"+u.getPicture()+"' )";
                     
                     
                    pst1 = cnx.prepareStatement(req);
                    
                  // pst1.setBlob(13, imgg);
                   
                    

                pst1.executeUpdate();
                System.out.println("ajout aves succes");
            }catch(SQLException EX){
                System.out.println("erreur");
            
           
        }
    }
    
    @Override    
    public ArrayList<user> getAllP() throws SQLException{
        ArrayList<user> retour = new ArrayList<user>();
        Statement stm = cnx.createStatement();
        user p=null;
        String req = "SELECT id, username,firstname,lastname,password,email,birthdate,sexe,biography FROM fos_user where roles='user'" ;
        ResultSet rs = stm.executeQuery(req);
      while (rs.next()) {                
      p=new user(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
  
      retour.add(p);
        }
  
  return retour;
  }
    
    
    @Override
    public user getById(int id) throws SQLException {
       String req="select id, username,firstname,lastname,password,email,birthdate,sexe,biography from fos_user where id=  "+id;
        
            Statement stm = cnx.createStatement();
            ResultSet rs=stm.executeQuery(req); 
            user result = new user();
        while(rs.next()){
            
            result.setId(rs.getInt("id"));
            result.setUsername(rs.getString("username"));
            result.setFirstname(rs.getString("firstname"));
            result.setLastname(rs.getString("lastname"));
            result.setPassword(rs.getString("password"));
            result.setEmail(rs.getString("email"));            
            result.setBirthdate(rs.getString("birthdate"));            
            result.setSexe(rs.getString("sexe"));  
            result.setBiography(rs.getString("biography")); 
         
        }
     //  list.add(new Talentueux(rs.getString("Talent"),rs.getInt("NumTel"), rs.getString("Email"), rs.getString("DateNaissance")); //soit le nom de la colonne soit l'indice
        return result;
    }   
    
    
    
}
