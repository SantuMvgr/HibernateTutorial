package com.sandyprojects.main;

import java.util.List;

import com.sandyprojects.dao.CompanyDAO;
import com.sandyprojects.dao.EmployeeDAO;
import com.sandyprojects.dao.RoleDAO;
import com.sandyprojects.daoimpl.CompanyDAOImpl;
import com.sandyprojects.daoimpl.EmployeeDAOImpl;
import com.sandyprojects.daoimpl.RoleDAOImpl;
import com.sandyprojects.entity.Company;
import com.sandyprojects.entity.Employee;
import com.sandyprojects.entity.Role;
import com.sandyprojects.util.HibernateUtil;

public class HibernateApp {

	/**
	 * @param args
	 */
	
	private static CompanyDAO companyDAO = new CompanyDAOImpl();
	private static RoleDAO roleDAO = new RoleDAOImpl();
	private static EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Intialize Hibernate session");
		HibernateUtil.init();	
		
		Company company = new Company();
		company.setId(3001);
		company.setName("Infosys");
		company.setIndustry("Software");
		
		//session.save(company);
		companyDAO.save(company);
		
		
		Company company2 = new Company();
		company2.setId(3002);
		company2.setName("Goldman Sachs");
		company2.setIndustry("Banking");
		
		//session.save(company);
		companyDAO.save(company2);
		
		Role role = new Role();
		role.setId(301);
		role.setName("Software Engineer");
		
		//session.save(role);
		roleDAO.save(role);
		
		for(int i = 1001; i < 1100; i++) {
			Employee employee = new Employee();
			employee.setName("Santosh Mandapati");
			employee.setId(i);
			if(i%5 == 0) 
				employee.setCompany(company2);
			else
				employee.setCompany(company);
			
			employee.setRole(role);
			
			//session.save(employee);
			employeeDAO.save(employee);
			
		}
		
		List<Employee> employeeList = employeeDAO.getEmployeesByCompany(3002);
		System.out.println("Employees - " + employeeList.size());
		for(Employee employee : employeeList) {
			System.out.println(employee.getId() + " - " + employee.getName());
		}

	}
	
}
