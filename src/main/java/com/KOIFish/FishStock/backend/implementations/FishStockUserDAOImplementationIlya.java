package com.KOIFish.FishStock.backend.implementations;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.KOIFish.FishStock.backend.FishStockUserDAO;
import com.KOIFish.FishStock.beans.FishStockUser;

@Component(value="userDAO")
public class FishStockUserDAOImplementationIlya implements FishStockUserDAO {

	@Override
	public FishStockUser getUserByUsername(Session session, String username) {
		return null;
	}

	@Override
	public FishStockUser getUserById(Session session, Integer id) {
		return null;
	}

}
