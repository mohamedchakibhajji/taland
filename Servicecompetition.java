/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.competition;
import utils.MaConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chekib
 */
public class Servicecompetition {


    private Connection cnx;
    private Statement st;
     private Statement st2;
    private PreparedStatement pst;
     private PreparedStatement pst1;
    private ResultSet rs;
private ResultSet rs2;
   
 /**
     *
     */
    public Servicecompetition()
  {
      cnx=MaConnection.getInstance().getConnection();
      
  }
     public void ajoutercompetition(competition c)
  {  
        if( nameexiste( c.getNamecomp()) == 0)
        {        
        try {
          
                
             
    {   
      
        String req="insert into competition (namecomp,desccomp,nbrmaxspec,nbrmaxpar,location,startingdate,endingdate,pricecomp,idcat,etat) values(?,?,?,?,?,?,?,?,?,?)";
     
            pst1=cnx.prepareStatement(req);
            pst1.setString(1, c. getNamecomp()); //1ere pt d'interrogation 
            pst1.setString(2, c.getDesccomp());
            pst1.setInt   (3, c.getNbrmaxspec());
            pst1.setInt   (4, c.getNbrmaxpar());
            pst1.setString(5, c.getLocation());
            pst1.setString(6, c.getStartingdate());
            pst1.setString(7, c.getEndingdate()); 
            pst1.setFloat (8, c.getPricecomp()); 
            pst1.setInt   (9, c.getIdcat()); 
            pst1.setInt   (10, c.getEtat()); 
      
  } 
          
       
           pst1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Servicecompetition.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else 
            System.out.println("NOM EXISTE DEJA !!");
  } 
     
    /**
     *
     * @return
     */
    public List<competition> affichercompetition() {
     List <competition> list=new ArrayList<>();
       String req="select * from competition ";
        try {
            st=cnx.createStatement();
            rs=st.executeQuery(req);
       
     while(rs.next())
       
     //  System.out.println("le nom de competition est: "+rs.getString("namecomp") +" la description est :"+rs.getString("desccomp")+ " le nombre maximale des spectateurs est: " +  rs.getInt("nbrmaxspec") +"le nombre maximale des participants est : " + rs.getInt("nbrmaxpar") + " la location est: " + rs.getString("location")+ " la date debut est: " + rs.getString("startingdate")+ " la date fin est: " + rs.getString("endingdate")+ " le prix est: " + rs.getFloat("pricecomp")+ " l'id categorie est: " + rs.getInt("idcat")+ " l'etat est: " + rs.getInt("etat"));
 list.add(new competition(rs.getString("namecomp"),rs.getString("desccomp"), rs.getInt("nbrmaxspec"),rs.getInt("nbrmaxpar"), rs.getString("location"),rs.getString("startingdate"),rs.getString("endingdate"),rs.getFloat("pricecomp"), rs.getInt("idcat"),rs.getInt("etat")));
      
  
        } catch (SQLException ex) {
            Logger.getLogger(Servicecompetition.class.getName()).log(Level.SEVERE, null, ex);
        }
       return list;
    }
 public List<competition> trierparstartdate() 
    { List<competition> list=new ArrayList<>();
        
           String req="select * from competition Order By startingdate" ;
        try {
          
            st=cnx.createStatement();
       
            rs=st.executeQuery(req);
        
       
     while(rs.next())
         
   
       
    { 
   list.add(new competition(rs.getString("namecomp"),rs.getString("desccomp"),rs.getInt("nbrmaxspec"),rs.getInt("nbrmaxpar"),rs.getString("location"),rs.getString("startingdate"), rs.getString("endingdate"),rs.getFloat("pricecomp"), rs.getInt("idcat"),rs.getInt("etat")));
 


    }

  
        } catch (SQLException ex) {
            System.out.println("erreur recherche");
        }
        return list;

}
 
 public List<competition> filtrerparplacevide()
 {List <competition> list =new ArrayList<>();
         String req="select * from competition where nbrparticipant < nbrmaxpar" ;
        try {
          
            st=cnx.createStatement();
       
            rs=st.executeQuery(req);
        
       
     while(rs.next())
         
   
       
    { 
       list.add(new competition(rs.getString("namecomp"),rs.getString("desccomp"),rs.getInt("nbrmaxspec"),rs.getInt("nbrmaxpar"),rs.getString("location"),rs.getString("startingdate"), rs.getString("endingdate"),rs.getFloat("pricecomp"), rs.getInt("idcat"),rs.getInt("etat")));
 


    }

  
        } catch (SQLException ex) {
            System.out.println("erreur recherche");
        }
        return list;
 }
 
 
 public List<competition> filtrerparplacespecvide()
 {List <competition> list=new ArrayList<>();
         String req="select * from competition where nbrspec< nbrmaxspec" ;
        try {
          
            st=cnx.createStatement();
       
            rs=st.executeQuery(req);
        
       
     while(rs.next())
         
   
       
    { 
        list.add(new competition(rs.getString("namecomp"),rs.getString("desccomp"),rs.getInt("nbrmaxspec"),rs.getInt("nbrmaxpar"),rs.getString("location"),rs.getString("startingdate"), rs.getString("endingdate"),rs.getFloat("pricecomp"), rs.getInt("idcat"),rs.getInt("etat")));
 


    }

  
        } catch (SQLException ex) {
            System.out.println("erreur recherche");
        }
        return list;
 }
 public List<competition> trierparenddate() 
    {
         List <competition> list=new ArrayList<>();
           String req="select * from competition Order By endingdate" ;
        try {
          
            st=cnx.createStatement();
       
            rs=st.executeQuery(req);
        
       
     while(rs.next())
         
   
       
    { 
       
  list.add(new competition(rs.getString("namecomp"),rs.getString("desccomp"),rs.getInt("nbrmaxspec"),rs.getInt("nbrmaxpar"),rs.getString("location"),rs.getString("startingdate"), rs.getString("endingdate"),rs.getFloat("pricecomp"), rs.getInt("idcat"),rs.getInt("etat")));


    }

  
        } catch (SQLException ex) {
            System.out.println("erreur recherche");
        }
return list;
}
 
  public List<competition> filtrerCompetitionParNbrMAx(int nbr) 
    {
        List<competition> list =new ArrayList<>();
         
        try {
            String req="select * from competition where nbrmaxpar < "+nbr ;
            st=cnx.createStatement();
           
            rs=st.executeQuery(req);
       
       
     while(rs.next())
    { 
      //  System.out.println("le nom de competition est: "+rs.getString("namecomp") +" la description est :"+rs.getString("desccomp")+ " le nombre maximale des spectateurs est: " +  rs.getInt("nbrmaxspec") +"le nombre maximale des participants est : " + rs.getInt("nbrmaxpar") + " la location est: " + rs.getString("location")+ " la date debut est: " + rs.getString("startingdate")+ " la date fin est: " + rs.getString("endingdate")+ " le prix est: " + rs.getFloat("pricecomp")+ " l'id categorie est: " + rs.getInt("idcat")+ " l'etat est: " + rs.getInt("etat"));
 
list.add(new competition(rs.getString("namecomp"),rs.getString("desccomp"),rs.getInt("nbrmaxspec"),rs.getString("location"),rs.getString("startingdate"),rs.getString("endingdate"),rs.getFloat("pricecomp"),rs.getInt("idcat"),rs.getInt("etat")));
    }

  
        } catch (SQLException ex) {
            System.out.println("erreur recherche");
        }
return list;
}  
     
 
 
  
  
 public void statcompetition() 
    {
        int i=0; 
        int j=0; 
        int y=0; 
        
          String req="select  * from competition where etat = 1" ;
           String req2="select  * from trophe" ;
        try {
          
            st=cnx.createStatement();
            st2=cnx.createStatement();
           rs=st.executeQuery(req);
            
            rs2=st2.executeQuery(req2);
         
       
     while(rs.next())
         
   
       
    { 
       i=i+1;

    }
     while(rs2.next())
         
   
       
    { 
       j=j+1;

    }

            System.out.println("Il Y'a "+i+" Compétitions Faite par les utilisateurs "+" dont "+j +" Sont Deja Faites");
        } catch (SQLException ex) {
            System.out.println("erreur recherche");
        }
    
}
 
 
   public void supprimercompetition(int id) 
    {
        if(getcompetition(5).isEmpty()== true){
        System.out.println("Il N'existe Aucune Compétition Avec Cette ID ");
    } 
    else
           try {  
                String q ="delete from competition where idcomp="+id;
                String q1="insert into archivecompetition (namecomp,desccomp,nbrmaxspec,nbrmaxpar,location,startingdate,endingdate,pricecomp,idcat,etat,nbrspec,nbrparticipant) values(?,?,?,?,?,?,?,?,?,?,?,?)";
     
            pst1=cnx.prepareStatement(q1);
            pst1.setString(1, getcompetition(id).get(0).getNamecomp()); //1ere pt d'interrogation 
            pst1.setString(2, getcompetition(id).get(0).getDesccomp());
            pst1.setInt   (3, getcompetition(id).get(0).getNbrmaxspec());
            pst1.setInt   (4, getcompetition(id).get(0).getNbrmaxpar());
            pst1.setString(5, getcompetition(id).get(0).getLocation());
            pst1.setString(6, getcompetition(id).get(0).getStartingdate());
            pst1.setString(7, getcompetition(id).get(0).getEndingdate()); 
            pst1.setFloat (8, getcompetition(id).get(0).getPricecomp()); 
            pst1.setInt   (9, getcompetition(id).get(0).getIdcat()); 
            pst1.setInt   (10, getcompetition(id).get(0).getEtat());
            pst1.setInt   (11, getcompetition(id).get(0).getNbrspec()); 
            pst1.setInt   (12, getcompetition(id).get(0).getNbrparticipant()); 
              pst1.executeUpdate();
             st=cnx.createStatement();
        st.executeUpdate(q);
               System.out.println("tu as bien supprimé");
        } catch (SQLException ex) {
            Logger.getLogger(Servicecompetition.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }      
     
      public void modifiercompetition(int idcomp,String namecomp,String desccomp,int nbrmaxspec,int nbrmaxpar,String location,String startingdate,String endingdate,Float pricecomp,int idcat,int etat) throws SQLException
    {
        
        if ( nameexiste2( namecomp,idcomp) == 0)
        {
          
                                                                                                                                        
        try {  
            if((namecomp!="")&&(desccomp!="")&& (nbrmaxspec!=0)&& (nbrmaxpar!=0)&&(location!="")&&(startingdate!="")&&(endingdate!="")&&(pricecomp!=0)&&(idcat!=0)&&(etat!=0))
            {  String query="update competition set namecomp='"+namecomp+"',desccomp='"+desccomp+"',nbrmaxspec='"+nbrmaxspec+"',nbrmaxpar='"+nbrmaxpar+"',location='"+location+"',startingdate='"+startingdate+"',endingdate='"+endingdate+"',pricecomp='"+pricecomp+"',idcat='"+idcat+"',etat='"+etat+"' where competition.idcomp="+idcomp;
        st=cnx.createStatement();
           st.executeUpdate(query);
           
            System.out.println("bien modifiée");
             
            }
            else System.out.println("tu dois inserer tous les elements");
        } catch (SQLException ex) {
            Logger.getLogger(Servicecompetition.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else {
            System.out.println("Nom Competition Existe Déja");
        }
    }
       public List<competition> recherchercompetition(String namecomp) 
    {
        List<competition> list=new ArrayList();
           String req="select * from competition where namecomp  LIKE '"+namecomp+"%'" ;
        try {
          
            st=cnx.createStatement();
       
            rs=st.executeQuery(req);
        
       
     while(rs.next())
         
   
       
    { 
        System.out.println("la competition que vous rechercher: "+rs.getString("namecomp") );
list.add(new competition(rs.getString("namecomp")));
    }

  
        } catch (SQLException ex) {
            System.out.println("erreur recherche");
        }
        return list;

}
       
   
     public int nameexiste(String namecomp )
     {
          int i=0; 
         String nom = "'"+namecomp+"'";
        
         String req="select  *  from competition where namecomp ="+nom;
       try {
            st=cnx.createStatement();
            rs=st.executeQuery(req);
       
     while(rs.next())
         

       
    { 
               
       i=i+1;
        
    }
  
        } catch (SQLException ex) {
            Logger.getLogger(Servicecompetition.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return i;
         
     }

     public int nameexiste2(String namecomp , int id)
     {
          int i=0; 
         String nom = "'"+namecomp+"'";
        
         String req="select  *  from competition where namecomp = "+nom+" and idcomp != "+id;
       try {
            st=cnx.createStatement();
            rs=st.executeQuery(req);
       
     while(rs.next())
       
    { 
               
       i=i+1;
        
    }
  
        } catch (SQLException ex) {
            Logger.getLogger(Servicecompetition.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return i;
         
     }


      public int nombrecompetitionapprouve( )
     {
          int i=0; 
        
        
         String req="select  *  from competition where etat = 1";
       try {
            st=cnx.createStatement();
            rs=st.executeQuery(req);
       
     while(rs.next())
         

       
    { 
               
       i=i+1;
        
    }
  
        } catch (SQLException ex) {
            Logger.getLogger(Servicecompetition.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return i;
         
     } 
      
       public List<competition> getcompetition(int id )
     {
          
          List<competition> list =new ArrayList<>(); 
          
         String req="select  *  from competition where idcomp = "+id;
       try {
            st=cnx.createStatement();
            rs=st.executeQuery(req);
       
     while(rs.next())
         

       
    { 
               
     list.add(new competition(rs.getString("namecomp"),rs.getString("desccomp"),rs.getInt("nbrmaxspec"),rs.getInt("nbrmaxpar"),rs.getString("location"),rs.getString("startingdate"), rs.getString("endingdate"),rs.getFloat("pricecomp"), rs.getInt("idcat"),rs.getInt("etat")));

        
    }
  
        } catch (SQLException ex) {
            Logger.getLogger(Servicecompetition.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
         return list; 
     } 
       
      public int nombrecompetitienattente( )
     {
          int i=0; 
        
        
         String req="select  *  from competition where etat = 0";
       try {
            st=cnx.createStatement();
            rs=st.executeQuery(req);
       
     while(rs.next())
         

       
    { 
               
       i=i+1;
        
    }
  
        } catch (SQLException ex) {
            Logger.getLogger(Servicecompetition.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return i;
         
     }
    
   
 
   


}
