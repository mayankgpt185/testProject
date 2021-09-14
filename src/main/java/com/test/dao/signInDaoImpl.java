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
public class signInDaoImpl implements signInDao {

	@PersistenceContext(unitName = "testconfigDSEmFactory")
	@Qualifier
	private EntityManager entityManager;

	@SuppressWarnings({ "unchecked" })
	@Override
	public DimManager signIn(String email, String pass) {
		List<DimManager> personalDetail = entityManager
				.createQuery("Select c from DimManager c where c.email=:email and c.password=:password")
				.setParameter("email", email).setParameter("password", pass).getResultList();

		if (personalDetail.size() != 0) {
			return personalDetail.get(0);
		} else {
			return null;
		}

	}

	@Override
	public DimManager loadUserByUsername(String email) {
		List<DimManager> personalDetail = entityManager.createQuery("Select c from DimManager c where c.email=:email")
				.setParameter("email", email).getResultList();
		if (personalDetail.size() != 0) {
			return personalDetail.get(0);
		} else {
			return null;
		}
	}

}
