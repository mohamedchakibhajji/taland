/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.user;
import Services.ServiceUser;
import api.Excel;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import utils.pdfuser;

/**
 *
 * @author Amine
 */
public class listutulisateurs implements Initializable {
    
    Excel e=new Excel();
    
    @FXML
    private AnchorPane bigAnchorPane;
    @FXML
    private Pane navePane;
    @FXML
    private Button btnHome;
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
    private AnchorPane mainPane;
    @FXML
    private TableView<user> tableview;
    @FXML
    private TableColumn<user, Integer> colid;
    @FXML
    private TableColumn<user, String> colusername;
    @FXML
    private TableColumn<user, String> colemail;
    @FXML
    private TableColumn<user, String> colfirstname;
    @FXML
    private TableColumn<user, String> collastname;
    @FXML
    private TableColumn<user, String> colbirthdate;
    @FXML
    private TableColumn<user, String> colsexe;
    @FXML
    private TableColumn<user, String> colbiography;
    ObservableList<user> oblist=FXCollections.observableArrayList();
    @FXML
    private Button btnExit;
    @FXML
    private ImageView btnNotification;
    @FXML
    private Button btndeleteuser;
    @FXML
    private TextField searchbar;
    @FXML
    private Button btnexportexcel;
    @FXML
    private Button btnexportpdf;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceUser  es = new ServiceUser();
        System.out.println("fxml.AfficherEController.initialize()");
        ArrayList<user> arrayList = null;
        
        try {
            arrayList = (ArrayList<user>) es.getAllP();
            System.out.println("yezi");
        } catch (SQLException ex) {
            System.out.println("erreudeder");
        }
        ObservableList oblist = FXCollections.observableArrayList(arrayList);
        tableview.setItems(oblist);

       colid.setCellValueFactory(new PropertyValueFactory<user,Integer>("id"));
       colusername.setCellValueFactory(new PropertyValueFactory<user,String>("username"));
       colfirstname.setCellValueFactory(new PropertyValueFactory<user,String>("firstname"));
       collastname.setCellValueFactory(new PropertyValueFactory<user,String>("lastname"));
       colemail.setCellValueFactory(new PropertyValueFactory<user,String>("email"));
       colbirthdate.setCellValueFactory(new PropertyValueFactory<user,String>("birthdate"));
       colsexe.setCellValueFactory(new PropertyValueFactory<user,String>("sexe"));
       colbiography.setCellValueFactory(new PropertyValueFactory<user,String>("biography"));
       
       oblist.add(es);
       
       
       
            System.out.println("aaa");
               
        
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
    private void btnNotificationAction(MouseEvent event) {
    }
    @FXML
    private void deleteuser(ActionEvent event) {
        ServiceUser cs = new ServiceUser();
        user c = tableview.getSelectionModel().getSelectedItem();
        tableview.getItems().removeAll(tableview.getSelectionModel().getSelectedItem());
        cs.deleteUser(c);
    }

    @FXML
    private void exportexcel(ActionEvent event) throws InterruptedException {
        String[] args = null;
        e.main(args);
        
        
    }

    @FXML
    private void search(KeyEvent event) {
        searchbar.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                
                ServiceUser sn = new ServiceUser();
                ObservableList oblist = FXCollections.observableList(sn.rechercherNom(newValue));
                System.out.println("sazdszd");
                tableview.setItems(oblist);
            } catch (SQLException ex) {
                System.out.println("erreur recherche");
            }
            
       

        });
        
    }

    @FXML
    private void exportpdf(ActionEvent event) throws Exception {
        String[] args = null;
        pdfuser.main(args);
       
        
    }

    
    
}