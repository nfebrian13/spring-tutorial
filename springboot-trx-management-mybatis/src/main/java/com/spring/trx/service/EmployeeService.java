package com.spring.trx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.trx.mapper.EmployeeMapper;
import com.spring.trx.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeMapper employeeDao;

	public void insertEmployee(Employee employee) {
		employeeDao.insertEmployee(employee);
	}

	public void deleteEmployeeById(String empid) {
		employeeDao.deleteEmployeeById(empid);
	}

}