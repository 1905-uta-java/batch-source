package serverTalk;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

public class Controller extends DefaultServlet {
	private static final long serialVersionUID = 1l;
	//private RequestHelp requestHelp = new RequestHelp();
	
	public Controller() {super();System.out.println("hi");}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("/static").forward(request, response);

	}
	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
//		String directory = request.getRequestURI().substring(request.getContextPath().length());
//		if(directory.equals("/median")) {
//			requestHelp.processGet(request, response);
//		}
//		else {
//			super.doGet(request, response);
//		}
//	}
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
//		requestHelp.proecessPost(request, response);
//	}
}
