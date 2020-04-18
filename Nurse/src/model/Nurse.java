package model;

import java.sql.*;

public class Nurse {

	// DB Connection
	public Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hcdb", "root", "");

			// For testing
			System.out.print("DB Successfully connected");
		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.print("DB not connected");
		}

		return con;
	}

	//Insert
	public String insertNurse(String name, String pwd, String gender, String email, String salary, String address,String phone) {

		String output = "";

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database";
			}

			// create a prepared statement
			String query = " insert into nursedetail(`nurseID`,`nurseName`,`nursePwd`,`nurseGender`,`nurseEmail`,`nurseSalary`,`nurseAddress`,`nursePhone`)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, name);
			preparedStmt.setString(3, pwd);
			preparedStmt.setString(4, gender);
			preparedStmt.setString(5, email);
			preparedStmt.setDouble(6, Double.parseDouble(salary));
			preparedStmt.setString(7, address);
			preparedStmt.setInt(8, Integer.parseInt(phone));

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";

		} catch (Exception e) {
			output = "Error while inserting";
			System.err.println(e.getMessage());
		}
		return output;
	}

	//Read
	public String readNurse() {

		String output = "";

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Nurse Name</th>" + "<th>Nurse Password</th><th>Gender</th>"
					+ "<th>Email</th>" + "<th>Salary</th><th>Address</th>" + "<th>Phone</th></tr>";

			String query = "select * from nursedetail";

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {

				String nurseID = Integer.toString(rs.getInt("nurseID"));
				String nurseName = rs.getString("nurseName");
				String nursePwd = rs.getString("nursePwd");
				String nurseGender = rs.getString("nurseGender");
				String nurseEmail = rs.getString("nurseEmail");
				String nurseSalary = Double.toString(rs.getDouble("nurseSalary"));
				String nurseAddress = rs.getString("nurseAddress");
				String nursePhone = Integer.toString(rs.getInt("nursePhone"));

				// Add into the html table
				output += "<tr><td>" + nurseName + "</td>";
				output += "<td>" + nursePwd + "</td>";
				output += "<td>" + nurseGender + "</td>";
				output += "<td>" + nurseEmail + "</td>";
				output += "<td>" + nurseSalary + "</td>";
				output += "<td>" + nurseAddress + "</td>";
				output += "<td>" + nursePhone + "</td>";

			

			}

			con.close();

			// Complete the html table
			output += "</table>";

		} catch (Exception e) {
			output = "Error while reading the items.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	//Update
	public String updateNurse(String ID, String name, String pwd, String gender, String email, String salary,String address, String phone) {

		String output = "";

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE nursedetail SET nurseName=?,nursePwd=?,nurseGender=?,nurseEmail=?,nurseSalary=?,nurseAddress=?,nursePhone=? WHERE nurseID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, name);
			preparedStmt.setString(2, pwd);
			preparedStmt.setString(3, gender);
			preparedStmt.setString(4, email);
			preparedStmt.setDouble(5, Double.parseDouble(salary));
			preparedStmt.setString(6, address);
			preparedStmt.setInt(7, Integer.parseInt(phone));
			preparedStmt.setInt(8, Integer.parseInt(ID));

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Updated successfully";

		} catch (Exception e) {
			output = "Error while updating the NurseDeatails.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	//Delete
	public String deleteNurse(String nurseID) {
		String output = "";

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from nursedetail where nurseID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(nurseID));

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";

		} catch (Exception e) {
			output = "Error while deleting the nurse Details.";
			System.err.println(e.getMessage());
		}
		return output;
	}
}
