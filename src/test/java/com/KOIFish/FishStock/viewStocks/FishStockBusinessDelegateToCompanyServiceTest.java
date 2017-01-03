
package com.KOIFish.FishStock.viewStocks;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.KOIFish.FishStock.beans.FishStockCompany;
import com.KOIFish.FishStock.configuration.FishStockGlobalConfiguration;
import com.KOIFish.FishStock.middletier.FishStockBusinessDelegate;

public class FishStockBusinessDelegateToCompanyServiceTest {

	private static ApplicationContext context;


	@BeforeClass
	public static void preClass(){
		context = new AnnotationConfigApplicationContext
				(FishStockGlobalConfiguration.class);
	}

	@Test
	public void getAllCompanies() throws Exception{
		FishStockBusinessDelegate bd 
			= context.getBean("businessdelegate", FishStockBusinessDelegate.class);
		Set<FishStockCompany> set = bd.getAllCompanies();
//		System.out.println(set);
		assertNotNull(set);
		assertTrue(set.size() == 10);
	}
}
