<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.hospital" %>
    
    
<%	
	if (request.getParameter("Hospital_Name") != null) {
		hospital Hospital = new hospital();
		String
		stsMsg = "";
		
		//Insert--------------------------
		if (request.getParameter("HospitalIDSave") == "") {
			stsMsg = Hospital.insertHospitals(request.getParameter("Hospital_Name"),
					request.getParameter("Hospital_Address"), 
					request.getParameter("Hospital_City"),
					request.getParameter("Hospital_Phone"),
					request.getParameter("Hospital_Email"), 
					request.getParameter("Hospital_Description"),
					request.getParameter("Open_Hours")
					
					);
		} else//Update----------------------
		{
			stsMsg = Hospital.updateHospitals(request.getParameter("Hospital_ID"),
					request.getParameter("Hospital_Name"), 
					request.getParameter("Hospital_Address"), 
					request.getParameter("Hospital_City"),
					request.getParameter("Hospital_Phone"),
					request.getParameter("Hospital_Email"), 
					request.getParameter("Hospital_Description"),
					request.getParameter("Open_Hours")
					);
		}
		session.setAttribute("statusMsg", stsMsg);
	}
	//Delete--------------------------------
	if (request.getParameter("DoctorID") != null) {
		hospital
		Hospital = new hospital();
		String
		stsMsg = Hospital.deleteHospitals(request
				.getParameter("DoctorlIDDelete"));
		session.setAttribute("statusMsg", stsMsg);
	}
%>	

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Hospital_Insert</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="./WEB-INF/Hospital.js"></script>
<style>
body{
	margin: 0;
	padding: 0;
	font-family: sans-serif;
}
.formBox{
	margin-top: 90px;
	padding: 50px;
}
.formBox  h1{
	margin: 0;
	padding: 0;
	text-align: center;
	margin-bottom: 50px;
	text-transform: uppercase;
	font-size: 48px;
}
.inputBox{
	position: relative;
	box-sizing: border-box;
	margin-bottom: 50px;
}
.inputBox .inputText{
	position: absolute;
    font-size: 24px;
    line-height: 50px;
    transition: .5s;
    opacity: .5;
}
.inputBox .input{
	position: relative;
	width: 4"0%;
	height: 40px;
	background: transparent;
	border: none;
    outline: none;
    font-size: 24px;
    border-bottom: 1px solid rgba(0,0,0,.5);

}
.focus .inputText{
	transform: translateY(-30px);
	font-size: 18px;
	opacity: 1;
	color: #00bcd4;

}
textarea{
	height: 100px !important;
}
.button{
	width: 100%;
    height: 50px;
    border: none;
    outline: none;
    background: #03A9F4;
    color: #fff;
}
</style>
</head>
<body>
	<form id="formHospital" name="formHospital" method="post" action="hospital.jsp">
		Hospital Name: 
		<input id="Hospital_Name" name="Hospital_Name" type="text"
			class="form-control form-control-sm" required> <br>
	    Contact No:
	     <input id="Hospital_Phone" name="Hospital_Phone" type="text" placeholder="0xxxxxxxxx" maxlength="10"
			 pattern="^\d{10}$" class="form-control form-control-sm"required > <br> 
		Address: 
		<input id="Hospital_Address" name="Hospital_Address" type="text"
			class="form-control form-control-sm" required> <br> 
		E-mail:
		 <input id="Hospital_Email" name="Hospital_Email" type="text"  
			class="form-control form-control-sm" required> <br> 
		
		Hospital_Description: 
		<input id="Hospital_Description" name="Hospital_Description" type="text"   
			class="form-control form-control-sm" required> <br>
	   
		Open_Hours:
		<input id="Open_Hours" name="Open_Hours" type="text"
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
	 hospital h1= new hospital();
	out.print(h1.readHospitals());
	%>
		<script language="javascript">
		
</body>
</html>