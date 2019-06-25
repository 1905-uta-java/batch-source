package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.connectionUtil.ConnectionUtil;
import com.revature.models.Employee;
import com.revature.models.Request;

public class RequestDAOImpl implements RequestDAO
{

	@Override
	public List<Request> viewRequestsByEmployee(int emp_id)
	{
		List<Request> allRequests = new ArrayList<>();
		// System.out.println("We stepped in here!");
		
		// make a query
		String sql = "SELECT * FROM REQUESTS WHERE CREATED_BY = " + emp_id;
		// prepare a connection, a read statement, and result set
		try
		{
			Connection connection = ConnectionUtil.getHardCodedConnection();
			Statement readRequests = connection.createStatement();
			ResultSet readResults = readRequests.executeQuery(sql);
			
			while (readResults.next())
			{
				//System.out.println("WE HAVE SOMETHING IN THE RESULT SET!");
				int req_id = readResults.getInt("REQ_ID");
				int ammount = readResults.getInt("AMMOUNT");
				String reason = readResults.getString("REASON");
				String status = readResults.getString("STATUS");
				int createdBy = readResults.getInt("CREATED_BY");
				int resolvedBy = readResults.getInt("RESOLVED_BY");
				String outcome = readResults.getString("OUTCOME");
				
				allRequests.add(new Request(req_id, ammount, reason, status, createdBy, resolvedBy, outcome));
			}
			
			for (Request request : allRequests)
			{
				//System.out.println("Request found!");
				System.out.println(request);
			}
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// DON'T FORGET TO RETURN SOMETHING HERE
		return allRequests;
	}

	@Override
	public List<Request> viewPendingRequestsForYourself(int id)
	{
		// make a list to return
				List<Request> allPendingRequests = new ArrayList<>();
				
				// make a query
				String sql = "SELECT * FROM REQUESTS WHERE STATUS = 'PENDING' AND CREATED_BY = " + id;
				// prepare a connection, a read statement, and result set
				try
				{
					Connection connection = ConnectionUtil.getHardCodedConnection();
					Statement readRequests = connection.createStatement();
					ResultSet readResults = readRequests.executeQuery(sql);
					
					while (readResults.next())
					{
						int reqId = readResults.getInt("REQ_ID");
						int ammount = readResults.getInt("AMMOUNT");
						String reason = readResults.getString("REASON");
						String status = readResults.getString("STATUS");
						int createdBy = readResults.getInt("CREATED_BY");
						int resolvedBy = readResults.getInt("RESOLVED_BY");
						String outcome = readResults.getString("OUTCOME");
						
						allPendingRequests.add(new Request(reqId, ammount, reason, status, createdBy, resolvedBy, outcome));
					}
					
					for (Request request : allPendingRequests)
					{
						System.out.println(request + "for emp with id " + id);
					}
				} 
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// DON'T FORGET TO RETURN SOMETHING HERE
				return allPendingRequests;
		
	}

	@Override
	public List<Request> viewResolvedRequestsForYourself(int id)
	{
		List<Request> allResolvedRequests = new ArrayList<>();
		
		// make a query
		String sql = "SELECT * FROM REQUESTS WHERE STATUS = 'RESOLVED' AND CREATED_BY = " + id;
		// prepare a connection, a read statement, and result set
		try
		{
			Connection connection = ConnectionUtil.getHardCodedConnection();
			Statement readRequests = connection.createStatement();
			ResultSet readResults = readRequests.executeQuery(sql);
			
			while (readResults.next())
			{
				int reqId = readResults.getInt("REQ_ID");
				int ammount = readResults.getInt("AMMOUNT");
				String reason = readResults.getString("REASON");
				String status = readResults.getString("STATUS");
				int createdBy = readResults.getInt("CREATED_BY");
				int resolvedBy = readResults.getInt("RESOLVED_BY");
				String outcome = readResults.getString("OUTCOME");
				
				allResolvedRequests.add(new Request(reqId, ammount, reason, status, createdBy, resolvedBy, outcome));
			}
			
			for (Request request : allResolvedRequests)
			{
				System.out.println(request + "for emp with id " + id);
			}
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// DON'T FORGET TO RETURN SOMETHING HERE
		return allResolvedRequests;
	}

	@Override
	public List<Request> viewAllPendingRequestsManagers()
	{
		// make a list to return
		List<Request> allPendingRequests = new ArrayList<>();
		
		// make a query
		String sql = "SELECT * FROM REQUESTS WHERE STATUS = 'PENDING'";
		// prepare a connection, a read statement, and result set
		try
		{
			Connection connection = ConnectionUtil.getHardCodedConnection();
			Statement readRequests = connection.createStatement();
			ResultSet readResults = readRequests.executeQuery(sql);
			
			while (readResults.next())
			{
				int id = readResults.getInt("REQ_ID");
				int ammount = readResults.getInt("AMMOUNT");
				String reason = readResults.getString("REASON");
				String status = readResults.getString("STATUS");
				int createdBy = readResults.getInt("CREATED_BY");
				int resolvedBy = readResults.getInt("RESOLVED_BY");
				String outcome = readResults.getString("OUTCOME");
				
				allPendingRequests.add(new Request(id, ammount, reason, status, createdBy, resolvedBy, outcome));
			}
			
			for (Request request : allPendingRequests)
			{
				System.out.println(request);
			}
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// DON'T FORGET TO RETURN SOMETHING HERE
		return allPendingRequests;
	}

	@Override
	public List<Request> viewAllResolvedWithResolveInfo()
	{
		// make a list to return
				List<Request> allResolvedRequests = new ArrayList<>();
				System.out.println("ENTERED RESOLVED WITH RESOLVE INFO DAO");
				// make a query
				String sql = "SELECT * FROM REQUESTS WHERE STATUS = 'RESOLVED'";
				// prepare a connection, a read statement, and result set
				try
				{
					Connection connection = ConnectionUtil.getHardCodedConnection();
					Statement readRequests = connection.createStatement();
					ResultSet readResults = readRequests.executeQuery(sql);
					
					while (readResults.next())
					{
						System.out.println("We found something!");
						int id = readResults.getInt("REQ_ID");
						int ammount = readResults.getInt("AMMOUNT");
						String reason = readResults.getString("REASON");
						String status = readResults.getString("STATUS");
						int createdBy = readResults.getInt("CREATED_BY");
						int resolvedBy = readResults.getInt("RESOLVED_BY");
						String outcome = readResults.getString("OUTCOME");
						
						allResolvedRequests.add(new Request(id, ammount, reason, status, createdBy, resolvedBy, outcome));
					}
					
					for (Request request : allResolvedRequests)
					{
						System.out.println(request);
					}
				} 
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// DON'T FORGET TO RETURN SOMETHING HERE
				return allResolvedRequests;
	}

	@Override
	public int createRequest(Request r)
	{
		// prepare a query for the database-- prepared statement will use question marks
				// prepare an integer to return
				int requestsCreated = 0;
				
				String sql = "INSERT INTO REQUESTS "
						+ 	 "VALUES (?,?,?,?,?, NULL, NULL)";
				
				// Create a connection object using try with resources and use the connection to prepare a statement
				try(Connection connection = ConnectionUtil.getHardCodedConnection();
					PreparedStatement createRequest = connection.prepareStatement(sql))
				
				// bind the values in the prepared statement-- fill in the question marks
				{
					createRequest.setInt(1, r.getReqID());
					createRequest.setInt(2, r.getAmmount());
					createRequest.setString(3, r.getReason());
					createRequest.setString(4, r.getStatus());
					createRequest.setInt(5, r.getCreatedBy());
					//createRequest.setInt(6, r.getResolvedBy());
					
					// query is executed here
					requestsCreated = createRequest.executeUpdate();
					
				} 
				
				catch (SQLException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				// BE SURE TO RETURN SOMETHING HERE
				return requestsCreated;
		}
	

	@Override
	public int updateRequest(Request r)
	{
		int requestsUpdated = 0;
		
		// craft SQL statement -- will use prepared statements
		String sql = "UPDATE REQUESTS SET "
					+ "STATUS = ?, "
					+ "OUTCOME = ?,"
					+  "RESOLVED_BY = ?"
					+ "WHERE REQ_ID = " + r.getReqID();
		
		System.out.println(sql);
		
		// create connection object and use created connection to make prepared statement
		try(Connection connection = ConnectionUtil.getHardCodedConnection();
			PreparedStatement updateRequest = connection.prepareStatement(sql))
		{
			// bind values using methods from prepared statement-- fill in the question marks
			updateRequest.setString(1, r.getStatus());
			updateRequest.setString(2, r.getOutcome());
			updateRequest.setInt(3, r.getResolvedBy());
			
			
			// execute query using execute update method from prepared statement
			requestsUpdated = updateRequest.executeUpdate();
		} 
		
		catch (SQLException e1)
		{
				// TODO Auto-generated catch block
				e1.printStackTrace();
		}
		
		// 
		
		// BE SURE TO RETURN SOMETHING HERE
		return requestsUpdated;
	}
	
	
	
	public int getMaxReqID()
	{
		// establish query string
		String sql = "SELECT MAX(REQ_ID) AS REQ_ID FROM REQUESTS";
		int maxID = 0;
		try
		{
			// establish connection
			Connection connection = ConnectionUtil.getHardCodedConnection();
			// use connection object to create a statement
			Statement getMaxID = connection.createStatement();
			ResultSet results = getMaxID.executeQuery(sql);
			
			while (results.next())
			{
				maxID = results.getInt("REQ_ID");
				//System.out.println(maxID);
			}
			
		} 
		
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return maxID;
	}

	@Override
	public Request viewOneRequestByID(int req_id)
	{
		String sql = "SELECT * FROM REQUESTS WHERE REQ_ID = " + req_id;
		Request request = null;
		
		// To retrieve an employee, we need a connection
		try
		{
			Connection connection = ConnectionUtil.getHardCodedConnection();
			// prepare a statement using the connection object
			Statement readStatement = connection.createStatement();
			// set a result set equal to the results of the exectuted querry
			ResultSet readResults = readStatement.executeQuery(sql);
			
			// iterate through the result set to return each field from the database
			while (readResults.next())
			{
				int reqID = readResults.getInt("REQ_ID");
				int ammount = readResults.getInt("AMMOUNT");
				String reason = readResults.getString("REASON");
				String status = readResults.getString("STATUS");
				int createdBy = readResults.getInt("CREATED_BY");
				int resolvedBy = readResults.getInt("RESOLVED_BY");
				String outcome = readResults.getString("OUTCOME");
				
				request = new Request(reqID, ammount, reason, status, createdBy, resolvedBy, outcome);
			}
		} 
		
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.toString();
		return request;
	}
	

}
