/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Like;
import Entity.Post;
import Entity.user;

import Interfaces.IServiceLike;
import Interfaces.IServicePost;
import Interfaces.IServiceUser;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import utils.MaConnection;



/**
 *
 * @author ASUS_ROG
 */
public class ServiceLike  implements IServiceLike {
    Connection cnx;
    Services.ServiceUser SU = new ServiceUser(); 
    Services.ServicePost SP = new ServicePost();    

    public ServiceLike() {
        cnx = MaConnection.getInstance().getConnection();
    }
    @Override
    public void addLike(Post p, user u) throws SQLException {
         Statement stm = cnx.createStatement();

        String queryverif = "SELECT COUNT(*) AS cmp FROM `likes` WHERE idU="+u.getId()+" AND idPost="+p.getIdPost()+"";   
        
        ResultSet result = stm.executeQuery(queryverif); 
        int cmp=0;
        while (result.next()) {           
            cmp=result.getInt("cmp");            
        }
        if (cmp==0) {
        String query = "INSERT INTO `likes` (`idLike`, `idPost`, `idU`)"
                + "     VALUES (NULL, '"+p.getIdPost()+"', '"+u.getId()+"')";
        stm.executeUpdate(query);
        System.out.println("Post liked");
        }else{
            System.out.println("Post liked already");
        }
        
    }

    @Override
    public List<Like> getPostLikes(Post p) throws SQLException {
     
        Statement stm = cnx.createStatement();
        String query = "select * from `likes` where idPost='"+p.getIdPost()+"'";
        ResultSet rst = stm.executeQuery(query);
        List<Like> likes = new ArrayList<>();
        while (rst.next()) {
            
            Like l2 = new Like();
            
            l2.setIdLike(rst.getInt("idLike"));
            l2.setIdPost(rst.getInt("idPost"));
            l2.setIdU(rst.getInt("idU"));
                
            likes.add(l2);
        }
        
        System.out.println(likes.size()+" Likes");
        
        return likes;
    }    
    
    @Override
    public void displayPostLikes(Post p) throws SQLException {
 
        
        Statement stm = cnx.createStatement();
        String query = "select * from `likes` where idPost='"+p.getIdPost()+"'";
        ResultSet rst = stm.executeQuery(query);
        List<Like> likes = new ArrayList<>();
        while (rst.next()) {
            
            Like l2 = new Like();
            
            l2.setIdLike(rst.getInt("idLike"));
            l2.setIdPost(rst.getInt("idPost"));
            l2.setIdU(rst.getInt("idU"));
                
            likes.add(l2);
        }
        
        System.out.println(likes.size()+" Likes");
        
        for (int i = 0; i < likes.size(); i++) {
            System.out.println(SU.getById(likes.get(i).getIdU()).getFirstname()+" "+
                               SU.getById(likes.get(i).getIdU()).getLastname()+
                               " Liked your Post : "+SP.getById(likes.get(i).getIdPost()).getDescription()
            );
        }        
    }

    @Override
    public void TrierPostLikesByDate(Post p) throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "select * from `likes` where idPost='"+p.getIdPost()+"' ORDER BY dateCreation DESC";
        ResultSet rst = stm.executeQuery(query);
        List<Like> likes = new ArrayList<>();
        while (rst.next()) {
            Like l2 = new Like();
            
            l2.setIdLike(rst.getInt("idLike"));
            l2.setIdPost(rst.getInt("idPost"));
            l2.setIdU(rst.getInt("idU"));
            l2.setDateCreation(rst.getDate("dateCreation"));
                
            likes.add(l2);
        }
        
        for (int i = 0; i < likes.size(); i++) {
            
        Timestamp Ctime = new Timestamp(System.currentTimeMillis());
        Date dbtime = likes.get(i).getDateCreation();
        
        String result=SubstractDate(Ctime,dbtime);
        
            System.out.println(SU.getById(likes.get(i).getIdU()).getFirstname()+" "+
                               SU.getById(likes.get(i).getIdU()).getLastname()+
                               " Liked your Post "+result+": "+SP.getById(likes.get(i).getIdPost()).getDescription()                           
            );
        } 
    }

    @Override
    public void deletePostLike(Post p, user u) throws SQLException {
         Statement stm = cnx.createStatement();
        String query = "DELETE FROM likes where idPost= '"+p.getIdPost()+"' and idU= '"+u.getId()+"'";
        stm.executeUpdate(query);
        System.out.println("Like deleted");
    }

    @Override
    public void deletePostLike(int id, user u) throws SQLException {
         Statement stm = cnx.createStatement();
        String query = "DELETE FROM likes where idPost= '"+id+"' and idU= '"+u.getId()+"'";
        stm.executeUpdate(query);
        System.out.println("Like deleted");
    }

    @Override
    public void displayUserLikedPosts(int id) throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "select * from `likes` where idU='"+id+"'";
        ResultSet rst = stm.executeQuery(query);
        List<Like> likes = new ArrayList<>();
        while (rst.next()) {          
            Like l2 = new Like();          
            l2.setIdPost(rst.getInt("idPost"));                
            likes.add(l2);
        }
        
        System.out.println(likes.size()+" Liked Post");
        
        for (int i = 0; i < likes.size(); i++) {
            System.out.println(SP.getById(likes.get(i).getIdPost()));
        }   
    }

    @Override
    public String SubstractDate(Timestamp current, Date Creation) {
      
        String today = current.toString();
        
        String dd = "";
        String mm = "";
        String yy = "";
        String hh = "";        
        String min = "";        
        String sec = "";  
        
            for (int j = 0; j < today.length(); j++) {
                if (j<=3) {
                   yy+=today.charAt(j);
                }else if (j<7 && j>4) {
                   mm+=today.charAt(j); 
                }else if (j<=9 && j>7) {
                   dd+=today.charAt(j);  
                }else if (j<=12 && j>10) {
                   hh+=today.charAt(j); 
                }else if (j<=15 && j>13) {
                   min+=today.charAt(j); 
                }else if (j<=18 && j>16) {
                   sec+=today.charAt(j); 
                }
            }
        
        int cdays = Integer.parseInt(dd);
        int cmois = Integer.parseInt(mm);
        int cannee = Integer.parseInt(yy);
        
             
        
        int bdays = Creation.getDate();        
        int bmois = (Creation.getMonth()+1);       
        int bannee = (Creation.getYear()+1900);
        
        int diff = (cdays - bdays) + (30 * (cmois - bmois)) + (360 * (cannee - bannee));
        String result="";
            if (diff==0) {
                result="Today";
            }else if (diff==1) {
                result="Yesterday";
            }else{
                result = (diff)+" days ago";
            }
            return result;
    }


}
