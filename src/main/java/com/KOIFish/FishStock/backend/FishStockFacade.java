package com.KOIFish.FishStock.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FishStockFacade {
	@Autowired
	private FishStockUserDAO userDAO;
	
	
}
