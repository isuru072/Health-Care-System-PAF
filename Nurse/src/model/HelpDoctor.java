package model;

import java.sql.*;

public class HelpDoctor {

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

	public String insertHelpDr(String NurseName, String DrName, String WardNo, String StartTime, String EndTime) {

		String output = "";

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database";
			}

			// create a prepared statement
			String query = " insert into helpdoctor(`helpID`,`helpNurseName`,`helpDrName`,`helpWardNo`,`helpStartTime`,`helpEndTime`)"
					+ " values (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, NurseName);
			preparedStmt.setString(3, DrName);
			preparedStmt.setString(4, WardNo);
			preparedStmt.setString(5, StartTime);
			preparedStmt.setString(6, EndTime);

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

	public String readHelpDr() {

		String output = "";

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Nurse Name</th>" + "<th>Doctor Name</th><th>Ward No</th>"
					+ "<th>Duty StartTime</th>" + "<th>DutyEndTime</th></tr>";

			String query = "select * from helpdoctor";

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {

				String helpID = Integer.toString(rs.getInt("helpID"));
				String helpNurseName = rs.getString("helpNurseName");
				String helpDrName = rs.getString("helpDrName");
				String helpWardNo = rs.getString("helpWardNo");
				String helpStartTime = rs.getString("helpStartTime");
				String helpEndTime = rs.getString("helpEndTime");

				// Add into the html table
				output += "<tr><td>" + helpNurseName + "</td>";
				output += "<td>" + helpDrName + "</td>";
				output += "<td>" + helpWardNo + "</td>";
				output += "<td>" + helpStartTime + "</td>";
				output += "<td>" + helpEndTime + "</td>";

				

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

	public String updateHelpDr(String helpID, String NurseName, String DrName, String WardNo, String StartTime,String EndTime) {

		String output = "";

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE helpdoctor SET helpNurseName=?,helpDrName=?,helpWardNo=?,helpStartTime=?,helpEndTime=? WHERE helpID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, NurseName);
			preparedStmt.setString(2, DrName);
			preparedStmt.setString(3, WardNo);
			preparedStmt.setString(4, StartTime);
			preparedStmt.setString(5, EndTime);
			preparedStmt.setInt(6, Integer.parseInt(helpID));

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Updated successfully";

		} catch (Exception e) {
			output = "Error while updating the Deatails.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deleteHelpDr(String helpID) {

		String output = "";

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from helpdoctor where helpID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(helpID));

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";

		} catch (Exception e) {
			output = "Error while deleting the  Details.";
			System.err.println(e.getMessage());
		}
		return output;
	}

}
