package com.KOIFish.FishStock.backend.implementations;

import com.KOIFish.FishStock.backend.FishStockTimePeriodDAO;
import com.KOIFish.FishStock.beans.FishStockCompany;
import com.KOIFish.FishStock.beans.FishStockTimePeriod;
import com.KOIFish.FishStock.beans.FishStockUser;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Repository(value="timePeriodDAO")
public class FishStockTimPeriodDAOImplementation implements FishStockTimePeriodDAO {

	private SessionFactory sessionFactory;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){ this.sessionFactory = sessionFactory; }
	
	@Override
	@Transactional (isolation=Isolation.READ_COMMITTED,
					propagation=Propagation.REQUIRES_NEW,
					rollbackFor=Exception.class)
	public void addCompanyToWatch(FishStockUser user, FishStockCompany company) {
		Session session = sessionFactory.getCurrentSession();
		FishStockTimePeriod timePeriod = new FishStockTimePeriod();
		timePeriod.setCompany(company);
		timePeriod.setUser(user);
		session.save(timePeriod);
	}
	
	@Override
	@Transactional (isolation=Isolation.REPEATABLE_READ,
					propagation=Propagation.REQUIRES_NEW,
					rollbackFor=Exception.class)
	public void removeCompanyFromWatch(FishStockUser user, FishStockCompany company){
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(FishStockTimePeriod.class);
		criteria.add(Restrictions.eq("user", user));
		criteria.add(Restrictions.eq("company", company));
		FishStockTimePeriod timePeriod = (FishStockTimePeriod) criteria.uniqueResult();
		session.delete(timePeriod);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional(isolation=Isolation.READ_UNCOMMITTED,
					propagation=Propagation.REQUIRES_NEW,
					rollbackFor=Exception.class)
	public Set<FishStockTimePeriod> getAllWatchList(){
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(FishStockTimePeriod.class);
		return new HashSet<>(criteria.list());
	}
	
}
