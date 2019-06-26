package com.reimbursement.model;

public class Employee {

	private int id;
	private int supervisorId;

	private String name;
	private String username;
	private String password;
	
	private int supervisor;

	public Employee() {
	}

	public Employee(int id, int supervisorId, String name, String username, String password, int supervisor) {
		super();
		this.id = id;
		this.supervisorId = supervisorId;
		this.name = name;
		this.username = username;
		this.password = password;
		this.supervisor = supervisor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSuperisorId() {
		return supervisorId;
	}

	public void setSupervisorId(int supervisorId) {
		this.supervisorId = supervisorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getSupervisor() {
		return this.supervisor;
	}
	
	public void setSupervisor(int supervisor) {
		this.supervisor = supervisor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		// result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + id;
		result = prime * result + supervisorId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((username == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		if (supervisorId != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", supervisorId=" + supervisorId + ", name=" + name + ", username=" + username
				+ "]";
	}
}
