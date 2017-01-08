package com.KOIFish.FishStock.beans;

import java.util.Map;
import java.util.Set;

import yahoofinance.Stock;

public class FishStockTransferCompanies {
	
	private Set<FishStockCompany> companies;
	private Map<String, Stock> stocks;
	
	public FishStockTransferCompanies() {
		super();
	}

	public FishStockTransferCompanies(Set<FishStockCompany> companies, Map<String, Stock> stocks) {
		super();
		this.companies = companies;
		this.stocks = stocks;
	}

	public Set<FishStockCompany> getCompanies() {
		return companies;
	}

	public void setCompanies(Set<FishStockCompany> companies) {
		this.companies = companies;
	}

	public Map<String, Stock> getStocks() {
		return stocks;
	}

	public void setStocks(Map<String, Stock> stocks) {
		this.stocks = stocks;
	}

	@Override
	public String toString() {
		return "FishStockTransferCompanies [companies=" + companies + ", stocks=" + stocks + "]\n";
	}
	
}
