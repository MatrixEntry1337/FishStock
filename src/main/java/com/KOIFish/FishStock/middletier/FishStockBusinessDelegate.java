package com.KOIFish.FishStock.middletier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.KOIFish.FishStock.beans.FishStockUser;

/**
 * Business delegate class that delegate all the calls to services.
 * 
 * @author Ilya Siarheyeu
 *
 */
@Component(value="businessdelegate")
public class FishStockBusinessDelegate {
	FishStockUserService userService;
	@Autowired
	public void setUserService(FishStockUserService userService) { this.userService = userService; }
	
	public FishStockUser authenticateUser(String username, String password) {
		return userService.authenticateUser(username, password);
	}
}
