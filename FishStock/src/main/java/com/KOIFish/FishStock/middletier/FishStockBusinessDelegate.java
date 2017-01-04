package com.KOIFish.FishStock.middletier;

import java.io.IOException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.KOIFish.FishStock.beans.FishStockUser;

import yahoofinance.Stock;

/**
 * Business delegate class that delegate all the calls to services.
 * 
 * @author Ilya Siarheyeu
 *
 */
@Component(value="businessdelegate")
public class FishStockBusinessDelegate {
	private FishStockUserService userService;
	@Autowired
	public void setUserService(FishStockUserService userService) { this.userService = userService; }
	
	private FishStockCompanyService companyService;
	@Autowired
	public void setCompanyService(FishStockCompanyService companyService) { this.companyService = companyService; }
	
	public FishStockUser authenticateUser(String username, String password) {
		return userService.authenticateUser(username, password);
	}
	
	public Map<String, Stock> getAllCompanies() throws IOException{
		return companyService.getAllCompanies();
	}

    public void modifyCompanyRating(int rating, int companyId) {
	    userService.modifyCompanyRating(rating, companyId);
    }

}
