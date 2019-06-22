package com.revature.project1.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.revature.project1.models.Employee;
import com.revature.project1.models.ReimbursementRequest;
import com.revature.project1.util.PasswordResult;
import com.revature.project1.util.PasswordUtil;

public class ReimbursementDummyDAO implements ReimbursementDAO {
	
	private int nextEmployeeID = 1;
	private int nextRequestID = 1;
	
	private List<Employee> employees;
	private List<ReimbursementRequest> requests;
	
	private SimpleDateFormat dateFormat;
	
	public ReimbursementDummyDAO() {
		
		super();
		
		employees = new ArrayList<Employee>();
		requests = new ArrayList<ReimbursementRequest>();
		
		dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		dateFormat.setLenient(false);
		
		try {
			
			addEmployee(1, "Trstram", "Eliesco", "Cost Accountant", 0, "teliesco0@nyu.edu", "619-828-9941", "51d2JxT8", dateFormat.parse("11/25/2018"), "74479 Prairieview Circle", "San Diego", "California", "United States", "92105");
			addEmployee(2, "Parrnell", "Wemyss", "Assistant Media Planner", 1, "pwemyss1@desdev.cn", "915-512-5590", "bcyJHcZcL", dateFormat.parse("3/10/2019"), "330 Leroy Way", "El Paso", "Texas", "United States", "88563");
			addEmployee(3, "Marya", "Boise", "Speech Pathologist", 1, "mboise2@stumbleupon.com", "216-802-3429", "C1uW962", dateFormat.parse("9/2/2018"), "3329 Morning Way", "Cleveland", "Ohio", "United States", "44185");
			addEmployee(4, "Lorrie", "Blackston", "Project Manager", 1, "lblackston3@posterous.com", "661-763-6979", "bNPzHQIn0VA", dateFormat.parse("8/17/2018"), "428 Meadow Vale Street", "Bakersfield", "California", "United States", "93381");
			addEmployee(5, "Ana", "Exer", "Physical Therapy Assistant", 1, "aexer4@dyndns.org", "915-534-3299", "w8Gv3OA9", dateFormat.parse("12/30/2018"), "6153 Elgar Circle", "El Paso", "Texas", "United States", "79945");
			addEmployee(6, "Ringo", "Olivello", "Librarian", 2, "rolivello5@yolasite.com", "816-576-2463", "jCTmGpJNzRA", dateFormat.parse("11/11/2018"), "9923 Mayer Way", "Kansas City", "Missouri", "United States", "64125");
			addEmployee(7, "Kala", "Bowton", "Executive Secretary", 2, "kbowton6@slashdot.org", "972-282-5640", "NZeEuwav", dateFormat.parse("7/7/2018"), "687 Barby Trail", "Plano", "Texas", "United States", "75074");
			addEmployee(8, "Sylvan", "Lamey", "Actuary", 2, "slamey7@nymag.com", "505-920-7700", "MKphxSYI", dateFormat.parse("6/2/2019"), "597 Sunbrook Park", "Albuquerque", "New Mexico", "United States", "87115");
			addEmployee(9, "Jordanna", "Petersen", "Developer III", 3, "jpetersen8@ning.com", "919-367-0707", "a2ZizIo33", dateFormat.parse("12/29/2018"), "49550 Mccormick Park", "Raleigh", "North Carolina", "United States", "27605");
			addEmployee(10, "Amy", "Jugging", "Director of Sales", 3, "ajugging9@taobao.com", "505-349-0625", "4b7eBZjWDHu6", dateFormat.parse("5/22/2019"), "171 Warner Hill", "Albuquerque", "New Mexico", "United States", "87115");
			addEmployee(11, "Joice", "Gilson", "Mechanical Systems Engineer", 3, "jgilsona@purevolume.com", "318-344-1766", "OSKOWgcpOud0", dateFormat.parse("10/1/2018"), "4375 Butternut Parkway", "Shreveport", "Louisiana", "United States", "71161");
			addEmployee(12, "Emilia", "Easseby", "Staff Accountant III", 4, "eeassebyb@google.es", "202-556-5962", "hE731ffI", dateFormat.parse("10/15/2018"), "32 Truax Plaza", "Washington", "District of Columbia", "United States", "20409");
			addEmployee(13, "Verla", "Esselen", "Assistant Professor", 4, "vesselenc@ning.com", "571-290-0273", "HznHuuN5LNDb", dateFormat.parse("7/8/2018"), "1 Eastwood Place", "Arlington", "Virginia", "United States", "22205");
			addEmployee(14, "Valencia", "Shackesby", "Web Designer I", 4, "vshackesbyd@ning.com", "419-527-6968", "OVsfsriBt", dateFormat.parse("3/24/2019"), "91042 Randy Park", "Toledo", "Ohio", "United States", "43699");
			addEmployee(15, "Rickert", "Pomery", "Nurse Practicioner", 5, "rpomerye@e-recht24.de", "952-688-4955", "3hcmaO2gMd", dateFormat.parse("6/12/2019"), "65 Algoma Point", "Young America", "Minnesota", "United States", "55573");
			addEmployee(16, "Savina", "Levensky", "Product Engineer", 5, "slevenskyf@mashable.com", "615-623-3019", "iyGIyhSqa", dateFormat.parse("4/5/2019"), "6687 Forest Dale Pass", "Nashville", "Tennessee", "United States", "37210");
			addEmployee(17, "Lenee", "Goozee", "Programmer IV", 5, "lgoozeeg@independent.co.uk", "859-458-9938", "ShwkjunZCi", dateFormat.parse("11/30/2018"), "0 Thierer Drive", "Lexington", "Kentucky", "United States", "40524");
			addEmployee(18, "Leupold", "O'Neal", "Office Assistant II", 15, "lonealh@domainmarket.com", "315-381-1266", "YSkCjHBKw", dateFormat.parse("1/8/2019"), "57718 Swallow Alley", "Utica", "New York", "United States", "13505");
			addEmployee(19, "Chrissie", "Frampton", "Internal Auditor", 15, "cframptoni@mozilla.com", "260-919-5148", "rkYN8yoxGZJ", dateFormat.parse("7/30/2018"), "3462 Fulton Circle", "Fort Wayne", "Indiana", "United States", "46825");
			addEmployee(20, "Mar", "Domenichini", "Office Assistant II", 17, "mdomenichinij@disqus.com", "803-473-3173", "O6mRYCd", dateFormat.parse("7/29/2018"), "96 American Junction", "Columbia", "South Carolina", "United States", "29208");

			
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
			
			nextEmployeeID = 21;
			nextRequestID = 21;
			
		} catch(ParseException e) {
			
			e.printStackTrace();
		}
	}
	
	private void addEmployee(int employeeID, String firstName, String lastName, String title, int managerID, String email, String phone, String password, Date hireDate, String address, String city, String state, String country, String postalCode) {
		
		PasswordResult passResult = PasswordUtil.hashPassword(password);
		
		employees.add(new Employee(employeeID, firstName, lastName, title, managerID, email, phone, passResult.getHash(), passResult.getSalt(), hireDate, address, city, state, country, postalCode));
	}
	
	public Employee getEmployeeByEmail(String email) {
		
		if(employees == null || employees.isEmpty())
			return null;
		
		for(Employee emp : employees) {
			if(emp.getEmail().equals(email))
				return emp;
		}
		
		return null;
	}
	
	boolean isEmailTaken(String email) {
		return getEmployeeByEmail(email) != null;
	}
	
	public Employee getEmployee(int employeeID) {
		
		if(employeeID <= 0 || employeeID >= nextEmployeeID)
			return null;
		
		if(employees == null || employees.isEmpty())
			return null;
		
		for(Employee emp : employees) {
			if(emp.getEmployeeID() == employeeID)
				return emp;
		}
		
		return null;
	}
	
	public List<Employee> getSubordinates(int managerId) {
		
		List<Employee> employeesOfManager = new ArrayList<Employee>();
		
		if(employees == null || employees.isEmpty())
			return employeesOfManager;
		
		for(Employee emp : employees) {
			
			if(emp.getManagerID() == managerId) {
				
				employeesOfManager.add(emp);
				employeesOfManager.addAll(getSubordinates(emp.getEmployeeID()));
			}
		}
		
		return employeesOfManager;
	}
	
	public boolean hasManager(int employeeID) {
		
		Employee emp = getEmployee(employeeID);
		
		return emp != null && emp.getManagerID() != 0;
	}
	
	public void updateEmployee(Employee employee) {
		
		if(employee == null)
			return;
		
		if(employees == null || employees.isEmpty())
			return;
		
		for(int i = 0; i < employees.size(); i++) {
			
			if(employees.get(i).getEmployeeID() == employee.getEmployeeID()) {
				
				employees.set(i, employee);
				return;
			}
		}
	}
	
	public void removeEmployee(Employee employee) {
		
		if(employee == null)
			return;
		
		if(employees == null || employees.isEmpty())
			return;
		
		for(int i = 0; i < employees.size(); i++) {
			
			if(employees.get(i) != null && employees.get(i).getEmployeeID() == employee.getEmployeeID()) {
				
				employees.remove(i);
				return;
			}
		}
	}
	
	public void createReimbursementRequest(ReimbursementRequest request) {
		
		request.setRequestID(nextRequestID);
		nextRequestID++;
		
		if(requests == null)
			requests = new ArrayList<ReimbursementRequest>();
		
		requests.add(request);
	}
	
	public ReimbursementRequest getReimbursementRequest(int requestID) {
		
		if(requestID <= 0 || requestID >= nextRequestID)
			return null;
		
		if(requests == null || requests.isEmpty())
			return null;
		
		for(ReimbursementRequest req : requests) {
			
			if(req.getRequestID() == requestID)
				return req;
		}
		
		return null;
	}
	
	public List<ReimbursementRequest> getRequestsForEmployee(int employeeID) {
		
		List<ReimbursementRequest> empRequests = new ArrayList<ReimbursementRequest>();
		
		if(requests == null || requests.isEmpty())
			return empRequests;
		
		for(ReimbursementRequest req : requests) {
			if(req.getEmployeeID() == employeeID)
				empRequests.add(req);
		}
		
		return empRequests;
	}
	
	public List<ReimbursementRequest> getRequestsForManager(int managerID) {
		
		List<ReimbursementRequest> managerRequests = new ArrayList<ReimbursementRequest>();
		
		List<Employee> subordinates = getSubordinates(managerID);
		
		if(requests == null || requests.isEmpty())
			return managerRequests;
		
		if(subordinates == null || subordinates.isEmpty())
			return managerRequests;
		
		for(ReimbursementRequest req : requests) {
			
			for(Employee sub : subordinates) {
				
				if(req.getEmployeeID() == sub.getEmployeeID())
					managerRequests.add(req);
			}
		}
		
		return managerRequests;
	}
	
	public void updateReimbursementRequest(ReimbursementRequest request) {
		
		if(request == null)
			return;
		
		if(requests == null || requests.isEmpty())
			return;
		
		for(int i = 0; i < requests.size(); i++) {
			
			if(requests.get(i).getRequestID() == request.getRequestID()) {
				
				requests.set(i, request);
				return;
			}
		}
	}
	
	public void removeReimbursementRequest(int requestID) {
		
		if(requests == null || requests.isEmpty())
			return;
		
		for(int i = 0; i < requests.size(); i++) {
			
			if(requests.get(i).getRequestID() == requestID) {
				
				requests.remove(i);
				return;
			}
		}
	}
}
