package com.KOIFish.FishStock.middletier;

import java.io.IOException;

import com.KOIFish.FishStock.beans.FishStockTransferCompanies;

public interface FishStockCompanyService {
	
	public FishStockTransferCompanies getAllCompanies() throws IOException;
	
}
