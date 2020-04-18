package model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.bean.*;

import com.resources.connect;

public class payment {
connect DbObj = new connect();
	
	//Read Payment Details
		public String readPayment() {  
			String output = "";  


			try {  
				Connection con = DbObj.connectMethod();
				if (con == null)  {   
					return "Error while connecting to the database for reading.";  
				} 

			// Prepare the html table to be displayed   
			output = "<table border=\"1\"><tr><th> paymentType</th>"    +"" 
					+ "<th>paymentAmountr</th>"    + ""
					+ "<th>appointmentID</th>"    + ""
					 +"<th>Update</th><th>Remove</th></tr>"; 

			  String query = "select * from payment";   
			  Statement stmt = con.createStatement();   
			  ResultSet rs = stmt.executeQuery(query); 

			  // iterate through the rows in the result set   
			  while (rs.next())   {    
				  String paymentID = Integer.toString(rs.getInt("paymentID"));    
				  String paymentType = rs.getString("paymentType");    
				  String paymentAmount= rs.getString("paymentAmount"); 
				  String appointmentID = Integer.toString(rs.getInt("appointmentID "));
				  
				 

			   // Add into the html table    
			  output += "<tr><td>" + paymentID + "</td>";    
			  output += "<td>" + paymentType+ "</td>";
			  output += "<td>" +  paymentAmount + "</td>";    
			  output += "<td>" + appointmentID + "</td>"; 
			 

//			   // buttons    
	 		  output += "<td><input name=\"btnUpdate\" "     + " "
			  		+ "type=\"button\" value=\"Update\"></td>"     + ""
			  				+ "<td><form method=\"post\" action=\"payment.jsp\">"     + ""
			  						+ "<input name=\"btnRemove\" "     + " "
			  								+ "type=\"submit\" value=\"Remove\">"     + ""
			  										+ "<input name=\"paymentID\" type=\"hidden\" "     + " "
			  												+ "value=\"" + 
			  												paymentID + "\">" + "</form></td></tr>";   
			  } 

			  con.close(); 

			  // Complete the html table   
			  output += "</table>"; 
			}
			catch (Exception e) {  
				output = "Error while reading the Payment data.";  
				System.err.println(e.getMessage()); 
			}

			return output;
		}	
		public String insertPayment(String p_type, String p_amount, String appointment_id) {
			
			String output = "";

			try {
				Connection con = DbObj.connectMethod();

				if (con == null) {
					return "Error while connecting to the database";
				}

				// create a prepared statement   
				String query = " insert into payment (`paymentID`,`paymentType`,`paymentAmount`,` appointmentID`)"+" values (?, ?, ?, ?)";

				PreparedStatement preparedStmt = con.prepareStatement(query);

				// binding values 
				preparedStmt.setInt(1, 0);   
				preparedStmt.setString(2, p_type);   
				preparedStmt.setString(3, p_amount);    
				preparedStmt.setInt(4, Integer.parseInt(appointment_id));
				
				

				//execute the statement   
				preparedStmt.execute();   
				con.close(); 

				output = "Inserted successfully";
			}
			catch (Exception e) {   
				output = "Error while inserting the payment Details.";   
				System.err.println(e.getMessage());  
			} 

			 return output; 
		}
		
		public String updatePayment(String p_id, String p_type, String p_amount, String appointment_id)  {   
			String output = ""; 
		 
		  try   {   
			  Connection con = DbObj.connectMethod();
		 
			  if (con == null)    {
				  return "Error while connecting to the database for updating."; 
			  } 
		 
		   // create a prepared statement    
		   String query = "UPDATE payment SET paymentType=?,paymentAmount=?,appointmentID=?    "
		   		+ "			WHERE paymentID=?"; 
		 
		   PreparedStatement preparedStmt = con.prepareStatement(query); 
		 
		   // binding values    
		       
			preparedStmt.setString(1, p_type);   
			preparedStmt.setString(2, p_amount);    
			preparedStmt.setInt(3, Integer.parseInt(appointment_id));

		 
		   // execute the statement    
		   preparedStmt.execute();    
		   con.close(); 
		 
		   output = "Updated successfully";   
		   }   catch (Exception e)   {    
			   output = "Error while updating the payment details.";    
			   System.err.println(e.getMessage());   
		   } 
		 
		  return output;  
		  }
		
		public String deletePayment(String paymentID) {  
			String output = ""; 
		 
		 try  {   
			 Connection con = DbObj.connectMethod();
		 
		  if (con == null)   {    
			  return "Error while connecting to the database for deleting.";   
		  } 
		 
		  // create a prepared statement   
		  String query = "payment from admin where paymentID=?"; 
		 
		  PreparedStatement preparedStmt = con.prepareStatement(query); 
		 
		  
		  preparedStmt.setInt(1, Integer.parseInt(paymentID));       
		     
		  preparedStmt.execute();   
		  con.close(); 
		 
		  output = "Deleted successfully";  
		  }  catch (Exception e)  {   
			  output = "Sorry , Error while deleting the payment details.";   
			  System.err.println(e.getMessage());  
			  
		 } 
		 
		 return output; 
		 }
		
		
}
	
