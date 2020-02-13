/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 

import jxl.Workbook; 
import jxl.write.*; 
import utils.MaConnection;
/**
 *
 * @author mazen
 */
public class excel {
     public static void main(String[] args) throws InterruptedException {

        	WritableWorkbook wworkbook;
            try {
           	wworkbook = Workbook.createWorkbook(new File("C:\\Users\\Amine\\Documents\\NetBeansProjects\\Taland\\listusers.xls"));
          			
				MaConnection obj_DBConnection_LMC=new MaConnection();
				Connection connection=obj_DBConnection_LMC.getConnection();
				PreparedStatement ps=null;
				
				ResultSet rs=null;
				 
			 
	 			String query="SELECT id,firstname,lastname,email,username FROM `users`;";
			
		 			 
				
				ps=connection.prepareStatement(query);
				System.out.println(ps);
				rs=ps.executeQuery();
				 WritableSheet wsheet = wworkbook.createSheet("First Sheet", 0);
				 Label label = new Label(0, 2, "A label record");
				  wsheet.addCell(label);
		          int i=0;
				 
		           
		           int j=1;
				while(rs.next()){
					
					i=0;
					
					 
					 label = new Label(i++, j, rs.getString("id"));
					  wsheet.addCell(label);
					  label = new Label(i++, j, rs.getString("firstname"));
					  wsheet.addCell(label);
					  label = new Label(i++, j, rs.getString("lastname"));
					  wsheet.addCell(label);
                                          label = new Label(i++, j, rs.getString("email"));
					  wsheet.addCell(label);
                                          label = new Label(i++, j, rs.getString("username"));
					  wsheet.addCell(label);
					  
					  
					  
					 
					j++;
				}
				
				
				
            
            wworkbook.write();
            wworkbook.close();
            System.out.println("fineshed");
            
            
            
            
            
            } catch (Exception e) {
            System.out.println(e);
			}
        }

      
    
}