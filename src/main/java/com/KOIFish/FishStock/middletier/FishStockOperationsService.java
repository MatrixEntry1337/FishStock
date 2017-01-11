package com.KOIFish.FishStock.middletier;

import com.KOIFish.FishStock.beans.FishStockCompany;
import com.KOIFish.FishStock.beans.FishStockPrediction;

/**
 * Service for operations like prediction and/or comparisson
 * @author Ilya Siarheyeu
 */

public interface FishStockOperationsService {
	public FishStockPrediction predictStock(FishStockCompany company);
}
