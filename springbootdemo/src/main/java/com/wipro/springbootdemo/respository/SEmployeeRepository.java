package com.wipro.springbootdemo.respository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.wipro.springbootdemo.entity.SEmployee;

@Repository
public interface SEmployeeRepository extends JpaRepository<SEmployee, Long>, 
PagingAndSortingRepository<SEmployee, Long>{
	public SEmployee findByEmail(String email);
	//public Page<SEmployee> findByEid(Pageable pageable);
}
