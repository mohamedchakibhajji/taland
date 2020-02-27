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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void ajoutrating(ActionEvent event) throws SQLException, IOException {
        System.out.println("controller ajout rating ");
        user u =new user();
        ServiceUser su=new ServiceUser();
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
        
    }

    
}
