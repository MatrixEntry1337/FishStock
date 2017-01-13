package com.KOIFish.FishStock.beans;


/**
 * Bean to hold prediction data. The factors' values don't mean anything special;
 * what's important is the sign of the factor. Positive - may go up, negative - may go down, 
 * zero - may stay the same.
 * @author Ilya Siatheyeu
 *
 */
public class FishStockPrediction {
	private String symbol;
	private int withinDayFactor, withinWeekFactor, withinMonthFactor, withinYearFactor;
	
	public FishStockPrediction() { super(); }

	public String getSymbol() { return symbol; }
	public void setSymbol(String symbol) { this.symbol = symbol; }

	public int getWithinDayFactor() { return withinDayFactor; }
	public void setWithinDayFactor(int withinDayFactor) { this.withinDayFactor = withinDayFactor; }
	
	public int getWithinWeekFactor() { return withinWeekFactor; }
	public void setWithinWeekFactor(int withinWeekFactor) { this.withinWeekFactor = withinWeekFactor; }
		
	public int getWithinMonthFactor() { return withinMonthFactor; }
	public void setWithinMonthFactor(int withinMonthFactor) { this.withinMonthFactor = withinMonthFactor; }

	public int getWithinYearFactor() { return withinYearFactor; }
	public void setWithinYearFactor(int withinYearFactor) { this.withinYearFactor = withinYearFactor; }

	@Override
	public String toString() {
		return "FishStockPrediction [symbol=" + symbol + ", withinDayFactor=" + withinDayFactor + ", withinWeekFactor="
				+ withinWeekFactor + ", withinMonthFactor=" + withinMonthFactor + ", withinYearFactor="
				+ withinYearFactor + "]";
	}
	
	
}
