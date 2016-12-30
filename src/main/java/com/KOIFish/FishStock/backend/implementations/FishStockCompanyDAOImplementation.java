package com.KOIFish.FishStock.backend.implementations;

import com.KOIFish.FishStock.backend.FishStockCompanyDAO;
import com.KOIFish.FishStock.beans.FishStockCompany;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FishStockCompanyDAOImplementation implements FishStockCompanyDAO {

    @Override
    public int getAverageRatingByCompanyId(Session session, int companyId) {
        Criteria criteria = session.createCriteria(FishStockCompany.class);
        criteria.add(Restrictions.eq("companyId", companyId));
        FishStockCompany company = (FishStockCompany) criteria.uniqueResult();
        return company.getTotalRating()/company.getTotalUsersRated();
    }
    public List getAllCompanies(Session session) {
        Criteria criteria = session.createCriteria(FishStockCompany.class);
        return criteria.list();
    }

}