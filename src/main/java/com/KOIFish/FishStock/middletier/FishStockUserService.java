package com.KOIFish.FishStock.middletier;

import com.KOIFish.FishStock.beans.FishStockUser;
import com.KOIFish.FishStock.beans.Rating;

/**
 * Interface for user service.
 * 
 * @author Ilya Siarheyeu
 *
 */
public interface FishStockUserService {
	
	public FishStockUser authenticateUser(String username, String password);
	void modifyCompanyRating(Rating rating);
}
