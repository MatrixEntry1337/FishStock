
package com.KOIFish.FishStock.viewStocks;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.KOIFish.FishStock.configuration.FishStockGlobalConfiguration;
import com.KOIFish.FishStock.middletier.FishStockBusinessDelegate;

import yahoofinance.Stock;

public class FishStockBusinessDelegateToCompanyServiceTest {

	private static ApplicationContext context;


	@BeforeClass
	public static void preClass(){
		context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");
	}

	@Test
	public void getAllCompanies() throws Exception{
		FishStockBusinessDelegate bd 
			= context.getBean("businessdelegate", FishStockBusinessDelegate.class);
		Map<String, Stock> stocks = bd.getAllCompanies();
//		System.out.println(set);
		assertNotNull(stocks);
		assertTrue(stocks.size() == 10);
	}
	
	
}
