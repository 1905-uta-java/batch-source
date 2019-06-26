package ERS_Runners;
//imports

import com.mdo.util.Input;

import ERS_Actors.Employee;
import JDBC_ERS_DAO.Employee_DAO;
import JDBC_ERS_DAO.Employee_DAO_Implementation;


/**
* Description - This class is used for authenticating Employee and Manager logins
* @author mattd
* @version 1.0.0
*/
public class AuthRunner {
	//class attributes
	Employee_DAO emp_DAO = new Employee_DAO_Implementation();
	
	/**
	 * Description - Creates a string that will represent a login token for the user logging in on ERS webapp
	 * @param username - String representation of the user logging in
	 * @param password - String representation of the password that is used to authenticate the user logging in
	 * @return - String token to be used by the user for the current session
	 * @throws - nothing.
	 */
	public String authenticate(String username, String password) {
		String employee = null;
		
		Employee emp = emp_DAO.empLogin(username, password);
		
		if(emp != null)
			employee = emp.getEmp_id() + ":" + emp.getEmp_pos();
		
		return employee;
	}
	
	/**
	 * Description - Checks to see if the user's token matches the user in the db
	 * @param authToken - Session token that is used to authorize the user
	 * @return - true if the user is authorized, false otherwise
	 * @throws - NumberFormatException if the user id from the authToken is not a verifiable id.
	 */
	public boolean isAuthorized(String authToken) {
		if(authToken != null && authToken.split(":").length == 2) {
			String id = authToken.split(":")[0];
			String pos = authToken.split(":")[1];
			if(Input.isInputInt(id)) {
				Employee emp = emp_DAO.getEmployee(Integer.parseInt(id));
				if(emp != null && Integer.toString(emp.getEmp_pos()).equals(pos))
					return true;
			}
		}
		return false;
	}
	
}