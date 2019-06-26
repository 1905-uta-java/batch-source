package com.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.sql.Date;
import java.util.List;

import com.company.model.Events;
import com.company.util.ConnectionUtil;


public class EventsDaoImpl implements EventsDao{

	//Get all the events pertaining to an employee
	@Override
	public List<Events> getEvents() {
		//Store all the events and store in a list
		List<Events> events = new ArrayList<>();
		
		//SQL statement to get events that are from an employee
		String sql = "SELECT * FROM EVENTS";
	
		//Try connecting to the database and Run SQL
		try(Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);){
				
			ResultSet rs = ps.executeQuery();		
				
			//Get the information from SQL and put into an Events Object
			while(rs.next()) {
				
				int id = rs.getInt("ID");
				Date dateTime = rs.getDate("DATE_TIME");
				String message = rs.getString("MESSAGE");
				int eId = rs.getInt("EMP_ID");
							
				//Add the Events to the list
				events.add(new Events(id,dateTime,message,eId));
			}
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
					
		return events;
	}
		
	//Get all the events pertaining to an employee
	@Override
	public List<Events> getEmployeeEvents(int empId) {
		//Store all the events and store in a list
		List<Events> events = new ArrayList<>();
		
		//SQL statement to get events that are from an employee
		String sql = "SELECT * FROM EVENTS WHERE EMP_ID = ?";
	
		//Try connecting to the database and Run SQL
		try(Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);){
				
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();		
				
			//Get the information from SQL and put into an Events Object
			while(rs.next()) {
				
				int id = rs.getInt("ID");
				Date dateTime = rs.getDate("DATE_TIME");
				String message = rs.getString("MESSAGE");
				int eId = rs.getInt("EMP_ID");
							
				//Add the Events to the list
				events.add(new Events(id,dateTime,message,eId));
			}
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
					
		return events;
	}

	//Create a new event
	@Override
	public int createEvents(Events e) {
		int eventsCreated = 0;
		
		//SQL statement to add a new event
		String sql = "INSERT INTO EVENTS VALUES (?,?,?,?)";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, e.getId());
			ps.setDate(2, e.getDateTime());
			ps.setString(3, e.getMessage());
			ps.setInt(4, e.getEmpId());
			
			eventsCreated = ps.executeUpdate();
		
		}catch(SQLException x){
			x.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return eventsCreated;
	}

	//Update an existing event
	@Override
	public int updateEvents(Events e) {
		int eventsUpdated = 0;
		
		//SQL statement to update an event
		String sql = "UPDATE EVENTS "
						+ "SET DATE_TIME = ?, "
						+ "MESSAGE = ?, "
						+ "EMP_ID = ?, "
						+ "WHERE ID = ?";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(4, e.getId());
			ps.setDate(1, e.getDateTime());
			ps.setString(2, e.getMessage());
			ps.setInt(3, e.getEmpId());
			
			eventsUpdated = ps.executeUpdate();
		
		}catch(SQLException x){
			x.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return eventsUpdated;
	}

	//delete an event
	@Override
	public int deleteEvents(int id) {
		int rowsDeleted = 0;
		
		//SQL statement to Delete an event based on id
		String sql = "DELETE FROM EVENTS WHERE ID = ?";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, id);
			rowsDeleted = ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		return rowsDeleted;
	}

	
	//Get the next events ID
	@Override
	public int getNextEventsID() {
		List<Events> events = getEvents();
		Collections.sort(events,new Comparator<Events>() {

			public int compare(Events e1, Events e2) {
			    return Integer.compare(e1.getId(), e2.getId());
			}
		
		});
		int newId=0;
		
		if(events.size() == 0) {
			return 0;
		}
		else {
			newId = events.get(events.size()-1).getId();
		}
		
		return newId;
	}

}
