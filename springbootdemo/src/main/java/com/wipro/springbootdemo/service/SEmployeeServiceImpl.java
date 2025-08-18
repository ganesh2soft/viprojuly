package com.wipro.springbootdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wipro.springbootdemo.entity.SEmployee;
import com.wipro.springbootdemo.respository.SEmployeeRepository;
@Service
public class SEmployeeServiceImpl implements SEmployeeService{

	@Autowired
	private SEmployeeRepository sEmployeeRepository;
	
	@Override
	public void createEmployee(SEmployee employee) {
		System.out.println(employee + " to be inserted");
		sEmployeeRepository.save(employee);
		System.out.println("Employee Created successfully !!!");
	}

	@Override
	public List<SEmployee> getAllEmployees() {
		
		return sEmployeeRepository.findAll();
	}

	@Override
	public SEmployee getAnEmployee(String email) {
		
		return sEmployeeRepository.findByEmail(email);
	}

	@Override
	public SEmployee updateEmployee(SEmployee employee) {
		
		return sEmployeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Long eid) {
		
		sEmployeeRepository.deleteById(eid);
	}

	@Override
	public Optional<SEmployee> getEmpById(Long eid) {
		
		return sEmployeeRepository.findById(eid);
	}

//	@Override
//	public Page<SEmployee> findById(Pageable pageable) {
//		// TODO Auto-generated method stub
//		return sEmployeeRepository.findByEid(pageable);
//	}

}
