package com.revature.project1;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.project1.models.Employee;
import com.revature.project1.models.ReimbursementRequest;
import com.revature.project1.service.AuthService;
import com.revature.project1.service.EmployeeService;
import com.revature.project1.service.ReimbursementRequestService;
import com.revature.project1.service.ServiceManager;
import com.revature.project1.util.InputCheckingUtil;
import com.revature.project1.util.PasswordResult;
import com.revature.project1.util.PasswordUtil;

public class Project1Tests {
	
	static EmployeeService empService;
	static ReimbursementRequestService reqService;
	static AuthService authService;
	
	static SimpleDateFormat dateFormat;
	
	static List<Employee> employees;
	static List<ReimbursementRequest> requests;
	
	@BeforeClass
	public static void init() {
		
		empService = ServiceManager.getEmpService();
		reqService = ServiceManager.getReimbursementRequestService();
		authService = ServiceManager.getAuthService();
		
		dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		dateFormat.setLenient(false);
		
		employees = new ArrayList<Employee>();
		requests = new ArrayList<ReimbursementRequest>();
		
		try {
			
			employees.add(createEmployee(1, "Trstram", "Eliesco", "Cost Accountant", 0, "teliesco0@nyu.edu", "619-828-9941", "51d2JxT8", dateFormat.parse("11/25/2018"), "74479 Prairieview Circle", "San Diego", "California", "United States", "92105"));
			employees.add(createEmployee(2, "Parrnell", "Wemyss", "Assistant Media Planner", 1, "pwemyss1@desdev.cn", "915-512-5590", "bcyJHcZcL", dateFormat.parse("3/10/2019"), "330 Leroy Way", "El Paso", "Texas", "United States", "88563"));
			employees.add(createEmployee(3, "Marya", "Boise", "Speech Pathologist", 1, "mboise2@stumbleupon.com", "216-802-3429", "C1uW962", dateFormat.parse("9/2/2018"), "3329 Morning Way", "Cleveland", "Ohio", "United States", "44185"));
			employees.add(createEmployee(4, "Lorrie", "Blackston", "Project Manager", 1, "lblackston3@posterous.com", "661-763-6979", "bNPzHQIn0VA", dateFormat.parse("8/17/2018"), "428 Meadow Vale Street", "Bakersfield", "California", "United States", "93381"));
			employees.add(createEmployee(5, "Ana", "Exer", "Physical Therapy Assistant", 1, "aexer4@dyndns.org", "915-534-3299", "w8Gv3OA9", dateFormat.parse("12/30/2018"), "6153 Elgar Circle", "El Paso", "Texas", "United States", "79945"));
			employees.add(createEmployee(6, "Ringo", "Olivello", "Librarian", 2, "rolivello5@yolasite.com", "816-576-2463", "jCTmGpJNzRA", dateFormat.parse("11/11/2018"), "9923 Mayer Way", "Kansas City", "Missouri", "United States", "64125"));
			employees.add(createEmployee(7, "Kala", "Bowton", "Executive Secretary", 2, "kbowton6@slashdot.org", "972-282-5640", "NZeEuwav", dateFormat.parse("7/7/2018"), "687 Barby Trail", "Plano", "Texas", "United States", "75074"));
			employees.add(createEmployee(8, "Sylvan", "Lamey", "Actuary", 2, "slamey7@nymag.com", "505-920-7700", "MKphxSYI", dateFormat.parse("6/2/2019"), "597 Sunbrook Park", "Albuquerque", "New Mexico", "United States", "87115"));
			employees.add(createEmployee(9, "Jordanna", "Petersen", "Developer III", 3, "jpetersen8@ning.com", "919-367-0707", "a2ZizIo33", dateFormat.parse("12/29/2018"), "49550 Mccormick Park", "Raleigh", "North Carolina", "United States", "27605"));
			employees.add(createEmployee(10, "Amy", "Jugging", "Director of Sales", 3, "ajugging9@taobao.com", "505-349-0625", "4b7eBZjWDHu6", dateFormat.parse("5/22/2019"), "171 Warner Hill", "Albuquerque", "New Mexico", "United States", "87115"));
			employees.add(createEmployee(11, "Joice", "Gilson", "Mechanical Systems Engineer", 3, "jgilsona@purevolume.com", "318-344-1766", "OSKOWgcpOud0", dateFormat.parse("10/1/2018"), "4375 Butternut Parkway", "Shreveport", "Louisiana", "United States", "71161"));
			employees.add(createEmployee(12, "Emilia", "Easseby", "Staff Accountant III", 4, "eeassebyb@google.es", "202-556-5962", "hE731ffI", dateFormat.parse("10/15/2018"), "32 Truax Plaza", "Washington", "District of Columbia", "United States", "20409"));
			employees.add(createEmployee(13, "Verla", "Esselen", "Assistant Professor", 4, "vesselenc@ning.com", "571-290-0273", "HznHuuN5LNDb", dateFormat.parse("7/8/2018"), "1 Eastwood Place", "Arlington", "Virginia", "United States", "22205"));
			employees.add(createEmployee(14, "Valencia", "Shackesby", "Web Designer I", 4, "vshackesbyd@ning.com", "419-527-6968", "OVsfsriBt", dateFormat.parse("3/24/2019"), "91042 Randy Park", "Toledo", "Ohio", "United States", "43699"));
			employees.add(createEmployee(15, "Rickert", "Pomery", "Nurse Practicioner", 5, "rpomerye@e-recht24.de", "952-688-4955", "3hcmaO2gMd", dateFormat.parse("6/12/2019"), "65 Algoma Point", "Young America", "Minnesota", "United States", "55573"));
			employees.add(createEmployee(16, "Savina", "Levensky", "Product Engineer", 5, "slevenskyf@mashable.com", "615-623-3019", "iyGIyhSqa", dateFormat.parse("4/5/2019"), "6687 Forest Dale Pass", "Nashville", "Tennessee", "United States", "37210"));
			employees.add(createEmployee(17, "Lenee", "Goozee", "Programmer IV", 5, "lgoozeeg@independent.co.uk", "859-458-9938", "ShwkjunZCi", dateFormat.parse("11/30/2018"), "0 Thierer Drive", "Lexington", "Kentucky", "United States", "40524"));
			employees.add(createEmployee(18, "Leupold", "O'Neal", "Office Assistant II", 15, "lonealh@domainmarket.com", "315-381-1266", "YSkCjHBKw", dateFormat.parse("1/8/2019"), "57718 Swallow Alley", "Utica", "New York", "United States", "13505"));
			employees.add(createEmployee(19, "Chrissie", "Frampton", "Internal Auditor", 15, "cframptoni@mozilla.com", "260-919-5148", "rkYN8yoxGZJ", dateFormat.parse("7/30/2018"), "3462 Fulton Circle", "Fort Wayne", "Indiana", "United States", "46825"));
			employees.add(createEmployee(20, "Mar", "Domenichini", "Office Assistant II", 17, "mdomenichinij@disqus.com", "803-473-3173", "O6mRYCd", dateFormat.parse("7/29/2018"), "96 American Junction", "Columbia", "South Carolina", "United States", "29208"));
			
			
			requests.add(new ReimbursementRequest(1, 15, 87.59f, dateFormat.parse("1/10/2019"), 5, false));
			requests.add(new ReimbursementRequest(2, 15, 11.54f, dateFormat.parse("3/15/2019"), 0, false));
			requests.add(new ReimbursementRequest(3, 15, 69.05f, dateFormat.parse("10/25/2018"), 1, true));
			requests.add(new ReimbursementRequest(4, 16, 85.86f, dateFormat.parse("3/18/2019"), 0, false));
			requests.add(new ReimbursementRequest(5, 13, 73.69f, dateFormat.parse("12/26/2018"), 4, false));
			requests.add(new ReimbursementRequest(6, 8, 48.56f, dateFormat.parse("7/11/2018"), 1, true));
			requests.add(new ReimbursementRequest(7, 10, 13.09f, dateFormat.parse("12/11/2018"), 7, true));
			requests.add(new ReimbursementRequest(8, 11, 94.29f, dateFormat.parse("8/15/2018"), 3, true));
			requests.add(new ReimbursementRequest(9, 8, 19.01f, dateFormat.parse("11/20/2018"), 0, false));
			requests.add(new ReimbursementRequest(10, 12, 90.55f, dateFormat.parse("9/24/2018"), 4, true));
			requests.add(new ReimbursementRequest(11, 12, 39.06f, dateFormat.parse("6/18/2019"), 4, false));
			requests.add(new ReimbursementRequest(12, 11, 69.02f, dateFormat.parse("3/9/2019"), 1, true));
			requests.add(new ReimbursementRequest(13, 9, 61.07f, dateFormat.parse("3/6/2019"), 0, false));
			requests.add(new ReimbursementRequest(14, 18, 37.57f, dateFormat.parse("10/22/2018"), 15, true));
			requests.add(new ReimbursementRequest(15, 18, 80.40f, dateFormat.parse("1/24/2019"), 15, true));
			requests.add(new ReimbursementRequest(16, 18, 55.16f, dateFormat.parse("1/29/2019"), 0, false));
			requests.add(new ReimbursementRequest(17, 4, 79.79f, dateFormat.parse("1/3/2019"), 0, false));
			requests.add(new ReimbursementRequest(18, 7, 88.21f, dateFormat.parse("9/21/2018"), 2, false));
			requests.add(new ReimbursementRequest(19, 6, 4.17f, dateFormat.parse("10/17/2018"), 0, false));
			requests.add(new ReimbursementRequest(20, 6, 88.70f, dateFormat.parse("8/27/2018"), 2, true));
			
		} catch(ParseException e) {
			
			e.printStackTrace();
		}
	}
	
	private static String bytesToHex(byte[] hashInBytes) {
		
        StringBuilder sb = new StringBuilder();
        
        for (byte b : hashInBytes) {
            
        	sb.append(String.format("%02x", b));
        }
        
        return sb.toString();
    }
	
	private static Employee createEmployee(int employeeID, String firstName, String lastName, String title, int managerID, String email, String phone, String password, Date hireDate, String address, String city, String state, String country, String postalCode) {
		
		PasswordResult passResult = PasswordUtil.hashPassword(password);
		
		return new Employee(employeeID, firstName, lastName, title, managerID, email, phone, passResult.getHash(), passResult.getSalt(), hireDate, address, city, state, country, postalCode);
	}
	
	private static Employee cloneEmployee(Employee e) {
		return new Employee(
			e.getEmployeeID(),
			e.getFirstName(),
			e.getLastName(),
			e.getTitle(),
			e.getManagerID(),
			e.getEmail(),
			e.getPhone(),
			e.getPasswordHash(),
			e.getPasswordSalt(),
			e.getHireDate(),
			e.getAddress(),
			e.getCity(),
			e.getState(),
			e.getCountry(),
			e.getPostalCode()
		);
	}
	
	// EmployeeService tests
	
	// getEmployee() tests
	
	@Test
	public void getEmployeeTest1() {
		
		Employee emp = empService.getEmployee(1);
		
		Employee testEmp = employees.get(0);
		
		assertEquals(testEmp.getEmail(), emp.getEmail());
	}
	
	@Test
	public void getEmployeeTest2() {
		
		Employee emp = empService.getEmployee(15);
		
		Employee testEmp = employees.get(14);
		
		assertEquals(testEmp.getEmail(), emp.getEmail());
	}
	
	@Test
	public void getEmployeeTest3() {
		
		Employee emp = empService.getEmployee(0);
		
		assertNull(emp);
	}
	
	// getEmployeeByEmail() tests

	@Test
	public void getEmployeeByEmailTest1() {
		
		Employee emp = empService.getEmployeeByEmail("jgilsona@purevolume.com");
		
		Employee testEmp = employees.get(10);
		
		assertEquals(testEmp.getEmployeeID(), emp.getEmployeeID());
	}
	
	@Test
	public void getEmployeeByEmailTest2() {
		
		Employee emp = empService.getEmployeeByEmail("lblackston3@posterous.com");
		
		Employee testEmp = employees.get(3);
		
		assertEquals(testEmp.getEmployeeID(), emp.getEmployeeID());
	}
	
	@Test
	public void getEmployeeByEmailTest3() {
		
		assertNull(empService.getEmployeeByEmail("fakeEmail@liar.com"));
	}
	
	// updateEmployee tests
	
	@Test
	public void updateEmployeeTest1() {
		
		Employee emp = cloneEmployee(empService.getEmployee(3));
		
		emp.setAddress("5355 Minnesota St.");
		
		empService.updateEmployee(emp);
		
		Employee emp2 = empService.getEmployee(3);
		
		assertEquals("5355 Minnesota St.", emp2.getAddress());
	}
	
	@Test
	public void updateEmployeeTest2() {
		
		Employee emp = cloneEmployee(empService.getEmployee(3));
		
		emp.setState("Washington");
		
		empService.updateEmployee(emp);
		
		Employee emp2 = empService.getEmployee(3);
		
		assertEquals("Washington", emp2.getState());
	}
	
	@Test
	public void updateEmployeeTest3() {
		
		Employee emp = cloneEmployee(empService.getEmployee(3));
		
		emp.setCity("Bartlesville");
		
		empService.updateEmployee(emp);
		
		Employee emp2 = empService.getEmployee(3);
		
		assertEquals("Bartlesville", emp2.getCity());
	}
	
	// updateEmail test
	
	@Test
	public void updateEmailTest() {
		
		empService.updateEmail(3, "my@email.com");
		
		Employee emp = empService.getEmployee(3);
		
		assertEquals("my@email.com", emp.getEmail());
	}
	
	// updatePassword test
	
	@Test
	public void updatePasswordTest() {
		
		empService.updatePassword(3, "Password");
		
		Employee emp = empService.getEmployee(3);
		
		assertNotNull(authService.verifyPassword("Password", emp.getEmail()));
	}
	
	// isEmailTaken tests
	
	@Test
	public void isEmailTakenTest1() {
		
		assertTrue(empService.isEmailTaken("cframptoni@mozilla.com"));
	}
	
	@Test
	public void isEmailTakenTest2() {
		
		assertFalse(empService.isEmailTaken("joshuaveit1995@gmail.com"));
	}
	
	// getSubordinates tests
	
	@Test
	public void getSubordinatesTest1() {
		
		List<Employee> subordinates = new ArrayList<Employee>();
		
		try {
			
			subordinates.add(createEmployee(2, "Parrnell", "Wemyss", "Assistant Media Planner", 1, "pwemyss1@desdev.cn", "915-512-5590", "bcyJHcZcL", dateFormat.parse("3/10/2019"), "330 Leroy Way", "El Paso", "Texas", "United States", "88563"));
			subordinates.add(createEmployee(3, "Marya", "Boise", "Speech Pathologist", 1, "mboise2@stumbleupon.com", "216-802-3429", "C1uW962", dateFormat.parse("9/2/2018"), "3329 Morning Way", "Cleveland", "Ohio", "United States", "44185"));
			subordinates.add(createEmployee(4, "Lorrie", "Blackston", "Project Manager", 1, "lblackston3@posterous.com", "661-763-6979", "bNPzHQIn0VA", dateFormat.parse("8/17/2018"), "428 Meadow Vale Street", "Bakersfield", "California", "United States", "93381"));
			subordinates.add(createEmployee(5, "Ana", "Exer", "Physical Therapy Assistant", 1, "aexer4@dyndns.org", "915-534-3299", "w8Gv3OA9", dateFormat.parse("12/30/2018"), "6153 Elgar Circle", "El Paso", "Texas", "United States", "79945"));
			subordinates.add(createEmployee(6, "Ringo", "Olivello", "Librarian", 2, "rolivello5@yolasite.com", "816-576-2463", "jCTmGpJNzRA", dateFormat.parse("11/11/2018"), "9923 Mayer Way", "Kansas City", "Missouri", "United States", "64125"));
			subordinates.add(createEmployee(7, "Kala", "Bowton", "Executive Secretary", 2, "kbowton6@slashdot.org", "972-282-5640", "NZeEuwav", dateFormat.parse("7/7/2018"), "687 Barby Trail", "Plano", "Texas", "United States", "75074"));
			subordinates.add(createEmployee(8, "Sylvan", "Lamey", "Actuary", 2, "slamey7@nymag.com", "505-920-7700", "MKphxSYI", dateFormat.parse("6/2/2019"), "597 Sunbrook Park", "Albuquerque", "New Mexico", "United States", "87115"));
			subordinates.add(createEmployee(9, "Jordanna", "Petersen", "Developer III", 3, "jpetersen8@ning.com", "919-367-0707", "a2ZizIo33", dateFormat.parse("12/29/2018"), "49550 Mccormick Park", "Raleigh", "North Carolina", "United States", "27605"));
			subordinates.add(createEmployee(10, "Amy", "Jugging", "Director of Sales", 3, "ajugging9@taobao.com", "505-349-0625", "4b7eBZjWDHu6", dateFormat.parse("5/22/2019"), "171 Warner Hill", "Albuquerque", "New Mexico", "United States", "87115"));
			subordinates.add(createEmployee(11, "Joice", "Gilson", "Mechanical Systems Engineer", 3, "jgilsona@purevolume.com", "318-344-1766", "OSKOWgcpOud0", dateFormat.parse("10/1/2018"), "4375 Butternut Parkway", "Shreveport", "Louisiana", "United States", "71161"));
			subordinates.add(createEmployee(12, "Emilia", "Easseby", "Staff Accountant III", 4, "eeassebyb@google.es", "202-556-5962", "hE731ffI", dateFormat.parse("10/15/2018"), "32 Truax Plaza", "Washington", "District of Columbia", "United States", "20409"));
			subordinates.add(createEmployee(13, "Verla", "Esselen", "Assistant Professor", 4, "vesselenc@ning.com", "571-290-0273", "HznHuuN5LNDb", dateFormat.parse("7/8/2018"), "1 Eastwood Place", "Arlington", "Virginia", "United States", "22205"));
			subordinates.add(createEmployee(14, "Valencia", "Shackesby", "Web Designer I", 4, "vshackesbyd@ning.com", "419-527-6968", "OVsfsriBt", dateFormat.parse("3/24/2019"), "91042 Randy Park", "Toledo", "Ohio", "United States", "43699"));
			subordinates.add(createEmployee(15, "Rickert", "Pomery", "Nurse Practicioner", 5, "rpomerye@e-recht24.de", "952-688-4955", "3hcmaO2gMd", dateFormat.parse("6/12/2019"), "65 Algoma Point", "Young America", "Minnesota", "United States", "55573"));
			subordinates.add(createEmployee(16, "Savina", "Levensky", "Product Engineer", 5, "slevenskyf@mashable.com", "615-623-3019", "iyGIyhSqa", dateFormat.parse("4/5/2019"), "6687 Forest Dale Pass", "Nashville", "Tennessee", "United States", "37210"));
			subordinates.add(createEmployee(17, "Lenee", "Goozee", "Programmer IV", 5, "lgoozeeg@independent.co.uk", "859-458-9938", "ShwkjunZCi", dateFormat.parse("11/30/2018"), "0 Thierer Drive", "Lexington", "Kentucky", "United States", "40524"));
			subordinates.add(createEmployee(18, "Leupold", "O'Neal", "Office Assistant II", 15, "lonealh@domainmarket.com", "315-381-1266", "YSkCjHBKw", dateFormat.parse("1/8/2019"), "57718 Swallow Alley", "Utica", "New York", "United States", "13505"));
			subordinates.add(createEmployee(19, "Chrissie", "Frampton", "Internal Auditor", 15, "cframptoni@mozilla.com", "260-919-5148", "rkYN8yoxGZJ", dateFormat.parse("7/30/2018"), "3462 Fulton Circle", "Fort Wayne", "Indiana", "United States", "46825"));
			subordinates.add(createEmployee(20, "Mar", "Domenichini", "Office Assistant II", 17, "mdomenichinij@disqus.com", "803-473-3173", "O6mRYCd", dateFormat.parse("7/29/2018"), "96 American Junction", "Columbia", "South Carolina", "United States", "29208"));
			
			List<Employee> daoSubs = empService.getSubordinates(1);
			
			subordinates.removeAll(daoSubs);
			
			assertEquals(0, subordinates.size());
			
		} catch(ParseException e) {
			
			e.printStackTrace();
			
			fail();
		}
	}
	
	@Test
	public void getSubordinatesTest2() {

		List<Employee> subordinates = new ArrayList<Employee>();
		
		try {
			
			subordinates.add(createEmployee(6, "Ringo", "Olivello", "Librarian", 2, "rolivello5@yolasite.com", "816-576-2463", "jCTmGpJNzRA", dateFormat.parse("11/11/2018"), "9923 Mayer Way", "Kansas City", "Missouri", "United States", "64125"));
			subordinates.add(createEmployee(7, "Kala", "Bowton", "Executive Secretary", 2, "kbowton6@slashdot.org", "972-282-5640", "NZeEuwav", dateFormat.parse("7/7/2018"), "687 Barby Trail", "Plano", "Texas", "United States", "75074"));
			subordinates.add(createEmployee(8, "Sylvan", "Lamey", "Actuary", 2, "slamey7@nymag.com", "505-920-7700", "MKphxSYI", dateFormat.parse("6/2/2019"), "597 Sunbrook Park", "Albuquerque", "New Mexico", "United States", "87115"));
			
			List<Employee> daoSubs = empService.getSubordinates(2);
			
			subordinates.removeAll(daoSubs);
			
			assertEquals(0, subordinates.size());
			
		} catch(ParseException e) {
			
			e.printStackTrace();
			
			fail();
		}
	}
	
	@Test
	public void getSubordinatesTest3() {

		List<Employee> subordinates = new ArrayList<Employee>();
		
		try {
			
			subordinates.add(createEmployee(9, "Jordanna", "Petersen", "Developer III", 3, "jpetersen8@ning.com", "919-367-0707", "a2ZizIo33", dateFormat.parse("12/29/2018"), "49550 Mccormick Park", "Raleigh", "North Carolina", "United States", "27605"));
			subordinates.add(createEmployee(10, "Amy", "Jugging", "Director of Sales", 3, "ajugging9@taobao.com", "505-349-0625", "4b7eBZjWDHu6", dateFormat.parse("5/22/2019"), "171 Warner Hill", "Albuquerque", "New Mexico", "United States", "87115"));
			subordinates.add(createEmployee(11, "Joice", "Gilson", "Mechanical Systems Engineer", 3, "jgilsona@purevolume.com", "318-344-1766", "OSKOWgcpOud0", dateFormat.parse("10/1/2018"), "4375 Butternut Parkway", "Shreveport", "Louisiana", "United States", "71161"));
			
			List<Employee> daoSubs = empService.getSubordinates(3);
			
			subordinates.removeAll(daoSubs);
			
			assertEquals(0, subordinates.size());
			
		} catch(ParseException e) {
			
			e.printStackTrace();
			
			fail();
		}
	}
	
	// ReimbursementService tests
	
	// getSubordinateRequets tests
	
	@Test
	public void getSubordinateRequestsTest1() {
		
		List<ReimbursementRequest> subRequests = new ArrayList<ReimbursementRequest>();
		
		try {
			
			subRequests.add(new ReimbursementRequest(14, 18, 37.57f, dateFormat.parse("10/22/2018"), 15, true));
			subRequests.add(new ReimbursementRequest(15, 18, 80.40f, dateFormat.parse("1/24/2019"), 15, true));
			subRequests.add(new ReimbursementRequest(16, 18, 55.16f, dateFormat.parse("1/29/2019"), 0, false));
			
			assertEquals(subRequests, reqService.getSubordinateRequests(15));
			
		} catch (ParseException e) {
			
			System.out.println("Date Parse Exception");
			
			e.printStackTrace();
			
			fail();
		}
	}
	
	@Test
	public void getSubordinateRequestsTest2() {
		
		List<ReimbursementRequest> subRequests = new ArrayList<ReimbursementRequest>();
		
		try {
			
			subRequests.add(new ReimbursementRequest(1, 15, 87.59f, dateFormat.parse("1/10/2019"), 5, false));
			subRequests.add(new ReimbursementRequest(2, 15, 11.54f, dateFormat.parse("3/15/2019"), 0, false));
			subRequests.add(new ReimbursementRequest(3, 15, 69.05f, dateFormat.parse("10/25/2018"), 1, true));
			subRequests.add(new ReimbursementRequest(4, 16, 85.86f, dateFormat.parse("3/18/2019"), 0, false));
			subRequests.add(new ReimbursementRequest(14, 18, 37.57f, dateFormat.parse("10/22/2018"), 15, true));
			subRequests.add(new ReimbursementRequest(15, 18, 80.40f, dateFormat.parse("1/24/2019"), 15, true));
			subRequests.add(new ReimbursementRequest(16, 18, 55.16f, dateFormat.parse("1/29/2019"), 0, false));
			
			assertEquals(subRequests, reqService.getSubordinateRequests(5));
			
		} catch (ParseException e) {
			
			System.out.println("Date Parse Exception");
			
			e.printStackTrace();
			
			fail();
		}
	}
	
	// getUserRequests tests
	
	@Test
	public void getUserRequestsTest1() {
		
		List<ReimbursementRequest> userRequests = new ArrayList<ReimbursementRequest>();
		
		for(ReimbursementRequest request : requests) {
			
			if(request.getEmployeeID() == 6)
				userRequests.add(request);
		}
		
		assertEquals(userRequests, reqService.getUsersRequests(6));
	}
	
	@Test
	public void getUserRequestsTest2() {
		
		List<ReimbursementRequest> userRequests = new ArrayList<ReimbursementRequest>();
		
		for(ReimbursementRequest request : requests) {
			
			if(request.getEmployeeID() == 7)
				userRequests.add(request);
		}
		
		assertEquals(userRequests, reqService.getUsersRequests(7));
	}
	
	// resolveReimbursementRequest tests
	
	@Test
	public void resolveReimbursementRequestTest1() {
		
		reqService.resolveReimbursementRequest(9, true, 1);
		
		ReimbursementRequest request = reqService.getReimbursementRequest(9);
		
		if(request.getManagerID() != 1)
			fail();
		
		boolean result = request.getWasApproved();
		
		assertTrue(result);
	}
	
	@Test
	public void resolveReimbursementRequestTest2() {
		
		reqService.resolveReimbursementRequest(17, false, 1);
		
		ReimbursementRequest request = reqService.getReimbursementRequest(17);
		
		if(request.getManagerID() != 1)
			fail();
		
		boolean result = request.getWasApproved();
		
		assertFalse(result);
	}
	
	// getReimbursementRequest tests
	
	@Test
	public void getReimbursementRequestTest1() {
		
		assertEquals(requests.get(18), reqService.getReimbursementRequest(19));
	}
	
	@Test
	public void getReimbursementRequestTest2() {
		
		assertEquals(requests.get(14), reqService.getReimbursementRequest(15));
	}
	
	// submitRequest test
	
	@Test
	public void submitRequestTest() {
		
		reqService.submitRequest(2, 5.5f);
		
		ReimbursementRequest request = reqService.getReimbursementRequest(21);

		reqService.removeRequest(21);
		
		if(request.getAmount() != 5.5f)
			fail();
		
		assertEquals(request.getEmployeeID(), 2);
	}
	
	// AuthService tests
	
	// verifyPassword tests
	
	@Test
	public void verifyPasswordTest1() {
		
		assertNotNull(authService.verifyPassword("O6mRYCd", "mdomenichinij@disqus.com"));
	}
	
	@Test
	public void verifyPasswordTest2() {
		
		assertNotNull(authService.verifyPassword("ShwkjunZCi", "lgoozeeg@independent.co.uk"));
	}
	
	// inputCheckingUtil tests
	
	// isEmailValid tests
	
	@Test
	public void emailValidationTest1() {
		
		assertTrue(InputCheckingUtil.isEmailValid("javeit1995@gmail.com"));
	}
	
	@Test
	public void emailValidationTest2() {
		assertFalse(InputCheckingUtil.isEmailValid("javeit@1995@gmail.com"));
	}
	
	@Test
	public void emailValidationTest3() {
		assertTrue(InputCheckingUtil.isEmailValid("javeit.1995@gmail.com"));
	}
	
	@Test
	public void emailValidationTest4() {
		assertFalse(InputCheckingUtil.isEmailValid("javeit1995@gmailcom"));
	}
	
	@Test
	public void emailValidationTest5() {
		assertFalse(InputCheckingUtil.isEmailValid("javeit..1995@gmailcom"));
	}
	
	// isDateValid tests
	
	@Test
	public void isDateValidTest1() {
		
		assertTrue(InputCheckingUtil.isDateValid("1/24/2000"));
	}
	
	@Test
	public void isDateValidTest2() {
		
		assertFalse(InputCheckingUtil.isDateValid("13/20/2001"));
	}
	
	@Test
	public void isDateValidTest3() {
		
		assertFalse(InputCheckingUtil.isDateValid("Hi"));
	}
	
	@Test
	public void isDateValidTest4() {
		
		assertTrue(InputCheckingUtil.isDateValid("9/24/1995"));
	}
}
