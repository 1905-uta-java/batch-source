package com.reavture.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDaoImpl;

/**
 * Servlet implementation class reimburstment
 */
public class reimburstment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reimburstment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeeDaoImpl empDao = new EmployeeDaoImpl();
		HttpSession session = request.getSession();
		String email=(String)session.getAttribute("KeyEmail");
		PrintWriter out = response.getWriter();
		String amount =request.getParameter("txtnum");
		double reimburstment=Double.parseDouble(amount);
		String pending=(String)"Pending";
		empDao.updateReimburstment(reimburstment,pending,email);
		response.sendRedirect("manager.html");
	}

}
