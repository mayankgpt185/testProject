package com.test.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.model.DimManager;

@Transactional(value = "testconfigDSTransactionManager")
@Repository
public class signUpDaoImpl implements signUpDao {

	@PersistenceContext(unitName = "testconfigDSEmFactory")
	@Qualifier
	private EntityManager entityManager;

	@Override
	public int register(DimManager manager) {
		entityManager.persist(manager);
		return 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String checkEmailDuplication(String emailId) {
		try {
			List<DimManager> manager = entityManager.createQuery("Select c from DimManager c where c.email=:email")
					.setParameter("email", emailId).getResultList();

			if (manager.size() == 0) {
				return "1";
			} else {
				return "0";
			}

		} catch (Exception e) {
			System.out.println(e);
			return "0";
		}

	}

}
