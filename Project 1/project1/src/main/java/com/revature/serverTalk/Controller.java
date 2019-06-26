package com.revature.serverTalk;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

public class Controller extends DefaultServlet {
	private static final long serialVersionUID = 1l;
	//private RequestHelp requestHelp = new RequestHelp();
	
	public Controller() {	super();		}
	
	RequestHelp requestHelp = new RequestHelp();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String directory = request.getRequestURI().substring(request.getContextPath().length());
		//System.out.println("dirctory: " + directory);
		if(directory.startsWith("/static")) {
			super.doGet(request, response);
		}
		else {
			requestHelp.processGet(request, response);

		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		requestHelp.processPost(request, response);
	}
}
