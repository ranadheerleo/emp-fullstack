package com.employeeinfo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeinfo.data.Employee;
import com.employeeinfo.repo.EmployeeMyBatisRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EmpMgmtController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EmployeeMyBatisRepository employeeRepository;

	@GetMapping("/employee")
	public List<Employee> getAllEmployees() {
		// Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
		return employeeRepository.findAll();
	}

	@PostMapping("/employee")
	public int createEmployee(@Valid @RequestBody Employee employee) {
		logger.debug("createEmployee" + employee);
		return employeeRepository.insert(employee);
	}

	@GetMapping(value = "/employee/{id}")
	public Employee getEmployeeById(@PathVariable("id") long id) {
		logger.debug("getEmployeeById" + id);

		return employeeRepository.findById(id);
	}

	@PutMapping(value = "/employee/{id}")
	public int updateEmployee(@PathVariable("id") long id, @Valid @RequestBody Employee employee) {
		logger.debug("updateEmployee" + id + employee);
		Employee employeeData = employeeRepository.findById(id);
		employeeData.setName(employee.getName());
		employeeData.setDesignation(employee.getDesignation());
		employeeData.setDeptartment(employee.getDeptartment());
		employeeData.setSalary(employee.getSalary());

		return employeeRepository.update(employeeData);
	}

	@DeleteMapping(value = "/employee/{id}")
	public int deleteEmployee(@PathVariable("id") long id) {
		logger.debug("deleteEmployee" + id);

		return employeeRepository.deleteById(id);
	}
}