package com.spring.trx.service;

import com.spring.trx.model.Employee;
import com.spring.trx.model.EmployeeHealthInsurance;
import com.spring.trx.service.impl.InvalidInsuranceAmountException;

public interface OrganizationService {
	public void joinOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance)
			throws InvalidInsuranceAmountException;
	public void leaveOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance);
}
