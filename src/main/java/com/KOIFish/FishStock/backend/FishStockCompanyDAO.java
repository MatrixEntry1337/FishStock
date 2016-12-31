package com.KOIFish.FishStock.backend;

import java.util.Set;

import org.hibernate.Session;

import com.KOIFish.FishStock.beans.FishStockCompany;

/**
 * Created by yehur on 12/30/2016.
 */
public interface FishStockCompanyDAO {
    int getAverageRatingByCompanyId(Session session, int id);
    Set<FishStockCompany> getAllCompanies(Session session);
}

