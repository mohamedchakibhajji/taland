/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

import java.sql.SQLException;
import java.util.List;
import Entity.Like;
import Entity.Post;
import Entity.user;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author ASUS_ROG
 */
public interface IServiceLike {
    
    public void addLike(Post p,user u) throws SQLException;
    
    public List<Like> getPostLikes(Post p) throws SQLException;

    public void displayPostLikes(Post p) throws SQLException;
    
    public void TrierPostLikesByDate(Post p) throws SQLException;

    public void deletePostLike(Post p,user u) throws SQLException;

    public void deletePostLike(int id,user u) throws SQLException; 

    public void displayUserLikedPosts(int id) throws SQLException;
    
    public String SubstractDate(Timestamp current,Date Creation) ;
    
}
