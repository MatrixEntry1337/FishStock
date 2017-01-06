package com.KOIFish.FishStock.backend;

import com.KOIFish.FishStock.beans.FishStockUser;

/**
 * Interface for UserDAO
 * 
 * @author Ilya Siarheyeu
 *
 */
public interface FishStockUserDAO {

	public FishStockUser getUserByUsername(String username);
	public FishStockUser getUserById(Integer id);
}
