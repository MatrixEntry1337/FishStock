package com.KOIFish.FishStock.Login;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.KOIFish.FishStock.backend.FishStockUserDAO;
import com.KOIFish.FishStock.beans.FishStockUser;
import com.KOIFish.FishStock.configuration.FishStockBackEndConfiguration;

public class FishStockUserDAOTest {

	private static ApplicationContext context;
	private static SessionFactory sf;

	private Session session;
	private Transaction transaction;

	@BeforeClass
	public static void preClass() {
		context = new AnnotationConfigApplicationContext(FishStockBackEndConfiguration.class);
		sf = new Configuration().configure().buildSessionFactory();
	}

	@AfterClass
	public static void postClass() {

	}

	@Before
	public void preTest() {
		session = sf.openSession();
		transaction = session.beginTransaction();
	}

	@After
	public void postTest() {
		transaction.commit();
		session.close();
	}

	@Test
	public void testSuccessfulRetrievalByUsername() {
		FishStockUserDAO dao = (FishStockUserDAO) context.getBean("userDAO");

		FishStockUser user = dao.getUserByUsername(session, "thanks");

		assertEquals("thanks", user.getUsername());
		assertEquals("Tom", user.getFirstName());
		assertEquals("Hanks", user.getLastName());
		assertEquals("thankstome@gmail.com", user.getEmail());
		assertNotEquals(0, user.getCompaniesWatched().size());
	}

	@Test
	public void testFailedRetrievalByUsername() {
		FishStockUserDAO dao = (FishStockUserDAO) context.getBean("userDAO");

		FishStockUser user = dao.getUserByUsername(session, "thanksss");

		assertNull(user);
	}

	@Test
	public void testSuccessfulRetrievalById() {
		FishStockUserDAO dao = (FishStockUserDAO) context.getBean("userDAO");

		FishStockUser user = dao.getUserById(session, 1);
		
		assertEquals("thanks", user.getUsername());
		assertEquals("Tom", user.getFirstName());
		assertEquals("Hanks", user.getLastName());
		assertEquals("thankstome@gmail.com", user.getEmail());
	}

	@Test
	public void testFailedRetrievalById() {
		FishStockUserDAO dao = (FishStockUserDAO) context.getBean("userDAO");

		FishStockUser user = dao.getUserById(session, 9999);
		
		assertNull(user);
	}

}
