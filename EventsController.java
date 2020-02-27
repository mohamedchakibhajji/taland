/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import Services.ServiceEvent;
import Entity.Event;
import Services.ServiceEventUser;
import java.sql.SQLException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class EventsController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private VBox eventcontainer;
    @FXML
    private Button buttonafficherajout;
    @FXML
    private TextField nameevent;
    @FXML
    private TextField descriptionevent;
    @FXML
    private TextField locationevent;
    @FXML
    private DatePicker datevent;
    @FXML
    private TextField priceevent;
    @FXML
    private TextField specnum;
    @FXML
    private Button creer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
         ServiceEvent ps=new ServiceEvent();
          
   nameevent.setVisible(false);
   descriptionevent.setVisible(false);
   locationevent.setVisible(false);
   datevent.setVisible(false);
   priceevent.setVisible(false);
   specnum.setVisible(false);
   creer.setVisible(false);
           List<Event> events;
        try {
            events = ps.getEvents();
              for (int i = 0; i < events.size(); i++) {
                Pane postpane=new Pane();
                postpane.setPrefHeight(256);
                postpane.setPrefWidth(200);     
                Label username=new Label();
                Label date = new Label();    
                username.setTextFill(Color.WHITE );
                date.setTextFill(Color.WHITE );
                username.setStyle("-fx-font-weight: bold");
                username.setText(events.get(i).getName());
                
                Format formatter = new SimpleDateFormat("yyyy-MM-dd");
                String s = formatter.format(events.get(i).getDate());
                date.setText(s);
                date.setPrefWidth(500);
                date.setPrefHeight(30);
                date.setLayoutX(420);
                date.setLayoutY(80);
                username.setPrefWidth(400);
                username.setPrefHeight(30);                
                postpane.getChildren().addAll(username,date);
                System.out.println(events.get(i).getPrice_event());
                eventcontainer.getChildren().add(postpane);
        } 
                
            } catch (SQLException ex) {
            System.out.println("Exception event controller");
        }
    }    

    @FXML
    private void afficherformulaire(ActionEvent event) {
         nameevent.setVisible(true);
   descriptionevent.setVisible(true);
   locationevent.setVisible(true);
 buttonafficherajout.setVisible(false);
   datevent.setVisible(true);
   priceevent.setVisible(true);
   specnum.setVisible(true);
   eventcontainer.setVisible(false);
    creer.setVisible(true);
    }

    @FXML
    private void ajouterevenement(ActionEvent event) throws SQLException, ParseException {
        nameevent.setVisible(false);
   descriptionevent.setVisible(false);
   locationevent.setVisible(false);
   datevent.setVisible(false);
   priceevent.setVisible(false);
   specnum.setVisible(false);
   creer.setVisible(false);
        ServiceEvent ev = new ServiceEvent();
       String date =  datevent.getValue().toString();
        java.sql.Date date1 = new java.sql.Date(new java.util.Date().getTime());
        char d1 =  date.charAt(8);
        char d2 =  date.charAt(9);
         String day = String.valueOf(Character.getNumericValue(d1))+String.valueOf(Character.getNumericValue(d2));
    
    int nhar = Integer.parseInt(day);
        date1.setDate(nhar);
        char m1 =  date.charAt(5);
        char m2 =  date.charAt(6);
         String month = String.valueOf(Character.getNumericValue(m1))+String.valueOf(Character.getNumericValue(m2));
         int chhar = Integer.parseInt(month);
       date1.setMonth(chhar-1);//starts from 0=january
       char y1 =  date.charAt(3);
        char y2 =  date.charAt(2);
         char y3 =  date.charAt(1);
        char y4 =  date.charAt(0);
         String year = String.valueOf(Character.getNumericValue(y4))+String.valueOf(Character.getNumericValue(y3))+String.valueOf(Character.getNumericValue(y2))+String.valueOf(Character.getNumericValue(y1));
         int aam = Integer.parseInt(year);
        date1.setYear(aam-1900); //starts from 1900 
        Event evenemment = new Event(0,nameevent.getText(),descriptionevent.getText(),locationevent.getText(),date1,Float.parseFloat(priceevent.getText()),Integer.parseInt(specnum.getText()),1,8);
        
        ev.addEvent(evenemment);
    }
      private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
}

   // ------------------------------------------------Year----------------------------------------------------
    
   
 
  