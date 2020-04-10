package com.spring.trx.service;

import com.spring.trx.model.Employee;

public interface EmployeeService {
	void insertEmployee(Employee emp);
	void deleteEmployeeById(String empid);
}
