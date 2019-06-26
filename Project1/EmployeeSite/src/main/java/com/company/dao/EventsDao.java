package com.company.dao;

import java.util.List;

import com.company.model.Events;

public interface EventsDao {
	public List<Events> getEmployeeEvents(int empId);
	public int createEvents(Events e);
	public int updateEvents(Events e);
	public int deleteEvents(int eventId);
	public int getNextEventsID();
	public List<Events> getEvents();
}
