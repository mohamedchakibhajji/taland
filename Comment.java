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
public class Comment {
    private int idComment;
    private int idPost;
    private int idU;
    private String contenu;
    private Date dateCreation;
    private int etat;

    public Comment() {
    }

    public Comment(int idComment, int idPost, int idU, String contenu, Date dateCreation) {
        this.idComment = idComment;
        this.idPost = idPost;
        this.idU = idU;
        this.contenu = contenu;
        this.dateCreation = dateCreation;
        this.etat=0;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
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

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public String toString() {
        return "Comment{" + "idComment=" + idComment + ", idPost=" + idPost + ", idU=" + idU + ", contenu=" + contenu + ", dateCreation=" + dateCreation + '}';
    }

}
