/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import Entity.Users;
import Interfaces.IServiceUsers;
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
public class ServiceUsers implements IServiceUsers{
    private Connection cnx;
    private Statement st;
    private PreparedStatement pst;
     private PreparedStatement pst1;
    private ResultSet rs;
    public ServiceUsers()
  {
      cnx=MaConnection.getInstance().getConnection();
      
  }
     @Override
    public void addUsers(Users u )  {
        if( verifexistance( u.getEmail(),u.getUsername()) == 0 )
        {        
        try {    
    {   
       
       
        String req="insert into users (firstname,lastname,email,password,role,birthdate,username,photo,rating,datecreation,biography,strike) values(?,?,?,?,?,?,?,?,?,?,?,?)";
     
            pst1=cnx.prepareStatement(req);
            pst1.setString(1, u.getFirstname()); //1ere pt d'interrogation 
            pst1.setString(2,u.getLastname());
            pst1.setString(3, u.getEmail());
            pst1.setString(4, u.getPassword());
            pst1.setInt(5, u.getRole());
            pst1.setString(6, u.getBirthdate());
            pst1.setString(7, u.getUsername()); 
            pst1.setString(8, u.getPhoto()); 
            pst1.setInt(9, u.getRating()); 
            pst1.setString(10, u.getDatecreation()); 
            pst1.setString(11, u.getBiography()); 
            pst1.setInt(12, u.getStrike()); 
            
      
  } 
          
       
           pst1.executeUpdate();
        } catch (SQLException ex) {
            
        }
        }
        else 
            System.out.println("utulisateur existe deja");
        
        
    }

     public int verifexistance(String email,String username)
     {
          int i=0; 
         String maila = "'"+email+"'";
         String usernamea = "'"+username+"'";
         String req="select  *  from users where email ="+maila+"or username ="+usernamea;
       try {
            st=cnx.createStatement();
            rs=st.executeQuery(req);
       
     while(rs.next())
    { 
               
       i=i+1;
        
    }
  
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return i;
         
     }
     
     public int verifexistance2(int id,String email,String username)
     {
          int i=0; 

          String emaila="'"+email+"'";
           String usernamea="'"+username+"'";
         String req="select  *  from users where email ="+emaila+" and username = "+usernamea+" and id !="+id;
       try {
            st=cnx.createStatement();
            rs=st.executeQuery(req);
       
     while(rs.next())
    { 
               
       i=i+1;
        
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
     public void displayUsers() throws SQLException{
     
       String req="select * from users ";
        try {
            Statement stm = cnx.createStatement();
            ResultSet rs=stm.executeQuery(req);
       
     while(rs.next())
     //  list.add(new Talentueux(rs.getString("Talent"),rs.getInt("NumTel"), rs.getString("Email"), rs.getString("DateNaissance")); //soit le nom de la colonne soit l'indice
       
       System.out.println("lid est: "+rs.getInt("id") +" le nom est :"+rs.getString("firstname")+ " le prenom " +  rs.getString("lastname")+"email"+rs.getString("email") );
 
      
  
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @Override
    public Users getById(int id) throws SQLException {
       String req="select * from users where id=  "+id;
        
            Statement stm = cnx.createStatement();
            ResultSet rs=stm.executeQuery(req); 
            Users result = new Users();
        while(rs.next()){
            
            result.setId(rs.getInt("id"));
            result.setFirstname(rs.getString("firstname"));
            result.setLastname(rs.getString("lastname"));
            result.setEmail(rs.getString("email"));            
            result.setPassword(rs.getString("password"));
            result.setRole(rs.getInt("role"));  
            result.setBirthdate(rs.getString("birthdate"));  
            result.setUsername(rs.getString("username"));  
            result.setPhoto(rs.getString("photo"));  
            result.setRating(rs.getInt("rating"));  
            result.setDatecreation(rs.getString("datecreation"));  
            result.setBiography(rs.getString("biography"));  
            result.setStrike(rs.getInt("strike"));  
            
        }
     //  list.add(new Talentueux(rs.getString("Talent"),rs.getInt("NumTel"), rs.getString("Email"), rs.getString("DateNaissance")); //soit le nom de la colonne soit l'indice
        return result;
    }


    @Override
    public void deleteUsers(int id) throws SQLException {
        String req="delete from users where id="+id;
        try {
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
       System.out.println("lutulistaeur a ete supprimre");
     
       
 
      
  
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void updateUsers(int id,String email,String username) throws SQLException {
       
       
        if ( verifexistance2(id,email,username) == 0)
        {
                                                                                                                                        
        try {  
            
             String query="update users set username='"+username+"',email='"+email+"' where id="+id;
             
        st=cnx.createStatement();
        
            
           st.executeUpdate(query);
               System.out.println("bien modifiée");
            
             
            }
        catch (SQLException ex) {
        
            
        }
           
       
}

    }

   
    @Override
        public void rechercherUtilisateurparUsername(String username) 
    {
        String usernamee = "'"+username+"'";
           String req="select * from users where username ="+usernamee;
        try {
            st=cnx.createStatement();
            rs=st.executeQuery(req);
       
     while(rs.next())
         
   
       
    { 
        System.out.println("rechecrhe par username");
        System.out.println("le nom  est: "+rs.getString("firstname") + " ,l'email est: " +  rs.getString("email"));
 
    }

  
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
}

           @Override
        public void rechercherUtilisateurparcaractere(String caractere) 
    {
        
           String req="select * from users where firstname  LIKE '"+caractere+"%'" ;
        try {
            st=cnx.createStatement();
            rs=st.executeQuery(req);
            
       
     while(rs.next())
         
   
       
    { 
        System.out.println("le nom que vous rechercher: "+rs.getString("firstname") );
 
    }

  
        } catch (SQLException ex) {
            System.out.println("erreur recherche");
        }
}

    @Override
    public void deleteUsers(Users u) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int login(String username,String password  ){
      String usernamee = "'"+username+"'";
      String passwordd = "'"+password+"'";
      
           String req="select * from users where username ="+usernamee+" and password ="+passwordd ;
        try {
            st=cnx.createStatement();
            rs=st.executeQuery(req);
       
     while(rs.next())
         
   
       
    { 
        
        
        return rs.getInt("role");
 
    }

  
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 2;
    }
    
    public void afficherlogin(String username,String password)
    {
        int i=login(username, password);
        if (i==2)
        {
            System.out.println("mot de passe ou username incorect");
        }
        if (i==0)
        {
            System.out.println("bienvenue user " + username);
        }
        if (i==1)
        {
            System.out.println("bienvue admin "+username);
        }
        
        
    }

    
    

     
     
     
     
    @Override
        public void trier() 
    {
        
           String req="select * from users ORDER BY username" ;
        try {
            st=cnx.createStatement();
            rs=st.executeQuery(req);
            System.out.println("tri par username: ");
       
     while(rs.next())
         
   
       
    { 
        System.out.println(rs.getString("username") );
 
    }

  
        } catch (SQLException ex) {
            System.out.println("erreur tri");
        }
}
  
     
     
     
     
     
     
     
     
     
     
}
