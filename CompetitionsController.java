/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.competition;
import Entity.competitionuser;
import Services.Servicecompetition;
import Services.Servicecompetitionuser;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
/**
 * FXML Controller class
 *
 * @author Chekib Elhajji
 */
public class CompetitionsController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private StackPane stackpane;
    @FXML
    private Label label;
    @FXML
    private Button buttonafficherajout;
    @FXML
    private TextField nameevent;
    @FXML
    private TextField descriptionevent;
    @FXML
    private TextField locationevent;
    @FXML
    private VBox eventcontainer;
    @FXML
    private DatePicker datevent;
    @FXML
    private TextField priceevent;
    @FXML
    private TextField specnum;
    @FXML
    private Button creer;
    @FXML
    private Label photo;
    List<String> lstFile=new ArrayList<>();  
    private Button addphoto;
    @FXML
    private JFXComboBox<String> categorie;
    @FXML
    private DatePicker datecompetition2;
    @FXML
    private TextField specnum1;
    @FXML
    private Button photoshop;
    private Label slach;
    @FXML
    private Label description;
    @FXML
    private Label prix;
    @FXML
    private Label dateend;
    @FXML
    private TextField search;
    @FXML
    private Button buttonafficherajout1;
    @FXML
    private Button buttonafficherajout11;
    @FXML
    private Button buttonafficherajout111;
    @FXML
    private Button updatebutton;
    @FXML
    private ImageView imagedrag;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            Servicecompetition ps=new Servicecompetition();
 affichercomp(ps.affichercompetition());
     
    }    
    
public void affichercomp(List <competition> competitions)
{

          lstFile.add("*.png");
        lstFile.add("*.jpg");
        lstFile.add("*.IMAGE");
        imagedrag.setVisible(false);
        photo.setVisible(false);
      
   nameevent.setVisible(false);
   descriptionevent.setVisible(false);
   locationevent.setVisible(false);
   datevent.setVisible(false);
   priceevent.setVisible(false);
   specnum.setVisible(false);
   creer.setVisible(false);
   specnum1.setVisible(false);
   categorie.setVisible(false);
    
   datecompetition2.setVisible(false);
   photoshop.setVisible(false);
   description.setVisible(false);
   prix.setVisible(false);
   dateend.setVisible(false);
         updatebutton.setVisible(false);
          
           for (int i = 0; i < competitions.size(); i++) {
               competition current=competitions.get(i);
               Pane postpane=new Pane();
               postpane.setPrefHeight(256);
               postpane.setPrefWidth(200);
               Label username=new Label();
            
               Label date = new Label();
               username.setTextFill(Color.WHITE );
               date.setTextFill(Color.WHITE );
               username.setStyle("-fx-font-weight: bold");
           
               username.setStyle("-fx-font-size: 45px");
               date.setStyle("-fx-font-weight: bold");
               date.setStyle("-fx-font-size: 20px");
               username.setText(competitions.get(i).getNamecomp());
               
               Image image2 = new Image("uploads/983279.jpg");
               final ImageView back=new ImageView();
               back.setLayoutX(150);
               back.setLayoutY(0);
               back.setFitHeight(150);
               back.setFitWidth(800);
               back.setOpacity(0.5);
               back.setImage(image2);
              Servicecompetitionuser seu = new Servicecompetitionuser();
               Button participer = new Button();
               Button spectate = new Button();
               Label  number = new Label();
                Label  numberspec = new Label();
               spectate.setText("Spectate");
               participer.setText("Participate");
               number.setLayoutX(450);
              
               number.setText(""+(competitions.get(i).getNbrmaxpar()-competitions.get(i).getNbrparticipant())+" Places Left");
               number.setTextFill(Color.GREEN);
               
               number.setMaxWidth(125);
               number.setLayoutY(80);
                numberspec.setLayoutX(700);
              numberspec.setStyle("-fx-font-size: 20px");
               numberspec.setText(""+(competitions.get(i).getNbrmaxspec()-competitions.get(i).getNbrspec())+" Places Left To Spectate");
               numberspec.setTextFill(Color.GREEN);
               
               numberspec.setMaxWidth(225);
               numberspec.setLayoutY(80);
               Button update = new Button();   
               Button delete = new Button();
               delete.setVisible(false);
               update.setVisible(false);
               if (competitions.get(i).getNbrmaxpar()-competitions.get(i).getNbrparticipant()== 0)
               {
                   participer.setVisible(false);
                  
                   ;
                   number.setMaxWidth(1250);
                   number.setLayoutY(50);
                   number.setLayoutX(450);
                   number.setText("No Place Available");
                   number.setTextFill(Color.RED);
               }
               if(competitions.get(i).getIdU() == 20 )
               {
             delete.setVisible(true);
             update.setVisible(true);
              update.setText("📝");
                update.setLayoutY(85);
               update.setLayoutX(980);
         
               
               update.setStyle("	-fx-background-color : transparent;\n\n" +

"	-fx-padding:00px;\n" +
"	-fx-background-radius:35px;\n" +
"	-fx-font-size:20;\n" +
"	-fx-cursor: pointer;");
                update.setOnMouseEntered(e ->{
                   update.setTextFill(Color.BLACK);
                   update.setCursor(Cursor.HAND);
               });
                 update.setTextFill(Color.WHITE);
               delete.setText("❌");
                delete.setLayoutY(25);
               delete.setLayoutX(980);
               spectate.setText("");
               participer.setText("");
                delete.setTextFill(Color.WHITE);
               delete.setStyle("	-fx-background-color : transparent;\n" +

"	-fx-padding:00px;\n" +
"	-fx-background-radius:35px;\n" +
"	-fx-font-size:20;\n" +
"	-fx-cursor: pointer;");
                delete.setOnMouseEntered(e ->{
                   delete.setTextFill(Color.RED);
                   delete.setCursor(Cursor.HAND);
               });
               update.setOnMouseExited(e ->{
                         
                   update.setTextFill(Color.WHITE);
                   update.setCursor(Cursor.DEFAULT);
               });
                     delete.setOnMouseExited(e ->{
                         
                   delete.setTextFill(Color.WHITE);
                   delete.setCursor(Cursor.DEFAULT);
               });
                     update.setOnMouseClicked(e ->{
                     
                       nameevent.setVisible(true);
                       nameevent.setText(current.getNamecomp());
   descriptionevent.setVisible(true);
   descriptionevent.setText(current.getDesccomp());
   locationevent.setVisible(true);
   locationevent.setText(current.getLocation());
   datevent.setVisible(true);
   // ------------------------------------------------Year----------------------------------------------------
       String startdate =current.getStartingdate();
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
    datevent.setValue(LocalDate.of(aam, chhar, nhar));
   priceevent.setVisible(true);
   priceevent.setText(String.valueOf(current.getPricecomp()));
   specnum.setVisible(true);
   specnum.setText(String.valueOf(current.getNbrmaxspec()));
   eventcontainer.setVisible(false);
         specnum1.setVisible(true);
         specnum1.setText(String.valueOf(current.getNbrmaxpar()));
   categorie.setVisible(true);
   datecompetition2.setVisible(true);
         prix.setVisible(false);
            // ------------------------------------------------Year----------------------------------------------------
       String enddate=current.getEndingdate();
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
    datevent.setValue(LocalDate.of(aam, chhar, nhar));
   dateend.setVisible(false);
   datecompetition2.setValue(LocalDate.of(aam2, chhar2, nhar2));
      categorie.getItems().removeAll(categorie.getItems());
    categorie.getItems().addAll("Dance", "Paint", "Photographie");
      updatebutton.setVisible(true);
       search.setVisible(false);
      description.setVisible(false);
                         System.out.println(current.getIdcat());
      if(current.getIdcat() == 0 )
      {
        categorie.setValue("Dance");
      }
       if(current.getIdcat() == 1 )
      {
           categorie.setValue("Paint");
      }
        if(current.getIdcat() == 2 )
      {
           categorie.setValue("Photographie");
      }

                
               });
                   delete.setOnMouseClicked(e ->{
                      Servicecompetition ev = new Servicecompetition();
                      Alert alert = new Alert(AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation Dialog");
                    alert.setHeaderText("Are You Sure To delete "+current.getNamecomp());
                    alert.setContentText("");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK){
     ev.supprimercompetition(current.getIdcomp());
       eventcontainer.getChildren().clear();
      affichercomp(ev.affichercompetition());
     
                    } 
                
               });
               }
               if (competitions.get(i).getNbrmaxspec()-competitions.get(i).getNbrspec()== 0)
               {
                   spectate.setVisible(false);
                  numberspec.setLayoutX(600);
                   numberspec.setMaxWidth(1250);
                   numberspec.setStyle("-fx-font-size: 20px");
                   numberspec.setLayoutY(50);
                   numberspec.setLayoutX(650);
                   numberspec.setText("No Place Available To Spectate");
                   numberspec.setTextFill(Color.RED);
               }
               
               participer.setBackground(Background.EMPTY);
               participer.setTextFill(Color.DODGERBLUE);
               participer.setStyle("-fx-font-size: 20px");
               spectate.setBackground(Background.EMPTY);
               spectate.setTextFill(Color.DODGERBLUE);
               spectate.setStyle("-fx-font-size: 20px");
               number.setStyle("-fx-font-size: 20px");
                   
               participer.setLayoutX(450);
               participer.setLayoutY(50);
               participer.setMaxWidth(125);
               participer.setPrefWidth(150);
               participer.setOnMouseEntered(e ->{
                   participer.setTextFill(Color.WHITE);
                   participer.setCursor(Cursor.HAND);
               });
               participer.setOnMouseExited(e -> participer.setTextFill(Color.DODGERBLUE) );
               
                competitionuser c2=new competitionuser(current.getIdcomp(),20);
                          
          try {
              int d = seu.dejaparticipe(current.getIdcomp(),20);
               if (d > 0 )
                  {
                      
                       participer.setTextFill(Color.BLUE);
                     participer.setText("Participated");   
                      participer.setLayoutX(450);
               participer.setLayoutY(50);
                  
                      participer.setMaxWidth(793);
                       participer.setOnMouseEntered(e ->{
                   participer.setTextFill(Color.WHITE);
                   participer.setText("I Won't");   
                  
                   participer.setCursor(Cursor.HAND);
                   
               });
               participer.setOnMouseExited(e -> {participer.setTextFill(Color.BLUE);
                  participer.setText("Participated");} );
               

                      
                  }
          } catch (Exception ex) {
              Logger.getLogger(CompetitionsController.class.getName()).log(Level.SEVERE, null, ex);
          }
         
               
             
               participer.setLayoutY(50);
                  spectate.setLayoutY(50);
               spectate.setLayoutX(800);
               spectate.setLayoutY(50);
               spectate.setMaxWidth(125);
               spectate.setPrefWidth(150);
               spectate.setOnMouseEntered(e ->{
                   spectate.setTextFill(Color.WHITE);
                   spectate.setCursor(Cursor.HAND);
               });
               spectate.setOnMouseExited(e -> spectate.setTextFill(Color.DODGERBLUE) );
               
                competitionuser c3=new competitionuser(current.getIdcomp(),20);
                           Servicecompetitionuser seu1 = new Servicecompetitionuser();
          try {
              int d = seu.dejaparticipe(current.getIdcomp(),20);
               if (d > 0 )
                  {
                      
                       spectate.setTextFill(Color.BLUE);
                     spectate.setText("I'll Go");   
                     spectate.setLayoutX(705);
                     spectate.setLayoutY(45);
                      spectate.setMaxWidth(793);;
                       spectate.setOnMouseEntered(e ->{
                   spectate.setTextFill(Color.WHITE);
                   spectate.setCursor(Cursor.HAND);
                   
               });
               spectate.setOnMouseExited(e -> spectate.setTextFill(Color.BLUE) );
               

                      
                  }
          } catch (Exception ex) {
              Logger.getLogger(CompetitionsController.class.getName()).log(Level.SEVERE, null, ex);
          }
         
               File file = new File(competitions.get(i).getPhoto());
               
               Image image = new Image(file.toURI().toString());
               final ImageView postimage=new ImageView();
               postimage.setLayoutX(50);
               postimage.setLayoutY(0);
               postimage.setFitHeight(150);
               postimage.setFitWidth(150);
               
               postimage.setImage(image);
               date.setText(competitions.get(i).getStartingdate());
               date.setPrefWidth(500);
               date.setPrefHeight(30);
               date.setLayoutX(230);
               date.setLayoutY(80);
               username.setLayoutX(230);
               username.setLayoutY(0);
               username.setPrefWidth(200);
               username.setPrefHeight(30);
               username.setOnMouseClicked(e ->{
                   JFXDialogLayout dialoglayout = new JFXDialogLayout();
                   
                   BoxBlur blur = new BoxBlur(10,10,10);
                   JFXDialog dialog = new JFXDialog(stackpane , dialoglayout , JFXDialog.DialogTransition.TOP);
                   stackpane.setEffect(null);
                   pane.setEffect(blur);
                   dialog.show();
                   dialog.close();
               });
       
               
               
               eventcontainer.getChildren().add(postpane);
               spectate.setOnMouseClicked(new EventHandler<MouseEvent>() {
                   public void handle(MouseEvent e) {
                   
                       try {
                           competitionuser c2=new competitionuser(current.getIdcomp(),20);
                           Servicecompetitionuser seu = new Servicecompetitionuser();
                           seu.reserverplacespec(c2,current.getNamecomp());
                           
                          spectate.setText("I'll Go");
                       participer.setText("");
                       
                       } catch (Exception ex) {
                           System.out.println(ex.getMessage());
                       }
                   }
                   
                   
                   
                   
               });
                   
                participer.setOnMouseClicked(new EventHandler<MouseEvent>() {
                   public void handle(MouseEvent e) {
                   
                       try {
                           competitionuser c2=new competitionuser(current.getIdcomp(),20);
                           Servicecompetitionuser seu = new Servicecompetitionuser();
                           seu.reserverplace(c2);
                           
                           eventcontainer.getChildren().clear();
                          back.setLayoutX(50);
                               back.setFitHeight(1500);
                            back.setFitWidth(900);
                           eventcontainer.getChildren().add(postpane);
                       
                       } catch (Exception ex) {
                           System.out.println(ex.getMessage());
                       }
                   }
                   
                   
                   
                   
               });
               
            if  (participer.getText() == "Participated" || participer.getText() == "I Won't" ||  participer.getText() == "I Won't Go")
               {
                    spectate.setVisible(false);
                  spectate.setText("");
                   numberspec.setVisible(true);
                   number.setVisible(true);
                    participer.setOnMouseExited(e -> {
                        participer.setTextFill(Color.BLUE) ;
                        participer.setText("Participated");
                            });
                     participer.setOnMouseEntered(e -> participer.setText("I Won't Go") );
                   participer.setOnMouseClicked(new EventHandler<MouseEvent>() {
                   public void handle(MouseEvent e) {
                
                
                       seu.supprimerparticipation(current.getIdcomp(), 20);
                        
                          
                   }
                   
                   
                   
                   
               });
               
                   
                   
               }
           
               if  (spectate.getText() == "I'll Go")
               {
                   participer.setVisible(false);
                   number.setVisible(false);
                   participer.setText("");
                    spectate.setText("I'll Go");
                   spectate.setVisible(true);
                    spectate.setOnMouseExited(e -> {
                        spectate.setTextFill(Color.BLUE) ;
                        spectate.setText("I'll Go");
                            });
                     spectate.setOnMouseEntered(e -> spectate.setText("I Won't Go") );
                   spectate.setOnMouseClicked(new EventHandler<MouseEvent>() {
                   public void handle(MouseEvent e) {
                    spectate.setText("Spectate");
                       seu.supprimerparticipationspec(current.getIdcomp(), 20);
                        
                          
                   }
                   
                   
                   
                   
               });
               
                   
                   
               }
            
                    
              
        
               username.setOnMouseEntered(e ->{
                   username.setTextFill(Color.DODGERBLUE);
                   username.setCursor(Cursor.HAND);
                    username.setUnderline(true);
               });
               username.setOnMouseExited(e -> {
                   username.setTextFill(Color.WHITE) ;
                    username.setUnderline(false);
                       });
               
               username.setOnMouseClicked(new EventHandler<MouseEvent>() {
                   public void handle(MouseEvent e) {
               
          
                 
                 eventcontainer.getChildren().clear();
                          back.setLayoutX(50);
                               back.setFitHeight(1500);
                            back.setFitWidth(900);
                              prix.setVisible(true);
                                dateend.setVisible(true);
                             description.setVisible(true);
                             description.setText("Decsription :       " +current.getDesccomp());
                             description.setLayoutX(200);
                             description.setLayoutY(400);
                              description.setMaxHeight(1800);
                            description.setMaxWidth(1500);
                            description.setTextFill(Color.DODGERBLUE);
                            description.setUnderline(true);
                             description.setStyle("-fx-font-size: 20px");
                                 prix.setText("Price :       " +current.getPricecomp()+" DT");
                             prix.setLayoutX(200);
                             prix.setLayoutY(250);
                              prix.setMaxHeight(1800);
                            prix.setMaxWidth(1500);
                            prix.setTextFill(Color.DODGERBLUE);
                            prix.setUnderline(true);
                             prix.setStyle("-fx-font-size: 40px");
                           eventcontainer.getChildren().add(postpane);
                  
                   }
                   
                   
                   
                   
               });
               
           
               
               postpane.getChildren().addAll(back,username,date,postimage,participer,number,spectate,numberspec,delete,update); 
               
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
     photo.setVisible(true);
     
         specnum1.setVisible(true);
   categorie.setVisible(true);
   datecompetition2.setVisible(true);
      photoshop.setVisible(true);
         prix.setVisible(false);
   dateend.setVisible(false);

       search.setVisible(false);
      description.setVisible(false);
      imagedrag.setVisible(true);
      updatebutton.setVisible(false);
   categorie.getItems().removeAll(categorie.getItems());
    categorie.getItems().addAll("Dance", "Paint", "Photographie");
    }

    @FXML
    private void ajouterevenement(ActionEvent event) throws AWTException {
       nameevent.setVisible(false);
   descriptionevent.setVisible(false);
   locationevent.setVisible(false);
   imagedrag.setVisible(false);
 buttonafficherajout.setVisible(true);
   datevent.setVisible(false);
   priceevent.setVisible(false);
   specnum.setVisible(false);
   eventcontainer.setVisible(true);
    creer.setVisible(false);
     photo.setVisible(false);
      photoshop.setVisible(false);
     
         specnum1.setVisible(false);
   categorie.setVisible(false);
   search.setVisible(true);
    updatebutton.setVisible(false);
   datecompetition2.setVisible(false);
        Servicecompetition ev = new Servicecompetition();
       int i = 0 ; 
  
       if ( categorie.getValue() == "Dance" )
       {
           i = 1 ;
       }
         if ( categorie.getValue() == "Paint" )
       {
           i = 2 ;
       }
          if ( categorie.getValue() == "Photographie" )
       {
           i = 3 ;
       }

         competition c1 =new competition(nameevent.getText(),descriptionevent.getText(),Integer.parseInt(specnum1.getText()),Integer.parseInt(specnum.getText()),locationevent.getText(),datevent.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),datecompetition2.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),Integer.parseInt(priceevent.getText()),i,0,photo.getText(),20);
       Servicecompetition ps=new Servicecompetition();
    ps.ajoutercompetition(c1);
        eventcontainer.getChildren().clear();
      affichercomp(ev.affichercompetition());
    }

   

    @FXML
    private void photoshopadd(ActionEvent event) throws IOException {
        
        Process pro=Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler affiche.psd");
    }

    @FXML
    private void rechercher(KeyEvent event) {
         Servicecompetition ps=new Servicecompetition();
        eventcontainer.getChildren().clear();
        affichercomp( ps.recherchercompetition(search.getText()));
        
     
    }

    @FXML
    private void filterbydate(ActionEvent event) {
        Servicecompetition ps=new Servicecompetition();
        eventcontainer.getChildren().clear();
        affichercomp( ps.trierparstartdate());
    }

    @FXML
    private void filterbynumberspec(ActionEvent event) {
        Servicecompetition ps=new Servicecompetition();
        eventcontainer.getChildren().clear();
        affichercomp( ps.filtrerparplacespecvide());
    }

    @FXML
    private void filterbynumber(ActionEvent event) {
         Servicecompetition ps=new Servicecompetition();
        eventcontainer.getChildren().clear();
        affichercomp( ps.filtrerparplacevide());
    }

    @FXML
    private void update(ActionEvent event) throws SQLException {
 int i = 0;
       if ( categorie.getValue() == "Dance" )
       {
           i = 0 ;
       }
         if ( categorie.getValue() == "Paint" )
       {
           i = 1 ;
       }
          if ( categorie.getValue() == "Photographie" )
       {
           i = 2 ;
       }
        competition c1 =new competition(nameevent.getText(),descriptionevent.getText(),Integer.parseInt(specnum1.getText()),Integer.parseInt(specnum.getText()),locationevent.getText(),datevent.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), datecompetition2.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),Float.parseFloat(priceevent.getText()),i);
       
     Servicecompetition ps=new Servicecompetition();
 ps.modifiercompetition(ps.getidcompetition(nameevent.getText()),c1);
     eventcontainer.getChildren().clear();
 photo.setVisible(false);
        addphoto.setVisible(false);
   nameevent.setVisible(false);
   descriptionevent.setVisible(false);
   locationevent.setVisible(false);
   datevent.setVisible(false);
   priceevent.setVisible(false);
   specnum.setVisible(false);
   creer.setVisible(false);
   specnum1.setVisible(false);
   categorie.setVisible(false);
    slach.setVisible(false);
   datecompetition2.setVisible(false);
   photoshop.setVisible(false);
   description.setVisible(false);
   prix.setVisible(false);
   dateend.setVisible(false);
         updatebutton.setVisible(false);
         
        affichercomp( ps.affichercompetition());
    }
 

 
    @FXML
    private void handleDragOver(DragEvent event) {
          if(event.getDragboard().hasFiles()){
            event.acceptTransferModes(TransferMode.ANY);
        }
    }

    @FXML
    private void handleDrop(DragEvent event) throws FileNotFoundException {
         List<File>files=event.getDragboard().getFiles();
        Image img = new Image(new FileInputStream(files.get(0).getAbsolutePath()));
        imagedrag.setImage(img);
   String path =files.get(0).getAbsolutePath();
   photo.setText(path);
        
    }

  
   
   
}
