/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Message;
import Entity.Users;
import Entity.javamail;
import Interfaces.IServiceMessage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MaConnection;

/**
 *
 * @author Amine
 */
public class ServiceMessage implements IServiceMessage{
    private Connection cnx;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;

    public ServiceMessage() {
        cnx = MaConnection.getInstance().getConnection();
        

    }
    @Override
    public void sendMesage(Message m) throws SQLException {
        try {
                {
                   /* String[] args = null;

                    javamail.main(args);*/
                    String req = "insert into message (idmessage,idU,idreceiver,contenu) "+ "values(?,?,?,?)";
                    

                    pst = cnx.prepareStatement(req);
                    pst.setInt(1, m.getIdmessage()); //1ere pt d'interrogation 
                    pst.setInt(2, m.getIdU());
                    pst.setInt(3, m.getIdreceiver());
                    pst.setString(4, m.getContenu());
                 

                }

                pst.executeUpdate();
                System.out.println("ajout message");
            

            } catch (SQLException ex) {
                System.out.println("erreur ajout message");;
            }
      
    }

    @Override
    public void displayMessage() throws SQLException {
        String req = "select * from message  ";
        try {
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);

            while (rs.next()) //  list.add(new Talentueux(rs.getString("Talent"),rs.getInt("NumTel"), rs.getString("Email"), rs.getString("DateNaissance")); //soit le nom de la colonne soit l'indice
            {
                System.out.println("Idmessage : " + rs.getInt("idmessage") + "  Idsender :" + rs.getInt("idU") + "  Idreceivere :" + 
                        rs.getInt("idreceiver") + "  Content :" + rs.getString("contenu"));
                        
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServiceUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    
}
 