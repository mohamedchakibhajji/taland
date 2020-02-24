/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Chekib
 */
public class competition {
    int idcomp;
    String namecomp;
    String desccomp;
    int nbrmaxspec;
    int nbrmaxpar;
    String location;
    String startingdate;
    String endingdate;
    float pricecomp;
    int idcat;
    int etat ; 
    int nbrspec;
    int nbrparticipant;
    String photo;
    int idU;

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public competition(int idcomp, String namecomp, String desccomp, int nbrmaxspec, int nbrmaxpar, String location, String startingdate, String endingdate, float pricecomp, int idcat, int etat, int nbrspec, int nbrparticipant, String photo,int idU) {
        this.idcomp = idcomp;
        this.namecomp = namecomp;
        this.desccomp = desccomp;
        this.nbrmaxspec = nbrmaxspec;
        this.nbrmaxpar = nbrmaxpar;
        this.location = location;
        this.startingdate = startingdate;
        this.endingdate = endingdate;
        this.pricecomp = pricecomp;
        this.idcat = idcat;
        this.etat = etat;
        this.nbrspec = nbrspec;
        this.nbrparticipant = nbrparticipant;
        this.photo = photo;
        this.idU=idU;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
  

    public void setNbrspec(int nbrspec) {
        this.nbrspec = nbrspec;
    }

    public void setNbrparticipant(int nbrparticipant) {
        this.nbrparticipant = nbrparticipant;
    }

    public int getNbrspec() {
        return nbrspec;
    }

    public int getNbrparticipant() {
        return nbrparticipant;
    }

    public int getIdcomp() {
        return idcomp;
    }

    public void setIdcomp(int idcomp) {
        this.idcomp = idcomp;
    }

    public String getNamecomp() {
        return namecomp;
    }

    public void setNamecomp(String namecomp) {
        this.namecomp = namecomp;
    }

    public String getDesccomp() {
        return desccomp;
    }

    public void setDesccomp(String desccomp) {
        this.desccomp = desccomp;
    }

    public int getNbrmaxspec() {
        return nbrmaxspec;
    }

    public void setNbrmaxspec(int nbrmaxspec) {
        this.nbrmaxspec = nbrmaxspec;
    }

    public int getNbrmaxpar() {
        return nbrmaxpar;
    }

    public void setNbrmaxpar(int nbrmaxpar) {
        this.nbrmaxpar = nbrmaxpar;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStartingdate() {
        return startingdate;
    }

    public void setStartingdate(String startingdate) {
        this.startingdate = startingdate;
    }

    public String getEndingdate() {
        return endingdate;
    }

    public void setEndingdate(String endingdate) {
        this.endingdate = endingdate;
    }

    public float getPricecomp() {
        return pricecomp;
    }

    public void setPricecomp(float pricecomp) {
        this.pricecomp = pricecomp;
    }

    public int getIdcat() {
        return idcat;
    }

    public void setIdcat(int idcat) {
        this.idcat = idcat;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "competition{" + "idcomp=" + idcomp + ", namecomp=" + namecomp + ", desccomp=" + desccomp + ", nbrmaxspec=" + nbrmaxspec + ", nbrmaxpar=" + nbrmaxpar + ", location=" + location + ", startingdate=" + startingdate + ", endingdate=" + endingdate + ", pricecomp=" + pricecomp + ", idcat=" + idcat + ", etat=" + etat + ", nbrspec=" + nbrspec + ", nbrparticipant=" + nbrparticipant + ", photo=" + photo+  '}';
    }

   

    public competition(String namecomp, String desccomp, int nbrmaxspec, int nbrmaxpar, String location, String startingdate, String endingdate, float pricecomp, int idcat, int etat,String photo,int idU) {
        this.namecomp = namecomp;
        this.desccomp = desccomp;
        this.nbrmaxspec = nbrmaxspec;
        this.nbrmaxpar = nbrmaxpar;
        this.location = location;
        this.startingdate = startingdate;
        this.endingdate = endingdate;
        this.pricecomp = pricecomp;
        this.idcat = idcat;
        this.etat = etat;
        this.photo=photo;
        this.idU=idU;
    }

    public competition(String namecomp) {
        this.namecomp = namecomp;
    }

 

    public competition(String namecomp, String desccomp, int nbrmaxspec, String location, String startingdate, String endingdate, float pricecomp, int idcat, int etat,String photo,int idU) {
        this.namecomp = namecomp;
        this.desccomp = desccomp;
        this.nbrmaxspec = nbrmaxspec;
        this.location = location;
        this.startingdate = startingdate;
        this.endingdate = endingdate;
        this.pricecomp = pricecomp;
        this.idcat = idcat;
        this.etat = etat;
        this.photo=photo;
        this.idU=idU;
    }
     public competition(String namecomp, String desccomp, int nbrmaxpar,int nbrmaxspec, String location, String startingdate, String endingdate, float pricecomp, int idcat) {
        this.namecomp = namecomp;
        this.desccomp = desccomp;
        this.nbrmaxspec = nbrmaxspec;
        this.nbrmaxpar=nbrmaxpar;
        this.location = location;
        this.startingdate = startingdate;
        this.endingdate = endingdate;
        this.pricecomp = pricecomp;
        this.idcat = idcat;
 
    }
    
    public competition(int  idcomp,String namecomp, String desccomp, int nbrmaxspec,int nbrmaxpar, String location, String startingdate, String endingdate, float pricecomp, int idcat, int etat,String photo,int idU) {
        this.idcomp = idcomp;
        this.namecomp = namecomp;
        this.desccomp = desccomp;
        this.nbrmaxspec = nbrmaxspec;
         this.nbrmaxpar = nbrmaxpar;
        this.location = location;
        this.startingdate = startingdate;
        this.endingdate = endingdate;
        this.pricecomp = pricecomp;
        this.idcat = idcat;
        this.etat = etat;
        this.photo = photo ;
        this.idU=idU;
    }

    
}
