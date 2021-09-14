package com.test.service;

import java.util.List;

import com.test.model.DimEmployee;

public interface EmployeeService {

	int createEmployee(DimEmployee emp);

	List<DimEmployee> getAllEmployee();

	int deleteEmployee(Integer employeeSkey);
}
