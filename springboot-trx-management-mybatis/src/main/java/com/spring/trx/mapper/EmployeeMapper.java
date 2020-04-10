package com.spring.trx.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.spring.trx.model.Employee;

@Mapper
public interface EmployeeMapper {
	void insertEmployee(Employee cus);
	void deleteEmployeeById(String empid);
}