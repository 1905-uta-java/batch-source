package JBDC_DAO;

import java.util.List;

import ERS_Actors.Employee;

public interface Employee_DAO {
	public Employee empLogin(String username, String password);
	public List<Employee> getAllEmployees();
	public Employee getEmployee(int emp_id);
	public int updateEmpl(Employee e);
}
