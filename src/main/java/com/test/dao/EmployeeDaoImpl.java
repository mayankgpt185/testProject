package com.test.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.model.DimEmployee;

@Transactional(value = "testconfigDSTransactionManager")
@Repository

public class EmployeeDaoImpl implements EmployeeDao {

	@PersistenceContext(unitName = "testconfigDSEmFactory")
	@Qualifier
	private EntityManager entityManager;

	@Override
	public int createEmployee(DimEmployee emp) {

		if (emp.getEmployeeSkey() != null) {
			emp.setStatus(1);
		} else {
			emp.setStatus(1);
		}

		DimEmployee listData = entityManager.merge(emp);

		return 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DimEmployee> getAllEmployee() {
		List<DimEmployee> dimList = entityManager.createQuery("Select c from DimEmployee c where c.status=1")
				.getResultList();
		return dimList;
	}

	@Override
	public int deleteEmployee(Integer employeeSkey) {
		Query deletequery = entityManager
				.createQuery("update DimEmployee e set e.status=:status where e.employeeSkey=:employeeSkey")
				.setParameter("status", 0).setParameter("employeeSkey", employeeSkey);
		deletequery.executeUpdate();
		return 1;
	}

}
