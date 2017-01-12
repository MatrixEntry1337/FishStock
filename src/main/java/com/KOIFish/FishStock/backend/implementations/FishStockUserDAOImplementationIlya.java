package com.KOIFish.FishStock.backend.implementations;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.KOIFish.FishStock.backend.FishStockUserDAO;
import com.KOIFish.FishStock.beans.FishStockUser;

@Component(value="userDAO")
public class FishStockUserDAOImplementationIlya implements FishStockUserDAO {
	
	
	private SessionFactory sessionFactory;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

	/**
	 * 
	 * Get user from db by username. If user with given username does not exist, return null.
	 * @param username username
	 * @return User object or null if user with given username does not exist
	 */
	@Override
	@Transactional (isolation=Isolation.READ_COMMITTED,
					propagation=Propagation.REQUIRES_NEW,
					rollbackFor=Exception.class)
	public FishStockUser getUserByUsername(String username) {
		Session session  = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(FishStockUser.class);
		criteria.add(Restrictions.eq("username", username));
		return (FishStockUser)criteria.uniqueResult();
	}

	/**
	 * Get user from db by id (primary key). If that primary key does not exist, return null.
	 *
	 * @param id id (PK)
	 * @return User object or null if PK does not exist
	 */
	@Override
	@Transactional (isolation=Isolation.READ_COMMITTED,
					propagation=Propagation.REQUIRES_NEW,
					rollbackFor=Exception.class)
	public FishStockUser getUserById(Integer id) {
		Session session  = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(FishStockUser.class);
		criteria.add(Restrictions.idEq(id));
		return (FishStockUser)criteria.uniqueResult();
	}

}
