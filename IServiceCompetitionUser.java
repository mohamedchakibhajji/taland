/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entity.competitionuser;

/**
 *
 * @author Chekib
 */
public interface IServiceCompetitionUser {
    
     public void reserverplacespec(competitionuser c);
     public void reserverplace(competitionuser c) throws Exception;
     public int dejaparticipe(int idcomp,int idu);
     public void supprimerparticipation(int idcomp , int id) ;
     public void supprimerparticipationspec(int idcomp , int id) ;
    
     
      
}
