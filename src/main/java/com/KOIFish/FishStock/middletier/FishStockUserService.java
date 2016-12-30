package com.KOIFish.FishStock.middletier;

import com.KOIFish.FishStock.beans.FishStockUser;

/**
 * Interface for user service.
 * 
 * @author Ilya Siarheyeu
 *
 */
public interface FishStockUserService {
	
	public FishStockUser authenticateUser(String username, String password);

}
