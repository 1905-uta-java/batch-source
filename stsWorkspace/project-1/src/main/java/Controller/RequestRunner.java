package Controller;
//imports

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import runners.AuthRunner;
import runners.ERS_Runner;
import runners.EmployeeRunner;
import runners.ManagerRunner;
import runners.ViewRunner;

/**
 * Description - This class is used to determine and delegate requests to specific runners
 * @author mattd
 * @version - 1.0.0
 */
public class RequestRunner {
	//class attributes
	private AuthRunner au = new AuthRunner();
	private EmployeeRunner er = new EmployeeRunner();
	private ERS_Runner ers = new ERS_Runner();
	private ManagerRunner mr = new ManagerRunner();
	private ViewRunner vr = new ViewRunner();
	
	public void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		
		vr.returnView(request, response);
	}
	
	
	
	
	/**
	 * Description - Authenticates the user that is requesting to log into the ERS webapp
	 * @param request - contains the user provided information for login
	 * @param response - response provided by the webapp to return to the user
	 * @throws - nothing.
	 */
	public void processPost(HttpServletRequest request, HttpServletResponse response) {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		
		switch(uri) {
		case "/login":
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			//Get the AuthRunner to authenticate and generate a token for the user
			String token = au.authenticate(username, password);
			System.out.println(token);
			if(token == null || token == "") {
				response.setStatus(401);
				System.out.println("401 at processPost");
			} else {
				System.out.println("Login success. Token sent.");
				response.setStatus(200);
				response.setHeader("Token", token);
			}
			break;
		default:
			break;
		}
	}
	
	
}
