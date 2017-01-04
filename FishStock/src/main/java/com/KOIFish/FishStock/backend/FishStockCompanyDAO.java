package com.KOIFish.FishStock.backend;

import com.KOIFish.FishStock.beans.FishStockCompany;
import org.hibernate.Session;

import java.util.Set;

public interface FishStockCompanyDAO {
    int getAverageRatingByCompanyId(Session session, int id);
    Set<FishStockCompany> getAllCompanies(Session session);
    void modifyRating(Session session, int rating, int companyId);
}

