package com.spring.trx.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.spring.trx.model.EmployeeHealthInsurance;

@Mapper
public interface HealthInsuranceMapper {
	void registerEmployeeHealthInsurance(EmployeeHealthInsurance employeeHealthInsurance);
	void deleteEmployeeHealthInsuranceById(String empid);
}
