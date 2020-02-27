/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.user;
import Services.ServiceUser;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
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
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utils.MaConnection;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


/**
 * FXML Controller class
 *
 * @author Amine
 */
public class LoginController implements Initializable {
   
            
            
            
            
    
    ImageView iv = new ImageView();
    
     private Connection cnx;
    private Statement st;
    private PreparedStatement pst;
    private PreparedStatement pst1;
    private ResultSet rs;
    public static int test ;

    public LoginController() {
        cnx = MaConnection.getInstance().getConnection();
        

    }
    
    
    private AnchorPane ap;

    private JFXPasswordField txtpassword;

    private JFXTextField txtusername;
      @FXML
    private Button btnSigin;
    @FXML
    private AnchorPane bigAnchorPane;

    /**

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 @FXML
    private void btnSiginAction(ActionEvent event) throws IOException {
         AnchorPane pane=FXMLLoader.load(getClass().getResource("/gui/Home.fxml"));
       bigAnchorPane.getChildren().setAll(pane);
    }
    private void btnlogin(ActionEvent event) throws IOException, SQLException {
         System.out.println("aaa");
         if (txtusername.getText().equals("")&&txtpassword.getText().equals("")){
             System.out.println("verifier les champs");
         }
         else{
        user p = new user();
        p.setUsername(txtusername.getText());
        p.setPassword(txtpassword.getText());
        
        
        ServiceUser sp = new ServiceUser();
        test=sp.authentification(p);
        
        
          System.out.println(test);
          
          String query = "update fos_user set status='connected' where id="+test;
       
                st = cnx.createStatement();

                st.executeUpdate(query);
                
        if(test!=0){
            
        Stage stage = (Stage) ap.getScene().getWindow();
        
                System.out.println("redirect to acceuil");
            Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("fxml/acceuil.fxml"));
      
            //System.err.println(info);
          
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
         }
         }
         
        
   

    private void btnsignup(ActionEvent event) throws IOException {
        Stage stage = (Stage) ap.getScene().getWindow();
                System.out.println("affichage des utulisateurs");
            Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("fxml/inscription.fxml"));
            
            
      
            //System.err.println(info);
          
            Scene scene = new Scene(root);
          
            stage.setScene(scene);
            stage.show();
    }
    
   
    
}
