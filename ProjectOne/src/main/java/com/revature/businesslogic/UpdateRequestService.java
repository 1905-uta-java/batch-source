package com.revature.businesslogic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.RequestDAOImpl;
import com.revature.models.Request;

public class UpdateRequestService
{
	RequestDAOImpl reqDaoObject = new RequestDAOImpl();

	public UpdateRequestService()
	{
		super();
		
	}
	
	public void updateRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		
		// get full request body
		String fullBody = request.getReader().readLine();
		System.out.println("Full request body is: " + fullBody);
		String[] splitBodyAmp = fullBody.split("&");
		for (String string : splitBodyAmp)
		{
			System.out.println(string);
		}
		
		// isolate username and password from request body and put the full declaration into an array
		String fullBodyReqId = splitBodyAmp[0];
		String fullBodyOutcome = splitBodyAmp[1];
		String fullBodyToken = splitBodyAmp[2];
		
		System.out.println("FULL BODY REQ_ID " + fullBodyReqId);
		System.out.println("FULL BODY PASSWORD " + fullBodyOutcome);
		System.out.println("FULL BODY TOKEN " + fullBodyToken);
		
		// split username, password and ID arrays to obtain JUST the username, password, and ID
		String[]splitReqId = fullBodyReqId.split("=");
		String[]splitOutcome = fullBodyOutcome.split("=");
		String[]splitToken = fullBodyToken.split("=");
		
		String stringReqId = splitReqId[1];
		String outcome = splitOutcome[1];
		String token = splitToken[1];
		
		System.out.println("REQ_ID " + stringReqId);
		System.out.println("OUTCOME " + outcome);
		System.out.println(" TOKEN " + token);
		
		String resolvedByString = (String) token.subSequence(0, 1);
		System.out.println("StringReqId: " + stringReqId);
		int reqId = Integer.parseInt(stringReqId);
		int resolvedBy = Integer.parseInt(resolvedByString); 
		
		
		
//		
		
		
		
		
		
//		
		Request reqToUpdate = reqDaoObject.viewOneRequestByID(reqId);
//		
//		// prompt user to change fields
		String status = "RESOLVED";
		reqToUpdate.setStatus(status);
		reqToUpdate.setOutcome(outcome);
		reqToUpdate.setResolvedBy(resolvedBy);
		
			
		if (status != null && outcome != null && resolvedBy != 0)
		{
			System.out.println("All fields have values");
			reqDaoObject.updateRequest(reqToUpdate);
		}
	}
}
