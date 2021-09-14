package com.test.dao;

import java.util.List;

import com.test.model.DimEmployee;

public interface EmployeeDao {

	int createEmployee(DimEmployee emp);

	List<DimEmployee> getAllEmployee();

	int deleteEmployee(Integer employeeSkey);
}
