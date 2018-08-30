package com.employeeinfo.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.employeeinfo.data.Employee;
import com.employeeinfo.repo.EmployeeMyBatisRepository;

@SpringBootApplication
public class EmployeeMgmtApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EmployeeMyBatisRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMgmtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("Employee id 10001 -> {}", repository.findById(10001L));

		logger.info("Inserting -> {}", repository.insert(new Employee(10010L, "John Paul", 2300L, "Sales", "Intern")));

		logger.info("Update 10003 -> {}", repository.update(new Employee(10001L, "Name-Updated", 2300L, "Marketing", "Manager")));

		repository.deleteById(10002L);

		logger.info("All users -> {}", repository.findAll());
	}
}
