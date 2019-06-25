package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.businesslogic.AuthenticationService;
import com.revature.models.Employee;

public class AuthenticationDelegate
{
	AuthenticationService authenticationTool = new AuthenticationService();
	ViewDelegate viewDelegate = new ViewDelegate();
	
	
	public AuthenticationDelegate()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	
	public void toAuthenticationService(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
			System.out.println("REACHED AUTHENTICATION DELEGATE. EMPLOYING SERVICE METHOD!");
			System.out.println("First, let's check null inputs.");
			
			// authenticate the user by getting the username and password they entered
			String username = request.getParameter("username");
			String password = request.getParameter("password");
//			boolean usernameValid = authenticationTool.usernameIsNotNull(username);
//			boolean passwordNotNull = authenticationTool.passwordIsNotNull(password);
			
			String token = "";
			boolean goodToken = false;
			
			// send the username and password to the service method for processing
			// the service method will then check their entry against the dao and assign a token
			Employee verifiedEmployee = authenticationTool.verifyEmployee(username, password);
			
			if (verifiedEmployee != null)
			{
				System.out.println("Redirecting you to be authenticated!");
				token = authenticationTool.authenticateEmployee(verifiedEmployee);
				
				// 
				goodToken = authenticationTool.isAuthorized(token);
				System.out.println("token is: " + token);
				System.out.println(token.substring(2));
			}
			else
			{
				System.out.println("We couldn't find you in the system! Time to go back to the login!");
				viewDelegate.directToView(request, response);
				
			}

			response.setHeader("authentication" , token);
	}
}
