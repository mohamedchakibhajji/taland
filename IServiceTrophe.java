/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entity.trophe;
import java.util.List;

/**
 *
 * @author Chekib
 */
public interface IServiceTrophe {
    public int tropheexiste(int idu,int idcomp);
    public void affectertrohpe(trophe t);
    public List<trophe> affichertrophe(int idu);
    public void supprimertrophe(int idcomp , int id) ;
     
     
}
