package com.demo.service;

import java.util.List;
import java.util.Optional;

import com.demo.entity.Employee;

public interface IEmpService {
	Employee saveData(Employee emp);
	List<Employee> getAllData();
	Optional<Employee> getById(int id);
	String deleteEmployee(int id);
	String updateData(Employee emp);
	String updatePartial(int id,Double esal);
}
