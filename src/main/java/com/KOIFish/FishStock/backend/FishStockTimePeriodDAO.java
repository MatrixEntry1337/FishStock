package com.KOIFish.FishStock.backend;

import java.util.Set;

import com.KOIFish.FishStock.beans.FishStockCompany;
import com.KOIFish.FishStock.beans.FishStockTimeperiod;
import com.KOIFish.FishStock.beans.FishStockUser;

public interface FishStockTimePeriodDAO {

	void addCompanytoWatch(FishStockUser user, FishStockCompany company);

	void removeCompanyFromWatch(FishStockUser user, FishStockCompany company);

	Set<FishStockTimeperiod> getAllWatchList();

}
