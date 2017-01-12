package com.KOIFish.FishStock.predictStock;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.KOIFish.FishStock.beans.FishStockCompany;
import com.KOIFish.FishStock.beans.FishStockPrediction;
import com.KOIFish.FishStock.middletier.FishStockOperationsService;

public class FishStockOperationsServicePredictStockTest {

	private static ApplicationContext context;

	@BeforeClass
	public static void preClass() {
		context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");
	}

	@Test
	public void testServiceItself() {
		FishStockOperationsService sv = (FishStockOperationsService) context.getBean("operationsservice");
		FishStockCompany cmp = new FishStockCompany();
		cmp.setSymbol("GOOG");
		FishStockPrediction pred = sv.predictStock(cmp);
		assertNotNull(pred);
		System.out.println("\nTest operations service predict stock, company : google (GOOG):");
		System.out.println("  Next day: " + pred.getWithinDayFactor());
		System.out.println("  Next week: " + pred.getWithinWeekFactor());
		System.out.println("  Next month: " + pred.getWithinMonthFactor());
		System.out.println("  Next year: " + pred.getWithinYearFactor());
		System.out.println("----------------------------------------------------------------\n");
	}
}
