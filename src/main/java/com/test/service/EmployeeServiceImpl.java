package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.EmployeeDao;
import com.test.model.DimEmployee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public int createEmployee(DimEmployee emp) {
		// TODO Auto-generated method stub
		return employeeDao.createEmployee(emp);
	}

	@Override
	public List<DimEmployee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeDao.getAllEmployee();
	}

	@Override
	public int deleteEmployee(Integer employeeSkey) {
		// TODO Auto-generated method stub
		return employeeDao.deleteEmployee(employeeSkey);
	}
}
