package com.wipro.springbootdemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SEmployee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long eid;
	private String name;
	private String email;
	private String password;

	public SEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getEid() {
		return eid;
	}

	public void setEid(Long eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "SEmployee [eid=" + eid + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}

}
