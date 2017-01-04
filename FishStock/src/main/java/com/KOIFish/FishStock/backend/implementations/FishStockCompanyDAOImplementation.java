package com.KOIFish.FishStock.backend.implementations;

import com.KOIFish.FishStock.backend.FishStockCompanyDAO;
import com.KOIFish.FishStock.beans.FishStockCompany;
import org.hibernate.Criteria;
import org.hibernate.Session;
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

    public void modifyRating(Session session, int rating, int companyId) {
        int totalRating;
        int usersRated;
        FishStockCompany company = (FishStockCompany) session.get(FishStockCompany.class, companyId);
        totalRating = company.getTotalRating();
        usersRated = company.getTotalUsersRated();
        totalRating += rating;
        usersRated++;
        company.setTotalRating(totalRating);
        company.setTotalUsersRated(usersRated);
        session.update(company);
    }
}