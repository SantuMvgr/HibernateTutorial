package com.sandyprojects.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="COMPANY")
public class Company implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6644509595804756309L;
	
	@Id
	@Column(name="CID")
	private int id;
	
	@Column(name="CNAME")
	private String name;
	
	@Column(name="INDUSTRY")
	private String industry;
	
	@OneToMany
	private Set<Employee> employees;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
}
