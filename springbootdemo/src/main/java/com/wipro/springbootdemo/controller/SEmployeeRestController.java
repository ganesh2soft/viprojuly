package com.wipro.springbootdemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.springbootdemo.entity.SEmployee;
import com.wipro.springbootdemo.respository.SEmployeeRepository;
import com.wipro.springbootdemo.service.SEmployeeService;

@RestController
@RequestMapping("/api/v1/semployee")
@CrossOrigin(origins = "http://localhost:4200/")
public class SEmployeeRestController {
	@Autowired
	private SEmployeeService sEmployeeService;

	@Autowired
	private SEmployeeRepository sEmployeeRepository;
	
	@GetMapping("/hello")
	public ResponseEntity<String> getApp() {
		
		return new ResponseEntity<String>("WELCOME TO DEEPS AZURE CLOUD SERVER DEMO APP", HttpStatus.OK);
	}

	@PostMapping("/createEmp")
	public ResponseEntity<?> createEmployee(@RequestBody SEmployee employee) {

		sEmployeeService.createEmployee(employee);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@GetMapping("/allempl")
	public ResponseEntity<List<SEmployee>> getAllEmployees() {
		List<SEmployee> emplist = sEmployeeService.getAllEmployees();
		if (emplist.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<SEmployee>>(emplist, HttpStatus.OK);
	}

	@GetMapping("/getAnEmp/{em}")
	public ResponseEntity<SEmployee> getAnEmployee(@PathVariable("em") String email) {
		SEmployee emp = sEmployeeService.getAnEmployee(email);
		if (emp == null) {
			return new ResponseEntity<SEmployee>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<SEmployee>(emp, HttpStatus.OK);
	}

	@PutMapping("/updateempl")
	public ResponseEntity<SEmployee> updateEmployee(@RequestBody SEmployee employee) {

		SEmployee emp = sEmployeeService.updateEmployee(employee);
		if (emp == null) {
			return new ResponseEntity<SEmployee>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<SEmployee>(emp, HttpStatus.OK);
	}

	@DeleteMapping("/deleteempl/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long eid) {
		sEmployeeService.deleteEmployee(eid);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/getEmpById/{eid}")
	public ResponseEntity<Optional<SEmployee>> getEmpById(@PathVariable("eid") Long eid) {
		Optional<SEmployee> emp = sEmployeeService.getEmpById(eid);
		if (emp == null) {
			return new ResponseEntity<Optional<SEmployee>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Optional<SEmployee>>(emp, HttpStatus.OK);
	}

//	@GetMapping
//	public ResponseEntity<Page<SEmployee>> getEmpById(Pageable pageable) {
//
//		Page<SEmployee> emp = sEmployeeService.findById(pageable);
//		if (emp.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<>(emp, HttpStatus.OK);
//	}

	@GetMapping("/page-One")
	public List<SEmployee> getPageOne() {

		// First page with 5 items
		Pageable paging = PageRequest.of(0, 2, Sort.by("name").ascending());
		Page<SEmployee> page = sEmployeeRepository.findAll(paging);

		// Retrieve the items
		return page.getContent();
	}
	
	
	@GetMapping("/semp/{id}")
	public EntityModel<Optional<SEmployee>> getEmployee(@PathVariable Long id) {
		Optional<SEmployee> sEmployee = sEmployeeService.getEmpById(id);

	    return EntityModel.of(sEmployee,
	    		WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SEmployeeRestController.class).getEmpById(id)).withSelfRel(),
	    		WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SEmployeeRestController.class).getAllEmployees()).withRel("semployee"));
	}

}
