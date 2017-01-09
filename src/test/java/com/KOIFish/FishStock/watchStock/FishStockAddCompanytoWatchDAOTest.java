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

public class FishStockAddCompanytoWatchDAOTest {

	
	private static ApplicationContext context;
	
	@BeforeClass
	public static void preClass(){
		context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");
	}
	
	@Test
	public void addStockToWatchTest(){
		FishStockTimePeriodDAO dao = context.getBean("timePeriodDAO", FishStockTimePeriodDAO.class);
		
		// create user
		FishStockUser user = new FishStockUser();
		user.setId(1);
		user.setUsername("thanks");
		
		// create company
		FishStockCompany company = new FishStockCompany();
		company.setCompanyId(3);
		company.setSymbol("CSCO");
		
		// remove and add company
		dao.removeCompanyFromWatch(user, company);
		dao.addCompanyToWatch(user, company);
		
		// search for timePeriod
		FishStockTimePeriod tp = new FishStockTimePeriod();
		tp.setUser(user);
		tp.setCompany(company);
		Set<FishStockTimePeriod> set =  dao.getAllWatchList();
		assertTrue(set.contains(tp));
	}
	
	@Test(expected=Exception.class)
	public void addStockToWatchUniqueViolationTest() {
		FishStockTimePeriodDAO dao = context.getBean("timePeriodDAO", FishStockTimePeriodDAO.class);
		
		// create user
		FishStockUser user = new FishStockUser();
		user.setId(1);
		
		// create company
		FishStockCompany company = new FishStockCompany();
		company.setCompanyId(9);
		
		dao.addCompanyToWatch(user, company);
	}
}
