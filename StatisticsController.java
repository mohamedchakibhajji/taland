/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
    @FXML
    private TextField totxxt;
    @FXML
    private TextField tosubject;
    @FXML
    private TextField tomessage;
    @FXML
    private Button sendmail;

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
       
        
    }


    @FXML
    private void stat(ActionEvent event) {
        
    }

    @FXML
    private void userlist(ActionEvent event) throws IOException {
           Stage stage = (Stage) biganchorpane.getScene().getWindow();
                System.out.println("redirect to acceuil");
                
            Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("gui/Statistics.fxml"));
           
            Scene scene = new Scene(root);
            stage.setScene(scene);
        
        
    }

    @FXML
    private void btnHomeAction(ActionEvent event) throws IOException {
         Stage stage = (Stage) biganchorpane.getScene().getWindow();
                System.out.println("redirect to acceuil");
                
            Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("gui/Home.fxml"));
           
            Scene scene = new Scene(root);
            stage.setScene(scene);
               
        
    }

    @FXML
    private void loadchart(ActionEvent event) {
        String req="select sexe,count(id) from fos_user group by sexe";
        XYChart.Series<String,Integer> series=new XYChart.Series<>();
        try{
            rs=cnx.createStatement().executeQuery(req);
            while(rs.next()){
                series.getData().add(new XYChart.Data<>(rs.getString(1), rs.getInt(2)));
            }
            BarChart.getData().add(series);
            
            
            
        }catch(Exception e){
            
        }
        
    }

    @FXML
    private void sendmail(ActionEvent event) throws Exception {
        mail.main("mohamedamine.mbarki@esprit.tn", "amine20132013", totxxt.getText(), tosubject.getText(), tomessage.getText());
        
    }
    
    
}
