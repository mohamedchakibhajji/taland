/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.user;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import static javax.swing.JOptionPane.showMessageDialog;
import utils.MaConnection;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class HomeController implements Initializable {
     private Connection cnx;
    private Statement stm;
    private PreparedStatement pst;
    private PreparedStatement pst1;
    private ResultSet rs;
    @FXML
    private Button btnrateus;

    public HomeController() {
        cnx = MaConnection.getInstance().getConnection();
        

    }

    @FXML
    private Pane navePane;
    @FXML
    private Button btnHome;
    @FXML
    private Pane mainPane;
    @FXML
    private Button btnCompettions;
    @FXML
    private Button btnEvents;
    @FXML
    private Button btnDeals;
    @FXML
    private Button btnStore;
    @FXML
    private Button btnPosts;
    @FXML
    private Button btnSettings;
    @FXML
    private Button btnLogout;
    @FXML
    private AnchorPane bigAnchorPane;
    @FXML
    private Button btnExit;
    @FXML
    private ImageView btnNotification;
    @FXML
    private Button btnprofil;

    /**
     * Initializes the controller class.
     */
    
 
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        AnchorPane pane;
        try {
            pane = FXMLLoader.load(getClass().getResource("/gui/HomePage.fxml"));
            mainPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());;
        }

    }

    @FXML
    private void btnHomeAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/gui/HomePage.fxml"));
        mainPane.getChildren().setAll(pane);

        //  mainPane.getChildren().setAll(FXMLLoader.load("Login.fxml"));
    }

    @FXML
    private void btnCompetitionsAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/gui/Competitions.fxml"));
        mainPane.getChildren().setAll(pane);
    }

    @FXML
    private void btnEventsAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/gui/Events.fxml"));
        mainPane.getChildren().setAll(pane);
    }

    @FXML
    private void btnDealsAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/gui/Deals.fxml"));
        mainPane.getChildren().setAll(pane);
    }

    @FXML
    private void btnStoreAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/gui/Store.fxml"));
        mainPane.getChildren().setAll(pane);
    }

    @FXML
    private void btnPostsAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/gui/Posts.fxml"));
        mainPane.getChildren().setAll(pane);
    }

    @FXML
    private void btnSettingsAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/gui/Settings.fxml"));
        mainPane.getChildren().setAll(pane);
    }

    @FXML
    private void btnLogoutAction(ActionEvent event) throws IOException, SQLException {
        
         String query = "update fos_user set status='not connected'";
        
                stm = cnx.createStatement();
                

                stm.executeUpdate(query);
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/gui/Login.fxml"));
        bigAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void btnExitAction(ActionEvent event) {
        System.exit(0);
//        Alert alert = new Alert(AlertType.CONFIRMATION);
//        alert.setTitle("Confirmation Dialog");
//        alert.setHeaderText("Exit application");
//        alert.setContentText("Are you ok with this?");
//
//        Optional<ButtonType> result = alert.showAndWait();
//        if (result.get() == ButtonType.OK) {
//           System.exit(0);
//        }
       
    }

    @FXML
    private void btnNotificationAction(MouseEvent event) {
    }

    @FXML
    private void afficherprofil(ActionEvent event) throws IOException {
         AnchorPane pane = FXMLLoader.load(getClass().getResource("/gui/afficherprofil.fxml"));
        mainPane.getChildren().setAll(pane);
            
    }

    @FXML
    private void rateusaction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/gui/Rating.fxml"));
        mainPane.getChildren().setAll(pane);
        
    }

}
