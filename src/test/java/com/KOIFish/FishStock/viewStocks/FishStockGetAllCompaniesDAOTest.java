package com.KOIFish.FishStock.viewStocks;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.KOIFish.FishStock.backend.FishStockCompanyDAO;
import com.KOIFish.FishStock.beans.FishStockCompany;

public class FishStockGetAllCompaniesDAOTest {

	private static  ApplicationContext context;
	
	@BeforeClass
	public static void preClass(){
		context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");
	}
	
	@Test
	public void getAllCompanies(){
		FishStockCompanyDAO dao = context.getBean("companyDAO", FishStockCompanyDAO.class);
		Set<FishStockCompany> set = dao.getAllCompanies();
		assertTrue(set.size() == 10);
		for(FishStockCompany comp: set){
			System.out.println(comp);
			assertTrue(comp.getCompanyName() != null);
		}
	}
}
