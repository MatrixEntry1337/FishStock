package com.KOIFish.FishStock.middletier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KOIFish.FishStock.backend.FishStockFacade;
import com.KOIFish.FishStock.beans.FishStockUser;

@Service(value="userservice")
public class FishStockUserService {
	@Autowired
	private FishStockFacade facade;
	public void setFacade(FishStockFacade facade) { this.facade = facade; }
	
	public FishStockUser authenticateUser(String username, String password){
		return null;
	}
}
