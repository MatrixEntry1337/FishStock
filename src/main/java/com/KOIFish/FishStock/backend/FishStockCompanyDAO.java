package com.KOIFish.FishStock.backend;

import com.KOIFish.FishStock.beans.FishStockCompany;
import com.KOIFish.FishStock.beans.Rating;

import java.util.Set;

/**
 * The interface Fish stock company dao.
 */
public interface FishStockCompanyDAO {

    /**
     * Gets the average rating by the company id.
     *
     * @param id the id
     * @return the average rating by company id
     */
    int getAverageRatingByCompanyId(int id);

    /**
     * Gets all companies.
     *
     * @return the all companies
     */
    Set<FishStockCompany> getAllCompanies();

    /**
     * Modify rating.
     *
     * @param rating the rating
     */
    void modifyRating(Rating rating);

    /**
     * Gets company.
     *
     * @param companyId the company id
     * @return the company
     */
    FishStockCompany getCompany(int companyId);

}

