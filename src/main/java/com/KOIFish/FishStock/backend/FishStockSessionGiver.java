package com.KOIFish.FishStock.backend;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class FishStockSessionGiver {
	
	private FishStockSessionGiver() {}
	
	private static final SessionFactory sf;
	static {
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	public static Session getNewSession() {
		return sf.openSession();
	}
}
