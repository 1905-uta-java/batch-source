package com.company.services;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.company.dao.EventsDao;
import com.company.dao.EventsDaoImpl;
import com.company.model.Events;

public class EventsService {
	EventsDao ed = new EventsDaoImpl();

	//Get events by employee id
	public List<Events> getByEmpId(int empId){
		return ed.getEmployeeEvents(empId);
	}
	
	//Create events
	public int create(Events e) {
		return ed.createEvents(e);
	}
	
	//Update events
	public int update(Events e) {
		return ed.updateEvents(e);
	}
	
	//Delete events
	public int delete(int id) {
		return ed.deleteEvents(id);
	}
	
	//Get next Event ID number
	public int getNextEventId() {
		return ed.getNextEventsID()+1;
	}
	
	//Convert a string date and time into a Date
	public Date convertDateTimeString(String dateTime) {
		SimpleDateFormat format = new SimpleDateFormat("MMddyy hh:mm");
        java.util.Date parsed;
		try {
			parsed = format.parse(dateTime);
			return new Date(parsed.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
