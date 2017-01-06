package com.KOIFish.FishStock.backend.implementations;

import com.KOIFish.FishStock.backend.FishStockCompanyDAO;
import com.KOIFish.FishStock.beans.FishStockCompany;
import com.KOIFish.FishStock.beans.Rating;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository(value="companyDAO")
public class FishStockCompanyDAOImplementation implements FishStockCompanyDAO {

    @Override
    public int getAverageRatingByCompanyId(Session session, int companyId) {
        FishStockCompany company = (FishStockCompany) session.get(FishStockCompany.class, companyId);
        return company.getTotalRating()/company.getTotalUsersRated();
    }
    
	@Override
    @SuppressWarnings("unchecked")
	public Set<FishStockCompany> getAllCompanies(Session session) {
		Criteria criteria = session.createCriteria(FishStockCompany.class);
		return new HashSet<>(criteria.list());
	}

	public FishStockCompany getCompany(Session session, int companyId) {
        Criteria criteria = session.createCriteria(FishStockCompany.class);
        criteria.add(Restrictions.eq("companyId", companyId));
       return (FishStockCompany) criteria.uniqueResult();
    }

    public void modifyRating(Session session, Rating rating) {
        int totalRating;
        int usersRated;
        FishStockCompany company = (FishStockCompany) session.get(FishStockCompany.class, rating.getCompanyId());
        totalRating = company.getTotalRating();
        usersRated = company.getTotalUsersRated();
        totalRating += rating.getRating();
        usersRated++;
        company.setTotalRating(totalRating);
        company.setTotalUsersRated(usersRated);
        session.update(company);
    }
}