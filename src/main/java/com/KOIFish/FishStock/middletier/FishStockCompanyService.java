package com.KOIFish.FishStock.middletier;

import java.io.IOException;
import java.util.Map;

import yahoofinance.Stock;

public interface FishStockCompanyService {
	
	public Map<String, Stock> getAllCompanies() throws IOException;
	
}
