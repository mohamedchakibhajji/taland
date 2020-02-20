/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

/**
 *
 * @author ASUS_ROG
 */
public class Post {
    private int idPost;
    private int idU;
    private String description;
    private String source;
    private int nbrlikes;
    private int nbrcomments;
    
    
    public Post() {
    }    
    
    public Post(int idPost,int idU,String description,String source,int nbrlike,int nbrcomments) {
        this.idPost = idPost;
        this.idU = idU;
        this.description = description;
        this.source = source;
        this.nbrlikes = nbrlike;
        this.nbrcomments = nbrcomments;
    }       

    public Post(int idU,String description,String source) {
        this.idPost=0;
        this.idU = idU;
        this.description = description;
        this.source = source;
        this.nbrlikes = 0;
        this.nbrcomments = 0;
    }      
    
    public int getIdPost() {
        return idPost;
    }

    public int getIdU() {
        return idU;
    }

    public String getDescription() {
        return description;
    }

    public String getSource() {
        return source;
    }

    public int getNbrlikes() {
        return nbrlikes;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSource(String source) {
        this.source = source;
    }


    public void setNbrlikes(int nbrlikes) {
        this.nbrlikes = nbrlikes;
    }

    public int getNbrcomments() {
        return nbrcomments;
    }

    public void setNbrcomments(int nbrcomments) {
        this.nbrcomments = nbrcomments;
    }

    @Override
    public String toString() {
        return "Post{" + "idPost=" + idPost + ", idU=" + idU + ", description=" + description + ", source=" + source + ", nbrlikes=" + nbrlikes + ", nbrcomments=" + nbrcomments + '}';
    }
    

  
    
    
}
