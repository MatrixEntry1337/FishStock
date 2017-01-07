package com.KOIFish.FishStock.backend;

import com.KOIFish.FishStock.beans.FishStockCompany;
import com.KOIFish.FishStock.beans.Rating;
import org.hibernate.Session;

import java.util.Set;

public interface FishStockCompanyDAO {
	
    int getAverageRatingByCompanyId(int id);
    
    Set<FishStockCompany> getAllCompanies();
    
    void modifyRating(Rating rating);
    
    FishStockCompany getCompany(int companyId);
    
}

