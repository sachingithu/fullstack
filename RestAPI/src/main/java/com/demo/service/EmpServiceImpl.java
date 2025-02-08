package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Employee;
import com.demo.exceptions.EmployeeNotFound;
import com.demo.repo.EmployeeRepo;

@Service
public class EmpServiceImpl implements IEmpService {
	@Autowired
	private EmployeeRepo repo;
	@Override
	public Employee saveData(Employee emp) {
		Employee em=repo.save(emp);
		return em;
	}

	@Override
	public List<Employee> getAllData() {
		List<Employee> list=repo.findAll();
		return list;
	}

	@Override
	public Optional<Employee> getById(int id) {
	Optional<Employee> emp=repo.findById(id);
	if(emp.isPresent()) {
		repo.findById(id);
	}else {
		throw new EmployeeNotFound(id+" Employee not found");
	}
	return emp;

	}

	@Override
	public String deleteEmployee(int id) {
		Optional<Employee> e=repo.findById(id);
		if(e.isPresent()) {
			repo.deleteById(id);
		}
		else {
			throw new EmployeeNotFound("No employee present with id "+id);
		}
		return "Employee deleted with id "+id;
	}

	@Override
	public String updateData(Employee emp) {
		Optional<Employee> opt=repo.findById(emp.getId());
		if(opt.isPresent()) {
			repo.save(emp);
		return "Employee updated";
		}
		else {
			throw new EmployeeNotFound("Employee not found with id "+emp.getId());
		}
		
	}

	@Override
	public String updatePartial(int  id, Double esal) {
		Optional<Employee> opt=repo.findById(id);
		if(opt.isPresent()) {
			Employee e=opt.get();
					e.setId(id);
					e.setEsal(esal);
					
					repo.save(e);
			return"Employee updated with salary "+e.getEsal()+" and name "+e.getEname();		
		}else {
			throw new EmployeeNotFound("Employee not found with id "+id);
		}
		
	}
	
}
