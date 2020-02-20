/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

import java.sql.SQLException;
import java.util.List;
import Entity.Post;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author ASUS_ROG
 */
public interface IServicePost {
    
    public void addPost(Post p) throws SQLException;

    public List<Post> getPosts() throws SQLException;
    
    public List<Post> TrierPosts() throws SQLException;

    public Post getById(int id) throws SQLException;

    public void deletePost(Post p) throws SQLException;

    public void deletePost(int id) throws SQLException;

    public void updatePost(Post p) throws SQLException; 

    public List<Post> getUserPosts(int id) throws SQLException;
    
    public void SearchPostsAdvanced(String character) ;
    
}
