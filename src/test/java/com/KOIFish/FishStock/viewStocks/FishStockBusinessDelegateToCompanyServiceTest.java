
package com.KOIFish.FishStock.viewStocks;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.KOIFish.FishStock.beans.FishStockTransferCompanies;
import com.KOIFish.FishStock.middletier.FishStockBusinessDelegate;

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
		FishStockTransferCompanies transferData = bd.getAllCompanies();
		
		assertNotNull(transferData.getCompanies());
		assertNotNull(transferData.getStocks());
		assertTrue(transferData.getCompanies().size() == 10);
		assertTrue(transferData.getStocks().keySet().size() == 10);
	}
	
	
}
