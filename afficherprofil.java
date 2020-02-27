/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.user;
import Services.ServiceUser;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import utils.Create_QR;
import utils.MaConnection;
import utils.cartepdf;
import utils.webcam;

/**
 *
 * @author Amine
 */
public class afficherprofil implements Initializable {
     private Connection cnx;
    private Statement stm;
    private PreparedStatement pst;
    private PreparedStatement pst1;
    private ResultSet rs;

  

    @FXML
    private AnchorPane bigAnchorPane;
    
    

    private AnchorPane mainPane;
    @FXML
    private TextField txtusername;
    @FXML
    private TextField txtfirstname;
    @FXML
    private TextField txtlastname;
    @FXML
    private TextField txtemail;
    @FXML
    private Button btnExit;
    @FXML
    private TextField txtpassword;
    @FXML
    private TextField txtbirthdate;
    @FXML
    private TextField txtbiography;
    @FXML
    private Button btnupdate;
    @FXML
    private Label lbusername;
    @FXML
    private Label lbfirstname;
    @FXML
    private Label lblastname;
    @FXML
    private Label lbemail;
    @FXML
    private Label lbpassword;
    @FXML
    private Label lbbirthdate;
    @FXML
    private Label lbbiography;
    @FXML
    private Button picturebtn;
    @FXML
    private Button btntalentcard;
    @FXML
    private Pane paneprofil;
    @FXML
    private Pane paneupdate;
    @FXML
    private Button btnupdateprofil;
    
      public afficherprofil() {
        cnx = MaConnection.getInstance().getConnection();
        

    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        paneupdate.setVisible(false);
    
        String req = "select * from fos_user where status='connected' ";
        try {
           /* String[] args = null;
            Webcamtest.main(args);*/
           
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);

            while (rs.next()) //  list.add(new Talentueux(rs.getString("Talent"),rs.getInt("NumTel"), rs.getString("Email"), rs.getString("DateNaissance")); //soit le nom de la colonne soit l'indice
            {
            System.out.println(rs.getString("firstname"));
            // attempt to put it in a textfield
           lbfirstname.setText(rs.getString("firstname"));
           lbpassword.setText("***********");
           lbemail.setText(rs.getString("email"));
           lbbiography.setText(rs.getString("biography"));
           lbbirthdate.setText(rs.getString("birthdate"));
           lbusername.setText(rs.getString("username"));
           lblastname.setText(rs.getString("lastname"));
           
                }

        } catch (SQLException ex) {
            System.out.println("asadad");
        
        }
        
        
    }    

    private void btnHomeAction(ActionEvent event) throws IOException {
        paneprofil.setVisible(false);
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/gui/HomePage.fxml"));
        mainPane.getChildren().setAll(pane);

        //  mainPane.getChildren().setAll(FXMLLoader.load("Login.fxml"));
    }

    private void btnCompetitionsAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/gui/Competitions.fxml"));
        mainPane.getChildren().setAll(pane);
    }

    private void btnEventsAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/gui/Events.fxml"));
        mainPane.getChildren().setAll(pane);
    }

    private void btnDealsAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/gui/Deals.fxml"));
        mainPane.getChildren().setAll(pane);
    }

    private void btnStoreAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/gui/Store.fxml"));
        mainPane.getChildren().setAll(pane);
    }

    private void btnPostsAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/gui/Posts.fxml"));
        mainPane.getChildren().setAll(pane);
    }

    private void btnSettingsAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/gui/Settings.fxml"));
        mainPane.getChildren().setAll(pane);
    }

    private void btnLogoutAction(ActionEvent event) throws IOException {
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
    private void updateprofil(ActionEvent event) throws IOException {
        
      
        
         System.err.println("modif");
        
        user p = new user();
        
     
        p.setUsername(txtusername.getText());
        p.setFirstname(txtfirstname.getText());
        p.setLastname(txtlastname.getText());
        p.setEmail(txtemail.getText());
        p.setPassword(txtpassword.getText());
        p.setBirthdate(txtbirthdate.getText());
        p.setBiography(txtbiography.getText());
      
        
       
      
        
       
        Services.ServiceUser sp = new ServiceUser();
        sp.updateUser(p);
        
          System.out.println("insertion effectue");
           AnchorPane pane = FXMLLoader.load(getClass().getResource("/gui/afficherprofil.fxml"));
        bigAnchorPane.getChildren().setAll(pane);
       
        
    }

    @FXML
    private void picture(ActionEvent event) throws IOException {
        System.out.println("sadzfegrhtry");
         String[] args = null;
        webcam.main(args);
    }

    @FXML
    private void exporttalentcard(ActionEvent event) throws IOException, Exception {
         String[] args = null;
        Create_QR.main(args);
        webcam.main(args);
        cartepdf.main(args);
    }

    @FXML
    private void updateprofill(ActionEvent event) {
        paneprofil.setVisible(false);
        paneupdate.setVisible(true);
    }


  

  
}
