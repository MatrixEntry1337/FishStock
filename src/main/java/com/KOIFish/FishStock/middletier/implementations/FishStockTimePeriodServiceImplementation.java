package com.KOIFish.FishStock.middletier.implementations;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KOIFish.FishStock.backend.FishStockFacade;
import com.KOIFish.FishStock.beans.FishStockCompany;
import com.KOIFish.FishStock.beans.FishStockTimePeriod;
import com.KOIFish.FishStock.beans.FishStockUser;
import com.KOIFish.FishStock.middletier.FishStockTimePeriodService;

@Service
public class FishStockTimePeriodServiceImplementation implements FishStockTimePeriodService{

	private FishStockFacade facade;
	@Autowired
	public void setFacade(FishStockFacade facade){ this.facade = facade; }
	
	@Override
	public void addCompanyToWatch(FishStockUser user, FishStockCompany company) {
		facade.addCompanyToWatch(user, company);
	}

	@Override
	public void removeCompanyFromWatch(FishStockUser user, FishStockCompany company) {
		facade.removeCompanyFromWatch(user, company);
	}

	@Override
	public Set<FishStockTimePeriod> getAllWatchList() {
		return facade.getAllWatchList();
	}
}
