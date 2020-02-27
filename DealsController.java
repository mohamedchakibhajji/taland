
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class DealsController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button viewcalendar;
    @FXML
    private AnchorPane deal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void viewcalendar(ActionEvent event) throws IOException {
        Stage stage = (Stage) deal.getScene().getWindow();
             
            Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("gui/FXMLDocument.fxml"));

            Scene scene = new Scene(root);
          
            stage.setScene(scene);
            stage.show();
    }
    
}
