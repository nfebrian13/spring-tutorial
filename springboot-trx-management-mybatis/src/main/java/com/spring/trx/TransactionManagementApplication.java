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
//		SpringApplication.run(TransactionManagementApplication.class, args);

		ApplicationContext context = SpringApplication.run(TransactionManagementApplication.class, args);
		OrganizationService organizationService = context.getBean(OrganizationService.class);

		Employee emp = new Employee();
		emp.setEmpId("emp1");
		emp.setEmpName("emp1");

		EmployeeHealthInsurance employeeHealthInsurance = new EmployeeHealthInsurance();
		employeeHealthInsurance.setEmpId("emp1");
		employeeHealthInsurance.setHealthInsuranceSchemeName("premium");
		employeeHealthInsurance.setCoverageAmount(20000);

		organizationService.joinOrganization(emp, employeeHealthInsurance);
	}

}
