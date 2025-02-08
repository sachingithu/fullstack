package com.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
