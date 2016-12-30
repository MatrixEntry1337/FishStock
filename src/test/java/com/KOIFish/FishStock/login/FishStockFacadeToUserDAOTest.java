package com.KOIFish.FishStock.login;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.KOIFish.FishStock.backend.FishStockFacade;
import com.KOIFish.FishStock.beans.FishStockUser;
import com.KOIFish.FishStock.configuration.FishStockBackEndConfiguration;

public class FishStockFacadeToUserDAOTest {

	private static ApplicationContext context;

	@BeforeClass
	public static void preClass() {
		context = new AnnotationConfigApplicationContext(FishStockBackEndConfiguration.class);
	}
	
	@Test
	public void testSuccessfulRetrievalByUsername() {
		FishStockFacade fsd = (FishStockFacade) context.getBean("facade");

		FishStockUser user = fsd.getUserByUsername("thanks");

		assertEquals("thanks", user.getUsername());
		assertEquals("Tom", user.getFirstName());
		assertEquals("Hanks", user.getLastName());
		assertEquals("thankstome@gmail.com", user.getEmail());
	}

	@Test
	public void testFailedRetrievalByUsername() {
		FishStockFacade fsd = (FishStockFacade) context.getBean("facade");

		FishStockUser user = fsd.getUserByUsername("thankssssss");

		assertNull(user);
	}

	@Test
	public void testSuccessfulRetrievalById() {
		FishStockFacade fsd = (FishStockFacade) context.getBean("facade");

		FishStockUser user = fsd.getUserById(1);
		
		assertEquals("thanks", user.getUsername());
		assertEquals("Tom", user.getFirstName());
		assertEquals("Hanks", user.getLastName());
		assertEquals("thankstome@gmail.com", user.getEmail());
	}

	@Test
	public void testFailedRetrievalById() {
		FishStockFacade fsd = (FishStockFacade) context.getBean("facade");

		FishStockUser user = fsd.getUserById(9999);
		
		assertNull(user);
	}
	
}
