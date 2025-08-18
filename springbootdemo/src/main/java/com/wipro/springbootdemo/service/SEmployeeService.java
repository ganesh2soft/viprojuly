package com.wipro.springbootdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wipro.springbootdemo.entity.SEmployee;

public interface SEmployeeService {

	public void createEmployee(SEmployee employee);
	public List<SEmployee> getAllEmployees();
	public SEmployee getAnEmployee(String email);
	public SEmployee updateEmployee(SEmployee employee);
	public void deleteEmployee(Long eid);
	public Optional<SEmployee> getEmpById(Long eid);
	//public Page<SEmployee> findById(Pageable pageable);
}
