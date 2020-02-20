/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entity.competition;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Chekib
 */
      public interface IServiceCompetition {
      public void ajoutercompetition(competition c);
      public List <competition> affichercompetition();
   
      public void supprimercompetition(int id) ;
      public void modifiercompetition(int idcomp,String namecomp,String desccomp,int nbrmaxspec,int nbrmaxpar,String location,String startingdate,String endingdate,Float pricecomp,int idcat,int etat) throws SQLException;
      public  List<competition> recherchercompetition(String namecomp);
      public int nameexiste(String namecomp );
      public int nameexiste2(String namecomp , int id);
      public List<competition> trierparstartdate() ;
      public List<competition> trierparenddate() ;
      public List<competition> filtrerparplacevide()  ;
      public List<competition> filtrerparplacespecvide()  ;
      public void statcompetition();
      public List<competition> filtrerCompetitionParNbrMAx(int nbr) ;
      public int nombrecompetitienattente( );
      public int nombrecompetitionapprouve( );
      public List<competition> getcompetition(int id );
      
}
