package com.revature.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImp;
import com.revature.dao.ManagerDao;
import com.revature.dao.ManagerDaoImp;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImp;
import com.revature.model.Employee;
import com.revature.model.Manager;
import com.revature.model.Request;
import com.revature.util.ValidationUtil;

public class TestUtil {
	public static final RequestDao rDao = new RequestDaoImp();
	public static final EmployeeDao eDao = new EmployeeDaoImp();
	public static final ManagerDao mDao = new ManagerDaoImp();
	public static final ValidationUtil valid = new ValidationUtil();
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	Employee emp = new Employee(10099, "Steven", "Chag", "daChag", "test0000", "daChag@gmail.com", 20088);
	Manager man = new Manager(20088, "Samwise", "Gamgi", "samMan", "mrFr0d0", "sammmo@gmail.com");
	Request req = new Request(460, emp.getId(), 14.55, "I accidentally drove into a shallow river and my company laptop got ruined", 0, 0);
	
	// Dao Tests
	@Ignore
	@Test
	public void canCreateManager() {
		mDao.createManager(man);
		assertEquals(mDao.getManagerById(man.getId()), man);
	}
	
	@Ignore
	@Test
	public void canCreateEmployee() {
		eDao.createEmployee(emp);
		assertEquals(eDao.getEmployeeById(emp.getId()), emp);
	}
	
	@Ignore
	@Test
	public void canCreateRequest() {
		rDao.createRequest(req);
		assertEquals(rDao.getRequestById(req.getId()), req);
	}
	
	@Test
	public void canApproveRequest() {
		rDao.approveRequest(req.getId(), man.getId());
		assertEquals(rDao.getRequestById(req.getId()).getApprovedBy(), man.getId());
	}
	
	// Validation Tests
	// Name Validation
	@Test
	public void isFirstNameValid() {
		assertTrue(valid.validateName("Steve"));
	}
	@Test
	public void isLastNameValid() {
		assertTrue(valid.validateName("Blum"));
	}
	@Test
	public void isFullNameInvalid() {
		assertFalse(valid.validateName("Steve Blum"));
	}
	@Test
	public void isNameInvalid() {
		assertFalse(valid.validateName(";St3ve"));
	}
	@Test
	public void isNumbersNotName() {
		assertFalse(valid.validateName("3345"));
	}
	
	// Illegal Characters Validation
	@Test
	public void isNoIllegalChars() {
		assertTrue(valid.validateIllegalChars("NoIllegalCharacters"));
	}
	@Test
	public void isSQLIllegal() {
		assertFalse(valid.validateIllegalChars("; DROP TABLE EMPLOYEE;"));
	}
	@Test
	public void isCharsIllegal() {
		assertFalse(valid.validateIllegalChars("Here are:someIllegal;Chars"));
	}
	@Test
	public void isOtherCharsLegal() {
		assertTrue(valid.validateIllegalChars("Here@areSome98Normal*chars"));
	}
	
	// Email Validation
	@Test
	public void isValidEmail() {
		assertTrue(valid.validateEmail("validEmail@email.com"));
	}
	@Test
	public void isNotValidEmail() {
		assertFalse(valid.validateEmail("notValid@badmail"));
	}
	@Test
	public void isInRightFormat() {
		assertTrue(valid.validateEmail("test@test.test"));
	}
	@Test
	public void isNotRightOrder() {
		assertFalse(valid.validateEmail("mail.com@steve"));
	}
	@Test
	public void isEmailWIllegalChars() {
		assertFalse(valid.validateEmail("steve:@gmail.com"));
	}
	
	// Password Validation
	@Test
	public void isValidPassword() {
		assertTrue(valid.validatePword("val1d@pass"));
	}
	@Test
	public void isTooShort() {
		assertFalse(valid.validatePword("no"));
	}
	@Test
	public void isPassWIllegalChars() {
		assertFalse(valid.validatePword("no space"));
	}
	
	// Manager Id Validation
	@Test
	public void isValidManId() {
		assertTrue(valid.validateManId(man.getId()));
	}
	@Test
	public void isNotAManager() {
		assertFalse(valid.validateManId(20150));
	}
	@Test
	public void isNotValidManId() {
		assertFalse(valid.validateManId(10025));
	}
	
	// Integer Validation
	@Test
	public void isInteger() {
		assertEquals(valid.validateInt("12"), 12);
	}
	@Test
	public void isNotInteger() {
		assertEquals(valid.validateInt("no"), -1);
	}
	@Test
	public void isDoubleNotInt() {
		assertEquals(valid.validateInt("12.5"), -1);
	}
	
	// Amount Validation
//	@SuppressWarnings("deprecation")
//	@Test
//	public void isMonetaryAmount() {
//		assertEquals(valid.validateAmount("15.35"), 15.35);
//	}
//	@SuppressWarnings("deprecation")
//	@Test
//	public void isNotMonetaryAmount() {
//		assertEquals(valid.validateAmount("no"), -1.00);
//	}
	
	// Username Validation
	@Test
	public void isExistingUname() {
		assertTrue(valid.validateUname(emp.getUserName()));
	}
	@Test
	public void isNotUsername() {
		assertFalse(valid.validateUname("notAUserName"));
	}
	@Test
	public void isUnameWIllegalChars() {
		assertFalse(valid.validateUname("bad: Name"));
	}
}
