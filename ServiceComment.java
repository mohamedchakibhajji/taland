/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Comment;
import Entity.Event;
import Entity.Post;
import Entity.user;
import Interfaces.IServiceComment;
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
public class ServiceComment implements IServiceComment {
    Connection cnx;
    Services.ServiceUser SU = new ServiceUser(); 
    Services.ServicePost SP = new ServicePost();  
    
    public ServiceComment() {
        cnx = MaConnection.getInstance().getConnection();
    }
    @Override
    public void addComment(Post p, user u,String comment) throws SQLException {
         Statement stm = cnx.createStatement();
        String query = "INSERT INTO `comments` (`idComment`, `idPost`, `idU`, `contenu`)"
                + "     VALUES (NULL, '"+p.getIdPost()+"', '"+u.getId()+"', '"+comment+"')";
        stm.executeUpdate(query);
    }

    @Override
    public List<Comment> getPostComments(Post p) throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "select * from `comments` where idPost ='"+p.getIdPost()+"'";
        ResultSet rst = stm.executeQuery(query);
        
        List<Comment> comments = new ArrayList<>();
        
        while (rst.next()) {
            
            Comment c2 = new Comment();
            
            c2.setIdComment(rst.getInt("idComment"));
            c2.setIdU(rst.getInt("idU"));
            c2.setContenu(rst.getString("contenu"));

            comments.add(c2);
        }
     return comments;        
    }

     @Override
    public void displayPostComments(Post p) throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "select * from `comments` where idPost ='"+p.getIdPost()+"'";
        ResultSet rst = stm.executeQuery(query);
        
        List<Comment> comments = new ArrayList<>();
        
        while (rst.next()) {
            
            Comment c2 = new Comment();
            
            c2.setIdComment(rst.getInt("idComment"));
            c2.setIdU(rst.getInt("idU"));
            c2.setContenu(rst.getString("contenu"));

            comments.add(c2);
        }
        System.out.println(comments.size()+" comments");
        
        for (int i = 0; i < comments.size(); i++) {
            System.out.println(SU.getById(comments.get(i).getIdU()).getFirstname()+" "+
                               SU.getById(comments.get(i).getIdU()).getLastname()+
                               " replied to Your Post : "+comments.get(i).getContenu()
            );
        } 
    }

    @Override
    public Comment getById(int id) throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "select * from `comments` where idComment= '"+id+"'";
        ResultSet rst = stm.executeQuery(query);
        
        Comment result = new Comment();
        
        while (rst.next()) {
            
            result.setIdComment(rst.getInt("idComment"));
            result.setIdPost(rst.getInt("idPost"));
            result.setIdU(rst.getInt("idU"));
            result.setDateCreation(rst.getDate("dateCreation"));
            result.setContenu(rst.getString("contenu"));
            
        }
     return result;
    }

    @Override
    public void deleteComment(Comment c,Post p, user u) throws SQLException {
         Statement stm = cnx.createStatement();
        String query = "DELETE FROM comments where idComment= '"+c.getIdComment()+"' and idPost='"+p.getIdPost()+"' and idU= '"+u.getId()+"'";
        stm.executeUpdate(query);
        System.out.println("comment deleted");
    }

    @Override
    public void deleteComment(int id,Post p, user u) throws SQLException {
         Statement stm = cnx.createStatement();
        String query = "DELETE FROM comments where idComment= '"+id+"' and idPost='"+p.getIdPost()+"' and idU= '"+u.getId()+"'";
        stm.executeUpdate(query);
        System.out.println("comment deleted");
    }

    @Override
    public void updateComment(Comment c,Post p,user u) throws SQLException {
        
         Statement stm = cnx.createStatement();
        String query = "UPDATE comments SET contenu= '"+c.getContenu()+"', etat= '"+1+"' WHERE idComment='"+c.getIdComment()+"' and idPost='"+p.getIdPost()+"' and idU='"+u.getId()+"'";
        
        if (c.getIdU() == u.getId()) {
            stm.executeUpdate(query);         
            System.out.println("Event Updated !");
        }else{
            System.out.println("You are not allowed to update this comment");        
        }
       
    }


    @Override
    public void SearchComments(String character,Post p)  throws SQLException{
           String requete="select * from comments where idPost='"+p.getIdPost()+"' contenu LIKE '%"+character+"%'" ;

        try {
            Statement stm=cnx.createStatement();
            ResultSet rst=stm.executeQuery(requete);  

            List<Comment> comments = new ArrayList<>();
        while (rst.next()) {          
            Comment c2 = new Comment();          
            c2.setIdPost(rst.getInt("idPost"));                
            c2.setIdU(rst.getInt("idU"));                
            c2.setContenu(rst.getString("contenu"));                
            comments.add(c2);
        }
        for (int i = 0; i < comments.size(); i++) {
            System.out.println(SU.getById(comments.get(i).getIdU())+" commented :"+comments.get(i).getContenu());
        }
        } catch (SQLException ex) {
            System.out.println("No Event Available !");
        }   
    }

    @Override
    public List<Comment> SortCommentsPost(Post p)  throws SQLException{
       Statement stm = cnx.createStatement();
        String query = "select * from `comments` where idPost ='"+p.getIdPost()+"' ORDER BY dateCreation DESC";
        ResultSet rst = stm.executeQuery(query);
        
        List<Comment> comments = new ArrayList<>();
        
        while (rst.next()) {
            
            Comment c2 = new Comment();
            
            c2.setIdComment(rst.getInt("idComment"));
            c2.setIdU(rst.getInt("idU"));
            c2.setContenu(rst.getString("contenu"));

            comments.add(c2);
        }
     return comments;     
    }
    
}
