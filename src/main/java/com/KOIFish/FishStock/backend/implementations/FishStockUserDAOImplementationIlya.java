package com.KOIFish.FishStock.backend.implementations;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.KOIFish.FishStock.backend.FishStockUserDAO;
import com.KOIFish.FishStock.beans.FishStockUser;

@Component(value="userDAO")
public class FishStockUserDAOImplementationIlya implements FishStockUserDAO {

	/**
	 * 
	 * Get user from db by username. If user with given username does not exist, return null.
	 * @param session session created by facade
	 * @param username username
	 * @return User object or null if user with given username does not exist
	 */
	@Override
	public FishStockUser getUserByUsername(Session session, String username) {
		Criteria criteria = session.createCriteria(FishStockUser.class);
		criteria.add(Restrictions.eq("username", username));
		return (FishStockUser)criteria.uniqueResult();
	}

	/**
	 * Get user from db by id (primary key). If that primary key does not exist, return null.
	 * 
	 * @param session session created by facade
	 * @param id id (PK)
	 * @return User object or null if PK does not exist
	 */
	@Override
	public FishStockUser getUserById(Session session, Integer id) {
		Criteria criteria = session.createCriteria(FishStockUser.class);
		criteria.add(Restrictions.idEq(id));
		return (FishStockUser)criteria.uniqueResult();
	}

}
