/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.user;
import Interfaces.IServiceUser;
import Controller.InscriptionnController;
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
    
        public String encrypt(String password){
        String crypte= " " ;
        for (int i=0; i<password.length();i++)  {
            int c=password.charAt(i)^48; 
            crypte=crypte+(char)c;
        }
        return crypte;
    }

 
    
    public int verifexistance(String email, String username) {
        int i = 0;
        String maila = "'" + email + "'";
        String usernamea = "'" + username + "'";
        String req = "select  *  from fos_user where email =" + maila + "or username =" + usernamea;
        try {
            stm = cnx.createStatement();
            rs = stm.executeQuery(req);

            while (rs.next()) {

                i = i + 1;

            }

        } catch (SQLException ex) {
            Logger.getLogger(ServiceUsers.class.getName()).log(Level.SEVERE, null, ex);
        }

        return i;

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
              
                String x =encrypt(u.getPassword());
              String req = "INSERT INTO fos_user (firstname, lastname,username,email,password,birthdate,biography,sexe,roles,status,strike,rating,picture) "
                       + "VALUES ('"+u.getFirstname()+"', '"+u.getLastname()+"', '"+u.getUsername()+"', '"+u.getEmail()+"' , '"+x+"', '"+u.getBirthdate()+"', '"+u.getBiography()+"', '"+u.getSexe()+"', '"+u.getRoles()+"', '"+u.getStatus()+"', '"+u.getStrike()+"', '"+u.getRating()+"','"+u.getPicture()+"' )";
                     
                     
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
        String req = "SELECT id, username,firstname,lastname,email,birthdate,sexe,biography FROM fos_user where roles='user'" ;
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
    
    
    @Override
       public void updateUser(user u) {
        
         
        
   String sql="UPDATE fos_user SET `username`=? , `password`=? ,`email`=?   ,`firstname`=? ,`lastname`=?  ,`biography`=?  ,`birthdate`=? WHERE email Like '"+u.getEmail()+"'";
   PreparedStatement ps;
        try {
            ps = cnx.prepareStatement(sql);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getFirstname());
            ps.setString(5, u.getLastname());
            ps.setString(6, u.getBiography());
            ps.setString(7, u.getBirthdate());
            //ps.setString(6, u.getCin());

            
            ps.executeUpdate();
           // int rowsUpdated=ps.executeUpdate();
           // if (rowsUpdated>0){
           String x=u.getEmail();
            System.out.println("x:"+x);
            System.out.println("La modification de user"+u.getEmail()+" a été éffectué avec succée ");
            }
        catch (SQLException ex) {
            System.out.println("erreur modification");
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
    @Override
       public void deleteUser(user r)   {
        String requete = " DELETE FROM fos_user WHERE id="+r.getId();
        System.out.println("hayhay");
        try {
            
           //  String[] args1 = null;
             //TrayIconDemo.main(args1);
          //  PreparedStatement pst = DataBase.getInstance().getConnection().prepareStatement(requete);
            
            stm= cnx.createStatement();
            stm.executeUpdate(requete);
                        System.out.println("aman");
            System.err.println("user Supprimé !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        
        
    }
       
       
       
       public ArrayList<user> filtre(String caractere) {
           ArrayList<user> retour = new ArrayList<user>();
           user u =null;

        
       String req = "  SELECT * FROM fos_user WHERE firstname  like '"+ "%"+caractere+"%"+"' or lastname like '"+ "%"+caractere+"%"+"'" +"or username like '"+ "%"+caractere+"%"+"' or password like '"+"%"+caractere+"% '" +"ORDER BY id DESC " ;
        try {
            stm = cnx.createStatement();
            rs = stm.executeQuery(req);
            System.out.println("filtre par id desc: ");

            while (rs.next()) {
                
                 u=new user(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
                 
                retour.add(u); 

            }

        } catch (SQLException ex) {
            System.out.println("erreur tri");
        }
        return retour;
        
        
    }
       
       public ArrayList<user> rechercherNom(String rech) throws SQLException {

        ArrayList<user> off = new ArrayList<>();
           user e = null;
        String req = "SELECT id ,`username` ,`firstname`,`lastname`,`email`,`birthdate`,`sexe` ,`biography` FROM fos_user where firstname Like '%"+rech+"%' and roles ='user' ";  
         
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(req);
        

        while (rst.next()) {
                              e = new user();
                
              
                
                e.setId(rst.getInt("id"));
                e.setFirstname(rst.getString("username"));
                e.setFirstname(rst.getString("firstname"));
                e.setLastname(rst.getString("lastname"));
                e.setEmail(rst.getString("email"));
                e.setBirthdate(rst.getString("birthdate"));
                e.setSexe (rst.getString("sexe"));
                e.setBiography(rst.getString("biography"));
                
        

             
                
                      
   user per = new user(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7),rst.getString(8));
  

            off.add(per);
        }
        return off;
    }
       
       
    public ArrayList<user> trier() throws SQLException {
         ArrayList<user> off = new ArrayList<>();
           user e = null;
        String req = "SELECT id ,`username` ,`firstname`,`lastname`,`email`,`birthdate`,`sexe` ,`biography` FROM fos_user order by id desc ";  
         
        
        
            Statement stm = cnx.createStatement();
             ResultSet rst = stm.executeQuery(req);
            System.out.println("tri par username: ");

            while (rst.next()) {
                 e = new user();
                
              
                
                e.setId(rst.getInt("id"));
                e.setFirstname(rst.getString("username"));
                e.setFirstname(rst.getString("firstname"));
                e.setLastname(rst.getString("lastname"));
                e.setEmail(rst.getString("email"));
                e.setBirthdate(rst.getString("birthdate"));
                e.setSexe (rst.getString("sexe"));
                e.setBiography(rst.getString("biography"));
                user per = new user(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7),rst.getString(8));
                off.add(per);
            }
            
        
        return off;
    }
       
       

    
}
