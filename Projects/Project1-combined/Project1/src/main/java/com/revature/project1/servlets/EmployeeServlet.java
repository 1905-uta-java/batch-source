package com.revature.project1.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project1.auth.AuthToken;
import com.revature.project1.models.Employee;
import com.revature.project1.service.AuthService;
import com.revature.project1.service.EmployeeService;
import com.revature.project1.service.ServiceManager;

/**
 * Servlet implementation class EmployeeServlet
 */
public class EmployeeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private AuthService authService = ServiceManager.getAuthService();
	private EmployeeService empService = ServiceManager.getEmpService();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ObjectMapper om = new ObjectMapper();
		
		String tokenString = request.getParameter("authToken");
		
		if(tokenString == null || tokenString.isEmpty()) {
			response.setStatus(401);
			return;
		}
		
		AuthToken token;
		
		try {
			
			token = om.readValue(tokenString, AuthToken.class);
			
		} catch(IOException e) {
			
			response.setStatus(401);
			return;
		}
		
		if(!authService.verifyToken(token)) {
			response.setStatus(401);
			return;
		}
		
		String target = request.getParameter("target");
		
		if(target == null || target.isEmpty()) {
			response.setStatus(400);
			return;
		}
		
		if("self".equals(target)) {
			
			Employee emp = empService.getEmployee(token.getUserId());
			
			String empString = om.writeValueAsString(emp);
			
			response.getWriter().write(empString);
			response.setStatus(200);
			
		} else if("subordinates".equals(target)) {
			
			List<Employee> subordinates = empService.getSubordinates(token.getUserId());
			
			String subordinatesString = om.writeValueAsString(subordinates);
			
			response.getWriter().write(subordinatesString);
			response.setStatus(200);
			
		} else {
			
			response.setStatus(400);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
