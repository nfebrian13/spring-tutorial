package com.spring.trx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.trx.mapper.HealthInsuranceMapper;
import com.spring.trx.model.EmployeeHealthInsurance;

@Service
public class HealthInsuranceService {

	@Autowired
	private HealthInsuranceMapper healthInsuranceDao;

	public void registerEmployeeHealthInsurance(EmployeeHealthInsurance employeeHealthInsurance) {
		healthInsuranceDao.registerEmployeeHealthInsurance(employeeHealthInsurance);
	}

	public void deleteEmployeeHealthInsuranceById(String empid) {
		healthInsuranceDao.deleteEmployeeHealthInsuranceById(empid);
	}
}