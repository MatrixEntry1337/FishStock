package com.KOIFish.FishStock.backend;

import java.util.Set;

import com.KOIFish.FishStock.beans.FishStockCompany;
import com.KOIFish.FishStock.beans.FishStockTimePeriod;
import com.KOIFish.FishStock.beans.FishStockUser;

public interface FishStockTimePeriodDAO {

	void addCompanyToWatch(FishStockUser user, FishStockCompany company);

	void removeCompanyFromWatch(FishStockUser user, FishStockCompany company);

	Set<FishStockTimePeriod> getAllWatchList();

}
