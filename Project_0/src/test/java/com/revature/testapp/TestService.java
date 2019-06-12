package com.revature.testapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.revature.accountdao.AccountDaoImp;
import com.revature.accountdao.UserDaoImp;
import com.revature.accountmodel.User;
import com.revature.accountutil.AccountMenuUtil;
import com.revature.accountutil.UserMenuUtil;

public class TestService {
	private static final UserDaoImp uDao = new UserDaoImp();
	private static final AccountDaoImp aDao = new AccountDaoImp();
	private static final UserMenuUtil uMenu = new UserMenuUtil();
	private static final AccountMenuUtil aMenu = new AccountMenuUtil();
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	User u = new User(71, "TestAccount", "test00pass", "test@test.test");
	
	@Ignore
	@Test
	public void canCreateUser() {
		uMenu.createUser(u.getuName(), u.getpWord(), u.geteMail());
		assertEquals(uDao.getUserById(u.getId()), u);
	}
	
	@Test
	public void canLogin() {
		assertEquals(uMenu.login(u.getuName(), u.getpWord()), u);
	}
	
	@Ignore
	@Test
	public void canCreateAccount() {
		assertTrue(aMenu.createAccount(u, 5555, 500.00));
	}
	
	@Test
	public void canDeposit() {
		assertTrue(aMenu.depositFunds(u, 5555, 50.00));
	}
	
	@Test
	public void canWithdraw() {
		assertTrue(aMenu.withdrawFunds(u, 5555, 50.00));
	}
	
	@Test
	public void cannotOverdraw() {
		assertFalse(aMenu.withdrawFunds(u, 5555, 10000.00));
	}
}
