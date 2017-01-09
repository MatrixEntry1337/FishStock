package com.KOIFish.FishStock.middletier;

import java.io.IOException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.KOIFish.FishStock.beans.FishStockCompany;
import com.KOIFish.FishStock.beans.FishStockTimePeriod;
import com.KOIFish.FishStock.beans.FishStockTransferCompanies;
import com.KOIFish.FishStock.beans.FishStockUser;
import com.KOIFish.FishStock.beans.Rating;

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
	
	private FishStockTimePeriodService timePeriodService;
	@Autowired
	public void setTimePeriodService(FishStockTimePeriodService timePeriodService){ this.timePeriodService = timePeriodService; }
	
	public FishStockUser authenticateUser(String username, String password) {
		return userService.authenticateUser(username, password);
	}
	
	public FishStockTransferCompanies getAllCompanies() throws IOException{
		return companyService.getAllCompanies();
	}

    public void modifyCompanyRating(Rating rating) {
	    userService.modifyCompanyRating(rating);
    }

    public void addCompanyToWatch(FishStockUser user, FishStockCompany company){
    	timePeriodService.addCompanyToWatch(user, company);
    }
    
    public void removeCompanyFromWatch(FishStockUser user, FishStockCompany company){
    	timePeriodService.removeCompanyFromWatch(user, company);
    }
    
    public Set<FishStockTimePeriod> getAllWatchList(){
    	return timePeriodService.getAllWatchList();
    }
}
