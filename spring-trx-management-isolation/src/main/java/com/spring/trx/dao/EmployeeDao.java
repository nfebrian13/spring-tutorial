package com.spring.trx.dao;

import com.spring.trx.model.Employee;

public interface EmployeeDao {
	void insertEmployee(Employee cus);
	void deleteEmployeeById(String empid);
}