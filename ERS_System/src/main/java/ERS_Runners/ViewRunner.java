package ERS_Runners;
//imports
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewRunner {
	
	public void returnView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRequestURI().substring(request.getContextPath().length());
		switch(path) {
		case "/":
			request.getRequestDispatcher("/static/login.html").forward(request, response);
			break;
		case "/login":
			request.getRequestDispatcher("/static/login.html").forward(request, response);
			break;
		case "/index":
			request.getRequestDispatcher("/static/index.html").forward(request, response);
			break;
		case "/create-req":
			request.getRequestDispatcher("/static/create-req.html").forward(request, response);
			break;
		case "/view-req":
			request.getRequestDispatcher("/static/view-req.html").forward(request, response);
			break;
		case "/view-users":
			request.getRequestDispatcher("/static/view-users.html").forward(request, response);
			break;
		case "/profile":
			request.getRequestDispatcher("/static/profile.html").forward(request, response);
			break;
		default:
			response.sendError(404, "Static Resource Not Found");
		}
	}
}