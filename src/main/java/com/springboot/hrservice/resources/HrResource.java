package com.springboot.hrservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.hrservice.models.Employee;
import com.springboot.hrservice.models.EmployeesList;

@RestController
@RequestMapping("/hr")
public class HrResource {

	List<Employee> employee = Arrays.asList(new Employee("Z123", "John", "Cena", "MediTech"),
			new Employee("X123", "Lila", "Mike", "Optometry"), new Employee("C123", "Solace", "Chuck", "Dentist"));

	@RequestMapping("/employees")
	public EmployeesList getEmployees(){
		EmployeesList employeesList = new EmployeesList();
		employeesList.setEmployees(employee);
		return employeesList;
	}
	
	@RequestMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable("id") String id) {
		Employee e = employee.stream()
				.filter(employee -> id.equals(employee.getId()))
				.findAny()
				.orElse(null);
		
		return e;	
		
	}

}

	
