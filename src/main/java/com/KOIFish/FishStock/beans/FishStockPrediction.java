package com.KOIFish.FishStock.beans;


/**
 * Bean to hold prediction data. The factors' values don't mean anything special;
 * what's important is the sign of the factor. Positive - may go up, negative - may go down, 
 * zero - may stay the same.
 * @author Ilya Siatheyeu
 *
 */
public class FishStockPrediction {
	private FishStockCompany company;
	private int withinDayFactor, withinWeekFactor, withinMonthFactor, withinYearFactor;
	
	public FishStockPrediction() { super(); }
	
	public FishStockPrediction(FishStockCompany company, int withinDayFactor, int withinWeekFactor,
			int withinYearFactor) {
		super();
		this.company = company;
		this.withinDayFactor = withinDayFactor;
		this.withinWeekFactor = withinWeekFactor;
		this.withinYearFactor = withinYearFactor;
	}
	
	public FishStockCompany getCompany() { return company; }
	public void setCompany(FishStockCompany company) { this.company = company; }
	
	public int getWithinDayFactor() { return withinDayFactor; }
	public void setWithinDayFactor(int withinDayFactor) { this.withinDayFactor = withinDayFactor; }
	
	public int getWithinWeekFactor() { return withinWeekFactor; }
	public void setWithinWeekFactor(int withinWeekFactor) { this.withinWeekFactor = withinWeekFactor; }
		
	public int getWithinMonthFactor() { return withinMonthFactor; }
	public void setWithinMonthFactor(int withinMonthFactor) { this.withinMonthFactor = withinMonthFactor; }

	public int getWithinYearFactor() { return withinYearFactor; }
	public void setWithinYearFactor(int withinYearFactor) { this.withinYearFactor = withinYearFactor; }
}
