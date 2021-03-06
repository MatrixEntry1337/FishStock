package com.KOIFish.FishStock.Login;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.KOIFish.FishStock.beans.FishStockUser;
import com.KOIFish.FishStock.middletier.FishStockBusinessDelegate;

/**
 * Testing the whole chain, delegate -> dao
 * 
 * @author Ilya Siarheyeu
 *
 */

public class FishStockBusinessDelegateToUserServiceTest {
private static ApplicationContext context;
	

	@BeforeClass
	public static void preClass() {
		context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");
	}
	
	@Test
	public void authenticateFailureTest1() {
		FishStockBusinessDelegate del = (FishStockBusinessDelegate) context.getBean("businessdelegate");
		FishStockUser user = del.authenticateUser("thanksss", "thanksss");
		assertNull(user);
	}
	
	@Test
	public void authenticateFailureTest2() {
		FishStockBusinessDelegate del = (FishStockBusinessDelegate) context.getBean("businessdelegate");
		FishStockUser user = del.authenticateUser("thanks", "thanksss");
		assertNull(user);
	}
	
	@Test
	public void authenticateSuccessTest1() {
		FishStockBusinessDelegate del = (FishStockBusinessDelegate) context.getBean("businessdelegate");
		FishStockUser user = del.authenticateUser("thanks", "thanks");
		assertNotNull(user);
		
		assertEquals("thanks", user.getUsername());
		assertEquals("Tom", user.getFirstName());
		assertEquals("Hanks", user.getLastName());
		assertEquals("thankstome@gmail.com", user.getEmail());
	}
}
