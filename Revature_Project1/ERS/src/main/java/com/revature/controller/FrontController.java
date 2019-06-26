package com.revature.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

public class FrontController extends DefaultServlet {
	
private RequestHelper rh = new RequestHelper();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRequestURI().substring(request.getContextPath().length());
		if(path.startsWith("/Static/")) {
			super.doGet(request, response);
		} else {
			// send request/response to a request helper
			rh.processGet(request, response);
			
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rh.processPost(request, response);
	}
	

	
}
