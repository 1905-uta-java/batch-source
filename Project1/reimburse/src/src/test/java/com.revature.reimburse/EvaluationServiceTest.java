import com.revature.controller.*;
import com.revature.daos.*;
import com.revature.delegates.*;
import com.revature.models.*;
import com.revature.services.*;
import com.revature.util.*;

import static org.junit.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class EvaluationServiceTest {
	List<User> users = new ArrayList<>();
	private UserDelegate ud = new UserDelegate();
	private EmployeeDelegate ed = new EmployeeDelegate();
	private ReimbursementDelegate rd = new ReimbursementDelegate();
	private ReimbursementService rs  = new ReimbursementService();
	private AuthDelegate ad = new AuthDelegate();
	/*******************************************************************
	 * Test 1 successful login
	 * @throws SQLException 
	 * 
	 * assertEquals(expected, actual);
	 *******************************************************************/
	@Test
	public void successfulLogin() {
		users.add(new User(8, "BDimitrie", "password", "manager"));

		assertEquals(ad.authenticate("BDimitrie", "password"), 8+":manager");
	}
	
	
	/*******************************************************************
	 * Test 2 all logged in users can add new reimbursement
	 * @throws SQLException 
	 *******************************************************************/
	@Test
	
	// create a new reimbursement object
	Reimbursement reimbursement = new Reimbursement(NULL, 'Travel', 'Pending', 20, TO_DATE('2018-08-23 01:40:45', 'yyyy/mm/dd hh24:mi:ss'), NULL, NULL, 2);
	
	// should not return sql exception
	assertNotSame(rs.create(reimbursement), SQLException);
	

	/*******************************************************************
	 * Test 3 manager can change status of reimbursement
	 * @throws SQLException 
	 *******************************************************************/
	public void approve(Reimbursement r) throws SQLException {
		reimburseDao.approveReimbursement(r);
		assertEquals(r.getStatus()==='Approved');
	}
	
	/*******************************************************************
	 * Test 4 users can log out
	 * @throws SQLException 
	 *******************************************************************/
		
}

	

	