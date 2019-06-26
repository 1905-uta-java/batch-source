package com.company.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

public class FrontController extends DefaultServlet{
	private static final long serialVersionUID = 1L;
	
	//Our RequestHelper
	private RequestHelper rh = new RequestHelper();
	
	//default constructor
	public FrontController() {
		super();
	}
	
	//doGet to handle any GET requests
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//Check if the request is to go to a page
		if(request.getRequestURI().substring(request.getContextPath().length()).startsWith("/static/")) {
			super.doGet(request, response);
		}else {
			rh.processGet(request,response);
		}
		
		
		
	}
	
	//doPost to handle any POST requests to add information
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		rh.processPost(request, response);
	}
	
	//doPut to handle any PUT requests to update information
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		rh.processPut(request, response);
	}
	
	//doPost to handle any DELETE requests to add information
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		rh.processDelete(request, response);
	}

}
