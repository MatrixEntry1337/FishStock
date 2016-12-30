package com.KOIFish.FishStock.backend.implementations;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.KOIFish.FishStock.backend.FishStockUserDAO;
import com.KOIFish.FishStock.beans.FishStockUser;

@Component(value="userDAO")
public class FishStockUserDAOImplementationIlya implements FishStockUserDAO {

	@Override
	public FishStockUser getUserByUsername(Session session, String username) {
		Criteria criteria = session.createCriteria(FishStockUser.class);
		criteria.add(Restrictions.eq("username", username));
		return (FishStockUser)criteria.uniqueResult();
	}

	@Override
	public FishStockUser getUserById(Session session, Integer id) {
		Criteria criteria = session.createCriteria(FishStockUser.class);
		criteria.add(Restrictions.idEq(id));
		return (FishStockUser)criteria.uniqueResult();
	}

}
