<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.doctor" %>
    
    
<%	
	if (request.getParameter("DoctorName") != null) {
		doctor Doctor = new doctor();
		String
		stsMsg = "";
		
		//Insert--------------------------
		if (request.getParameter("DoctorIDSave") == "") {
			stsMsg = Doctor.insertDoctors(request.getParameter("DoctorName"),
					request.getParameter("NIC"), 
					request.getParameter("DepartmentName"),
					request.getParameter("Address"),
					request.getParameter("MobileNo"), 
					request.getParameter("Email"),
					request.getParameter("Specialization"),
					request.getParameter("HospitalName") 
					
					);
		} else//Update----------------------
		{
			stsMsg = Doctor.updateDoctors(request.getParameter("DoctorID"),
					request.getParameter("DoctorName"), 
					request.getParameter("NIC"), 
					request.getParameter("DepartmentName"),
					request.getParameter("Address"),
					request.getParameter("MobileNo"), 
					request.getParameter("Email"),
					request.getParameter("Specialization"),
					request.getParameter("HospitalName") 
					);
		}
		session.setAttribute("statusMsg", stsMsg);
	}
	//Delete--------------------------------
	if (request.getParameter("DoctorID") != null) {
		doctor
		Doctor = new doctor();
		String
		stsMsg = Doctor.deleteDoctors(request
				.getParameter("DoctorlIDDelete"));
		session.setAttribute("statusMsg", stsMsg);
	}
%>	
    
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Doctor_Insert</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="./Components/Hospital.js"></script>
</head>
<body>
	<form id="formDoctor" name="formDoctor" method="post" action="doctor.jsp">
	   Doctor Name: 
		<input id="DoctorName" name="DoctorName" type="text"
			class="form-control form-control-sm" required> <br>
	   NIC:
		<input id="NIC" name="NIC" type="text"
			class="form-control form-control-sm" required> <br> 
	   DepartmentName: 
		<input id="DepartmentName" name="DepartmentName" type="text"
			class="form-control form-control-sm" required> <br> 
		Address:
		 <input id="Address" name="Address" type="text"  
			class="form-control form-control-sm" required> <br> 
		
		 MobileNo
	     <input id="MobileNo" name="MobileNo" type="text" placeholder="0xxxxxxxxx" maxlength="10"
			 pattern="^\d{10}$" class="form-control form-control-sm"required > <br> 
	   
		Email:
		<input id="Email" name="Email" type="text"
			class="form-control form-control-sm" required> <br> 
			
		Specialization:
		<input id="Specialization" name="Specialization" type="text"
			class="form-control form-control-sm" required> <br> 
			
		Hospital Name:
		<input id="HospitalName" name="HospitalName" type="text"
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
	 doctor h1= new doctor();
	out.print(h1.readDoctors());
	%>
		<script language="javascript">
		
</body>
</html>