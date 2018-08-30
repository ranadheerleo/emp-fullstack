package com.employeeinfo.repo;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.employeeinfo.data.Employee;

@Mapper
public interface EmployeeMyBatisRepository {
	@Select("select * from employee")
	public List<Employee> findAll();

	@Select("SELECT * FROM employee WHERE id = #{id}")
	public Employee findById(long id);

	@Delete("DELETE FROM employee WHERE id = #{id}")
	public int deleteById(long id);

	@Insert("INSERT INTO employee(id, name, salary, deptartment, designation) VALUES (#{id}, #{name}, #{salary}, #{deptartment}, #{designation})")
	public int insert(Employee employee);

	@Update("Update employee set name=#{name}, salary=#{salary}, deptartment=#{deptartment}, designation=#{designation} where id=#{id}")
	public int update(Employee employee);

}
