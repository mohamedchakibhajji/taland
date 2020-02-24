/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.user;
import Services.ServiceUser;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * FXML Controller class
 *
 * @author Amine
 */
public class InscriptionController implements Initializable {

    @FXML
    private JFXTextField txtFirstname;
    @FXML
    private JFXTextField Txtlastname;
    @FXML
    private JFXTextField TxtRenterpassword;
    @FXML
    private JFXPasswordField Txtpassword;
    @FXML
    private JFXTextField Txtemail;
    @FXML
    private JFXTextField TxtBirthdate;
    @FXML
    private JFXTextField TxtBiography;
    @FXML
    private JFXComboBox<String> ComboboxSexe;
    ObservableList<String> list=FXCollections.observableArrayList("Male","Female");
    @FXML
    private Button btnvalider;
    @FXML
    private JFXTextField TxtUsername;
    @FXML
    private AnchorPane ap;
    @FXML
    private ListView photoview;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ComboboxSexe.setItems(list);
    }    

    @FXML
    private void inscription(ActionEvent event) throws SQLException, IOException {
         System.out.println("test inscription");
        
        user p=new user();
        p.setUsername(TxtUsername.getText());
        p.setPassword(Txtpassword.getText());
        p.setFirstname(txtFirstname.getText());
        p.setLastname(Txtlastname.getText());
        p.setSexe(ComboboxSexe.getValue());
        p.setEmail(Txtemail.getText());
        p.setBirthdate(TxtBirthdate.getText());
        p.setBiography(TxtBiography.getText());
        p.setRoles("user");
        p.setRating(0);
        p.setStrike(0);
        
        ServiceUser sp = new ServiceUser();
        sp.addUser(p);
          System.out.println("insertion effectue");
       
        Stage stage = (Stage) ap.getScene().getWindow();
                System.err.println("bbb2");
            Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("fxml/login.fxml"));
      
            //System.err.println(info);
          
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        
        
        
        
    }
     private void signinEt(ActionEvent event) throws SQLException, IOException {
        //Preferences userPreferences = Preferences.userRoot();    
       
    }

    @FXML
    private void choosefile(ActionEvent event) {
        FileChooser fc=new FileChooser();
        File selectedfile=fc.showOpenDialog(null);
        String path =selectedfile.getAbsolutePath();
        if(selectedfile!=null){
            photoview.getItems().add(path);
        }else{
            System.out.println("file is not valid");
        }
        
        
        
        
    }
    
}
