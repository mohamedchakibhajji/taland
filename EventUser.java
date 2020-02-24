/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Chekib
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
/**
 *
 * @author Eya Loukil
 */
public class EventUser {
    


    int idevent;
    int idu;

    
    public EventUser(int idevent, int idu) {
        this.idevent = idevent;
        this.idu = idu;
    }

    public int getIdevent() {
        return idevent;
    }

    public int getIdu() {
        return idu;
    }

    public void setIdevent(int idevent) {
        this.idevent = idevent;
    }

    public void setIdu(int idu) {
        this.idu = idu;
    }

    @Override
    public String toString() {
        return "EventUser{" + "idevent=" + idevent + ", idu=" + idu + '}';
    }

   


   
}

