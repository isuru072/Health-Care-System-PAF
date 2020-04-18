package com;

import model.Nurse;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

//SET PATH ..............................................
@Path("/Nurses")
public class NurseService {

	Nurse nurseObj = new Nurse();

	// Read
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)

	public String readNurse() {

		return nurseObj.readNurse();
	}

	// Insert
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertNurse(

			@FormParam("nurseName") String nurseName, @FormParam("nursePwd") String nursePwd,
			@FormParam("nurseGender") String nurseGender, @FormParam("nurseEmail") String nurseEmail,
			@FormParam("nurseSalary") String nurseSalary, @FormParam("nurseAddress") String nurseAddress,
			@FormParam("nursePhone") String nursePhone) {

		String output = nurseObj.insertNurse(nurseName, nursePwd, nurseGender, nurseEmail, nurseSalary, nurseAddress,
				nursePhone);
		return output;
	}

	// Update
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateNurse(String nurseData) {

		// Convert the input string to a JSON object
		JsonObject nurseObject = new JsonParser().parse(nurseData).getAsJsonObject();

		// Read the values from the JSON object
		String nurseID = nurseObject.get("nurseID").getAsString();
		String nurseName = nurseObject.get("nurseName").getAsString();
		String nursePwd = nurseObject.get("nursePwd").getAsString();
		String nurseGender = nurseObject.get("nurseGender").getAsString();
		String nurseEmail = nurseObject.get("nurseEmail").getAsString();
		String nurseSalary = nurseObject.get("nurseSalary").getAsString();
		String nurseAddress = nurseObject.get("nurseAddress").getAsString();
		String nursePhone = nurseObject.get("nursePhone").getAsString();

		String output = nurseObj.updateNurse(nurseID, nurseName, nursePwd, nurseGender, nurseEmail, nurseSalary,
				nurseAddress, nursePhone);

		return output;
	}

	// Delete
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteNurse(String nurseData) {

		// Convert the input string to an XML document
		Document doc = Jsoup.parse(nurseData, "", Parser.xmlParser());

		// Read the value from the element <nurseID>
		String nurseID = doc.select("nurseID").text();
		String output = nurseObj.deleteNurse(nurseID);
		return output;
	}

}
