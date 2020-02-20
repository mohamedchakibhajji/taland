/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;

/**
 *
 * @author ASUS_ROG
 */
public class Like {
    private int idLike;
    private int idPost;
    private int idU;
    private Date dateCreation;

    public Like() {
    }

    public Like(int idLike, int idPost, int id,Date dateCreation) {
        this.idLike = idLike;
        this.idPost = idPost;
        this.idU = id;
        this.dateCreation=dateCreation;
    }

    public int getIdLike() {
        return idLike;
    }

    public void setIdLike(int idLike) {
        this.idLike = idLike;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public String toString() {
        return "Like{" + "idLike=" + idLike + ", idPost=" + idPost + ", id=" + idU + '}';
    }
    
    
}
