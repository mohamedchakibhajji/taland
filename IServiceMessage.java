/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;
import Entity.Users;
import Entity.Message;
import java.sql.SQLException;

/**
 *
 * @author Amine
 */
public interface IServiceMessage {
    public void sendMesage(Message m) throws SQLException;
    public void displayMessage() throws SQLException;
    
}
