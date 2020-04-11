package com.spring.trx.service;

import com.spring.trx.model.Employee;
import com.spring.trx.model.EmployeeHealthInsurance;

public interface OrganizationService {
	public void joinOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance);
	public void leaveOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance);
}
