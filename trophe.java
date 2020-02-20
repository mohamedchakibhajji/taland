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
public class trophe {
    private int idcomp;
    private int idu;

    public int getIdcomp() {
        return idcomp;
    }

    public trophe(int idcomp, int idu) {
        this.idcomp = idcomp;
        this.idu = idu;
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
        return "trophe{" + "idcomp=" + idcomp + ", idu=" + idu + '}';
    }
    
}
