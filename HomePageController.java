/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import animatefx.animation.*;
import javafx.animation.FadeTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class HomePageController implements Initializable {

    @FXML
    private Label ev1;
    @FXML
    private Label ev2;
    @FXML
    private Label comp1;
    @FXML
    private Label comp2;
    @FXML
    private ImageView bluerectangle;
    @FXML
    private ImageView circles;
    
    int position=0;
    ImageView imageview = new ImageView();
    int i=0;
    @FXML
    private AnchorPane deals;
    @FXML
    private AnchorPane main;
    @FXML
    private Button btn;
    @FXML
    private Button btn1;
    @FXML
    private VBox hbox;
    @FXML
    private ImageView bluesquare;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ev1.setCursor(Cursor.HAND);
        ev2.setCursor(Cursor.HAND);
        comp1.setCursor(Cursor.HAND);
        comp2.setCursor(Cursor.HAND);
        afficher();
        
        new FadeIn(bluesquare).play();
       
        new FadeInUp(bluerectangle).play();
        
    }    

    @FXML
    private void ev1clicked(MouseEvent event) {
        TranslateTransition translate = new TranslateTransition(Duration.seconds(0.5),bluerectangle);
            translate.setToY(0);
            translate.play();
            Image circles1 = new Image("/uploads/circles1.png");
            circles.setImage(circles1);
    }

    @FXML
    private void ev2clicked(MouseEvent event) {
        TranslateTransition translate = new TranslateTransition(Duration.seconds(0.5),bluerectangle);
        translate.setToY(90);
            translate.play();
            Image circles2 = new Image("/uploads/circles2.png");
            circles.setImage(circles2);
    }
    @FXML
    private void comp1clicked(MouseEvent event) {
        TranslateTransition translate = new TranslateTransition(Duration.seconds(0.5),bluerectangle);
        translate.setToY(180);
            translate.play();
            Image circles3 = new Image("/uploads/circles3.png");
            circles.setImage(circles3);
    
    }

    @FXML
    private void comp2clicked(MouseEvent event) {
        TranslateTransition translate = new TranslateTransition(Duration.seconds(0.5),bluerectangle);
        translate.setToY(260);
            translate.play();
            Image circles4 = new Image("/uploads/circles4.png");
            circles.setImage(circles4);
    }
    
    public void afficher(){
        ZoomInUp zoomInUp = new ZoomInUp(hbox);
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
            hbox.getChildren().add(postbackground);  
        }
        ScaleTransition st = new ScaleTransition(Duration.millis(1000), hbox.getChildren().get(0));
       st.setByX(1.5);
       st.setByY(1.5);
       st.play();
        System.out.println("yoooooooooooooooooooooo");
       
        btn1.setDisable(true);
    }
    
    
    public void scaleforward (VBox hbox,int i)
           
   {  
       FadeTransition fade = new FadeTransition();  
       fade.setDuration(Duration.millis(1000)); 
        fade.setFromValue(10);  
        fade.setToValue(0);  
       fade.setNode(hbox.getChildren().get(i-1)); 
       fade.play();  
       TranslateTransition sttrans = new TranslateTransition(Duration.millis(1000), hbox.getChildren().get(i));
       
       ScaleTransition st = new ScaleTransition(Duration.millis(1000), hbox.getChildren().get(i));
       st.setByX(1.5);
       st.setByY(1.5);
        
       TranslateTransition st1trans = new TranslateTransition(Duration.millis(1000), hbox.getChildren().get(i-1));
       
       ScaleTransition st1 = new ScaleTransition(Duration.millis(1000), hbox.getChildren().get(i-1));
       st1.setByX(-1.5);
       st1.setByY(-1.5);
       st.play();
       st1.play();
   }
   
   public void scalebackwards (VBox hbox,int i)
           
   {   
       FadeTransition fade = new FadeTransition();  
       fade.setDuration(Duration.millis(1000)); 
        fade.setFromValue(0);  
        fade.setToValue(10);  
       fade.setNode(hbox.getChildren().get(i-1)); 
       fade.play();  
       ScaleTransition st = new ScaleTransition(Duration.millis(1000), hbox.getChildren().get(i-1));
       st.setByX(1.5);
       st.setByY(1.5);
       ScaleTransition st1 = new ScaleTransition(Duration.millis(1000), hbox.getChildren().get(i));
       st1.setByX(-1.5);
       st1.setByY(-1.5);
       st.play();
       st1.play();
   }

    @FXML
    private void btnclicked(ActionEvent event) {
        btn1.setDisable(false);
        TranslateTransition translate = new TranslateTransition(Duration.seconds(1),hbox);
        position=position-140;
        
        i++;
        if(i>2){btn.setDisable(true);}
        
        System.out.println("HBOX position = "+position);
        System.out.println("i= "+i);
           scaleforward(hbox,i);
            translate.setToY(position);
            translate.play();
    }

    @FXML
    private void btn1clicked(ActionEvent event) {
        
        if(i<=3){btn.setDisable(false);}
        TranslateTransition translate = new TranslateTransition(Duration.seconds(1),hbox);
        position=position+140;
        translate.setToY(position);
            translate.play();
           scalebackwards(hbox,i);
            i--;
            if(i==0){btn1.setDisable(true);}
            System.out.println("HBOX position = "+position);
            System.out.println("i= "+i);
    }
   
}
