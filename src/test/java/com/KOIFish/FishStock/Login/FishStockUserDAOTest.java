package com.KOIFish.FishStock.Login;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.KOIFish.FishStock.backend.FishStockUserDAO;
import com.KOIFish.FishStock.beans.FishStockUser;

/**
 * Testing userDao getUserBy[] methods
 * 
 * @author Ilya Siarheyeu
 *
 */
public class FishStockUserDAOTest {

	private static ApplicationContext context;

	@BeforeClass
	public static void preClass() {
		context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");
	}

	@Test
	public void testSuccessfulRetrievalByUsername() {
		FishStockUserDAO dao = (FishStockUserDAO) context.getBean("userDAO");

		FishStockUser user = dao.getUserByUsername("thanks");

		assertEquals("thanks", user.getUsername());
		assertEquals("Tom", user.getFirstName());
		assertEquals("Hanks", user.getLastName());
		assertEquals("thankstome@gmail.com", user.getEmail());
		assertNotEquals(0, user.getCompaniesWatched().size());
	}

	@Test
	public void testFailedRetrievalByUsername() {
		FishStockUserDAO dao = (FishStockUserDAO) context.getBean("userDAO");

		FishStockUser user = dao.getUserByUsername("thanksss");

		assertNull(user);
	}

	@Test
	public void testSuccessfulRetrievalById() {
		FishStockUserDAO dao = (FishStockUserDAO) context.getBean("userDAO");

		FishStockUser user = dao.getUserById(1);
		
		assertEquals("thanks", user.getUsername());
		assertEquals("Tom", user.getFirstName());
		assertEquals("Hanks", user.getLastName());
		assertEquals("thankstome@gmail.com", user.getEmail());
	}

	@Test
	public void testFailedRetrievalById() {
		FishStockUserDAO dao = (FishStockUserDAO) context.getBean("userDAO");

		FishStockUser user = dao.getUserById(9999);
		
		assertNull(user);
	}

}
