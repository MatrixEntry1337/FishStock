package com.KOIFish.FishStock.backend;

import com.KOIFish.FishStock.beans.FishStockCompany;
import com.KOIFish.FishStock.beans.FishStockUser;
import com.KOIFish.FishStock.beans.Rating;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Facade class that redirects calls to DAOs while handling sessions and
 * transactions.
 * 
 * @author Ilya Siarheyeu
 *
 */
@Component(value = "facade")
public class FishStockFacade {
	private FishStockUserDAO userDAO;

	@Autowired
	public void setUserDAO(FishStockUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	private FishStockCompanyDAO companyDAO;

	@Autowired
	public void setCompanyDAO(FishStockCompanyDAO companyDAO) {
		this.companyDAO = companyDAO;
	}

	public FishStockFacade() {
		super();
	}

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
}
