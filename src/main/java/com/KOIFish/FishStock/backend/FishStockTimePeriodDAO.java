package com.KOIFish.FishStock.backend;

import com.KOIFish.FishStock.beans.FishStockCompany;
import com.KOIFish.FishStock.beans.FishStockUser;

public interface FishStockTimePeriodDAO {

	public void addCompanytoWatch(FishStockUser user, FishStockCompany company);

}
