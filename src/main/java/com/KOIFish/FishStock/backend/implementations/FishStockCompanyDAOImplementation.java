package com.KOIFish.FishStock.backend.implementations;

import com.KOIFish.FishStock.backend.FishStockCompanyDAO;
import com.KOIFish.FishStock.beans.FishStockCompany;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Repository(value="companyDAO")
public class FishStockCompanyDAOImplementation implements FishStockCompanyDAO {
	
	private SessionFactory sessionFactory;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }


    @Override
    @Transactional (isolation=Isolation.READ_COMMITTED,
					propagation=Propagation.REQUIRES_NEW,
					rollbackFor=Exception.class)
    public int getAverageRatingByCompanyId(int companyId) {
    	Session session  = sessionFactory.getCurrentSession();
        FishStockCompany company = (FishStockCompany) session.get(FishStockCompany.class, companyId);
        return company.getTotalRating()/company.getTotalUsersRated();
    }
    
	@Override
    @SuppressWarnings("unchecked")
	@Transactional (isolation=Isolation.SERIALIZABLE,
					propagation=Propagation.REQUIRES_NEW,
					rollbackFor=Exception.class)
	public Set<FishStockCompany> getAllCompanies() {
		Session session  = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(FishStockCompany.class);
		return new HashSet<>(criteria.list());
	}

	@Override
	@Transactional (isolation=Isolation.REPEATABLE_READ,
					propagation=Propagation.REQUIRES_NEW,
					rollbackFor=Exception.class)
    public void modifyRating(int rating, int companyId) {
		Session session  = sessionFactory.getCurrentSession();
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