/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.*; 
import java.sql.*; 
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.general.DefaultPieDataset;
import utils.MaConnection;

public class PieChart_DB {
 public static void main( String[ ] args )throws Exception {
      
  
      /* Create MySQL Database Connection */
      Class.forName( "com.mysql.jdbc.Driver" );
      Connection connect = DriverManager.getConnection( 
         "jdbc:mysql://localhost:3306/taland" ,     
         "root",     
         "");
      
      Statement statement = connect.createStatement( );
      ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
      DefaultPieDataset dataset = new DefaultPieDataset( );
      
      while( resultSet.next( ) ) {
         dataset.setValue( 
         resultSet.getString( "firstname" ) ,
         Double.parseDouble( resultSet.getString( "id" )));
      }
      
      JFreeChart chart = ChartFactory.createPieChart(
         "Statistiques",   // chart title           
         dataset,          // data           
         true,             // include legend          
         true,           
         false );

      int width = 560;    /* Width of the image */
      int height = 370;   /* Height of the image */ 
      File pieChart = new File( "stat.jpeg" );
      ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );
   }
}