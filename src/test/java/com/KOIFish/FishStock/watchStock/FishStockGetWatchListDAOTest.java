package com.KOIFish.FishStock.watchStock;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.KOIFish.FishStock.backend.FishStockTimePeriodDAO;
import com.KOIFish.FishStock.beans.FishStockTimePeriod;
import com.KOIFish.FishStock.beans.FishStockUser;

public class FishStockGetWatchListDAOTest {

	private static ApplicationContext context;
	
	@BeforeClass
	public static void preClass(){
		context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");
	}
	
	@Test
	public void getWatchList(){
		FishStockTimePeriodDAO dao = context.getBean("timePeriodDAO", FishStockTimePeriodDAO.class);
		
		// create user
		FishStockUser user = new FishStockUser();
		user.setId(1);
		user.setUsername("thanks");
		
		Set<FishStockTimePeriod> set = dao.getWatchList(user);
		for(FishStockTimePeriod tp : set){
			assertEquals(user.getId(), tp.getUser().getId());
		}
	}
}
