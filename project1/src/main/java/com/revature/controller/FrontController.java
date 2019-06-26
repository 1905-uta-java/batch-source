package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import org.apache.catalina.servlets.DefaultServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.AuthDelegate;

public class FrontController extends DefaultServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private RequestHelper rh = new RequestHelper();
	private AuthDelegate ad = new AuthDelegate();
	
	public FrontController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		System.out.println("YO BUCKGET request in FrontController");
		if(request.getRequestURI().substring(request.getContextPath().length()).startsWith("/static/")){
			super.doGet(request, response);
		}
		else 
			rh.processGet(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		System.out.println("POST request in FrontController");
		rh.processPost(request, response);
	}
}
