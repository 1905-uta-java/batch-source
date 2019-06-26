package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

import JDBC_Conn.ERS_Connection;

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
		String path = request.getRequestURI().substring(request.getContextPath().length());
		if(path.startsWith("/static/"))
			super.doGet(request, response);
		else {
			rr.processGet(request, response);
			System.out.println("Firing");
			try {
				Connection con = ERS_Connection.getHardCodedConnection();
				System.out.println("Success");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//login
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rr.processPost(request, response);
	}
}
