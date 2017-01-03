package com.KOIFish.FishStock.middletier;

import java.io.IOException;
import java.util.Set;

import com.KOIFish.FishStock.beans.FishStockCompany;

public interface FishStockCompanyService {
	
	public Set<FishStockCompany> getAllCompanies() throws IOException;
	
}
