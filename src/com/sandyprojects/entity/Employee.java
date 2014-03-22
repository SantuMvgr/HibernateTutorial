package com.sandyprojects.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;


@NamedQueries({
	@NamedQuery(
		name="Employee.findByCompany", 
		query="select e from Employee e where e.company.id=:id"),
	
	@NamedQuery(
		name="Employee.findByRole",
		query="select e from Employee e where e.role.id=:id")
	})


@Entity
@Table(name="EMPLOYEE")
@DynamicUpdate(value=true)
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5702138430527556902L;

	@Id
	@Column(name="EID")
	private long id;
	
	@Column(name="ENAME")
	private String name;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Company company;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Role role;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}
