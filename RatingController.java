/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.controlsfx.control.Rating;
import Entity.Ratings;
import Entity.user;
import Services.ServiceRatings;
import Services.ServiceUser;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amine
 */
public class RatingController implements Initializable {

    @FXML
    private AnchorPane bigAnchorPane;
    @FXML
    private Rating rateme;
    @FXML
    private Button btnsubmit;
    @FXML
    private TextField lbdescription;
    @FXML
    private Pane panerating;
    @FXML
    private Button btnupdate;
    int secconds=0;
     user u =new user();
     ServiceUser su=new ServiceUser();
    @FXML
    private Button btndeleterating;
    @FXML
    private Label labelrating;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            rateme.ratingProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> arg0, Number t, Number t1) {
              labelrating.setText("Rating:"+t1.toString());
            }

           
            
        });
       
        
    }    

    @FXML
    private void ajoutrating(ActionEvent event) throws SQLException, IOException {
        System.out.println("controller ajout rating ");
       
        int con=su.getconnecteduser();
        System.out.println("eyaaa"+con);
        Ratings r =new Ratings();
        u.setId(con);
        r.setRate((float) rateme.getRating());
        r.setDescription(lbdescription.getText());
        r.setIdu(con);
       
        Services.ServiceRatings sr = new ServiceRatings();
        sr.addRatings(r,u);
    
        System.out.println("ajout rating controller avec succes");
        
         Stage stage = (Stage) bigAnchorPane.getScene().getWindow();
                System.err.println("bbb2");
            Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("gui/Home.fxml"));
      
            //System.err.println(info);
           
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            btnupdate.setVisible(false);
            btnupdate.setVisible(true);
        
            
        
    }

    @FXML
    private void updaterating(ActionEvent event) throws SQLException, IOException {
        Ratings r=new Ratings();
        r.setDescription(lbdescription.getText());
        r.setRate((float) rateme.getRating());
      //  rateme.setRating(4.0);
      //rate2.setRating(rateme.getRating());
        ServiceRatings sr=new ServiceRatings();
        int con=su.getconnecteduser();
        u.setId(con);
        r.setIdu(con);
        sr.updateRatings(r, u);
        System.out.println("update");
        Stage stage = (Stage) bigAnchorPane.getScene().getWindow();
                System.err.println("bbb2");
            Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("gui/Home.fxml"));
      
            //System.err.println(info);
           
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        


       
    }

    @FXML
    private void deleterating(ActionEvent event) throws SQLException {
        ServiceRatings sr =new ServiceRatings();
        Ratings r =new Ratings();
        int con=su.getconnecteduser();
        u.setId(con);
        r.setIdu(con);
        sr.deleteratings(u, r);
        
    }

    
}
