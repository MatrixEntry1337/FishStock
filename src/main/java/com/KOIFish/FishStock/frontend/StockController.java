package com.KOIFish.FishStock.frontend;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
