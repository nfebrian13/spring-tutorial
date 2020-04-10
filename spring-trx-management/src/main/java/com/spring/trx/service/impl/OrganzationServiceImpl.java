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
public class OrganzationServiceImpl implements OrganizationService {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	HealthInsuranceService healthInsuranceService;

	/**
	 * added @Transactional
	 * Transaction is a cross cutting concern and it is implemented using AOP in Spring Boot.
	 **/

	@Override
	@Transactional
	public void joinOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance) {
		employeeService.insertEmployee(employee);

		/**
		 * Skenario Test misalkan service untuk insert berhasil dan untuk pemanggilan
		 * registerEmployeeHealthInsurance gagal karena error test skenario berikut
		 * jika tidak menggunakan annotation @Transactional maka insertEmployee tetap diinsert
		 * sedangkan harusnya keduanya tidak diinsert jika salah satu gagal atau ada error
		 **/

		if (employee.getEmpId().equals("emp1")) {
			throw new RuntimeException("thowing exception to test transaction rollback");
		}

		healthInsuranceService.registerEmployeeHealthInsurance(employeeHealthInsurance);
	}

	@Override
	@Transactional
	public void leaveOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance) {
		employeeService.deleteEmployeeById(employee.getEmpId());
		healthInsuranceService.deleteEmployeeHealthInsuranceById(employeeHealthInsurance.getEmpId());
	}
}
