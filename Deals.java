/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author acer
 */
public class Deals {
    private int iddeal;
    private int idU;
    private int duree;
    private int idphoto;
    private int idvideo;
    private int nbrevue;
    private String description;
    private int priceperhour ;

    public int getPriceperhour() {
        return priceperhour;
    }

    public void setPriceperhour(int priceperhour) {
        this.priceperhour = priceperhour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIddeal() {
        return iddeal;
    }

    public int getIdU() {
        return idU;
    }

    public int getDuree() {
        return duree;
    }

    public int getIdphoto() {
        return idphoto;
    }

    public int getIdvideo() {
        return idvideo;
    }

    public int getNbrevue() {
        return nbrevue;
    }

    public void setIddeal(int iddeal) {
        this.iddeal = iddeal;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setIdphoto(int idphoto) {
        this.idphoto = idphoto;
    }

    public void setIdvideo(int idvideo) {
        this.idvideo = idvideo;
    }

    public void setNbrevue(int nbrevue) {
        this.nbrevue = nbrevue;
    }

    public Deals(int iddeal, int idU, int duree, int idphoto, int idvideo, int nbrevue, String description, int priceperhour) {
        this.iddeal = iddeal;
        this.idU = idU;
        this.duree = duree;
        this.idphoto = idphoto;
        this.idvideo = idvideo;
        this.nbrevue = nbrevue;
        this.description = description;
        this.priceperhour = priceperhour;
    }

    public Deals() {
        nbrevue=0;
    }

    @Override
    public String toString() {
        return "Deals{" + "iddeal=" + iddeal + ", idU=" + idU + ", duree=" + duree + ", idphoto=" + idphoto + ", idvideo=" + idvideo + ", nbrevue=" + nbrevue + ", description=" + description + ", priceperhour=" + priceperhour + '}';
    }



    
    
    
}
