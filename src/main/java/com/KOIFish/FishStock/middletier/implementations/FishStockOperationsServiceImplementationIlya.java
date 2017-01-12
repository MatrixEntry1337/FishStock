package com.KOIFish.FishStock.middletier.implementations;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;

import com.KOIFish.FishStock.beans.FishStockCompany;
import com.KOIFish.FishStock.beans.FishStockPrediction;
import com.KOIFish.FishStock.middletier.FishStockOperationsService;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

/**
 * Implementation for Operations Service
 * @author Ilya Siarheyeu
 *
 */
@Service(value="operationsservice")
public class FishStockOperationsServiceImplementationIlya implements FishStockOperationsService {

	@Override
	public FishStockPrediction[] predictStocks(FishStockCompany[] companies) {
		FishStockPrediction[] results = new FishStockPrediction[companies.length];
		
		for (int i = 0; i < companies.length; i++) {
			results[i] = predictStock(companies[i]);
		}
		
		return results;
	}
	
	@Override
	public FishStockPrediction predictStock(FishStockCompany company) {

		FishStockPrediction prediction = new FishStockPrediction();
		prediction.setCompany(company);

		Calendar from, to; // for periods
		to = Calendar.getInstance();
		Stock companyStock;

		// next day prediction (take last 12 calendar days)
		from = Calendar.getInstance();
		from.add(Calendar.DAY_OF_YEAR, -12);
		try {
			companyStock = YahooFinance.get(company.getSymbol(), from, to, Interval.DAILY);
			prediction.setWithinDayFactor(checkUpsAndDowns(companyStock.getHistory()));
		} catch (IOException e) {
			prediction.setWithinDayFactor(0); //if can't read from finance API, lie to the user
		}
		
		//next week prediction (take 3 weeks worth of time in days)
		from = Calendar.getInstance();
		from.add(Calendar.DAY_OF_YEAR, -21);
		
		try {
			companyStock = YahooFinance.get(company.getSymbol(), from, to, Interval.DAILY);
			prediction.setWithinWeekFactor(checkUpsAndDowns(companyStock.getHistory()));
		} catch (IOException e) {
			prediction.setWithinWeekFactor(0); //if can't read from finance API, lie to the user
		}
		
		//next month prediction (take 4 months worth of time in weeks)
		from = Calendar.getInstance();
		from.add(Calendar.MONTH, -4);
		try {
			companyStock = YahooFinance.get(company.getSymbol(), from, to, Interval.WEEKLY);
			prediction.setWithinMonthFactor(checkUpsAndDowns(companyStock.getHistory()));
		} catch (IOException e) {
			prediction.setWithinMonthFactor(0); //if can't read from finance API, lie to the user
		}
		
		//next year prediction (take 4 years worth of time by months)
		from = Calendar.getInstance();
		from.add(Calendar.YEAR, -4);
		try {
			companyStock = YahooFinance.get(company.getSymbol(), from, to, Interval.MONTHLY);
			prediction.setWithinYearFactor(checkUpsAndDowns(companyStock.getHistory()));
		} catch (IOException e) {
			prediction.setWithinYearFactor(0); //if can't read from finance API, lie to the user
		}

		return prediction;
	}

	/**
	 * Convenience method that checks for the increasing and decreasing segments 
	 * and finds their total lengths
	 * @param history stock history
	 * @return difference between decr. segment length and inc. segment length
	 */
	private int checkUpsAndDowns(List<HistoricalQuote> history) {
		
		//sinse history.get(0) is the most recent stock
		//reverse the meaning of ups and downs
		int reverseups = 0, reversedowns = 0, j = 0;

		boolean down = history.get(0).getOpen().compareTo(history.get(1).getOpen()) > 0;
		j = 1; //length of the segment
		int i = 1; //iterator
		while (i < history.size() - 1) {
			if ((down && history.get(i).getOpen().compareTo(history.get(i + 1).getOpen()) > 0) ||
			    (!down && history.get(i).getOpen().compareTo(history.get(i + 1).getOpen()) <= 0)){
				j++;
			} else {
				if (down) {
					reversedowns += j;
					j = 1;
				} else {
					reverseups += j;
					j = 1;
				}
				down = !down;
			}
			i++;
		}
		
		//for the last segment
		if (down) {
			reversedowns += j;
		}
		else {
			reverseups += j;
		}
		
		return reversedowns - reverseups;
	}

	

}
