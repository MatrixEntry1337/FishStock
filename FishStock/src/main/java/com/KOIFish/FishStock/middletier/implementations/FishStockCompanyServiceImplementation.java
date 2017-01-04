package com.KOIFish.FishStock.middletier.implementations;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KOIFish.FishStock.backend.FishStockFacade;
import com.KOIFish.FishStock.beans.FishStockCompany;
import com.KOIFish.FishStock.middletier.FishStockCompanyService;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

@Service(value="companyservice")
public class FishStockCompanyServiceImplementation implements FishStockCompanyService{

	@Autowired
	private FishStockFacade facade;
	public void setCompanyDAO(FishStockFacade facade){ this.facade = facade;}

	@Override
	public Map<String,Stock> getAllCompanies() throws IOException {
		Set<FishStockCompany> set = facade.getAllCompanies();
		List<FishStockCompany> list = null;
		int size = set.size();
		String[] symbols = new String[size];
		int current = 0;
		for(FishStockCompany com: set){
			symbols[current] = com.getSymbol();
			current++;
		}
		
		// API call - Yahoo 
		Map<String, Stock> stocks = YahooFinance.get(symbols, true);
//		System.out.println(stocks.get("INTC").getName());
		System.out.println("Stocks:" + stocks.toString());
		
		return stocks;
	}
}

