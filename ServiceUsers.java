/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.TrayIconDemo;
import Entity.Users;
import Entity.webcam;
import Interfaces.IServiceUsers;
import Entity.javamail;
import java.awt.AWTException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import utils.MaConnection;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.objects.NativeRegExp;


/**
 *
 * @author Siwar
 */
public class ServiceUsers implements IServiceUsers {

    private Connection cnx;
    private Statement st;
    private PreparedStatement pst;
    private PreparedStatement pst1;
    private ResultSet rs;

    public ServiceUsers() {
        cnx = MaConnection.getInstance().getConnection();
        

    }
 

    @Override
    public void addUsers(Users u) throws SQLException{
        if (verifexistance(u.getEmail(), u.getUsername()) == 0) {
            try {
                {
                    String[] args = null;

                    javamail.main(args);
                    String req = "insert into users (firstname,lastname,email,password,role,birthdate,username,photo,rating,datecreation,biography,strike,etatcnt) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
                      String x= encrypt(u.getPassword(),u);
                      System.out.println(x);
                    pst1 = cnx.prepareStatement(req);
                    pst1.setString(1, u.getFirstname()); //1ere pt d'interrogation 
                    pst1.setString(2, u.getLastname());
                    pst1.setString(3, u.getEmail());
                    pst1.setString(4, x);
                    pst1.setInt(5, u.getRole());
                    pst1.setString(6, u.getBirthdate());
                    pst1.setString(7, u.getUsername());
                    pst1.setString(8, u.getPhoto());
                    pst1.setInt(9, u.getRating());
                    pst1.setString(10, u.getDatecreation());
                    pst1.setString(11, u.getBiography());
                    pst1.setInt(12, u.getStrike());
                    pst1.setInt(13, 0);

                }

                pst1.executeUpdate();
                System.out.println("ajout aves succes");
                                  
            

            } catch (SQLException ex) {
                Logger.getLogger(ServiceUsers.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(ServiceUsers.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("utulisateur existe deja");
             String[] args = null;

            try {
                javamail.main(args);
            } catch (Exception ex) {
                Logger.getLogger(ServiceUsers.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

    }

    public int verifexistance(String email, String username) {
        int i = 0;
        String maila = "'" + email + "'";
        String usernamea = "'" + username + "'";
        String req = "select  *  from users where email =" + maila + "or username =" + usernamea;
        try {
            st = cnx.createStatement();
            rs = st.executeQuery(req);

            while (rs.next()) {

                i = i + 1;

            }

        } catch (SQLException ex) {
            Logger.getLogger(ServiceUsers.class.getName()).log(Level.SEVERE, null, ex);
        }

        return i;

    }

    public int verifexistance2(int id, String email, String username) {
        int i = 0;

        String emaila = "'" + email + "'";
        String usernamea = "'" + username + "'";
        String req = "select  *  from users where email =" + emaila + " and username = " + usernamea + " and id !=" + id;
        try {
            st = cnx.createStatement();
            rs = st.executeQuery(req);

            while (rs.next()) {

                i = i + 1;

            }

        } catch (SQLException ex) {
            Logger.getLogger(ServiceUsers.class.getName()).log(Level.SEVERE, null, ex);
        }

        return i;

    }

    @Override
    public List<Users> getUsers() throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "select * from `users`";
        ResultSet rst = stm.executeQuery(query);
        List<Users> users = new ArrayList<>();
        while (rst.next()) {
            Users p2 = new Users();
            p2.setId(rst.getInt("id"));
            p2.setRating(rst.getInt("rating"));
            p2.setFirstname(rst.getString(2));

            users.add(p2);
        }
        return users;
    }

    @Override
    public void displayUsers() throws SQLException {

        String req = "select * from users ";
        try {
           /* String[] args = null;
            Webcamtest.main(args);*/
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);

            while (rs.next()) //  list.add(new Talentueux(rs.getString("Talent"),rs.getInt("NumTel"), rs.getString("Email"), rs.getString("DateNaissance")); //soit le nom de la colonne soit l'indice
            {
                System.out.println("Id : " + rs.getInt("id") + "  First Name :" + rs.getString("firstname") + "  Last Name :" + 
                        rs.getString("lastname") + "  Email :" + rs.getString("email")
                        +"  Role :"+rs.getInt("role")+"  Birthdate :"+rs.getString("birthdate")+"  Username :"+rs.getString("username")+"  Photo :"+rs.getString("photo")+
                        "  Rating :"+rs.getString("rating")+"  Datecreation :"+rs.getString("datecreation")+"  Biography :"+rs.getString("biography"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServiceUsers.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    }

    @Override
    public void getById(int id) throws SQLException {
        String req = "select * from users where id=  " + id;
        try {
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);

            while (rs.next()) //  list.add(new Talentueux(rs.getString("Talent"),rs.getInt("NumTel"), rs.getString("Email"), rs.getString("DateNaissance")); //soit le nom de la colonne soit l'indice
            {
                System.out.println("Bienvenue: " + " le nom est :" + rs.getString("firstname") + " le prenom " + rs.getString("lastname"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServiceUsers.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @Override
    public int recuperid(String username,String password) throws SQLException{
        
        String usernamee = "'" + username + "'";
        String passwordd = "'" + password + "'";
         String req = "select id from users where username=" + usernamee + " and password = " + passwordd;
         try {
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);

            while (rs.next()) 
            {
                
                return rs.getInt("id");
                
            }

        } catch (SQLException ex) {
             System.out.println("erreur recuperation did");
        }
         return 0;
        
    }

    @Override
    public void deleteUsers(int id) throws SQLException {
        String req = "delete from users where id=" + id;
        try {
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
            System.out.println("lutulistaeur a ete supprimre");
                    String[] args1 = null;

                    TrayIconDemo.main(args1);

        } catch (SQLException ex) {
            Logger.getLogger(ServiceUsers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AWTException ex) {
            Logger.getLogger(ServiceUsers.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void updateUsers(int id, String email, String username ,String firstname,String lastname,String password,int role,String birthdate,String photo,String biography) throws SQLException {

        if (verifexistance2(id, email, username) == 0) {

            try {

                String query = "update users set username='" + username +  "',firstname='" + firstname + "',lastname='" + lastname + "',email='" + email +
                        "',password='" + password +"',role='" + role +  "',birthdate='" + birthdate + "',photo='" + photo  +  "',biography='" + biography +
                        "' where id=" + id;

                st = cnx.createStatement();

                st.executeUpdate(query);
                System.out.println("bien modifiée");

            } catch (SQLException ex) {

            }

        }

    }

    @Override
    public void rechercherUtilisateurparUsername(String username) {
        String usernamee = "'" + username + "'";
        String req = "select * from users where username =" + usernamee;
        try {
            st = cnx.createStatement();
            rs = st.executeQuery(req);

            while (rs.next()) {
                System.out.println("rechecrhe par username");
                System.out.println("le nom  est: " + rs.getString("firstname") + " ,l'email est: " + rs.getString("email"));

            }

        } catch (SQLException ex) {
            System.out.println("Il nexiste aucun utulisateur avec ce username");
        }
    }

   

    @Override
    public void deleteUsers(Users u) throws SQLException {

    }

    public int login(String username, String password) {
        String usernamee = "'" + username + "'";
        String passwordd = "'" + password + "'";

        String req = "select * from users where username =" + usernamee + " and password =" + passwordd;
        try {
            st = cnx.createStatement();
            rs = st.executeQuery(req);

            while (rs.next()) {

                return rs.getInt("role");

            }

        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 2;
    }

    public void afficherlogin(String username, String password) {
        int i = login(username, password);
        if (i == 2) {
            System.out.println("mot de passe ou username incorect");
        }
        if (i == 0) {
            System.out.println("bienvenue user " + username);
             try {

                String query = "update users set etatcnt=1 where id="+recuperid(username,password);

                st = cnx.createStatement();

                st.executeUpdate(query);
                

            } catch (SQLException ex) {

            }
        }
        if (i == 1) {
            System.out.println("bienvue admin " + username);
            try {

                String query = "update users set etatcnt=1 where id ="+recuperid(username,password);

                st = cnx.createStatement();

                st.executeUpdate(query);
                

            } catch (SQLException ex) {

            }

        }
         
    }
    @Override
        public void logout (String username,String password)
    {
         try {

                String query = "update users set etatcnt=0 where id="+recuperid(username,password);

                st = cnx.createStatement();

                st.executeUpdate(query);
                System.out.println("logout de lutisateur: "+username);
                

            } catch (SQLException ex) {

            }
        
        
    }

    @Override
    public void rechercherUtilisateurparcaractere(String caractere) 
    {

        String req = "select * from users where firstname  LIKE '%" + caractere + "%'";
        try {
            st = cnx.createStatement();
            rs = st.executeQuery(req);

            while (rs.next()) {
                System.out.println("le nom que vous rechercher: " + rs.getString("firstname"));

            }

        } catch (SQLException ex) {
            System.out.println("erreur recherche");
        }
    }
    
    @Override
    public void filtre(String caractere) {

        
       String req = "  SELECT * FROM users WHERE firstname  like '"+ "%"+caractere+"%"+"' or lastname like '"+ "%"+caractere+"%"+"'" +"or username like '"+ "%"+caractere+"%"+"' or password like '"+"%"+caractere+"% '" +"ORDER BY id DESC " ;
        try {
            st = cnx.createStatement();
            rs = st.executeQuery(req);
            System.out.println("filtre par id desc: ");

            while (rs.next()) {
                
                System.out.println("Id : " + rs.getInt("id") + "  First Name :" + rs.getString("firstname") + "  Last Name :" + 
                        rs.getString("lastname") + "  Email :" + rs.getString("email")
                        +"  Username :"+rs.getString("username"));
            

            }

        } catch (SQLException ex) {
            System.out.println("erreur tri");
        }
    }
    
    @Override
    public void trier() {

        String req = "select * from users ORDER BY username";
        try {
            st = cnx.createStatement();
            rs = st.executeQuery(req);
            System.out.println("tri par username: ");

            while (rs.next()) {
                System.out.println("Username :"+rs.getString("username")+ "  First Name :" + rs.getString("firstname") + "  Last Name :" + 
                        rs.getString("lastname") + "  Email :" + rs.getString("email"));

            }

        } catch (SQLException ex) {
            System.out.println("erreur tri");
        }
    }
    public String encrypt(String password,Users u ){
        String passwordToHash = u.getPassword();
         String generatedPassword = null;
          try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(passwordToHash.getBytes());
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
        System.out.println(generatedPassword);
        return generatedPassword;
        
        
    }
   


}
