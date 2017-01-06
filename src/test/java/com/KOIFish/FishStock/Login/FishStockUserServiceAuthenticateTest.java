package com.KOIFish.FishStock.Login;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.KOIFish.FishStock.beans.FishStockUser;
import com.KOIFish.FishStock.middletier.FishStockUserService;

/**
 * Testing the service authentication methods.
 * 
 * @author Ilya Siarheyeu
 *
 */
public class FishStockUserServiceAuthenticateTest {

	private static ApplicationContext context;
	

	@BeforeClass
	public static void preClass() {
		context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");
	}
	
	@Test
	public void authenticateFailureTest1() {
		FishStockUserService srvc = (FishStockUserService) context.getBean("userservice");
		FishStockUser user = srvc.authenticateUser("thanksss", "thanksss");
		assertNull(user);
	}
	
	@Test
	public void authenticateFailureTest2() {
		FishStockUserService srvc = (FishStockUserService) context.getBean("userservice");
		FishStockUser user = srvc.authenticateUser("thanks", "thanksss");
		assertNull(user);
	}
	
	@Test
	public void authenticateSuccessTest1() {
		FishStockUserService srvc = (FishStockUserService) context.getBean("userservice");
		FishStockUser user = srvc.authenticateUser("thanks", "thanks");
		assertNotNull(user);
		
		assertEquals("thanks", user.getUsername());
		assertEquals("Tom", user.getFirstName());
		assertEquals("Hanks", user.getLastName());
		assertEquals("thankstome@gmail.com", user.getEmail());
	}
}
