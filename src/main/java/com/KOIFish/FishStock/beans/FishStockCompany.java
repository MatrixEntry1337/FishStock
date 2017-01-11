package com.KOIFish.FishStock.beans;

import javax.persistence.*;


@Cacheable
@Entity
@Table(name = "Fish_Companies")
public class FishStockCompany {

    @Id
    @Column(name = "CompanyId", nullable = false)
    private int companyId;

    @Column(name = "Name", nullable = false, length = 100)
    private String companyName;

    @Column(name = "Symbol", nullable = true, length = 10)
    private String symbol;

    @Column(name = "TotalRating", nullable = true)
    private int totalRating;

    @Column(name = "TotalUsersRated", nullable = true)
    private int totalUsersRated;

    public FishStockCompany() {
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

    public void setTotalUsersRated(int totalUsersRated) {
        this.totalUsersRated = totalUsersRated;
    }

    @Override
    public String toString() {
        return "FishStockCompany [companyId=" + companyId + ", companyName=" + companyName + ", symbol=" + symbol
                + ", totalRating=" + totalRating + ", totalUsersRated=" + totalUsersRated + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FishStockCompany other = (FishStockCompany) obj;
        if (symbol == null) {
            if (other.symbol != null)
                return false;
        } else if (!symbol.equals(other.symbol))
            return false;
        return true;
    }

}
