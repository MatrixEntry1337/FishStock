package com.KOIFish.FishStock.frontend;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.KOIFish.FishStock.beans.FishStockCompany;
import com.KOIFish.FishStock.beans.FishStockPrediction;
import com.KOIFish.FishStock.beans.FishStockTransferCompanies;
import com.KOIFish.FishStock.middletier.FishStockBusinessDelegate;

import yahoofinance.Stock;

@Controller
public class StockController {

	private FishStockBusinessDelegate delegate;
	@Autowired
	public void setDelegate(FishStockBusinessDelegate delegate) { this.delegate = delegate; }

	@ResponseBody
	@RequestMapping(value={"/getAll.do"}, method={RequestMethod.POST}, produces={"application/json"})
	public FishStockTransferCompanies getAll() throws IOException{
		FishStockTransferCompanies transferData = delegate.getAllCompanies();
		return transferData;
	}
	
	@ResponseBody
	@RequestMapping(value={"/getPrediction.do"}, method={RequestMethod.GET}, produces={"application/json"},
					consumes={"application/json"})
	public FishStockPrediction getPrediction(@RequestBody FishStockCompany company ) {
		FishStockPrediction prediction = delegate.predictStock(company);
		return prediction;
	
	}
	
	@ResponseBody
	@RequestMapping(value={"/getPredictions.do"}, method={RequestMethod.GET}, produces={"application/json"},
					consumes={"application/json"})
	public FishStockPrediction[] getPredictions(@RequestBody FishStockCompany[] companies ) {
		FishStockPrediction[] predictions = delegate.predictStocks(companies);
		return predictions;
	
	}
}
