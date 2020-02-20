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

public class competitionuser {
    int idcomp;
    int idu;

   


    public int getIdcomp() {
        return idcomp;
    }

    public void setIdcomp(int idcomp) {
        this.idcomp = idcomp;
    }

    public int getIdu() {
        return idu;
    }

    public void setIdu(int idu) {
        this.idu = idu;
    }

   

    @Override
    public String toString() {
        return "competitionuser{" + "idcomp=" + idcomp + ", idu=" + idu +'}';
    }

    public competitionuser(int idcomp, int idu) {
        this.idcomp = idcomp;
        this.idu = idu;
       
    }
    
}


