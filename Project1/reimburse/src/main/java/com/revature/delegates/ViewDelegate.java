package com.revature.delegates;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.revature.delegates.AuthDelegate;
import com.revature.delegates.EmployeeDelegate;
import com.revature.delegates.ReimbursementDelegate;
import com.revature.delegates.UserDelegate;

public class ViewDelegate {
//	private AuthDelegate ad = new AuthDelegate();
	private UserDelegate ud = new UserDelegate();
	private EmployeeDelegate ed = new EmployeeDelegate();
	private ReimbursementDelegate rd = new ReimbursementDelegate();

	
	public void returnView(HttpServletRequest request, HttpServletResponse response ) throws Exception {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		switch(uri) {
		case "users":
			// request appropriate user(s) from UserDelegate
			ud.getUsers(request, response);
			break;
		case "/":
			ed.getEmployees(request, response);
			break;
		case "/reimbursements":
			rd.getReimbursements(request, response);
			break;
		case "/employees":
			ed.getEmployees(request, response);
			break;
		case "/add":
			request.getRequestDispatcher("/static/Views/add-reimbursement-form.html").forward(request, response);			
			break;
		case "/login":
			request.getRequestDispatcher("/static/Login.html").forward(request, response);
			break;
		case "/home":
			request.getRequestDispatcher("/static/Home.html").forward(request, response);
			break;	
		case "/css/style.css":
			request.getRequestDispatcher("/static/Views/css/style.css").forward(request, response);			
			break;
		case "/static/Scripts/addReimbursementForm.js":
			request.getRequestDispatcher("/static/Scripts/addReimbursementForm.js").forward(request, response);			
			break;
		case "/static/Scripts/approvalPage.js":
			request.getRequestDispatcher("/static/Scripts/addReimbursementRequest.js").forward(request, response);			
			break;
		case "/static/Scripts/updateReimbursementForm.js":
			request.getRequestDispatcher("/static/Scripts/addReimbursementRequest.js").forward(request, response);			
			break;			
		case "/approve":
			request.getRequestDispatcher("/static/Views/approval-page.html").forward(request, response);
		case "/update":
			request.getRequestDispatcher("/static/Views/update-reimbursement-form.html").forward(request, response);
//			rd.getReimbursementById(request, response);
			break;
		default:
			response.sendError(404, "Static Resource Not Found");
		}
	}		
}
