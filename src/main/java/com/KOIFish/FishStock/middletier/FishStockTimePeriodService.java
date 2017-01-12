package com.KOIFish.FishStock.middletier;

import java.util.Set;

import com.KOIFish.FishStock.beans.FishStockCompany;
import com.KOIFish.FishStock.beans.FishStockTimePeriod;
import com.KOIFish.FishStock.beans.FishStockUser;

public interface FishStockTimePeriodService {

	public void addCompanyToWatch(FishStockUser user, FishStockCompany company);
	
	public void removeCompanyFromWatch(FishStockUser user, FishStockCompany company);
	
	public Set<FishStockTimePeriod> getAllWatchList();
	
	public Set<FishStockTimePeriod> getWatchList(FishStockUser user);

}
