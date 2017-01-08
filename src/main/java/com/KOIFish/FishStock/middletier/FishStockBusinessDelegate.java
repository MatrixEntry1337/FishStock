package com.KOIFish.FishStock.middletier;

import com.KOIFish.FishStock.beans.FishStockTransferCompanies;
import com.KOIFish.FishStock.beans.FishStockUser;
import com.KOIFish.FishStock.beans.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Business delegate class that delegate all the calls to services.
 * 
 * @author Ilya Siarheyeu
 * @author Kyle Chang Fatt
 * @author Osher Cohen
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
	
	public FishStockTransferCompanies getAllCompanies() throws IOException{
		return companyService.getAllCompanies();
	}

    public void modifyCompanyRating(Rating rating) {
	    userService.modifyCompanyRating(rating);
    }

}
