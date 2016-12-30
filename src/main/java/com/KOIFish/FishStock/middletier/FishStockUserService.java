package com.KOIFish.FishStock.middletier;

import com.KOIFish.FishStock.beans.FishStockUser;

public interface FishStockUserService {
	
	public FishStockUser authenticateUser(String username, String password);

}
