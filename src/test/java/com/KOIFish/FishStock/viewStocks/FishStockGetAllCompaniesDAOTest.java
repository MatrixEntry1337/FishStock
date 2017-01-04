package com.KOIFish.FishStock.viewStocks;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.KOIFish.FishStock.backend.FishStockCompanyDAO;
import com.KOIFish.FishStock.beans.FishStockCompany;
import com.KOIFish.FishStock.configuration.FishStockBackEndConfiguration;

public class FishStockGetAllCompaniesDAOTest {

	private static  ApplicationContext context;
	private static 	SessionFactory sf;
	
	private Session session;
	
	@BeforeClass
	public static void preClass(){
		context = new AnnotationConfigApplicationContext(FishStockBackEndConfiguration.class);
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	@AfterClass
	public static void postClass(){
		
	}
	
	@Before
	public void before(){
		session = sf.openSession();
	}
	
	@After
	public void after(){
		session.close();
	}
	
	@Test
	public void getAllCompanies(){
		FishStockCompanyDAO dao = context.getBean("companyDAO", FishStockCompanyDAO.class);
		Set<FishStockCompany> set = dao.getAllCompanies(session);
		assertTrue(set.size() == 10);
		for(FishStockCompany comp: set){
			System.out.println(comp);
			assertTrue(comp.getCompanyName() != null);
		}
	}
}
