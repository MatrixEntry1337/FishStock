package com.KOIFish.FishStock.Login;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.KOIFish.FishStock.backend.FishStockFacade;
import com.KOIFish.FishStock.beans.FishStockUser;

/**
 * Testing integration of facade with userdao
 * 
 * @author Ilya Siarheyeu
 *
 */
public class FishStockFacadeToUserDAOTest {

	private static ApplicationContext context;

	@BeforeClass
	public static void preClass() {
		context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");
	}
	
	@Test
	public void testSuccessfulRetrievalByUsername() {
		FishStockFacade fsd = (FishStockFacade) context.getBean("facade");

		FishStockUser user = fsd.getUserByUsername("thanks");

		assertEquals("thanks", user.getUsername());
		assertEquals("Tom", user.getFirstName());
		assertEquals("Hanks", user.getLastName());
		assertEquals("thankstome@gmail.com", user.getEmail());
		assertNotEquals(0, user.getCompaniesWatched().size());
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
