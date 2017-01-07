package com.KOIFish.FishStock.middletier.implementations;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KOIFish.FishStock.backend.FishStockFacade;
import com.KOIFish.FishStock.beans.FishStockCompany;
import com.KOIFish.FishStock.beans.FishStockTransferCompanies;
import com.KOIFish.FishStock.middletier.FishStockCompanyService;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

@Service(value="companyservice")
public class FishStockCompanyServiceImplementation implements FishStockCompanyService{

	@Autowired
	private FishStockFacade facade;
	public void setCompanyDAO(FishStockFacade facade){ this.facade = facade;}

	@Override
	public FishStockTransferCompanies getAllCompanies() throws IOException {
		Set<FishStockCompany> set = facade.getAllCompanies();
		
		// set size of array for symbols and ids
		int size = set.size();
		String[] symbols = new String[size];
		int[] ids = new int[size];
		
		// grab symbols from set
		int current = 0;
		for(FishStockCompany com: set){
			symbols[current] = com.getSymbol();
			current++;
		}
		
		// API call - Yahoo 
		Map<String, Stock> stocks = YahooFinance.get(symbols, true);
		FishStockTransferCompanies transferData = new FishStockTransferCompanies(set, stocks);
		
		return transferData;
	}
}

