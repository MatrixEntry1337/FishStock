package com.KOIFish.FishStock.backend;

import com.KOIFish.FishStock.beans.FishStockCompany;
import com.KOIFish.FishStock.beans.Rating;
import org.hibernate.Session;

import java.util.Set;

public interface FishStockCompanyDAO {
    int getAverageRatingByCompanyId(Session session, int id);
    Set<FishStockCompany> getAllCompanies(Session session);
    void modifyRating(Session session, Rating rating);
    FishStockCompany getCompany(Session session, int companyId);
}

