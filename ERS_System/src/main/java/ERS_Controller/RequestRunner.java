package ERS_Controller;
//imports
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ERS_Runners.AuthRunner;
import ERS_Runners.ERS_Runner;
import ERS_Runners.EmployeeRunner;
import ERS_Runners.ManagerRunner;
import ERS_Runners.ViewRunner;



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
	
	/**
	 * Description - Processes GET requests from the client and executes the runner responsible for that request
	 * @param request - the request from the client
	 * @param response - response provided by the application
	 * @throws ServletException
	 * @throws IOException
	 */
	public void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(uri);
		if(uri.startsWith("/api/")) {
			String execute = uri.substring(5);
			System.out.println(execute);
			
			//select which runner to run
			switch(execute) {
			case "users":
				System.out.println("users");
				er.getAllUsers(request, response);
				break;
			case "requests":
				System.out.println("requests for a user");
				ers.getUserRequests(request, response);
				break;
			default:
				response.sendError(404, "Operation not found.");
			}
			
			
		} else {
			vr.returnView(request, response);
		}
	}
	
	
	
	
	/**
	 * Description - Processes Post requests from the client
	 * @param request - the request from the client
	 * @param response - response provided by the application
	 * @throws IOException 
	 */
	public void processPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
		case "/api/profile":
			System.out.println("getting user profile");
			er.getUserInfoById(request, response);
			break;
		case "/api/profile/update":
			System.out.println("updating user profile");
			er.updateUser(request, response);
			break;
		case "/api/create-req":
			System.out.println("creating request");
			ers.createRequest(request, response);
			break;
		case "/api/requests/approve":
			System.out.println("approving request");
			ers.approveRequest(request, response);
			break;
		case "/api/requests/deny":
			System.out.println("denying request");
			ers.denyRequest(request, response);
			break;
		case "/api/requests":
			ers.getRequestByUser(request, response);
			break;
		default:
			break;
		}
	}
	
	
}