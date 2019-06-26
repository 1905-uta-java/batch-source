package ERS_Actors;

import java.util.ArrayList;
import java.util.List;

/**
 * Description - Manager class that extends Employee. Unlike Employee, Manager can view other ERS_Requests that do not belong to Manager itself. Manager can also approve or deny pending ERS_Requests.
 * @author mattd
 * @version 1.0.0
 *
 */
public class Manager extends Employee {//class header
	//class attributes
	private List<ERS_Request> ersList = new ArrayList<>(); 
	
	/**
	 * Description - No args constructor for Manager. All attributes and Lists are set to null.
	 * @param - nothing.
	 * @returns - nothing.
	 * @throws - nothing.
	 */
	public Manager() {
		super();
	}
	
	/**
	 * Description - Argument constructor for Manager that will instantiate a Manager with the associated parameters as attributes.
	 * @param emp_id - Integer value that represents a Manager's ID.
	 * @param lastname - String that represents the manager's last name.
	 * @param firstname - String that represents the manager's first name.
	 * @param emp_pos - Integer value that represents the position that the manager has been hired into. (Please refer to EMP_Position table for more information)
	 * @param username - String that represents the username for the manager.
	 * @param password - String that represents the password for the username of the manager.
	 * @param email - String that represents the manager's email address.
	 * @returns - nothing.
	 * @throws - nothing.
	 */
	public Manager(int emp_id, String lastname, String firstname, int emp_pos, String username, String password, String email) {
		super(emp_id, lastname, firstname, emp_pos, username, password, email);
	}
	
	/**
	 * Description - Returns a List containing all existing ERS_Requests regardless of status
	 * @return - A List object containing ERS_Request objects, null if List is empty
	 * @throws - NullPointerException if list being queried is empty
	 */
	public List<ERS_Request> getAllRequests(){
		List<ERS_Request> tempList = new ArrayList<>(); //new List being returned
		
		try {
			for(int x = 0; x < ersList.size(); x++)
				tempList.add(ersList.get(x).deepCopy());
		} catch (NullPointerException e) { //ersList is empty
			return null;
		}
		
		
		return tempList;
	}
	
	/**
	 * Description - Returns a List of ERS_Requests with the status attribute of "pending"
	 * @return - A List object referencing all ERS_Request objects that have the status of "pending", null otherwise
	 * @throws - NullPointerException if the List being queried is empty
	 */
	public List<ERS_Request> getPendingRequests(){
		List<ERS_Request> tempList = new ArrayList<>(); //new List being returned
		
		try {
			for(int x = 0; x < ersList.size(); x++)
				if(ersList.get(x).getStatus().compareToIgnoreCase("pending") == 0)
					tempList.add(ersList.get(x).deepCopy());
		} catch (NullPointerException e) { //ersList is empty
			return null;
		}
		return tempList;
	}
	
	/**
	 * Description - Returns a List of ERS_Requests with the status attribute of "approved"
	 * @return - A List object referencing all ERS_Request objects that have the status of "approved", null otherwise
	 * @throws - NullPointerException if the List being queried is empty
	 */
	public List<ERS_Request> getApprovedRequests(){
		List<ERS_Request> tempList = new ArrayList<>(); //new List being returned
		
		try {
			for(int x = 0; x < ersList.size(); x++)
				if(ersList.get(x).getStatus().compareToIgnoreCase("approved") == 0)
					tempList.add(ersList.get(x).deepCopy());
		} catch (NullPointerException e) { //ersList is empty
			return null;
		}
		
		return tempList;
	}
	
	/**
	 * Description - Returns a List of ERS_Requests with the status attribute of "denied"
	 * @return - A List object referencing all ERS_Request objects that have the status of "denied", null otherwise
	 * @throws - NullPointerException if the List being queried is empty
	 */
	public List<ERS_Request> getDeniedRequests(){
		List<ERS_Request> tempList = new ArrayList<>(); //new List being returned
		
		try {
			for(int x = 0; x < ersList.size(); x++)
				if(ersList.get(x).getStatus().compareToIgnoreCase("denied") == 0)
					tempList.add(ersList.get(x).deepCopy());
		} catch (NullPointerException e) { //ersList is empty
			return null;
		}
		return tempList;
	}
	
	/**
	 * Description - Returns an ERS_Request object whose emp_id matches the parameter
	 * @param emp_id - Integer representation of the employee ID being requested
	 * @return - a List object containing all ERS_Requests belonging to the employee, null if employee has not made a request
	 * @throws - NullPointerException if the List being queried is empty
	 */
	public List<ERS_Request> getEmployeeRequest(int emp_id) {
		List<ERS_Request> tempList = new ArrayList<>(); //new List being returned
		
		try {
			for(int x = 0; x < ersList.size(); x++)
				if(ersList.get(x).getEmp_id() == emp_id)
					tempList.add(ersList.get(x).deepCopy());
		} catch (NullPointerException e) { //ersList is empty
			return null;
		}
		
		return tempList; //This emp_id doesn't exist or has not made a request
	}
	
	/**
	 * Description - Returns the ERS_Request with the req_id matching the paramter of req_id
	 * @param req_id - Integer representation of the req_id for the requested ERS_Request
	 * @return - a deep copy of the first instance ERS_Request matching the parameter since req_id are unique to each request, null if request doesn't exist
	 * @throws - NullPointerException if the List being queried is empty
	 */
	public ERS_Request getRequest(int req_id) {
		
		try {
			for(int x = 0; x < ersList.size(); x++)
				if(ersList.get(x).getEmp_id() == req_id)
					return ersList.get(x).deepCopy();
		} catch (NullPointerException e) { //ersList is empty
			return null;
		}
		
		return null; //This emp_id doesn't exist or has not made a request
	}
	
	/* Depending on implementation with servlets and javascript, may not be used.
	public boolean approveRequest(ERS_Request req) {
		
	}
	
	public boolean denyRequest(ERS_Request req) {
		
	}
	
	public boolean pendRequest(ERS_Request req) {
		
	}*/
	
	

}//end of class
