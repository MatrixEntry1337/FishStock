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
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.KOIFish.FishStock.backend.FishStockUserDAO;
import com.KOIFish.FishStock.beans.FishStockUser;
import com.KOIFish.FishStock.configuration.FishStockBackEndConfiguration;
import com.KOIFish.FishStock.configuration.FishStockGlobalConfiguration;

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
