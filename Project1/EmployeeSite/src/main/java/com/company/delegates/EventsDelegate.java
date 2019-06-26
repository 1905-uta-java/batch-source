package com.company.delegates;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.model.Events;
import com.company.services.EmployeeService;
import com.company.services.EventsService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EventsDelegate {
	private EventsService evs = new EventsService();
	private EmployeeService es = new EmployeeService();
	
	//Get employee's events
	public List<Events> getEmpEvents(HttpServletRequest request,HttpServletResponse response){
		String strId = request.getParameter("emp_id");
		int empId = es.convertIdString(strId);
		
		//Check if empId is 0
		if(empId == 0) {
			return null;
		}
		
		return evs.getByEmpId(empId);
	}
	
	//Create new event for an employee
	public int createEvents(HttpServletRequest request,HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Events newEvent = mapper.readValue(request.getInputStream(),Events.class);
//		String strDateTime = request.getParameter("date_time");
//		SimpleDateFormat format = new SimpleDateFormat("yyyyy.MMMMM.dd hh:mm aaa");
//		java.util.Date parsed;
//		Date dateTime = null;
//		try {
//			parsed = format.parse("strDateTime");
//			dateTime = new java.sql.Date(parsed.getTime());
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		String message = request.getParameter("message");
		
		//Generate a new event id
		int newId = evs.getNextEventId();
		
		
		newEvent.setId(newId);
		
		return evs.create(newEvent);
	}
	
	//Update an event of an employee
	public int updateEvents(HttpServletRequest request,HttpServletResponse response) {
		String strDate = request.getParameter("date_time");
		String message = request.getParameter("message");
		String strId = request.getParameter("emp_id");
		int empId = es.convertIdString(strId);
		String strEventId = request.getParameter("event_id");
		int eventId = es.convertIdString(strEventId);
		
		//Convert date time
		Date dateTime =evs.convertDateTimeString(strDate);
		
		//Check conversion was correct
		if(dateTime == null || empId == 0 || eventId == 0) {
			return 0;
		}
		
		
		return evs.update(new Events(eventId, dateTime, message, empId));
	}
	
	//Delete an event of an employee
	public int deleteEvents(HttpServletRequest request,HttpServletResponse response) {
		String strEventId = request.getParameter("event_id");
		int eventId = es.convertIdString(strEventId);
		
		//Check if Id is 0
		if(eventId == 0) {
			return 0;
		}
		
		return evs.delete(eventId);
	}
	
}
