package com.KOIFish.FishStock.backend.implementations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.KOIFish.FishStock.backend.FishStockTimePeriodDAO;
import com.KOIFish.FishStock.beans.FishStockCompany;
import com.KOIFish.FishStock.beans.FishStockTimeperiod;
import com.KOIFish.FishStock.beans.FishStockUser;

@Repository(value="timePeriodDAO")
public class FishStockTimPeriodDAOImplementation implements FishStockTimePeriodDAO {

	private SessionFactory sessionFactory;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){ this.sessionFactory = sessionFactory; }
	
	@Override
	@Transactional (isolation=Isolation.REPEATABLE_READ,
					propagation=Propagation.REQUIRES_NEW,
					rollbackFor=Exception.class)
	public void addCompanytoWatch(FishStockUser user, FishStockCompany company) {
		Session session = sessionFactory.getCurrentSession();
		
		FishStockTimeperiod timePeriod = new FishStockTimeperiod();
		timePeriod.setCompany(company);
		timePeriod.setUser(user);
		session.save(timePeriod);
	}
	
	
	
}
