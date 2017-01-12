package com.KOIFish.FishStock.backend;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.KOIFish.FishStock.beans.FishStockCompany;
import com.KOIFish.FishStock.beans.FishStockTimePeriod;
import com.KOIFish.FishStock.beans.FishStockUser;
import com.KOIFish.FishStock.beans.Rating;

/**
 * Facade class that redirects calls to DAOs while handling sessions and
 * transactions.
 * 
 * @author Ilya Siarheyeu
 * @author Kyle Chang Fatt
 * @author Osher Cohen
 *
 */
@Component(value = "facade")
public class FishStockFacade {
	
	private FishStockUserDAO userDAO;
	@Autowired
	public void setUserDAO(FishStockUserDAO userDAO) { this.userDAO = userDAO; }

	private FishStockCompanyDAO companyDAO;
	@Autowired
	public void setCompanyDAO(FishStockCompanyDAO companyDAO) { this.companyDAO = companyDAO; }

	private FishStockTimePeriodDAO timePeriodDAO;
	@Autowired
	public void setTimePeriodDAO(FishStockTimePeriodDAO timePeriodDAO){ this.timePeriodDAO = timePeriodDAO; }
	
	public FishStockFacade() { super(); }

	public FishStockUser getUserByUsername(String username) {

		FishStockUser result = userDAO.getUserByUsername(username);
		return result;
	}

	public FishStockUser getUserById(Integer id) {

		FishStockUser result = userDAO.getUserById(id);
		return result;
	}

	public Set<FishStockCompany> getAllCompanies() {

		Set<FishStockCompany> set = companyDAO.getAllCompanies();
		return set;
	}

	public void modifyCompanyRating(Rating rating) {

		companyDAO.modifyRating(rating);
	}
	
	public void addCompanyToWatch(FishStockUser user, FishStockCompany company){
		
		timePeriodDAO.addCompanyToWatch(user, company);
	}
	
	public void removeCompanyFromWatch(FishStockUser user, FishStockCompany company){
		timePeriodDAO.removeCompanyFromWatch(user, company);
	}
	
	public Set<FishStockTimePeriod> getAllWatchList(){
		return timePeriodDAO.getAllWatchList();
	}

	public Set<FishStockTimePeriod> getWatchList(FishStockUser user){
		return timePeriodDAO.getWatchList(user);
	}
}