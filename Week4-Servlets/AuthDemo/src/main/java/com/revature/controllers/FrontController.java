package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends DefaultServlet {
	private static final long serialVersionUID = 1L;
      
	// create an instance of RequestHelper to process request each type of request
	private RequestHelper rh = new RequestHelper();	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // method processing all GET requests sent to the server
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// use the DefaultServlet's implementation to direct any static resources to the "static" folder within webapp folder
		if(request.getRequestURI().substring(request.getContextPath().length()).startsWith("/static/")) {
		
			super.doGet(request, response);
		
		} else {
			
			// send to request helper if uri does not include "/static/" representing a static resource 
			rh.processGet(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    // method processing all GET requests sent to the service
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rh.processPost(request, response);
	}

}
