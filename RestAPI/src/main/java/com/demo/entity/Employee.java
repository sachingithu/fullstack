package com.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Emp_Practiced")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message = "Name is required")
	private String ename;
	private String eadd;
	private Double esal;
	public Employee(Integer id, String ename, String eadd, Double esal) {
		super();
		this.id = id;
		this.ename = ename;
		this.eadd = eadd;
		this.esal = esal;
	}
	public Employee() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEadd() {
		return eadd;
	}
	public void setEadd(String eadd) {
		this.eadd = eadd;
	}
	public Double getEsal() {
		return esal;
	}
	public void setEsal(Double esal) {
		this.esal = esal;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", ename=" + ename + ", eadd=" + eadd + ", esal=" + esal + "]";
	}
	
}
