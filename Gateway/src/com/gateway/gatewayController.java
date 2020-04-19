package com.gateway;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/home")
public class gatewayController {
	@GET
	@Path("/payment")
	@Produces(MediaType.TEXT_HTML)
	public String getpaymentDetails() throws IOException {
		URL obj = new URL("http://localhost:8090/Payment/paymentAPI/Payments");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print result
			System.out.println(response.toString());
			return response.toString();
		} else {
			System.out.println("GET request not worked");
			return "GET request not worked";
		}
	}
	
	@GET
	@Path("/appoiment")
	@Produces(MediaType.TEXT_HTML)
	public String getHospitalDetails() throws IOException {
		URL obj = new URL("http://localhost:8090/Hospital/HospitalAPI/Appointment");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print result
			System.out.println(response.toString());
			return response.toString();
		} else {
			System.out.println("GET request not worked");
			return "GET request not worked";
		}
	}
	
	@GET
	@Path("/doctor")
	@Produces(MediaType.TEXT_HTML)
	public String getDoctorDetails() throws IOException {
		URL obj = new URL("http://localhost:8090/Hospital/HospitalAPI/Doctor");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print result
			System.out.println(response.toString());
			return response.toString();
		} else {
			System.out.println("GET request not worked");
			return "GET request not worked";
		}
	}
	
	@GET
	@Path("/patient")
	@Produces(MediaType.TEXT_HTML)
	public String getPatientDetails() throws IOException {
		URL obj = new URL("http://localhost:8090/Hospital/HospitalAPI/Patient");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print result
			System.out.println(response.toString());
			return response.toString();
		} else {
			System.out.println("GET request not worked");
			return "GET request not worked";
		}
	}

	@GET
	@Path("/prescription")
	@Produces(MediaType.TEXT_HTML)
	public String getPrescriptionDetails() throws IOException {
		URL obj = new URL("http://localhost:8090/Hospital/HospitalAPI/Prescription");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print result
			System.out.println(response.toString());
			return response.toString();
		} else {
			System.out.println("GET request not worked");
			return "GET request not worked";
		}
	}
	
	@GET
	@Path("/receptionist")
	@Produces(MediaType.TEXT_HTML)
	public String getReceptionistDetails() throws IOException {
		URL obj = new URL("http://localhost:8090/Hospital/HospitalAPI/Receptionist");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print result
			System.out.println(response.toString());
			return response.toString();
		} else {
			System.out.println("GET request not worked");
			return "GET request not worked";
		}
	}
	
	@GET
	@Path("/schedule")
	@Produces(MediaType.TEXT_HTML)
	public String getScheduleDetails() throws IOException {
		URL obj = new URL("http://localhost:8090/Hospital/HospitalAPI/Schedule");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print result
			System.out.println(response.toString());
			return response.toString();
		} else {
			System.out.println("GET request not worked");
			return "GET request not worked";
		}
	}
	
	@GET
	@Path("/admin")
	@Produces(MediaType.TEXT_HTML)
	public String getAdminDetails() throws IOException {
		URL obj = new URL("http://localhost:8090/Admin/AdminAPI/admin");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print result
			System.out.println(response.toString());
			return response.toString();
		} else {
			System.out.println("GET request not worked");
			return "GET request not worked";
		}
	}
	
	@GET
	@Path("/admin/doctor")
	@Produces(MediaType.TEXT_HTML)
	public String getAdminDoctorDetails() throws IOException {
		URL obj = new URL("http://localhost:8090/Admin/AdminAPI/doctor");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print result
			System.out.println(response.toString());
			return response.toString();
		} else {
			System.out.println("GET request not worked");
			return "GET request not worked";
		}
	}
	

	@GET
	@Path("/admin/hospital")
	@Produces(MediaType.TEXT_HTML)
	public String getAdminHospitalDetails() throws IOException {
		URL obj = new URL("http://localhost:8090/Admin/AdminAPI/hospital");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print result
			System.out.println(response.toString());
			return response.toString();
		} else {
			System.out.println("GET request not worked");
			return "GET request not worked";
		}
	}
	
	@GET
	@Path("/admin/payment")
	@Produces(MediaType.TEXT_HTML)
	public String getAdminPaymentDetails() throws IOException {
		URL obj = new URL("http://localhost:8090/Admin/AdminAPI/payment");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print result
			System.out.println(response.toString());
			return response.toString();
		} else {
			System.out.println("GET request not worked");
			return "GET request not worked";
		}
	}
	
	@GET
	@Path("/helpdoctor")
	@Produces(MediaType.TEXT_HTML)
	public String getHelpDoctorDetails() throws IOException {
		URL obj = new URL("http://localhost:8090/Nurse/NurseServiceAPI/HelpDoctor");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print result
			System.out.println(response.toString());
			return response.toString();
		} else {
			System.out.println("GET request not worked");
			return "GET request not worked";
		}
	}

	@GET
	@Path("/nurses")
	@Produces(MediaType.TEXT_HTML)
	public String getNursesDetails() throws IOException {
		URL obj = new URL("http://localhost:8090/Nurse/NurseServiceAPI/Nurses");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print result
			System.out.println(response.toString());
			return response.toString();
		} else {
			System.out.println("GET request not worked");
			return "GET request not worked";
		}
	}
	@GET
	@Path("/stock")
	@Produces(MediaType.TEXT_HTML)
	public String getStockDetails() throws IOException {
		URL obj = new URL("http://localhost:8090/Stock/StockAPI/Stock");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print result
			System.out.println(response.toString());
			return response.toString();
		} else {
			System.out.println("GET request not worked");
			return "GET request not worked";
		}
	}
}
