/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

import java.sql.SQLException;
import java.util.List;
import Entity.Comment;
import Entity.Post;
import Entity.user;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author ASUS_ROG
 */
public interface IServiceComment {
    
    public void addComment(Post p, user u,String comment) throws SQLException;

    public List<Comment> getPostComments(Post p) throws SQLException;
    
    public void displayPostComments(Post p) throws SQLException;

    public Comment getById(int id) throws SQLException;

    public void deleteComment(Comment c,Post p, user u) throws SQLException;

    public void deleteComment(int id,Post p, user u) throws SQLException;

    public void updateComment(Comment c,Post p,user u) throws SQLException; 
    
    public void SearchComments(String character,Post p)  throws SQLException;
    
    public List<Comment> SortCommentsPost(Post p)  throws SQLException;    
    
}

