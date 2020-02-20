/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entity.Message;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author acer
 */
public interface IServiceMessage {
    public void addMessage(Message m) throws SQLException;
    public void displayMessage() throws SQLException;
}
