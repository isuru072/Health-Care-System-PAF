<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.admin" %>
    
    
<%	
	if (request.getParameter("Admin_Name") != null) {
		admin Admin = new admin();
		String
		stsMsg = "";
		
		//Insert--------------------------
		if (request.getParameter("AdminIDSave") == "") {
			stsMsg = Admin.insertAdmin(request.getParameter("Admin_Name"),
					request.getParameter("Admin_Gender"), 
					request.getParameter("Admin_Address"),
					request.getParameter("Admin_Password"),
					request.getParameter("Admin_Phone"), 
					request.getParameter("Admin_Email")
					
					
					);
		} else//Update----------------------
		{
			stsMsg = Admin.updateAdmins(request.getParameter("AdminID"),
					request.getParameter("Admin_Name"), 
					request.getParameter("Admin_Gender"), 
					request.getParameter("Admin_Address"),
					request.getParameter("Admin_Password"),
					request.getParameter("Admin_Phone"), 
					request.getParameter("Admin_Email")
					);
		}
		session.setAttribute("statusMsg", stsMsg);
	}
	//Delete--------------------------------
	if (request.getParameter("DoctorID") != null) {
		admin
		Admin = new admin();
		String
		stsMsg = Admin.deleteAdmin(request
				.getParameter("AdminIDDelete"));
		session.setAttribute("statusMsg", stsMsg);
	}
%>	
    
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Admin_Insert</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="./Components/Admin.js"></script>
</head>
<body>
	<form id="formAdmin" name="formAdmin" method="post" action="Admin.jsp">
	   Admin Name: 
		<input id="Admin_Name" name="Admin_Name" type="text"
			class="form-control form-control-sm" required> <br>
	    NIC:
		<input id="Admin_Gender" name="Admin_Gender" type="text"
			class="form-control form-control-sm" required> <br> 
	    Admin Address:
		<input id="Admin_Address" name="Admin_Address" type="text"
			class="form-control form-control-sm" required> <br> 
		Admin Password:
		 <input id="Admin_Password" name="Admin_Password" type="text"  
			class="form-control form-control-sm" required> <br> 
		
	    Admin Phone:
	     <input id="Admin_Phone" name="Admin_Phone" type="text" placeholder="0xxxxxxxxx" maxlength="10"
			 pattern="^\d{10}$" class="form-control form-control-sm"required > <br> 
	   
		Admin Email:
		<input id="Admin_Email" name="Admin_Email" type="text"
			class="form-control form-control-sm" required> <br> 
			
	
					
		<input id="btnSave" name="btnSave" type="submit" value="Save" 
			class="btn btn-primary"  > 
		<input type="hidden" id="HospitalIDSave" name="HospitalIDSave" value="">	
		
	</form>

	<div id"alertSuccess" class="alert alert-success">
		<%
			out.print(session.getAttribute("statusMsg"));
		%>

	</div>

	<%
	 admin h1= new admin();
	out.print(h1.readAdmin());
	%>
		<script language="javascript">
		
</body>
</html>