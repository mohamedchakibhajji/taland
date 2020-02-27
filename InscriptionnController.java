/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.user;
import Services.ServiceUser;
import api.TrayIconDemo;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import java.awt.AWTException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import utils.mail;

/**
 * FXML Controller class
 *
 * @author Amine
 */
public class InscriptionnController implements Initializable {

    @FXML
    private TextField Txtlastname;
    @FXML
    private TextField TxtFirstname;
    @FXML
    private TextField Txtpassword;
    @FXML
    private TextField Txtemail;
    @FXML
    private TextField TxtBirthdate;
    @FXML
    private TextField TxtBiography;
    @FXML
    private Button btninscription;
    @FXML
    private ComboBox<String> ComboboxSexe;
    ObservableList<String> list=FXCollections.observableArrayList("Male","Female");
    @FXML
    private TextField TxtUsername;
    @FXML
    private AnchorPane anchorpane;
    @FXML
    private StackPane stackpane;
    @FXML
    private Label labelpane;
    @FXML
    private Button fermerpane;
    @FXML
    private Pane Pane;

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ComboboxSexe.setItems(list);
        labelpane.setVisible(false);
        fermerpane.setVisible(false);
        
    }    

    @FXML
    private void butooninscription(ActionEvent event) throws SQLException, IOException, Exception {
         System.out.println("test inscription");
         
        
        user p=new user();
      //  ServiceUser su =new ServiceUser();
       // if (su.verifexistance(p.getEmail(), p.getUsername())==0)
          p.setUsername(TxtUsername.getText());
        p.setPassword(Txtpassword.getText());
        p.setFirstname(TxtFirstname.getText());
        p.setLastname(Txtlastname.getText());
        p.setSexe(ComboboxSexe.getValue());
        
        p.setEmail(Txtemail.getText());
        p.setBirthdate(TxtBirthdate.getText());
        p.setBiography(TxtBiography.getText());
        p.setRoles("user");
        p.setRating(0);
        p.setStrike(0);
      
        
         
        ServiceUser sp = new ServiceUser();
        if (sp.verifexistance(p.getEmail(), p.getUsername())==0)
        {
            
            sp.addUser(p);
          System.out.println("insertion effectue");
          
        String[] args = null;
        //String
        try {
            TrayIconDemo.main(args);
        } catch (AWTException ex) {
            Logger.getLogger(InscriptionnController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
       
        Stage stage = (Stage) anchorpane.getScene().getWindow();
                System.err.println("bbb2");
            Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("gui/Login.fxml"));
      
            //System.err.println(info);
          
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else{
                 JFXDialogLayout dialoglayout = new JFXDialogLayout();
          
            BoxBlur blur = new BoxBlur(10,10,10);
             JFXDialog dialog = new JFXDialog(stackpane , dialoglayout , JFXDialog.DialogTransition.TOP);
             fermerpane.addEventHandler(MouseEvent.MOUSE_CLICKED , (MouseEvent mouseEvent)-> { 
                 dialog.close();
                    labelpane.setVisible(false);
        fermerpane.setVisible(false);
                 Pane.setEffect(null);
             });
          // Pane.setEffect(blur);
         
              stackpane.setEffect(null);
              
             labelpane.setVisible(true);
        fermerpane.setVisible(true);
             dialog.show();
               dialog.close();
                }
    }
        
     //   else{
           
       // }
        
        
    

   
    
}
