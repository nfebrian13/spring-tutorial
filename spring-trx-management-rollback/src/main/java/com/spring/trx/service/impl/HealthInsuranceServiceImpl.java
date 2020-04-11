package com.spring.trx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.trx.dao.HealthInsuranceDao;
import com.spring.trx.model.EmployeeHealthInsurance;
import com.spring.trx.service.HealthInsuranceService;

@Service
@Transactional
public class HealthInsuranceServiceImpl implements HealthInsuranceService {

	@Autowired
	HealthInsuranceDao healthInsuranceDao;

	@Override
	public void registerEmployeeHealthInsurance(EmployeeHealthInsurance employeeHealthInsurance)
			throws InvalidInsuranceAmountException {

		if (employeeHealthInsurance.getCoverageAmount() < 0) {
			throw new InvalidInsuranceAmountException("Coverage Amount Should not be negative");
		}
		healthInsuranceDao.registerEmployeeHealthInsurance(employeeHealthInsurance);
	}

	@Override
	public void deleteEmployeeHealthInsuranceById(String empid) {
		healthInsuranceDao.deleteEmployeeHealthInsuranceById(empid);
	}

}