package com.spring.trx.service;

import com.spring.trx.model.EmployeeHealthInsurance;
import com.spring.trx.service.impl.InvalidInsuranceAmountException;

public interface HealthInsuranceService {
	void registerEmployeeHealthInsurance(EmployeeHealthInsurance employeeHealthInsurance)
			throws InvalidInsuranceAmountException;
	void deleteEmployeeHealthInsuranceById(String empid);
}
