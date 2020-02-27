/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Event;
import Entity.competition;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import Services.Servicecompetition;
import java.awt.AWTException;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class CompetitionsController implements Initializable {
    private Label name;
    private Label startingdate;
    private Label prix;
    private Label location;
    @FXML
    private Button buttonajouter;
    @FXML
    private TextField nom;
    @FXML
    private TextField Descriptionfield;
    @FXML
    private TextField nbrspecmaxfield;
    @FXML
    private TextField nbrmaxparfield;
    @FXML
    private DatePicker startingdatefield;
    @FXML
    private DatePicker endingdatefield;
    @FXML
    private TextField pricecompetition;
    @FXML
    private ComboBox<String> categorie;
    @FXML
    private Button validerajout;
    @FXML
    private TextField localisation;
    @FXML
    private Button buttonmodifier;
    @FXML
    private Button validermodifer;
    @FXML
    private Button buttonsupprimer;
    @FXML
    private AnchorPane pane;
    @FXML
    private VBox apaneaffichage;
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      Servicecompetition ps=new Servicecompetition();
     
          List<competition> competitions;
          competitions = ps.affichercompetition();
           for (int i = 0; i < competitions.size(); i++) {
               Pane postpane=new Pane();
               postpane.setPrefHeight(256);
               postpane.setPrefWidth(300);
               Label username=new Label();
               Label date = new Label();
             username.setTextFill(Color.DODGERBLUE );
              date.setTextFill(Color.DODGERBLUE );
              Button participer = new Button();
              participer.setLayoutX(1040);
              participer.setLayoutY(270);
              participer.setText("Participer");
              
              username.setLayoutY(250);
              username.setStyle("-fx-font-weight: bold");
              username.setStyle("-fx-font-size: 50px");
              date.setStyle("-fx-font-weight: bold");
              date.setStyle("-fx-font-size: 50px");
              username.setText(competitions.get(i).getNamecomp());
               date.setText("Le " +competitions.get(i).getStartingdate());
              date.setPrefWidth(500);
              date.setPrefHeight(30);
              date.setLayoutX(620);
              date.setLayoutY(250);
              username.setPrefWidth(600);
              username.setPrefHeight(50);
               postpane.getChildren().addAll(username,date,participer);            
               apaneaffichage.getChildren().add(postpane);
          }
               
      nom.setVisible(false);
       Descriptionfield.setVisible(false);
       nbrspecmaxfield.setVisible(false);
      nbrmaxparfield.setVisible(false);
       startingdatefield.setVisible(false);
       endingdatefield.setVisible(false);
       pricecompetition.setVisible(false);
       categorie.setVisible(false);
       localisation.setVisible(false);
       validerajout.setVisible(false);
       validermodifer.setVisible(false);
       categorie.getItems().removeAll(categorie.getItems());
    categorie.getItems().addAll("Dance", "Paint", "Photographie");
    
    }    

    @FXML
    private void formulaireAjout(ActionEvent event) {
         nom.setVisible(true);
         buttonajouter.setVisible(false);
       Descriptionfield.setVisible(true);
       nbrspecmaxfield.setVisible(true);
      nbrmaxparfield.setVisible(true);
       startingdatefield.setVisible(true);
       endingdatefield.setVisible(true);
       pricecompetition.setVisible(true);
       categorie.setVisible(true);
       localisation.setVisible(true);
      validermodifer.setVisible(false);
       validerajout.setVisible(true);
    }

    @FXML
    private void validerajoutaction(ActionEvent event) throws AWTException {
      int i = 0 ; 
  
       if ( categorie.getValue() == "Dance" )
       {
           i = 1 ;
       }
         if ( categorie.getValue() == "Paint" )
       {
           i = 2 ;
       }
         competition c1 =new competition(nom.getText(),Descriptionfield.getText(),Integer.parseInt(nbrspecmaxfield.getText()), Integer.parseInt(nbrmaxparfield.getText()),localisation.getText(),startingdatefield.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), endingdatefield.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),Integer.parseInt(pricecompetition.getText()),i,1);
    Servicecompetition ps=new Servicecompetition();
    ps.ajoutercompetition(c1);
      nom.setVisible(false);
       Descriptionfield.setVisible(false);
       nbrspecmaxfield.setVisible(false);
      nbrmaxparfield.setVisible(false);
       startingdatefield.setVisible(false);
       endingdatefield.setVisible(false);
       pricecompetition.setVisible(false);
       categorie.setVisible(false);
       localisation.setVisible(false);
       validerajout.setVisible(false);
    }

    @FXML
    private void buttonmodiferaction(ActionEvent event ) {
        nom.setVisible(true);
         buttonajouter.setVisible(false);
         buttonmodifier.setVisible(true);
       Descriptionfield.setVisible(true);
       nbrspecmaxfield.setVisible(true);
      nbrmaxparfield.setVisible(true);
       startingdatefield.setVisible(true);
       endingdatefield.setVisible(true);
       pricecompetition.setVisible(true);
       categorie.setVisible(true);
       localisation.setVisible(true);
       validerajout.setVisible(false);
       validermodifer.setVisible(true);
       Servicecompetition ps=new Servicecompetition();
       nom.setText(ps.affichercompetition().get(1).getNamecomp());
       Descriptionfield.setText(ps.affichercompetition().get(1).getDesccomp());
       nbrspecmaxfield.setText(String.valueOf(ps.affichercompetition().get(1).getNbrmaxspec()));
       nbrmaxparfield.setText(String.valueOf(ps.affichercompetition().get(1).getNbrmaxpar()));
       localisation.setText(ps.affichercompetition().get(1).getLocation());
        
         pricecompetition.setText(String.valueOf(ps.affichercompetition().get(1).getPricecomp()));
    
       
         if (  ps.affichercompetition().get(1).getIdcat() == 8 )
       {
         categorie.setValue("paint");
      }
        if ( ps.affichercompetition().get(1).getIdcat() == 1)
      {
         categorie.setValue("Dance");
      }
        // ------------------------------------------------Year----------------------------------------------------
       String startdate = ps.affichercompetition().get(1).getStartingdate();
   char y1 =  startdate.charAt(6);

   char y2 =  startdate.charAt(7);
 
   char y3 =  startdate.charAt(8);
        
   char y4 =  startdate.charAt(9);
      
    String year = String.valueOf(Character.getNumericValue(y1))+String.valueOf(Character.getNumericValue(y2))+String.valueOf(Character.getNumericValue(y3))+String.valueOf(Character.getNumericValue(y4));
    
    int aam = Integer.parseInt(year);
       
// ------------------------------------------------month----------------------------------------------------
   char m1 =  startdate.charAt(3);
   char m2 =  startdate.charAt(4);
    String month = String.valueOf(Character.getNumericValue(m1))+String.valueOf(Character.getNumericValue(m2));
 int chhar = Integer.parseInt(month);
        
// ------------------------------------------------day----------------------------------------------------
   char d1 =  startdate.charAt(0);
   char d2 =  startdate.charAt(1);
    String day = String.valueOf(Character.getNumericValue(d1))+String.valueOf(Character.getNumericValue(d2));
    int nhar = Integer.parseInt(day);
    startingdatefield.setValue(LocalDate.of(aam, chhar, nhar));
     
    
    // ------------------------------------------------Year----------------------------------------------------
       String enddate = ps.affichercompetition().get(1).getEndingdate();
      
   char y12 =  enddate.charAt(6);
   char y22 =  enddate.charAt(7);
   char y32 =  enddate.charAt(8);
   char y42 =  enddate.charAt(9);
    String year2 = String.valueOf(Character.getNumericValue(y12))+String.valueOf(Character.getNumericValue(y22))+String.valueOf(Character.getNumericValue(y32))+String.valueOf(Character.getNumericValue(y42));
      
    int aam2 = Integer.parseInt(year2);
        
// ------------------------------------------------month----------------------------------------------------
   char m12 =  enddate.charAt(3);
   char m22 =  enddate.charAt(4);
    String month2 = String.valueOf(Character.getNumericValue(m12))+String.valueOf(Character.getNumericValue(m22));
      int chhar2 = Integer.parseInt(month2);
// ------------------------------------------------day----------------------------------------------------
   char d12 =  enddate.charAt(0);
   char d22 =  enddate.charAt(1);
    String day2 = String.valueOf(Character.getNumericValue(d12))+String.valueOf(Character.getNumericValue(d22));
 
    int nhar2 = Integer.parseInt(day2);
   endingdatefield.setValue(LocalDate.of(aam2, chhar2, nhar2));
       
    }

    @FXML
    private void actionvalidermodifier(ActionEvent event) throws SQLException {
          int i = 0 ; 
  Servicecompetition ps=new Servicecompetition();
       if ( ps.affichercompetition().get(0).getIdcat() == 8)
       {
           i = 1 ;
       }
         if ( ps.affichercompetition().get(0).getIdcat() == 8 )
       {
           i = 2 ;
       }
     
        competition c1 =new competition(nom.getText(),Descriptionfield.getText(),Integer.parseInt(nbrmaxparfield.getText()),Integer.parseInt(nbrspecmaxfield.getText()),localisation.getText(),startingdatefield.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), endingdatefield.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),Float.parseFloat(pricecompetition.getText()),i,1);
        
     
    ps.modifiercompetition(ps.getidcompetition(name.getText()),c1);
     
      nom.setVisible(false);
       Descriptionfield.setVisible(false);
       nbrspecmaxfield.setVisible(false);
      nbrmaxparfield.setVisible(false);
       startingdatefield.setVisible(false);
       endingdatefield.setVisible(false);
       pricecompetition.setVisible(false);
       categorie.setVisible(false);
       localisation.setVisible(false);
       validerajout.setVisible(false);
       validermodifer.setVisible(false);
    }

    @FXML
    private void supprimer(ActionEvent event) throws IOException {
         Servicecompetition ps=new Servicecompetition();
        ps.supprimercompetition(ps.getidcompetition(name.getText()));
   
    }

   
    
}
