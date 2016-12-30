package com.KOIFish.FishStock.backend;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KOIFish.FishStock.beans.FishStockUser;

@Service(value="facade")
public class FishStockFacade {
	@Autowired
	private FishStockUserDAO userDAO;
	public void setUserDAO(FishStockUserDAO userDAO) { this.userDAO = userDAO; }

	public FishStockFacade() { super(); }
	
	public FishStockUser getUserByUsername(String username) {
		Session session = null; 
		Transaction tx = null;
		FishStockUser result = null;
		try {
			session = FishStockSessionGiver.getNewSession();
			tx = session.beginTransaction();
			result = userDAO.getUserByUsername(session, username);
			tx.commit();
		}
		catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
		}
		finally{
			session.disconnect();
			session.close();
		}
		return result;
	}
	
	public FishStockUser getUserById(Integer id) {
		Session session = null; 
		Transaction tx = null;
		FishStockUser result = null;
		try {
			session = FishStockSessionGiver.getNewSession();
			tx = session.beginTransaction();
			result = userDAO.getUserById(session, id);
			tx.commit();
		}
		catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
		}
		finally{
			session.disconnect();
			session.close();
		}
		return result;
	}

	
}
