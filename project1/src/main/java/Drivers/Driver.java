package Drivers;

import com.revature.daos.EmployeeDao;
import com.revature.daos.EmployeeDaoImpl;
import com.revature.daos.ReimburseDao;
import com.revature.daos.ReimburseDaoImpl;
import com.revature.daos.UserDao;
import com.revature.daos.UserDaoImpl;
import com.revature.models.Employee;
import com.revature.models.Reimburse;
import com.revature.models.User;

public class Driver {
	
	public static void main(String[] args) {
		
		
		UserDao ud = new UserDaoImpl();
		EmployeeDao ed = new EmployeeDaoImpl();
		ReimburseDao rd = new ReimburseDaoImpl();
		
		
		User user = new User("dog", "password", "20-JUN-19", 5, "user", "token");
		Employee employee = new Employee(5, "Perky", "Plane", "pplane@gmail.com", "14-JAN-50", 1, "janitor");
		Reimburse reimburse = new Reimburse(10, "Dog died", 400.00, "15-MAY-90", "15-MAY-91", "Rejected", 1, 5);
		
		
		//add new employee - WORKS
		System.out.println("\n\nAdd new Employee: \n");
		System.out.println(ed.addEmployee(employee));
		
		
		//Get all employees
		System.out.println("\n\nGet all Employees: \n");
		System.out.println(ed.getAllEmployees());
		
		//get employee by ID 1
		System.out.println("\n\nEmployee with ID 1: \n");
		System.out.println(ed.getEmpById(1));
		//get employee with N/A ID
		System.out.println("\n\nEmployee with ID 10 (doesn't exist): \n");
		System.out.println(ed.getEmpById(10));
		
		//update emplpyee
		System.out.println("\n\nUpdate Employee with ID 3 : \n");
		Employee updEmp = new Employee(3, "Scott", "Pilgrim", "scottpilgrimizkewl@gmail.com", "1-JAN-19", 1, "Cashier");
		System.out.println(ed.updateEmployee(updEmp));
		
		
		//delete employee
		System.out.println("\n\nDelete Employee with ID 5 : \n");
		System.out.println(ed.deleteEmployee(5));
		
		//EMPLOYEE GOOD!!
		
		/*
		//USER test
		//get all users
		System.out.println("\n\nGet all Users : \n");
		System.out.println(ud.getAllUsers());
		
		
		//get user by username
		System.out.println("\n\nGet user by username: \n");
		System.out.println(ud.getUserByUsername("jcross"));
		
		
		//create user 
		System.out.println("\n\nCreate user: \n");
		System.out.println("Create employee first");
		ed.addEmployee(new Employee(5, "Perky", "Plane", "pplane@gmail.com", "14-JAN-50", 1, "janitor"));
		System.out.println(ud.createUser(new User("pplane", "password", "21-NOV-90", 5, "user", null)));
		
		
		
		//check username account
		System.out.println("\n\nCheck username for pplane: \n");
		System.out.println(ud.checkUsername("pplane"));
		
		
		//check password account
		System.out.println("\n\nCheck Password for pplane: \n");
		System.out.println(ud.checkPassword("pplane", "password"));
		
		//update login
		System.out.println("\n\nUpdate pplane: \n");
		System.out.println(ud.updateLogin(new User("pplane", "jacobsucks", "21-NOV-90", 5, "user", null)));
		
		//delete account
		System.out.println("\n\nDelete pplane: \n");
		System.out.println(ud.deleteAccount("pplane"));
		 */
		

		//USERS GOOD!
		/*
		//Reimburse CHECK
		System.out.println("\n\nGet all reimbursements: \n");
		System.out.println(rd.getAllReimburseReq());
		
		
		//Get reimbutse associated with user id
		System.out.println("\n\nGet reimbursements for user ID 2: \n");
		System.out.println(rd.getReimburseForUser(2));
		
		
		//get all pending
		System.out.println("\n\nGet all pending reimbursements : \n");
		System.out.println(rd.getAllWithStatus("Pending"));
		
		
		
		//get all associated with emp_id
		System.out.println("\n\nGet all reimbursements for EMP_ID 2: \n");
		System.out.println(rd.getWithStatus("Pending", 2));
		
		//new reimbursement
		System.out.println("\n\nNew reimbursement: \n");
		System.out.println(rd.newReimburse(new Reimburse(10, "Dog died", 400.00, "15-MAY-90", "15-MAY-91", "Rejected", 1, 5)));
		System.out.println(rd.newReimburse(new Reimburse(11, "Somethinh else", 990.00, "15-MAY-90", null, "Pending", 1, 2)));
		System.out.println(rd.newReimburse(new Reimburse(12, "hurt feelings", 1400.00, "20-MAY-94", "20-JUN-99", "Accepted", 1, 2)));

		//delete reimburse
		System.out.println("\n\nDelete reimbursement 10: \n");
		System.out.println(rd.delReimburse(10));
		*/
	}
}
