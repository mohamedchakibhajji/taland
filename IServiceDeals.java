/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entity.Deals;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author acer
 */
public interface IServiceDeals {
    public void addDeals(Deals d) throws SQLException;
    public void displayDeals() throws SQLException;

    public List<Deals> getDeals() throws SQLException;

    public void getById(int id) throws SQLException;
    
    public int price(int iddeal) throws SQLException;

    public void deleteDeals(Deals d) throws SQLException;

    public void deleteDeals(int id) throws SQLException;

    public void updateDeals(int id,int duree) throws SQLException;
    
    public void trier();
    
    public void rechercherDeal(String caractere) ;

}
