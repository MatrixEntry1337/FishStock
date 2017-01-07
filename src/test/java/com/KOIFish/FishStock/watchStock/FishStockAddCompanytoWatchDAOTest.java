package com.KOIFish.FishStock.watchStock;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.KOIFish.FishStock.backend.FishStockTimePeriodDAO;
import com.KOIFish.FishStock.beans.FishStockCompany;
import com.KOIFish.FishStock.beans.FishStockUser;

public class FishStockAddCompanytoWatchDAOTest {

	
	private static ApplicationContext context;
	
	@BeforeClass
	public void preClass(){
		context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans/xml");
	}
	
	@Test
	public void watchStockTest(){
		FishStockTimePeriodDAO dao = context.getBean("timePeriodDAO", FishStockTimePeriodDAO.class);
		FishStockUser user = new FishStockUser();
		FishStockCompany company = new FishStockCompany();
		dao.addCompanytoWatch(user, company);
		
	}
	
}
