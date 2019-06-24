package com.revature.project1.servlets;

import java.io.IOException;
import java.util.Enumeration;
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
import com.revature.project1.util.InputCheckingUtil;
import com.revature.project1.util.PasswordUtil;

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
			response.getWriter().write("missing authToken");
			response.setStatus(401);
			return;
		}
		
		AuthToken token;
		
		try {
			
			token = om.readValue(tokenString, AuthToken.class);
			
		} catch(IOException e) {
			
			response.getWriter().write("invalid authToken");
			response.setStatus(401);
			return;
		}
		
		if(!authService.verifyToken(token)) {
			response.getWriter().write("invalid authToken");
			response.setStatus(401);
			return;
		}
		
		String source = request.getParameter("source");
		
		if(source == null || source.isEmpty()) {
			response.getWriter().write("missing source");
			response.setStatus(400);
			return;
		}
		
		if("self".equals(source)) {
			
			Employee emp = empService.getEmployee(token.getUserId());
			
			String empString = om.writeValueAsString(emp);
			
			response.getWriter().write(empString);
			response.setStatus(200);
			
		} else if("subordinates".equals(source)) {
			
			List<Employee> subordinates = empService.getSubordinates(token.getUserId());
			
			String subordinatesString = om.writeValueAsString(subordinates);
			
			response.getWriter().write(subordinatesString);
			response.setStatus(200);
			
		} else {
			
			response.getWriter().write("invalid source");
			response.setStatus(400);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ObjectMapper om = new ObjectMapper();
		
		String tokenString = request.getParameter("authToken");
		
		if(tokenString == null || tokenString.isEmpty()) {
			response.getWriter().write("missing authToken");
			response.setStatus(401);
			return;
		}
		
		AuthToken token;
		
		try {
			
			token = om.readValue(tokenString, AuthToken.class);
			
		} catch(IOException e) {
			
			response.getWriter().write("invalid authToken");
			response.setStatus(401);
			return;
		}
		
		if(!authService.verifyToken(token)) {
			response.getWriter().write("invalid authToken");
			response.setStatus(401);
			return;
		}
		
		String updateType = request.getParameter("updateType");
		
		if(updateType == null || updateType.isEmpty()) {
			response.getWriter().write("missing updateType");
			response.setStatus(400);
			return;
		}
		
		if("email".equals(updateType)) {
			
			String email = request.getParameter("email");
			
			if(email == null || email.isEmpty()) {

				response.getWriter().write("missing email");
				response.setStatus(400);
				return;
			}
			
			if(!InputCheckingUtil.isEmailValid(email)) {

				response.getWriter().write("invalid email");
				response.setStatus(400);
				return;
			}
			
			if(empService.isEmailTaken(email)) {

				response.getWriter().write("email taken");
				response.setStatus(400);
				return;
			}
			
			Employee emp = empService.getEmployee(token.getUserId());
			
			emp.setEmail(email);
			
			empService.updateEmployee(emp);
			
			response.setStatus(200);
			
		} else if("password".equals(updateType)) {
			
			String password = request.getParameter("password");
			
			if(password == null || password.isEmpty()) {

				response.getWriter().write("missing password");
				response.setStatus(400);
				return;
			}
			
			if(!PasswordUtil.isValidPassword(password)) {

				response.getWriter().write("invalid password");
				response.setStatus(400);
				return;
			}
			
			empService.updatePassword(token.getUserId(), password);
			
			response.setStatus(200);
			
		} else if("data".equals(updateType)) {
			
			String empString = request.getParameter("employee");
			
			Employee emp;
			
			try {
				
				emp = om.readValue(empString, Employee.class);
				
			} catch (IOException e) {
				
				response.getWriter().write("missing employee data");
				response.setStatus(401);
				return;
			}
			
			Employee storedEmp = empService.getEmployee(token.getUserId());
			
			storedEmp.setFirstName(emp.getFirstName());
			storedEmp.setLastName(emp.getLastName());
			storedEmp.setPhone(emp.getPhone());
			storedEmp.setAddress(emp.getAddress());
			storedEmp.setCity(emp.getCity());
			storedEmp.setState(emp.getState());
			storedEmp.setCountry(emp.getCountry());
			storedEmp.setPostalCode(emp.getPostalCode());
			
			empService.updateEmployee(storedEmp);
			
			response.setStatus(200);
			
		} else {
			
			response.getWriter().write("invalid updateType");
			response.setStatus(400);
		}
	}

}
