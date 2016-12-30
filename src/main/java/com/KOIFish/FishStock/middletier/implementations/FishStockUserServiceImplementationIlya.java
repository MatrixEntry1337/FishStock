package com.KOIFish.FishStock.middletier.implementations;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KOIFish.FishStock.backend.FishStockFacade;
import com.KOIFish.FishStock.beans.FishStockUser;
import com.KOIFish.FishStock.middletier.FishStockUserService;

@Service(value="userservice")
public class FishStockUserServiceImplementationIlya implements FishStockUserService {
	@Autowired
	private FishStockFacade facade;
	public void setFacade(FishStockFacade facade) { this.facade = facade; }
	
	public FishStockUser authenticateUser(String username, String password){
		FishStockUser user = facade.getUserByUsername(username);
		
		if (user == null || user.getPassword() == null) { return null; }
		
		if (!BCrypt.checkpw(password, user.getPassword())) {
			return null;
		}
		
		return user;
	}
}
