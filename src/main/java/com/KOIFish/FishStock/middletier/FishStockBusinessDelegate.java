package com.KOIFish.FishStock.middletier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.KOIFish.FishStock.beans.FishStockUser;

@Component(value="businessdelegate")
public class FishStockBusinessDelegate {
	@Autowired
	FishStockUserService userService;
	public void setUserService(FishStockUserService userService) { this.userService = userService; }
	
	public FishStockUser authenticateUser(String username, String password) {
		return userService.authenticateUser(username, password);
	}
}
