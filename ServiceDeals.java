/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Deals;
import Interfaces.IServiceDeals;
import utils.MaConnection;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.objects.NativeRegExp;

/**
 *
 * @author acer
 */
public class ServiceDeals implements IServiceDeals{
    private Connection cnx;
    private Statement st;
    private PreparedStatement pst;
    private PreparedStatement pst1;
    private ResultSet rs;
    public ServiceDeals()
  {
      cnx=MaConnection.getInstance().getConnection();
      
  }
    
         @Override
    public void addDeals(Deals d )  {
     
        try {    
    {   
        String req="insert into deals (iddeal,idU,duree,idphoto,idvideo,nbrevue,description,priceperhour) values(?,?,?,?,?,?,?,?)";
     
            pst1=cnx.prepareStatement(req);
            pst1.setInt(1, d.getIddeal()); 
            pst1.setInt(2, d.getIdU()); 
            pst1.setInt(3, d.getDuree()); 
            pst1.setInt(4, d.getIdphoto()); 
            pst1.setInt(5, d.getIdvideo()); 
            pst1.setInt(6, d.getNbrevue()); 
            pst1.setString(7, d.getDescription()); 
            pst1.setInt(8, d.getPriceperhour()); 
            
            } 
          
       
           pst1.executeUpdate();
        } catch (SQLException ex) {
            
        }
        

    }
    
    
    
    
//-------------------------------------------------------------------------   
    
        @Override
    public List<Deals> getDeals() throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "select * from `deals`";
        ResultSet rst = stm.executeQuery(query);
        List<Deals> deals = new ArrayList<>();
        while (rst.next()) {
            Deals p2 = new Deals();
            p2.setIddeal(rst.getInt("iddeal"));
            p2.setIdU(rst.getInt("idU"));

            deals.add(p2);
        }
     return deals;
    }

    
    @Override
     public void displayDeals() throws SQLException{
     
       String req="select * from deals ";
        try {
            Statement stm = cnx.createStatement();
            ResultSet rs=stm.executeQuery(req);
       
     while(rs.next())

       System.out.println("l'id de deal est: "+rs.getInt("iddeal") +" l'id de user :"+rs.getInt("idU")+ " duree " +  rs.getInt("duree") );
 
      
  
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDeals.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
     
      public int nombredealssuperieura(int prix) throws SQLException{
       int i = 0 ;
         
         
       String req="select * from deals where priceperhour*duree >   " + prix;
        try {
            Statement stm = cnx.createStatement();
            ResultSet rs=stm.executeQuery(req);
       
     while(rs.next())

      i=i+1;
      
  
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDeals.class.getName()).log(Level.SEVERE, null, ex);
        }
       return i;
    }
      public int nombredealsinferieura(int prix) throws SQLException{
       int i = 0 ;
          

       String req="select * from deals where priceperhour*duree < " + prix;
        try {
            Statement stm = cnx.createStatement();
            ResultSet rs=stm.executeQuery(req);
       
     while(rs.next())

      i=i+1;
      
  
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDeals.class.getName()).log(Level.SEVERE, null, ex);
        }
       return i;
    }
     
     
     @Override
    public void getById(int iddeal) throws SQLException {
       String req="select * from deals where iddeal=  "+iddeal;
        try {
            Statement stm = cnx.createStatement();
            ResultSet rs=stm.executeQuery(req);
       System.out.println("eeeeeeeeeeeeee");
     while(rs.next())
       System.out.println("Deals: " +" le nom de deal est :"+rs.getInt("iddeal")+ " le prenom " +  rs.getInt("idU") );
 
      
  
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDeals.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    @Override
    public int price(int iddeal) throws SQLException {
        int price=-1;
       String req="select * from deals where iddeal=  "+iddeal;
        try {
            Statement stm = cnx.createStatement();
            ResultSet rs=stm.executeQuery(req);
       System.out.println("eeeeeeeeeeeeee");
     while(rs.next())
         price= rs.getInt("priceperhour")*rs.getInt("duree");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceDeals.class.getName()).log(Level.SEVERE, null, ex);
        }
        return price;
    }
    
    
        @Override
    public void deleteDeals(Deals d) throws SQLException {
        
    }
    
        @Override
    public void deleteDeals(int iddeal) throws SQLException {
        String req="delete from deals where iddeal="+iddeal;
        try {
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
       System.out.println("le deal a ete supprimre");
     
       
 
      
  
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDeals.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     @Override
    public void updateDeals(int iddeal,int duree) throws SQLException {
                                                                                                                                
        try {  
            
             String query="update deals set duree='"+duree+"' where iddeal="+iddeal;
             
        st=cnx.createStatement();
        
            
           st.executeUpdate(query);
               System.out.println("bien modifiée");
            
             
            }
        catch (SQLException ex) {
        
            
        }   

    }

    
    @Override
    public void trier() {

        String req = "select * from deals ORDER BY iddeal";
        try {
            st = cnx.createStatement();
            rs = st.executeQuery(req);
            System.out.println("tri par iddeal: ");

            while (rs.next()) {
                System.out.println(rs.getInt("iddeal"));

            }

        } catch (SQLException ex) {
            System.out.println("erreur tri");
        }
    }
    
    
     @Override
    public void rechercherDeal(String caractere) 
    {

        String req = "select * from deals where description  LIKE '%" + caractere + "%'";
        try {
            st = cnx.createStatement();
            rs = st.executeQuery(req);

            while (rs.next()) {
                System.out.println("le nom que vous rechercher: " + rs.getString("description"));

            }

        } catch (SQLException ex) {
            System.out.println("erreur recherche");
        }
    }
}
