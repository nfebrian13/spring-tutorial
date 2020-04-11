package com.spring.trx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.trx.model.Employee;
import com.spring.trx.model.EmployeeHealthInsurance;
import com.spring.trx.service.EmployeeService;
import com.spring.trx.service.HealthInsuranceService;
import com.spring.trx.service.OrganizationService;

@Service
@Transactional
public class OrganzationServiceImpl implements OrganizationService {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	HealthInsuranceService healthInsuranceService;

	/** @Transactional(rollbackFor = InvalidInsuranceAmountException.class) 
	 *  anotation berikut memastikan apablia gagal insert karena validasi 
	 *  maka semua transaksi akan di rollback
	 * **/
	
	@Override
	@Transactional(rollbackFor = InvalidInsuranceAmountException.class) 
	public void joinOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance)
			throws InvalidInsuranceAmountException {
		employeeService.insertEmployee(employee);
		try {
			healthInsuranceService.registerEmployeeHealthInsurance(employeeHealthInsurance);
		} catch (InvalidInsuranceAmountException e) {
			throw new InvalidInsuranceAmountException("Exception is thrown");
		}
	}

	@Override
	public void leaveOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance) {
		employeeService.deleteEmployeeById(employee.getEmpId());
		healthInsuranceService.deleteEmployeeHealthInsuranceById(employeeHealthInsurance.getEmpId());
	}
}