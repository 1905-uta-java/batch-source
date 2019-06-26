package com.revature.web;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.doa.EmployeeDoa;
import com.revature.doa.TransactionDoa;
import com.revature.model.FullTransaction;
import com.revature.model.Transaction;

public class newTransaction {
	public void addtrans(HttpServletRequest request, HttpServletResponse response) {
		String amount = request.getParameter("amount");
		String log = request.getParameter("log");
		String id = request.getParameter("id");
		
		EmployeeDoa ed = new EmployeeDoa();
		int manId = ed.getManagerId(id);
		
		FullTransaction ft = new FullTransaction();
		Transaction ta = ft.setTransactionFromEmployee(Integer.parseInt(id), Double.parseDouble(amount), log);
		
		TransactionDoa td = new TransactionDoa();
		
		try {
			td.createNewTransaction(ta);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
