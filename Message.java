/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Amine
 */
public class Message {
    int idmessage;
    int idU;
    int idreceiver;
    String contenu;
    int etatmessage=0;

    public Message() {
    }

    public Message(int idmessage, int idU, int idreceiver, String contenu) {
        this.idmessage = idmessage;
        this.idU = idU;
        this.idreceiver = idreceiver;
        this.contenu = contenu;
    }

    public int getIdmessage() {
        return idmessage;
    }

    public int getIdU() {
        return idU;
    }

    public int getIdreceiver() {
        return idreceiver;
    }

    public String getContenu() {
        return contenu;
    }

    public int getEtatmessage() {
        return etatmessage;
    }

    public void setIdmessage(int idmessage) {
        this.idmessage = idmessage;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public void setIdreceiver(int idreceiver) {
        this.idreceiver = idreceiver;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setEtatmessage(int etatmessage) {
        this.etatmessage = etatmessage;
    }

    @Override
    public String toString() {
        return "Message{" + "idmessage=" + idmessage + ", idU=" + idU + ", idreceiver=" + idreceiver + ", contenu=" + contenu + ", etatmessage=" + etatmessage + '}';
    }

    
    
    
    
    
    
}
