package com.sandyprojects.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

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
	
	@ManyToOne
	@JoinColumn(name="CNAME")
	private Company company;
	
	@ManyToOne
	@JoinColumn(name="NAME")
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
