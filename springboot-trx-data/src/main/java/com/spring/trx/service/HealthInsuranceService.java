package com.spring.trx.service;

import com.spring.trx.model.EmployeeHealthInsurance;

public interface HealthInsuranceService {
	void registerEmployeeHealthInsurance(EmployeeHealthInsurance employeeHealthInsurance);
	void deleteEmployeeHealthInsuranceById(String empid);
}
