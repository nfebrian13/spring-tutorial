package com.spring.trx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.trx.model.Employee;
import com.spring.trx.model.EmployeeHealthInsurance;

@Service
public class OrganizationService {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private HealthInsuranceService healthInsuranceService;

	/**
	 * added @Transactional Transaction is a cross cutting concern and it is
	 * implemented using AOP in Spring Boot.
	 **/

	@Transactional
	public void joinOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance) {
		employeeService.insertEmployee(employee);

		/**
		 * Skenario Test misalkan service untuk insert berhasil dan untuk pemanggilan
		 * registerEmployeeHealthInsurance gagal karena error test skenario berikut jika
		 * tidak menggunakan annotation @Transactional maka insertEmployee tetap
		 * diinsert sedangkan harusnya keduanya tidak diinsert jika salah satu gagal
		 * atau ada error
		 **/

		/*
		if (employee.getEmpId().equals("emp1")) {
			throw new RuntimeException("thowing exception to test transaction rollback");
		}*/

		healthInsuranceService.registerEmployeeHealthInsurance(employeeHealthInsurance);

	}

	@Transactional
	public void leaveOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance) {
		employeeService.deleteEmployeeById(employee.getEmpId());
		healthInsuranceService.deleteEmployeeHealthInsuranceById(employeeHealthInsurance.getEmpId());
	}
}
