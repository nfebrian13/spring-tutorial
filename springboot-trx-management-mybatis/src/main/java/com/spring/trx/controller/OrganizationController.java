package com.spring.trx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.trx.model.Employee;
import com.spring.trx.model.EmployeeHealthInsurance;
import com.spring.trx.service.OrganizationService;

@RestController
@RequestMapping("/coba")
public class OrganizationController {

	@Autowired
	private OrganizationService organizationService;

	@RequestMapping(value = "/hit", method = RequestMethod.GET)
	public String getInHouseInquiry() throws Exception {
		Employee emp = new Employee();
		emp.setEmpId("emp1");
		emp.setEmpName("emp1");

		EmployeeHealthInsurance employeeHealthInsurance = new EmployeeHealthInsurance();
		employeeHealthInsurance.setEmpId("emp1");
		employeeHealthInsurance.setHealthInsuranceSchemeName("premium");
		employeeHealthInsurance.setCoverageAmount(20000);

		organizationService.joinOrganization(emp, employeeHealthInsurance);
		return "";
	}

}
