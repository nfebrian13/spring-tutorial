package com.spring.trx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.spring.trx.model.Employee;
import com.spring.trx.model.EmployeeHealthInsurance;
import com.spring.trx.service.OrganizationService;

@SpringBootApplication
public class TransactionManagementApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(TransactionManagementApplication.class, args);
		OrganizationService organizationService = context.getBean(OrganizationService.class);

		Employee emp = new Employee();
		emp.setEmpId("emp2");
		emp.setEmpName("emp2");

		EmployeeHealthInsurance employeeHealthInsurance = new EmployeeHealthInsurance();
		employeeHealthInsurance.setEmpId("emp2");
		employeeHealthInsurance.setHealthInsuranceSchemeName("premium");
		employeeHealthInsurance.setCoverageAmount(30000);

		organizationService.joinOrganization(emp, employeeHealthInsurance);
	}

}
