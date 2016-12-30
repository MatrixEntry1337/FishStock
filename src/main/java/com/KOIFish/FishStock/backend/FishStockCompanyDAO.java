package com.KOIFish.FishStock.backend;

import org.hibernate.Session;

/**
 * Created by yehur on 12/30/2016.
 */
public interface FishStockCompanyDAO {
    int getAverageRatingByCompanyId(Session session, int id);


}
