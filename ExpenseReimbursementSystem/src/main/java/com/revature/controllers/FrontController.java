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
       
	private RequestHelper rh = new RequestHelper();
	
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRequestURI().substring(request.getContextPath().length());
		if(path.startsWith("/static/")) {
			super.doGet(request, response);
		} else {
			// send request/response to a request helper
			rh.processGet(request, response);
			
		}
		
	}
    // method processing all GET requests sent to the service
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rh.processPost(request, response);
	}

}
