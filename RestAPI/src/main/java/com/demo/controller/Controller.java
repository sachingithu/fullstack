package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Employee;
import com.demo.service.IEmpService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class Controller {

	@Autowired
	private IEmpService service;
	@PostMapping("/insert")
	public ResponseEntity<?> insertData(@Valid @RequestBody Employee employee,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			//StringBuilder errorMsg=new StringBuilder("Validation Error");
			StringBuilder errorMsg=new StringBuilder();
			//bindingResult.getFieldErrors().forEach(e->errorMsg.append(e.getField()).append(" ").append(e.getDefaultMessage()).append(";"));
			bindingResult.getFieldErrors().forEach(e->errorMsg.append(e.getDefaultMessage()).append(";"));
			//bindingResult.getFieldErrors().forEach(e->e.getField())
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMsg.toString());
		}
		Employee emp=service.saveData(employee);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> list=service.getAllData();
		return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
		Optional<Employee> emp=service.getById(id);
		return new ResponseEntity<Employee>(emp.get(),HttpStatus.OK);
	}

	@PutMapping("/modify")
	public  ResponseEntity<String> modifyData(@RequestBody Employee emp){
		String msg=service.updateData(emp);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
				
	}
	@PatchMapping("/partial")
	public ResponseEntity<String> partialUpdate(@RequestParam("id") int id,@RequestParam("sal") Double sal){
		String msg=service.updatePartial(id, sal);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteEmployee(@RequestParam("ido") int id){
		String msg=service.deleteEmployee(id);
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
}
