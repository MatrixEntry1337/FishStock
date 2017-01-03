package com.KOIFish.FishStock.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Fish_Watchlist")
public class FishStockTimeperiod {
	@Id
	@Column(name="TimePeriodId", nullable=false)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="UserId", nullable=false)
	private FishStockUser user;
	
	@OneToOne
	@JoinColumn(name="CompanyId", nullable=false)
	private FishStockCompany company;
	
	@Column(name="TimeStart")
	private Timestamp startDate;
	
	@Column(name="TimeEnd")
	private Timestamp endDate;
	
	public FishStockTimeperiod() { super(); }
	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
	public FishStockUser getUser() { return user; }
	public void setUser(FishStockUser user) { this.user = user; }
	
	public FishStockCompany getCompany() { return company; }
	public void setCompany(FishStockCompany company) { this.company = company; }
	
	public Timestamp getStartDate() { return startDate; }
	public void setStartDate(Timestamp startDate) { this.startDate = startDate; }
	
	public Timestamp getEndDate() { return endDate; }
	public void setEndDate(Timestamp endDate) { this.endDate = endDate; }
}
