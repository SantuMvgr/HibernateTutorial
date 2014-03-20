package com.sandyprojects.main;

import org.hibernate.Transaction;

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
		System.out.println("Hibernate Application");
		
		Company company = new Company();
		company.setId(1);
		company.setName("Infosys");
		company.setIndustry("Software");
		
		//session.save(company);
		companyDAO.save(company);
		
		Role role = new Role();
		role.setId(1);
		role.setName("Software Engineer");
		
		//session.save(role);
		roleDAO.save(role);
		
		for(int i = 0; i < 100; i++) {
			Employee employee = new Employee();
			employee.setId(i);
			employee.setName("Santosh Mandapati");
			employee.setCompany(company);
			employee.setRole(role);
			
			//session.save(employee);
			employeeDAO.save(employee);
			
		}	
	}
	
}
