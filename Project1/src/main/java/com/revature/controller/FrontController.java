package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

import com.revature.delegates.ViewDelegate;


public class FrontController extends DefaultServlet {
	private static final long serialVersionUID = 1L;
	
	RequestHelper rh = new RequestHelper();

    public FrontController() {
    	super();
        // TODO Auto-generated constructor stub
    
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ViewDelegate vd = new ViewDelegate();
		String path = request.getRequestURI().substring(request.getContextPath().length());
		

		if (path.startsWith("/static")) {
			super.doGet(request, response);
		} else {
			rh.processGet(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			rh.processPost(request, response);
			
	}

}