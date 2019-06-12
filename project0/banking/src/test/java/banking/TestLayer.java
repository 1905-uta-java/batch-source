package banking;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.runners.MethodSorters;


import java.sql.SQLException;

import org.junit.FixMethodOrder;
import org.junit.Test;
import com.banking.dao.UserDao;
import com.banking.dao.UserDaoImpl;
import com.banking.util.ConnectionUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestLayer {
	private static final UserDao ud = new UserDaoImpl();

	@Test
	public void testAvailableFalse() {
		assertFalse(ud.isAvailable("mantunguyen"));
	}

	@Test
	public void testAvailableTrue() {
		assertTrue(ud.isAvailable("tommy"));
	}

	@Test
	public void testBCreateuser() {
		assertTrue(ud.createUser("tommy", "123456"));
	}
	
	@Test
	public void testCLogin() {
		boolean success = true;;
		try {
			ConnectionUtil.getConnectionWithNameAndPassword("tommy", "123456");
		} catch (SQLException e) {
			success = false;
			throw new RuntimeException("Wrong username or password");
		}
		assertTrue(success);
	}
 	
	@Test
	public void testDeposit() {
		double balance = ud.deposit("tommy", 500);
		System.out.println(balance);
		assertEquals(1, balance, 0);
	}
	
	@Test
	public void testEWithdraw() {
		double balance = ud.withdraw("tommy", 500);
		System.out.println(balance);
		assertEquals(1, balance, 0);
	}

	@Test
	public void testFCheckBalance() {
		double balance = ud.checkBalance("tommy");
		System.out.println(balance);
		assertEquals(0, balance, 0);
	}
}
