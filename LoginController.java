/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.user;
import Services.ServiceUser;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.awt.Desktop;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration.*;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import static javax.swing.JOptionPane.showMessageDialog;
import utils.MaConnection;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import utils.webcam;

/**
 * FXML Controller class
 *
 * @author Amine
 */
public class LoginController implements Initializable {

    private Connection cnx;
    private Statement st;
    private PreparedStatement pst;
    private PreparedStatement pst1;
    private ResultSet rs;
    public static int test;


    @FXML
    private ImageView taland;
    @FXML
    private Button btnSiginup;
    @FXML
    private StackPane stackpane;
     @FXML
    private Pane Pane;
     
    public LoginController() {
        cnx = MaConnection.getInstance().getConnection();

    }

    @FXML
    private TextField txtusername;

    @FXML
    private TextField txtpassword;
    @FXML
    private Button btnSigin;
    @FXML
    private AnchorPane bigAnchorPane;
  @FXML 
  private Label labelpane;
  @FXML 
  private Button fermerpane;
    /**
     *
     * /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       labelpane.setVisible(false);
        fermerpane.setVisible(false);

    }
    
   

    @FXML
    private void btnSiginAction(ActionEvent event) throws IOException, SQLException {
        System.out.println("aaa");
        if (txtusername.getText().equals("") && txtpassword.getText().equals("")) {
            System.out.println("verifier les champs");
             JFXDialogLayout dialoglayout = new JFXDialogLayout();
          
            BoxBlur blur = new BoxBlur(10,10,10);
             JFXDialog dialog = new JFXDialog(stackpane , dialoglayout , JFXDialog.DialogTransition.TOP);
             fermerpane.addEventHandler(MouseEvent.MOUSE_CLICKED , (MouseEvent mouseEvent)-> { 
                 dialog.close();
                    labelpane.setVisible(false);
        fermerpane.setVisible(false);
                  Pane.setEffect(null);
             });
           
         
              stackpane.setEffect(null);
              Pane.setEffect(blur);
             labelpane.setVisible(true);
        fermerpane.setVisible(true);
             dialog.show();
             dialog.close();
//            Alert alert = new Alert(AlertType.WARNING);
//            alert.setTitle("Warning Dialog");
//            
//            alert.setGraphic(new ImageView(this.getClass().getResource("/uploads/password.png").toString()));
//            alert.setHeaderText("Look, a Warning Dialog");
//            alert.setContentText("Verifier les champs");
//            alert.showAndWait();
        } else {
            user p = new user();
            p.setUsername(txtusername.getText());
            p.setPassword(txtpassword.getText());
            

            ServiceUser sp = new ServiceUser();
            test = sp.authentification(p);

            System.out.println(test);

            String query = "update fos_user set status='connected' where id=" + test;

            st = cnx.createStatement();

            st.executeUpdate(query);

            if (test != 0) {

                Stage stage = (Stage) bigAnchorPane.getScene().getWindow();
               

                System.out.println("redirect to acceuil");
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/Home.fxml"));
                 
                //System.err.println(info);
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }

    }

    @FXML
    private void btnSiginupAction(ActionEvent event) throws IOException {
        
        Stage stage = (Stage) bigAnchorPane.getScene().getWindow();
                System.out.println("affichage des utulisateurs");
            Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("gui/Inscriptionn.fxml"));
            
            
      
            //System.err.println(info);
          
            Scene scene = new Scene(root);
          
            stage.setScene(scene);
            stage.show();
    }

    private void loginfb(ActionEvent event) throws IOException, URISyntaxException {
        
        }
    }
    
    
      

   




