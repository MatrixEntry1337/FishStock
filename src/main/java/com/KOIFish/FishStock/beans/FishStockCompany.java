package com.KOIFish.FishStock.beans;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Cacheable
@Entity
@Table(name="Fish_Companies")
public class FishStockCompany {
	
	@Id
	@Column(name="CompanyId", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int companyId;
	
	@Column(name="Name", nullable=false, length=100)
	private String companyName;
	
	@Column(name="Symbol", nullable=true, length=10)
	private String symbol;
	
	@Column(name="TotalRating", nullable=true)
	private int totalRating;
	
	@Column(name="TotalUsersRated", nullable=true)
	private int totalUsersRated;
	
	public FishStockCompany(){
		super();
	}
	
	public FishStockCompany(String companyName, String symbol) {
		super();
		this.companyName = companyName;
		this.symbol = symbol;
	}

	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public int getTotalRating() {
		return totalRating;
	}
	public void setTotalRating(int totalRating) {
		this.totalRating = totalRating;
	}
	public int getTotalUsersRated() {
		return totalUsersRated;
	}
	public void setTotalUsersRating(int totalUsersRated) {
		this.totalUsersRated = totalUsersRated;
	}

	@Override
	public String toString() {
		return "FishStockCompany [companyId=" + companyId + ", companyName=" + companyName + ", symbol=" + symbol
				+ ", totalRating=" + totalRating + ", totalUsersRated=" + totalUsersRated + "]";
	}
	
	
}
