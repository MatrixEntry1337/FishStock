package com.KOIFish.FishStock.backend;

import com.KOIFish.FishStock.beans.FishStockCompany;
import org.hibernate.Session;

import java.util.Set;

public interface FishStockCompanyDAO {
    int getAverageRatingByCompanyId(int id);
    Set<FishStockCompany> getAllCompanies();
    void modifyRating(int rating, int companyId);
}

