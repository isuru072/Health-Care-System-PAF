package com.resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.controller.cntStock;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.java.stock;





@Path("/Stock")
public class resStock {
	
	String baseUrl = "http://localhost";
	String PAYMENT_PORT = ":8080";
	
	stock appdata = new stock();
	
	
	//Read API
		@GET
		@Path("/")
		@Produces(MediaType.TEXT_HTML)
		public String readstock()
		{
			cntStock appdata = new cntStock();
			
		return appdata.readstock();
		}
	
		//Read API Hospital
		@GET
		@Path("/hospital")
		@Produces(MediaType.TEXT_HTML)
		public String gethospitaldetails() throws IOException
		{
			URL obj = new URL("http://localhost:8080/Payment/paymentAPI/Payments");
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			System.out.println("GET Response Code :: " + responseCode);
						
			if (responseCode == HttpURLConnection.HTTP_OK) { // success
				BufferedReader in = new BufferedReader(new InputStreamReader(
						con.getInputStream()));
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
	
	
	
	
	//Insert API
		@POST
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String insertstock(String appobj)
		{
			JsonObject apdat = new JsonParser().parse(appobj).getAsJsonObject();
			
			 int id = apdat.get("id").getAsInt();
			 String mname = apdat.get("mname").getAsString();
			 String description = apdat.get("description").getAsString();
			 int amount = apdat.get("amount").getAsInt();
			 int price = apdat.get("price").getAsInt();
			 
			 cntStock apdat2 = new cntStock();
			 
			 appdata.setId(id);
			 appdata.setMname(mname);
			 appdata.setDescription(description);
			 appdata.setAmount(amount);
			 appdata.setPrice(price);
			 
			
			 String output = apdat2.insertstock(appdata);
				return output;
		}
		
		
		
		//Update API
		@PUT
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String updateHospital(String appobject)
		{
		//Convert the input string to a JSON object
		 JsonObject apdat = new JsonParser().parse(appobject).getAsJsonObject();
		//Read the values from the JSON object
		 int id = apdat.get("id").getAsInt();
		 String mname = apdat.get("mname").getAsString();
		 String description = apdat.get("description").getAsString();
		 int amount = apdat.get("amount").getAsInt();
		 int price = apdat.get("price").getAsInt();
		 
		 
		 cntStock apdat1 = new cntStock();
		 
		 appdata.setId(id);
		 appdata.setMname(mname);
		 appdata.setDescription(description);
		 appdata.setAmount(amount);
		 appdata.setPrice(price);
		 
		 
		String output = apdat1.updatestock(appdata);
		return output;
		}
		
		//Delete API
		@DELETE
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String deletesto(String appobject){
		
		JsonObject apdat = new JsonParser().parse(appobject).getAsJsonObject();
		
		int id = apdat.get("id").getAsInt();

		cntStock apdat2 = new cntStock();
		appdata.setId(id);
		
		 String output = apdat2.deletestock(appdata);
		return output;
		}

	
	
	
	
		
}



