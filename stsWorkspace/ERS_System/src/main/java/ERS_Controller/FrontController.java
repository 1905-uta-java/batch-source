package ERS_Controller;
//imports
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

import JDBC_ERS_Conn.ERS_Connection;



public class FrontController extends DefaultServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5197505553529637397L;
	
	//class attributes
	private RequestRunner rr = new RequestRunner();

	public FrontController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		if(request.getRequestURI().substring(request.getContextPath().length()).startsWith("/static"))
			super.doGet(request, response);
		else {
			rr.processGet(request, response);
		}
	}
	
	//login
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		rr.processPost(request, response);
	}
}