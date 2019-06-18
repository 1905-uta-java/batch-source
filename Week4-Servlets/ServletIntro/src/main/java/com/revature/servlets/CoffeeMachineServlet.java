package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.CoffeeMachine;
import com.revature.service.CoffeeMachineService;

public class CoffeeMachineServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private CoffeeMachineService cmService = new CoffeeMachineService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		// get all of our CoffeeMachines from our service layer 
		List<CoffeeMachine> cMachines = cmService.getCoffeeMachines();
		
		// use ObjectMapper to convert CoffeeMachines to JSON
		ObjectMapper om = new ObjectMapper();
		String cmString = om.writeValueAsString(cMachines);
//		System.out.println(cmString);
		
		// use PrintWriter to put JSON string into response body
		response.getWriter().print(cmString);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		// get request body from HttpServlet 
		String newObjJSON = request.getReader().readLine();
		
		System.out.println(newObjJSON);
		
		// user ObjectMapper to convert JSON to Object (CoffeeMachine)
		ObjectMapper om = new ObjectMapper();
		CoffeeMachine cm = om.readValue(newObjJSON, CoffeeMachine.class);
		
		System.out.println(cm.toString());
		
		// use CoffeeMachineService to add it to the list of CoffeeMachines
		cmService.addCoffeeMachine(cm);
		response.setStatus(201);
	}

}
