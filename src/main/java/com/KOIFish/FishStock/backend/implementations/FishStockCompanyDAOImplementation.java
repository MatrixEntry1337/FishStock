package com.KOIFish.FishStock.backend.implementations;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.KOIFish.FishStock.backend.FishStockCompanyDAO;
import com.KOIFish.FishStock.beans.FishStockCompany;

@Repository(value="companyDAO")
public class FishStockCompanyDAOImplementation implements FishStockCompanyDAO {

    @Override
    public int getAverageRatingByCompanyId(Session session, int companyId) {
        Criteria criteria = session.createCriteria(FishStockCompany.class);
        criteria.add(Restrictions.eq("companyId", companyId));
        FishStockCompany company = (FishStockCompany) criteria.uniqueResult();
        return company.getTotalRating()/company.getTotalUsersRated();
    }
    
	@Override
	public Set<FishStockCompany> getAllCompanies(Session session) {
		Criteria criteria = session.createCriteria(FishStockCompany.class);
		return new HashSet<FishStockCompany>(criteria.list());
	}

}