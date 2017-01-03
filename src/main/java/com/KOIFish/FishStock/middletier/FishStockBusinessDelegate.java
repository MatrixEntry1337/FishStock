package com.KOIFish.FishStock.middletier;

import java.io.IOException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.KOIFish.FishStock.beans.FishStockCompany;
import com.KOIFish.FishStock.beans.FishStockUser;

/**
 * Business delegate class that delegate all the calls to services.
 * 
 * @author Ilya Siarheyeu
 * @author Kyle Chang Fatt
 *
 */
@Component(value="businessdelegate")
public class FishStockBusinessDelegate {
	@Autowired
	FishStockUserService userService;
	public void setUserService(FishStockUserService userService) { this.userService = userService; }
	
	@Autowired
	private FishStockCompanyService companyService;
	public void setCompanyService(FishStockCompanyService companyService) { 
		this.companyService = companyService;
	}
	
	public FishStockUser authenticateUser(String username, String password) {
		return userService.authenticateUser(username, password);
	}
	
	public Set<FishStockCompany> getAllCompanies() throws IOException{
		return companyService.getAllCompanies();
	}
}
