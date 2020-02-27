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
import java.util.ArrayList;
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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import utils.MaConnection;
import utils.mail;

/**
 *
 * @author Amine
 */
public class StatisticsController implements Initializable{
    private Connection cnx;
    private Statement stm;
    private PreparedStatement pst;
    private PreparedStatement pst1;
    private ResultSet rs;
    private TextField totxxt;
    @FXML
    private TextField tosubject;
    @FXML
    private TextField tomessage;
    @FXML
    private ComboBox<String> comboboxemail;
    @FXML
    private Pane navePane;
    @FXML
    private Button btnHome1;
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
    private Button btnprofil;
    @FXML
    private Pane mailpane;
    @FXML
    private Pane paneuserslist;
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
    private TextField searchbar;
    @FXML
    private Button btnmail;
    @FXML
    private Button btnsendmail;

    public StatisticsController() {
        cnx = MaConnection.getInstance().getConnection();
        

    }
    

    @FXML
    private AnchorPane biganchorpane;
   // private Pane panecompetitions;
    //private Pane paneposts;
    //private Pane panestore;
    //private Pane panedelas;
    @FXML
    private Button statisticsbtn;
    @FXML
    private Button userlistbtn;
    @FXML
    private Button btnHome;
    @FXML
    private Button btnload;
    @FXML
    private BarChart<String, Integer> BarChart;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        paneuserslist.setVisible(false);
        mailpane.setVisible(false);
        String req="select email from fos_user";
        try {
            pst=cnx.prepareStatement(req);
            rs=pst.executeQuery();
            
            while(rs.next()){
                String email=rs.getString("email");
                comboboxemail.getItems().add(email);
                
            }
            
            
        } catch (SQLException ex) {
            System.out.println("erreur comboxemail");
        }
        
        
         ServiceUser  es = new ServiceUser();
        System.out.println("recherche");
        ArrayList<user> arrayList = null;
        
        try {
            arrayList = (ArrayList<user>) es.getAllP();
            System.out.println("recherche");
        } catch (SQLException ex) {
            System.out.println("erreur recherche");
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
       
       
       
            System.out.println("main");
        
       
        
    }


    @FXML
    private void stat(ActionEvent event) {
        mailpane.setVisible(false);
        BarChart.setVisible(true);
        paneuserslist.setVisible(false);
        btnload.setVisible(true);
        
    }

    @FXML
    private void userlist(ActionEvent event) throws IOException {
//           Stage stage = (Stage) biganchorpane.getScene().getWindow();
//                System.out.println("redirect to acceuil");
//                
//            Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("gui/Statistics.fxml"));
//           
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
    mailpane.setVisible(false);
    btnload.setVisible(false);
    BarChart.setVisible(false);
    paneuserslist.setVisible(true);


        
        
    }

    @FXML
    private void btnHomeAction(ActionEvent event) throws IOException {
//         Stage stage = (Stage) biganchorpane.getScene().getWindow();
//                System.out.println("redirect to acceuil");
//                
//            Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("gui/Home.fxml"));
//           
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
               
        
    }

    @FXML
    private void loadchart(ActionEvent event) {
        String req="select sexe,count(id) from fos_user where roles='user' group by sexe ";
        XYChart.Series<String,Integer> series=new XYChart.Series<>();
        try{
            rs=cnx.createStatement().executeQuery(req);
            while(rs.next()){
                series.getData().add(new XYChart.Data<>(rs.getString(1), rs.getInt(2)));
            }
            BarChart.getData().add(series);
            
            
            
        }catch(Exception e){
           System.out.println("erreur stat");
            
        }
        
    }

    @FXML
    private void sendmail(ActionEvent event)  {
       mailpane.setVisible(true);
       BarChart.setVisible(false);
       btnload.setVisible(false);
       paneuserslist.setVisible(false);
        
      
        
    }

    @FXML
    private void btnCompetitionsAction(ActionEvent event) {
    }

    @FXML
    private void btnEventsAction(ActionEvent event) {
    }

    @FXML
    private void btnDealsAction(ActionEvent event) {
    }

    @FXML
    private void btnStoreAction(ActionEvent event) {
    }

    @FXML
    private void btnPostsAction(ActionEvent event) {
    }

    @FXML
    private void btnSettingsAction(ActionEvent event) {
    }

    @FXML
    private void btnLogoutAction(ActionEvent event) {
    }

    @FXML
    private void afficherprofil(ActionEvent event) {
    }

    @FXML
    private void search(KeyEvent event) {
        searchbar.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                
                ServiceUser sn = new ServiceUser();
                ObservableList oblist = FXCollections.observableList(sn.rechercherNom(newValue));
                System.out.println("recherche");
                tableview.setItems(oblist);
            } catch (SQLException ex) {
                System.out.println("erreur recherche");
                
            }
            
       

        });
    }

    @FXML
    private void mailsendd(ActionEvent event) throws Exception {
         mail.main("mohamedamine.mbarki@esprit.tn", "amine20132013", comboboxemail.getValue(), tosubject.getText(), tomessage.getText());
    }
    
    
}
