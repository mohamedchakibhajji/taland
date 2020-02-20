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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class HomePageController implements Initializable {

    @FXML
    private Button btnuserslist;
    @FXML
    private AnchorPane biganchorpane;
    @FXML
    private Button btnstatistics;
    @FXML
    private Pane panecompetitions;
    @FXML
    private Pane paneposts;
    @FXML
    private Pane panestore;
    @FXML
    private Pane panedelas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void userslist(ActionEvent event) throws IOException {
        Stage stage = (Stage) biganchorpane.getScene().getWindow();
        
                System.out.println("redirect to acceuil");
                
            Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("gui/listutulisateurs.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
               
      
            //System.err.println(info);
          
            
            
            stage.show();
            
            
    }

    @FXML
    private void statistics(ActionEvent event) throws IOException {
       
        
        Stage stage = (Stage) biganchorpane.getScene().getWindow();
                System.out.println("redirect to acceuil");
                
            Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("gui/Statistics.fxml"));
           
            Scene scene = new Scene(root);
            stage.setScene(scene);
               
        
        
    }

    
}
