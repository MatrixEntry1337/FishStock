package com.KOIFish.FishStock.backend;

import org.hibernate.Session;

import com.KOIFish.FishStock.beans.FishStockUser;

/**
 * Interface for UserDAO
 * 
 * @author Ilya Siarheyeu
 *
 */
public interface FishStockUserDAO {
	public FishStockUser getUserByUsername(Session session, String username);
	public FishStockUser getUserById(Session session, Integer id);
}
