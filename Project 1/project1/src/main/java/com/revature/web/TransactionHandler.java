package com.revature.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.doa.TransactionDoa;

public class TransactionHandler {
	public void handleTransaction(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		int transId = Integer.parseInt(id);
		
		TransactionDoa td = new TransactionDoa();
		td.updateTransaction(transId);
	}
}
