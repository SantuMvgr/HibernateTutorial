package com.sandyprojects.dao;

import java.util.List;

import com.sandyprojects.entity.Employee;

public interface EmployeeDAO extends GenericDAO<Employee, Long> {
	
	public List<Employee> getEmployeesByCompany(int companyId);
	public List<Employee> getEmployeesByRole(int roleId);

}
