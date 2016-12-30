package com.KOIFish.FishStock.backend;

import org.hibernate.Session;

import com.KOIFish.FishStock.beans.FishStockUser;

public interface FishStockUserDAO {
	
	public FishStockUser getUserByUsername(Session session, String username);
	public FishStockUser getUserById(Session session, Integer id);
}
