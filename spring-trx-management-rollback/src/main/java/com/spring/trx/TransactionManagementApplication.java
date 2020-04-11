package com.spring.trx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.spring.trx.model.Employee;
import com.spring.trx.model.EmployeeHealthInsurance;
import com.spring.trx.service.OrganizationService;
import com.spring.trx.service.impl.InvalidInsuranceAmountException;

@SpringBootApplication
public class TransactionManagementApplication {

	public static void main(String[] args) throws InvalidInsuranceAmountException {

		ApplicationContext context = SpringApplication.run(TransactionManagementApplication.class, args);
		OrganizationService organizationService = context.getBean(OrganizationService.class);

		Employee emp = new Employee();
		emp.setEmpId("emp1");
		emp.setEmpName("emp1");

		EmployeeHealthInsurance employeeHealthInsurance = new EmployeeHealthInsurance();
		employeeHealthInsurance.setEmpId("emp1");
		employeeHealthInsurance.setHealthInsuranceSchemeName("premium");
		employeeHealthInsurance.setCoverageAmount(-1);

		organizationService.joinOrganization(emp, employeeHealthInsurance);
	}

}
