package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.resources.connect;
import com.bean.*;

public class doctor {
	connect DbObj = new connect();
	
	//Read Doctors Details
	public String readDoctors() {  
		String output = "";  


		try {  
			Connection con = DbObj.connectMethod();
			if (con == null)  {   
				return "Error while connecting to the database for reading.";  
			} 

		// Prepare the html table to be displayed   
		output = "<table border=\"1\"><tr><th>Doctor Name</th>"    +"" 
				+ "<th>NIC</th><th>Department Name</th>"    + ""
				+ "<th>Address</th><th>Mobile No</th>"    + ""
				+ "<th>Email</th><th>Specialization</th>"    + ""
						+ "<th>Email</th><th>Specialization</th>" + ""
				        +"<th>Update</th><th>Remove</th></tr>"; 

		  String query = "select * from doctors";   
		  Statement stmt = con.createStatement();   
		  ResultSet rs = stmt.executeQuery(query); 

		  // iterate through the rows in the result set   
		  while (rs.next())   {    
			  String DoctorID = Integer.toString(rs.getInt("DoctorID"));    
			  String DoctorName = rs.getString("DoctorName");    
			  String NIC= rs.getString("NIC"); 
			  String DepartmentName= rs.getString("DepartmentName");
			  String Address = rs.getString("Address");    
			  String MobileNo = Integer.toString(rs.getInt("MobileNo"));
			  String Email = rs.getString("Email");
			  String Specialization = rs.getString("Specialization");
			  String HospitalName = rs.getString("HospitalName"); 

		   // Add into the html table    
		  output += "<tr><td>" + DoctorName + "</td>";    
		  output += "<td>" + NIC + "</td>";
		  output += "<td>" + DepartmentName + "</td>";    
		  output += "<td>" + Address + "</td>"; 
		  output += "<td>" + MobileNo + "</td>";    
		  output += "<td>" + Email + "</td>";
		  output += "<td>" +Specialization + "</td>"; 
		  output += "<td>" +HospitalName + "</td>";

//		   // buttons    
 		  output += "<td><input name=\"btnUpdate\" "     + " "
		  		+ "type=\"button\" value=\"Update\"></td>"     + ""
		  				+ "<td><form method=\"post\" action=\"doctor.jsp\">"     + ""
		  						+ "<input name=\"btnRemove\" "     + " "
		  								+ "type=\"submit\" value=\"Remove\">"     + ""
		  										+ "<input name=\"DoctorID\" type=\"hidden\" "     + " "
		  												+ "value=\"" + 
		  												DoctorID + "\">" + "</form></td></tr>";   
		  } 

		  con.close(); 

		  // Complete the html table   
		  output += "</table>"; 
		}
		catch (Exception e) {  
			output = "Error while reading the Doctor data.";  
			System.err.println(e.getMessage()); 
		}

		return output;
	}	
	public String insertDoctors(String name, String nic, String departmentName, String address, String mobileNo, String email, String specialization, String hospitalName) {
		String output = "";

		try {
			Connection con = DbObj.connectMethod();

			if (con == null) {
				return "Error while connecting to the database";
			}

			// create a prepared statement   
			String query = " insert into doctors (`DoctorID`,`DoctorName`,`NIC`,`DepartmentName`,`Address`,`MobileNo`,`Email`,`Specialization`,`HospitalName`)"+" values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values 
			preparedStmt.setInt(1, 0);   
			preparedStmt.setString(2, name);   
			preparedStmt.setString(3, nic);    
			preparedStmt.setString(4, departmentName);
			preparedStmt.setString(5,  address);
			preparedStmt.setInt(6, Integer.parseInt(mobileNo));
			preparedStmt.setString(7, email);
			preparedStmt.setString(8, specialization);  
			preparedStmt.setString(9, hospitalName);  
			

			//execute the statement   
			preparedStmt.execute();   
			con.close(); 

			output = "Inserted successfully";
		}
		catch (Exception e) {   
			output = "Error while inserting the Hospitals.";   
			System.err.println(e.getMessage());  
		} 

		 return output; 
	}
	
	public String updateDoctors(String doc_id, String name, String nic, String departmentName, String address, String mobileNo, String email, String specialization, String hospitalName)  {   
		String output = ""; 
	 
	  try   {   
		  Connection con = DbObj.connectMethod();
	 
		  if (con == null)    {
			  return "Error while connecting to the database for updating."; 
		  } 
	 
	   // create a prepared statement    
	   String query = "UPDATE doctors SET DoctorName=?,NIC=?,DepartmentName=?,Address=?,MobileNo=?,Email=?,Specialization=?,HospitalName=?      "
	   		+ "			WHERE DoctorID=?"; 
	 
	   PreparedStatement preparedStmt = con.prepareStatement(query); 
	 
	   // binding values    
	   preparedStmt.setInt(1, 0);   
		preparedStmt.setString(2, name);   
		preparedStmt.setString(3, nic);    
		preparedStmt.setString(4, departmentName);
		preparedStmt.setString(5,  address);
		preparedStmt.setInt(6, Integer.parseInt(mobileNo));
		preparedStmt.setString(7, email);
		preparedStmt.setString(8, specialization);  
		preparedStmt.setString(9, hospitalName);  
		preparedStmt.setInt(10, Integer.parseInt(doc_id));

	 
	   // execute the statement    
	   preparedStmt.execute();    
	   con.close(); 
	 
	   output = "Updated successfully";   
	   }   catch (Exception e)   {    
		   output = "Error while updating the Hospitals.";    
		   System.err.println(e.getMessage());   
	   } 
	 
	  return output;  
	  }
	
	public String deleteDoctors(String doc_id) {  
		String output = ""; 
	 
	 try  {   
		 Connection con = DbObj.connectMethod();
	 
	  if (con == null)   {    
		  return "Error while connecting to the database for deleting.";   
	  } 
	 
	  // create a prepared statement   
	  String query = "delete from doctors where DoctorID=?"; 
	 
	  PreparedStatement preparedStmt = con.prepareStatement(query); 
	 
	  
	  preparedStmt.setInt(1, Integer.parseInt(doc_id));       
	     
	  preparedStmt.execute();   
	  con.close(); 
	 
	  output = "Deleted successfully";  
	  }  catch (Exception e)  {   
		  output = "Sorry , Error while deleting the doctors details.";   
		  System.err.println(e.getMessage());  
		  
	 } 
	 
	 return output; 
	 }

}
