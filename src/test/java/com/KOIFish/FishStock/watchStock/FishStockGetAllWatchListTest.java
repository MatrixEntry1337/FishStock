package com.KOIFish.FishStock.watchStock;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.KOIFish.FishStock.backend.FishStockTimePeriodDAO;
import com.KOIFish.FishStock.beans.FishStockTimePeriod;

public class FishStockGetAllWatchListTest {

	private static ApplicationContext context;
	
	@BeforeClass
	public static void preClass(){
		context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");
	}
	
	@Test
	public void getAllWatchListTest(){
		FishStockTimePeriodDAO dao = context.getBean("timePeriodDAO", FishStockTimePeriodDAO.class);
		
		Set<FishStockTimePeriod> set = dao.getAllWatchList();
		assertNotNull(set);
	}
}
