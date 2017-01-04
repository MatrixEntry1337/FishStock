package com.KOIFish.FishStock.backend;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Session giver initializes session factory as a singleton and gives out new session on request.
 * Does not close the sessions that are given.
 * 
 * @author Ilya Siarheyeu
 *
 */
@Repository
public final class FishStockSessionGiver {
	
	private static final SessionFactory sf;
	static {
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	public Session getNewSession() {
		return sf.openSession();
	}
}
