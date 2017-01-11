package com.KOIFish.FishStock.backend;

import com.KOIFish.FishStock.beans.FishStockCompany;
import com.KOIFish.FishStock.beans.FishStockTimePeriod;
import com.KOIFish.FishStock.beans.FishStockUser;

import java.util.Set;

/**
 * The interface Fish stock time period dao.
 */
public interface FishStockTimePeriodDAO {

	/**
	 * Add company to watch.
	 *
	 * @param user    the user
	 * @param company the company
	 */
	void addCompanyToWatch(FishStockUser user, FishStockCompany company);

	/**
	 * Remove company from watch.
	 *
	 * @param user    the user
	 * @param company the company
	 */
	void removeCompanyFromWatch(FishStockUser user, FishStockCompany company);

	/**
	 * Gets all watch list.
	 *
	 * @return the all watch list
	 */
	Set<FishStockTimePeriod> getAllWatchList();

}
