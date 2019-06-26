package com.revature.serverTalk;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.web.LoginPage;
import com.revature.web.NewEmployee;
import com.revature.web.TransactoinDisplay;
import com.revature.web.newTransaction;

public class RequestHelp{
	//create instance of each delegate to reference here

	LoginPage lp = new LoginPage();
	NewEmployee ne = new NewEmployee();
	TransactoinDisplay td = new TransactoinDisplay();
	newTransaction nt = new newTransaction();
	
	protected void processGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		processPost(request, response);
	}
	
		
	
	
	protected void processPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String directory = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("request dirctory: " + directory);

		switch(directory){
			case "/static":
				request.getRequestDispatcher("/static/index.html").forward(request, response);;
				break;	
			case "/login":
				lp.userLog(request, response);
				request.getRequestDispatcher("/static/loggedIn.html").forward(request, response);
				break;
			case "/newEmp":
				request.getRequestDispatcher("/static/newEmployee.html").forward(request, response);
			case "createEmployee":
				ne.createEmployee(request, response);
				break;
			case "/getTransactions":
				td.displayTransaction(request, response);
				break;
			case "/newTransaction":
				request.getRequestDispatcher("/static/newTransaction.html").forward(request, response);
				break;
			case "/addTransaction":
				nt.addtrans(request, response);
				break;
			default:
				System.out.println("defualt");
				break;
	}
	
	
}
}