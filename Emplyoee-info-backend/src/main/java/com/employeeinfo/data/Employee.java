package com.employeeinfo.data;

import java.util.Date;

public class Employee {
	private Long id;
    public String name;
    public Long salary;
    public String deptartment; 
    public String designation;

    private Date createdAt = new Date();
    
	public Employee() {
		super();
	}

	public Employee(Long id, String name, Long salary, String deptartment, String designation) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.deptartment = deptartment;
		this.designation = designation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public String getDeptartment() {
		return deptartment;
	}

	public void setDeptartment(String deptartment) {
		this.deptartment = deptartment;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", deptartment=" + deptartment
				+ ", designation=" + designation + ", createdAt=" + createdAt + "]";
	}

	
	
}
