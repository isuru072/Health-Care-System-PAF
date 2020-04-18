<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.payment" %>
    
    
<%	
	if (request.getParameter("Admin_Name") != null) {
		payment Payment = new payment();
		String
		stsMsg = "";
		
		//Insert--------------------------
		if (request.getParameter("PaymentIDSave") == "") {
			stsMsg = Payment.insertPayment(request.getParameter("paymentType"),
					request.getParameter("paymentAmount"), 
					request.getParameter("appointmentID")
					
					
					);
		} else//Update----------------------
		{
			stsMsg = Payment.updatePayment(request.getParameter("paymentID"),
					request.getParameter("paymentType"), 
					request.getParameter("paymentAmount"), 
					request.getParameter("appointmentID")
					);
		}
		session.setAttribute("statusMsg", stsMsg);
	}
	//Delete--------------------------------
	if (request.getParameter("DoctorID") != null) {
		payment
		Payment = new payment();
		String
		stsMsg = Payment.deletePayment(request
				.getParameter("PaymentIDDelete"));
		session.setAttribute("statusMsg", stsMsg);
	}
%>	
    
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Payment_Insert</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="./Components/Admin.js"></script>
</head>
<body>

	<form id="formPayment" name="formPayment" method="post" action="payment.jsp">
	   paymentType: 
		<input id="paymentType" name="paymentType" type="text"
			class="form-control form-control-sm" required> <br>
	   paymentAmount:
		<input id="paymentAmount" name="paymentAmount" type="text"
			class="form-control form-control-sm" required> <br> 
	   appointmentID:
		<input id="appointmentID" name="appointmentID" type="text"
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
	 payment h1= new payment();
	out.print(h1.readPayment());
	%>
		<script language="javascript">
		
</body>
</html>