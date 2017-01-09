package com.KOIFish.FishStock.watchStock;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.KOIFish.FishStock.backend.FishStockTimePeriodDAO;
import com.KOIFish.FishStock.beans.FishStockCompany;
import com.KOIFish.FishStock.beans.FishStockTimePeriod;
import com.KOIFish.FishStock.beans.FishStockUser;

public class FishStockRemoveCompanytoWatchDAOTest {

private static ApplicationContext context;
	
	@BeforeClass
	public static void preClass(){
		context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");
	}
	
	@Test
	public void removeStocktoWatchTest(){
		FishStockTimePeriodDAO dao = context.getBean("timePeriodDAO", FishStockTimePeriodDAO.class);
		
		// create user
		FishStockUser user = new FishStockUser();
		user.setId(1);
		user.setUsername("thanks");
		
		// create company
		FishStockCompany company = new FishStockCompany();
		company.setCompanyId(4);
		company.setSymbol("FB");
		
		dao.addCompanyToWatch(user, company);
		dao.removeCompanyFromWatch(user, company);
		
		FishStockTimePeriod check = new FishStockTimePeriod();
		check.setUser(user);
		check.setCompany(company);
		Set<FishStockTimePeriod> set =  dao.getAllWatchList();
		assertTrue(!set.contains(check));
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void removeStockToWatchViolationTest(){
		FishStockTimePeriodDAO dao = context.getBean("timePeriodDAO", FishStockTimePeriodDAO.class);
		
		// create user
		FishStockUser user = new FishStockUser();
		user.setId(1);
		
		// create company
		FishStockCompany company = new FishStockCompany();
		company.setCompanyId(2);
		
		dao.removeCompanyFromWatch(user, company);
	}
}
