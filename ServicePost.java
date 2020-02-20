/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import Interfaces.IServicePost;
import Entity.Post;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MaConnection;

/**
 *
 * @author ASUS_ROG
 */
public class ServicePost implements IServicePost {
    Connection cnx;

    public ServicePost() {
        cnx = MaConnection.getInstance().getConnection();
    }
 
    @Override
    public void addPost(Post p) throws SQLException {
         Statement stm = cnx.createStatement();
        String query = "INSERT INTO `posts` (`idPost`, `idU`, `description`, `source`, `nbrlikes`, `nbrcomments`)"
                + "     VALUES (NULL, '"+p.getIdU()+"', '"+p.getDescription()+"', '"+p.getSource()+"', '0', '0')";
        stm.executeUpdate(query);      
    }

    @Override
    public List<Post> getPosts() throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "select * from `posts`";
        ResultSet rst = stm.executeQuery(query);
        List<Post> posts = new ArrayList<>();
        while (rst.next()) {
            Post p2 = new Post();
            p2.setIdPost(rst.getInt("idPost"));
            p2.setIdU(rst.getInt("idU"));
            p2.setDescription(rst.getString("description"));
            p2.setSource(rst.getString("source"));            
            p2.setNbrlikes(rst.getInt("nbrlikes"));
            p2.setNbrcomments(rst.getInt("nbrcomments"));
            posts.add(p2);
        }
     return posts;
    }

    @Override
    public Post getById(int id) throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "select * from `posts` where idPost= '"+id+"'";
        ResultSet rst = stm.executeQuery(query);
        
        Post result = new Post();
        
        while (rst.next()) {
            
            result.setIdPost(rst.getInt("idPost"));
            result.setIdU(rst.getInt("idU"));
            result.setDescription(rst.getString("description"));
            result.setSource(rst.getString("source"));            
            result.setNbrlikes(rst.getInt("nbrlikes"));
            result.setNbrcomments(rst.getInt("nbrcomments"));
            
        }
     return result;
    }

    @Override
    public void deletePost(Post p) throws SQLException {
         Statement stm = cnx.createStatement();
        String query = "DELETE FROM posts where idPost= '"+p.getIdPost()+"'";
        stm.executeUpdate(query);    
    }

    @Override
    public void deletePost(int id) throws SQLException {
         Statement stm = cnx.createStatement();
        String query = "DELETE FROM posts where idPost= '"+id+"'";
        stm.executeUpdate(query);          
    }

    @Override
    public void updatePost(Post p) throws SQLException {
         Statement stm = cnx.createStatement();
        String query = "UPDATE posts SET description= '"+p.getDescription()+"', source= '"+p.getSource()+"' WHERE idPost='"+p.getIdPost()+"'";
        stm.executeUpdate(query); 
    }

    
    @Override
    public List<Post> TrierPosts() throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "select * from `posts` ORDER BY nbrlikes DESC";
        ResultSet rst = stm.executeQuery(query);
        List<Post> posts = new ArrayList<>();
        while (rst.next()) {
            Post p2 = new Post();
            p2.setIdPost(rst.getInt("idPost"));
            p2.setIdU(rst.getInt("idU"));
            p2.setDescription(rst.getString("description"));
            p2.setSource(rst.getString("source"));            
            p2.setNbrlikes(rst.getInt("nbrlikes"));
            p2.setNbrcomments(rst.getInt("nbrcomments"));
            posts.add(p2);
        }
     return posts;
    }
    
    @Override
    public List<Post> getUserPosts(int id) throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "select * from `posts` where idU= '"+id+"'";
        ResultSet rst = stm.executeQuery(query);
        List<Post> posts = new ArrayList<>();
        while (rst.next()) {
            Post p2 = new Post();
            p2.setIdPost(rst.getInt("idPost"));
            p2.setIdU(rst.getInt("idU"));
            p2.setDescription(rst.getString("description"));
            p2.setSource(rst.getString("source"));            
            p2.setNbrlikes(rst.getInt("nbrlikes"));
            p2.setNbrcomments(rst.getInt("nbrcomments"));
            posts.add(p2);
        }
     return posts;
    }
    
           @Override
        public void SearchPostsAdvanced(String character) 
    {
        
           String req="select * from posts where description  LIKE '"+character+"%'" ;
        try {
            Statement stm=cnx.createStatement();
            ResultSet rst=stm.executeQuery(req);
            
       
     while(rst.next()) 
    { 
        System.out.println("Post : "+rst.getString("description")+"\tMedia :"+rst.getString("source")+"\tNombre de J'aime :"+rst.getInt("nbrlikes") );
    }
        } catch (SQLException ex) {
            System.out.println("No Posts");
        }
}

    
}
