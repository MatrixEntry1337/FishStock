package com.KOIFish.FishStock.viewStocks;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.KOIFish.FishStock.backend.FishStockFacade;
import com.KOIFish.FishStock.beans.FishStockCompany;
import com.KOIFish.FishStock.configuration.FishStockBackEndConfiguration;

public class FishStockFacadeToCompanyDAOTest {

	private static ApplicationContext context;
	
	@BeforeClass
	public static void preClass(){
		context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");
	}
	
	@Test
	public void getAllCompanies(){
		FishStockFacade fsd = context.getBean("facade", FishStockFacade.class);
		Set<FishStockCompany> set = fsd.getAllCompanies();
		System.out.println(set);
		assertNotNull(set);
		assertTrue(set.size() == 10);
	}
	
}
