package ERS_Actors;

import java.util.ArrayList;
import java.util.List;

/**
 * Description - An Employee class that contains an ERS_Request list based on the employee id. This ERS_Request list can only be viewed. Employee can also make ERS_Requests of its own.
 * @author mattd
 * @version 1.0.0
 *
 */
public class Employee {//class header
	//class attributes
	private int emp_id, emp_pos;
	private String lastname, firstname, username, password, email;
	private ArrayList<ERS_Request> ersList;
	
	/**
	 * Description - No args constructor for Employee, ERS_Request list is empty and all attributes are set to null;
	 * @param - none
	 * @returns - nothing
	 * @throws - nothing
	 */
	public Employee() {
		
	}
	
	/**
	 * Description - Argument constructor that will instantiate an Employee object with the associated parameters as attributes.
	 * @param emp_id - Integer value that represents an employee ID.
	 * @param lastname - String that represents the employee's last name.
	 * @param firstname - String that represents the employee's first name.
	 * @param emp_pos - Integer value that represents the position that the employee has been hired into. (Please refer to EMP_Position table for more information)
	 * @param username - String that represents the username for the employee.
	 * @param password - String that represents the password for the username of the employee.
	 * @param email - String that represents the employee's email address.
	 * @returns - nothing.
	 * @throws - nothing.
	 */
	public Employee(int emp_id, String lastname, String firstname, int emp_pos, String username, String password, String email) {
		this.emp_id = emp_id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.emp_pos = emp_pos;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	/**
	 * Description - Returns a List containing all existing ERS_Requests regardless of status belonging to this Employee
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
	 * Description - Returns a List of ERS_Requests with the status attribute of "pending" belonging to this Employee
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
	 * Description - Returns a List of ERS_Requests with the status attribute of "approved" belonging to this Employee
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
	 * Description - Returns a List of ERS_Requests with the status attribute of "denied" belonging to this Employee
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
	 * Description - Adds a new ERS_Request to the Employee's list of requests.
	 * @param request - ERS_Request object that will be added to Employee's list of requests.
	 * @throws - nothing.
	 */
	public void setRequest(ERS_Request request) {
		ersList.add(request);
	}
	
	/**
	 * Description - Returns the Employee's ID
	 * @return - An Integer representation of this Employee's ID
	 * @throws - nothing
	 */
	public int getEmp_id() {
		return emp_id;
	}
	
	/**
	 * Description - Sets the emp_id of this Employee to the requested parameter
	 * @param emp_id - Integer representation of the desired emp_id
	 * @returns - nothing.
	 * @throws - nothing.
	 */
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	
	/**
	 * Description - Returns the position of the Employee
	 * @return - An integer representation of the employee's hired position
	 */
	public int getEmp_pos() {
		return emp_pos;
	}
	
	/**
	 * Description - Sets the Employee's position to a new position.
	 * @param emp_pos - Integer representation of the Employee's new position.
	 * @returns - Nothing.
	 * @throws - Nothing.
	 */
	public void setEmp_pos(int emp_pos) {
		this.emp_pos = emp_pos;
	}
	
	/**
	 * Description - Returns the last name of this Employee
	 * @return - String of the Employee's last name.
	 * @throws - Nothing.
	 */
	public String getLastname() {
		return lastname;
	}
	
	/**
	 * Description - Sets a new last name for this Employee.
	 * @param lastname - String of the desired new last name for this Employee.
	 * @returns - Nothing.
	 * @throws - Nothing.
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Description - Returns the first name of this Employee
	 * @return - String of the Employee's first name.
	 * @throws - Nothing.
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Description - Sets a new first name for this Employee.
	 * @param lastname - String of the desired new first name for this Employee.
	 * @returns - Nothing.
	 * @throws - Nothing.
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Description - Returns the username for this Employee.
	 * @return - String of the Employee's username.
	 * @throws - Nothing.
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * Description - Sets a new username for this Employee.
	 * @param username - String of the desired new username for this Employee.
	 * @returns - Nothing.
	 * @throws - Nothing.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Description - returns the password of this Employee.
	 * @return - String of the Employee's password.
	 * @throws - Nothing.
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Description - Sets a new password for this Employee.
	 * @param password - String representation of the desired password.
	 * @returns - Nothing.
	 * @throws - Nothing.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Description - Returns the email of this Employee.
	 * @return - String of the employee's email.
	 * @throws - Nothing.
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Description - Sets a new email for this Employee.
	 * @param email - a String representation of the desired email for this Employee.
	 * @returns - Nothing.
	 * @throws - Nothing.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + emp_id;
		result = prime * result + emp_pos;
		result = prime * result + ((ersList == null) ? 0 : ersList.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (emp_id != other.emp_id)
			return false;
		if (emp_pos != other.emp_pos)
			return false;
		if (ersList == null) {
			if (other.ersList != null)
				return false;
		} else if (!ersList.equals(other.ersList))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
	
	
}//end of class
