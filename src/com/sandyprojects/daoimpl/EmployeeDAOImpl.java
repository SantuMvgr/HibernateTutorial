package com.sandyprojects.daoimpl;

import java.util.List;

import org.hibernate.Query;

import com.sandyprojects.dao.EmployeeDAO;
import com.sandyprojects.entity.Employee;
import com.sandyprojects.util.HibernateUtil;

public class EmployeeDAOImpl extends GenericDAOImpl<Employee, Long> implements EmployeeDAO {
	
	@Override
	public List<Employee> getEmployeesByCompany(int companyId) {
		HibernateUtil.startTransaction();
		Query query = HibernateUtil.getCurrentSession().getNamedQuery("Employee.findByCompany");
		query.setParameter("id", companyId);
		
		List<Employee> employeeList = query.list();
		HibernateUtil.releaseConnection();
		return employeeList;
	}

	@Override
	public List<Employee> getEmployeesByRole(int roleId) {
		// TODO Auto-generated method stub
		return null;
	}

}
