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
import javafx.stage.FileChooser;
import Entity.Event;
import Entity.EventUser;
import Entity.competitionuser;
import Services.ServiceEventUser;
import Services.Servicecompetitionuser;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import java.io.File;
import java.sql.SQLException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import animatefx.animation.*;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
/**
 * FXML Controller class
 *
 * @author acer
 */
public class EventsController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private HBox eventcontainer;
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
    @FXML
    private Label photo;
    List<String> lstFile=new ArrayList<>();  
    @FXML
    private Button addphoto;
    @FXML
    private AnchorPane pane;
    @FXML
    private StackPane stackpane;
   
    @FXML
    private Label photo1;
    @FXML
    private Label btn;
    @FXML
    private Label btn1;

   int position = 0 ; 
   int pos = 0;
   ImageView imageView = new ImageView();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
         ServiceEvent ps=new ServiceEvent();
          lstFile.add("*.png");
        lstFile.add("*.jpg");
        lstFile.add("*.IMAGE");
        photo.setVisible(false);
        addphoto.setVisible(false);
   nameevent.setVisible(false);
   descriptionevent.setVisible(false);
   locationevent.setVisible(false);
   datevent.setVisible(false);
   priceevent.setVisible(false);
   specnum.setVisible(false);
   creer.setVisible(false);
   afficher();
           List<Event> events;
        try {
            events = ps.getEvents();
           
              for (int i = 0; i < events.size(); i++) {
                   Event current=events.get(i);
                Pane postpane=new Pane();
                postpane.setPrefHeight(256);
                postpane.setPrefWidth(200);     
                Label username=new Label();
                Label date = new Label();    
                username.setTextFill(Color.WHITE );
                date.setTextFill(Color.WHITE );
                username.setStyle("-fx-font-weight: bold");
                username.setStyle("-fx-border-color : white");
                username.setStyle("-fx-border-width : 0px 0px 2px 0px");
                username.setStyle("-fx-font-size: 175px");
                date.setStyle("-fx-font-weight: bold");
                date.setStyle("-fx-font-size: 50px");
                username.setText(events.get(i).getName());
                
                  Image image2 = new Image("uploads/983279.jpg");
               final ImageView back=new ImageView();
                back.setLayoutX(80);
                back.setLayoutY(-40);
                back.setFitHeight(650);
                back.setFitWidth(800);
                back.setOpacity(0.5);
                back.setImage(image2);
                

                     Button participer = new Button();
              Button spectate = new Button();
              Label  number = new Label();
              participer.setText("Participate");
               number.setLayoutX(800);
              number.setText(""+(events.get(i).getSpec_max()-events.get(i).getNumber())+" Places Left");
              number.setTextFill(Color.GREEN);
              
              number.setMaxWidth(125);
              number.setLayoutY(80);
              if (events.get(i).getSpec_max()-events.get(i).getNumber() == 0)
              {
                  participer.setVisible(false);
                  number.setLayoutX(600);
                  number.setMaxWidth(1250);
                  number.setLayoutY(50);
                  number.setLayoutX(750);
                  number.setText("No Place Available");
                  number.setTextFill(Color.RED);
              }
                 ServiceEventUser seu = new ServiceEventUser();
                        
               participer.setLayoutX(800);
                               participer.setMaxWidth(125);

              participer.setLayoutY(50);
              if(seu.dejaparticipe(current.getIdEvent(), 20) > 0 )
              {
                   participer.setText("Participated");
                            
               participer.setLayoutX(1300);
              participer.setMaxWidth(500);
              }
              participer.setBackground(Background.EMPTY);
              participer.setTextFill(Color.DODGERBLUE);
              participer.setStyle("-fx-font-size: 20px");
               
               number.setStyle("-fx-font-size: 20px");
                     
              
       
              participer.setOnMouseEntered(e ->{
                  participer.setTextFill(Color.WHITE);
                  participer.setCursor(Cursor.HAND);
                      });
              participer.setOnMouseExited(e -> participer.setTextFill(Color.DODGERBLUE) );
            
                
             
              participer.setPrefWidth(150);
             
          
                    participer.setOnMouseClicked(new EventHandler<MouseEvent>() {
                   public void handle(MouseEvent e) {
                   participer.setText("Participated");
                    participer.setLayoutX(1090);
                     participer.setMaxWidth(790);
                       try {
                        EventUser c2=new EventUser(current.getIdEvent(),20);
                          ServiceEventUser seu = new ServiceEventUser();
                          seu.reserverplace(c2);
                       } catch (Exception ex) {
                           System.out.println(ex.getMessage());
                       }
                   }
                      
                          

                   
               });
                   
               if(participer.getText() == "Participated")
               {
                
                   participer.setOnMouseClicked(e -> {
                       participer.setText("Participer");
                       
                       seu.supprimerparticipation(current.getIdEvent(),20);
                   }
                     );     
               }

           
                     File file = new File(events.get(i).getPhoto());
        Image image = new Image(file.toURI().toString());
               final ImageView postimage=new ImageView();
                postimage.setLayoutX(80);
                postimage.setLayoutY(-40);
                postimage.setFitHeight(650);
                postimage.setFitWidth(800);
               postimage.setStyle("-fx-border-radius: 20%");
                postimage.setImage(image);
                Format formatter = new SimpleDateFormat("yyyy-MM-dd");
                String s = formatter.format(events.get(i).getDate());
          
                date.setPrefWidth(500);
                date.setPrefHeight(30);
                date.setLayoutX(230);
                date.setLayoutY(230);
                username.setLayoutX(230);
                username.setLayoutY(0);
                username.setPrefWidth(400);
                username.setPrefHeight(30);  
                 number.setVisible(false);
                 date.setVisible(false);
                  System.out.println(date.getText());
                 back.setVisible(false);
                  username.setVisible(false);
                     postimage.setOnMouseEntered(e ->{
                         date.setVisible(true);
              number.setVisible(true);
                back.setVisible(true);
                username.setVisible(true);
          });
                back.setOnMouseExited(e ->{
              number.setVisible(false);
              date.setVisible(false);
               back.setVisible(false);
                username.setVisible(false);
          });
 
                postpane.getChildren().addAll(postimage,back,username,date,participer,number);
                System.out.println(events.get(i).getPrice_event());
                eventcontainer.getChildren().add(postpane);
        } 
                
            } catch (SQLException ex) {
            Logger.getLogger(EventsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    


 public void afficher(){
        ZoomInUp zoomInUp = new ZoomInUp(eventcontainer);
            zoomInUp.play();
        System.out.println("aaaaaaaaaaaaaaaaaaaaa");
        for(int j=1;j<5;j++)
        {
            //Pane post = new Pane();
            ImageView postbackground = new ImageView();
            String path= "/uploads/"+j+".jpg";
            Image image = new Image(path);
            postbackground.setImage(image);
            postbackground.setFitHeight(90);
             postbackground.setFitWidth(90);
            FadeIn fadeIn = new FadeIn(postbackground);
            fadeIn.play();
            fadeIn.setDelay(Duration.millis(50000));
            eventcontainer.getChildren().add(postbackground);  
        }
        ScaleTransition st = new ScaleTransition(Duration.millis(1000), eventcontainer.getChildren().get(0));
       st.setByX(1.5);
       st.setByY(1.5);
       st.play();
        System.out.println("yoooooooooooooooooooooo");
       
        btn1.setDisable(true);
    }
    
    
    public void scaleforward (HBox eventcontainer,int i)
           
   {  
       FadeTransition fade = new FadeTransition();  
       fade.setDuration(Duration.millis(1000)); 
        fade.setFromValue(10);  
        fade.setToValue(0);  
       fade.setNode(eventcontainer.getChildren().get(i-1)); 
       fade.play();  
       TranslateTransition sttrans = new TranslateTransition(Duration.millis(1000), eventcontainer.getChildren().get(i));
       
       ScaleTransition st = new ScaleTransition(Duration.millis(1000), eventcontainer.getChildren().get(i));
       st.setByX(1.5);
       st.setByY(1.5);
        
       TranslateTransition st1trans = new TranslateTransition(Duration.millis(1000), eventcontainer.getChildren().get(i-1));
       
       ScaleTransition st1 = new ScaleTransition(Duration.millis(1000), eventcontainer.getChildren().get(i-1));
       st1.setByX(-1.5);
       st1.setByY(-1.5);
       st.play();
       st1.play();
   }
   
   public void scalebackwards (HBox eventcontainer,int i)
           
   {   
       FadeTransition fade = new FadeTransition();  
       fade.setDuration(Duration.millis(1000)); 
        fade.setFromValue(0);  
        fade.setToValue(10);  
       fade.setNode(eventcontainer.getChildren().get(i-1)); 
       fade.play();  
       ScaleTransition st = new ScaleTransition(Duration.millis(1000), eventcontainer.getChildren().get(i-1));
       st.setByX(1.5);
       st.setByY(1.5);
       ScaleTransition st1 = new ScaleTransition(Duration.millis(1000), eventcontainer.getChildren().get(i));
       st1.setByX(-1.5);
       st1.setByY(-1.5);
       st.play();
       st1.play();
   }

    private void btnclicked(ActionEvent event) {
          btn1.setDisable(false);
        TranslateTransition translate = new TranslateTransition(Duration.seconds(1),eventcontainer);
        position=position-140;
        
        pos++;
        if(pos>2){btn.setDisable(true);}
        
        System.out.println("eventcontainer position = "+position);
        System.out.println("i= "+pos);
           scaleforward(eventcontainer,pos);
            translate.setToX(position);
            translate.play();
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
        addphoto.setVisible(true);
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
    photo.setVisible(false);
        addphoto.setVisible(false);
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
        Event evenemment = new Event(0,nameevent.getText(),descriptionevent.getText(),locationevent.getText(),date1,Float.parseFloat(priceevent.getText()),0,Integer.parseInt(specnum.getText()),8,photo.getText());
      
        
        ev.addEvent(evenemment);
    }
      private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    @FXML
    private void ajouterphoto(ActionEvent event) {
          FileChooser fc=new FileChooser();
        
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Word Files",lstFile));
       File f=fc.showOpenDialog(null);
        if(f!=null)
        {
            photo.setText(f.getAbsolutePath());
        }
    }

    @FXML
    private void btnclicked(MouseEvent event) {
        btn1.setDisable(false);
        TranslateTransition translate = new TranslateTransition(Duration.seconds(1),eventcontainer);
        position=position-140;
        
        pos++;
        if(pos>2){btn.setDisable(true);}
        
        System.out.println("eventcontainer position = "+position);
        System.out.println("i= "+pos);
           scaleforward(eventcontainer,pos);
            translate.setToY(position);
            translate.play();
    }

    @FXML
    private void btn1clicked(MouseEvent event) {
         if(pos<=3){btn.setDisable(false);}
        TranslateTransition translate = new TranslateTransition(Duration.seconds(1),eventcontainer);
        position=position+140;
        translate.setToX(position);
            translate.play();
           scalebackwards(eventcontainer,pos);
            pos--;
            if(pos==0){btn1.setDisable(true);}
            System.out.println("eventcontainer position = "+position);
            System.out.println("i= "+pos);
    }



  

   

    
}

  
    
   
 
  