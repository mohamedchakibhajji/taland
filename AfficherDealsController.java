/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import animatefx.animation.FadeIn;
import animatefx.animation.ZoomInUp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class AfficherDealsController implements Initializable {

    @FXML
    private Button buttonleft;
    @FXML
    private Button button;
    @FXML
    private VBox hbox;

    int position=0;
    ImageView imageview = new ImageView();
    int i=0;
    @FXML
    private Button btn;
    @FXML
    private Button btn1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficher();
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
        
    }
    
    
    public void scaleforward (VBox hbox,int i)
           
   {  
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
        
        
        TranslateTransition translate = new TranslateTransition(Duration.seconds(1),hbox);
        position=position-140;
        i++;
        
        System.out.println("HBOX position = "+position);
        System.out.println("i= "+i);
           scaleforward(hbox,i);
            translate.setToY(position);
            translate.play();
    }

    @FXML
    private void btn1clicked(ActionEvent event) {
        TranslateTransition translate = new TranslateTransition(Duration.seconds(1),hbox);
        position=position+140;
        translate.setToY(position);
            translate.play();
           scalebackwards(hbox,i);
            i--;
            System.out.println("HBOX position = "+position);
            System.out.println("i= "+i);
    }
    
}
