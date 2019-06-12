package com.revature;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.models.User;

public class ServiceTest {
	UserDao usrDaoServ = new UserDaoImpl();
	User uServ = new User(0, "admin", "root", "email@email.com", "George", "Newman");
	Scanner scServ = null;
	public Bank bank = new Bank(usrDaoServ, uServ, scServ);
	public Login login = new Login(usrDaoServ, scServ);
	public Create create = new Create(usrDaoServ, scServ);
	

	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	/****************************************
	 * LOGIN TESTING
	 *****************************************/
	@Test
	public void badUsername(){
		assertEquals(-1, login.loginService("fevacaefsae", "wjcicbs"));
	}
	
	@Test
	public void badPassword(){
		assertEquals(-2, login.loginService("admin", "wjcicbs"));
	}

	
	/****************************************
	 * CREATE TESTING
	 *****************************************/
	@Test
	public void usernameTaken(){
		assertTrue(create.checkUsername("admin"));
	}

	@Test
	public void usernameFree(){
		assertFalse(create.checkUsername("djihcsinck"));
	}
	
	
	
	/****************************************
	 * CREATE TESTING
	 *****************************************/
	@Test
	public void badType(){
		assertEquals("", bank.typeService("djihcsinck"));
	}

	@Test
	public void validType(){
		assertEquals("Checking", bank.typeService("C"));
	}
	
	@Test
	public void badParseInitialBalance(){
		assertEquals(-1, bank.initialBalanceService("djihcsinck"), 0);
	}
	
	@Test 
	public void initBalanceEmptyOrNegative(){
		assertEquals(-2, bank.initialBalanceService("0"), 0);
	}
	
	@Test
	public void initBalancePass(){
		assertEquals(100, bank.initialBalanceService("100"), 0);
	}
	
	@Test
	public void badParseSelectAccount(){
		assertEquals(-1, bank.selectAccountService("csajicbhu"));
	}

	@Test
	public void outOfBoundsSelectAccount(){
		assertEquals(-2, bank.selectAccountService("40"));
	}

	@Test
	public void outOfBoundsSingleAccount(){
		assertEquals(-2, bank.singleAccountService(40));
	}
	
	@Test
	public void depositNumberFormatExcp(){
		assertEquals(-1, bank.depositService(40, 11, "xzxz"), 0);
	}
	
	@Test
	public void emptyDepositService(){
		assertEquals(-2, bank.depositService(7910, 11, "0"), 0);
	}

	
	@Test
	public void negativeDepositService(){
		assertEquals(-3, bank.depositService(7910, 11, "-50000.00"), 0);
	}
	
	@Test
	public void goodDepositService(){
		assertEquals(7920, bank.depositService(7910, 11, "10"), 0);
	}
	
	@Test
	public void formatExcpWithdService(){
		assertEquals(-1, bank.withdrawlService(7910, 11, "wwscscscs"), 0);
	}
	
	
	@Test
	public void negWithdNegService(){
		assertEquals(-2, bank.withdrawlService(7910, 11, "-10.00"), 0);
	}
	
	@Test
	public void accZeroService(){
		assertEquals(-3, bank.withdrawlService(7910, 11, "10000"), 0);
	}
	
	@Test
	public void withdPassService(){
		assertEquals(7900, bank.withdrawlService(7910, 11, "10"), 0);
	}

	
	@Test
	public void delMoneyService(){
		bank.updateAccList();
		assertEquals(-2, bank.deleteService(2), 0);
	}
	
	@Test
	public void delNoMoneyService(){
		bank.updateAccList();
		assertEquals(0, bank.deleteService(1), 0);
	}

	
}
	
	
	
	
	

