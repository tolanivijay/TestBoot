package com.vijay.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="employee")
//@Entity(collection="employee")
public class Employee {

	@Id
	private String id;
	
	private String name;
	
	private String dept;
	
	private String subdept;
	
	private Integer salary;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getSubdept() {
		return subdept;
	}

	public void setSubdept(String subdept) {
		this.subdept = subdept;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
	
	
	
}
