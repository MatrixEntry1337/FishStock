package com.KOIFish.FishStock.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Fish_Users")
public class FishStockUser {
	@Id
	@Column(name="UserId")
	private int id;
	
	@Column(name="FirstName")
	private String firstName;
	
	@Column(name="LastName")
	private String lastName;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="Username")
	private String username;
	
	@Column(name="Password")
	private String password;
	
	@ManyToMany
	@JoinTable(name="Fish_Watchlist", joinColumns=@JoinColumn(name="UserId"), 
	inverseJoinColumns=@JoinColumn(name="CompanyId"))
	private Set<FishStockCompany> companiesWatched = new HashSet<>();
	
	
	public FishStockUser() { super(); }


	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public String getFirstName() { return firstName; }
	public void setFirstName(String firstName) { this.firstName = firstName; }

	public String getLastName() { return lastName; }
	public void setLastName(String lastName) { this.lastName = lastName; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }

	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }

	public Set<FishStockCompany> getCompaniesWatched() { return companiesWatched; }
	public void setCompaniesWatched(Set<FishStockCompany> companiesWatched) { this.companiesWatched = companiesWatched; }

	@Override
	public String toString() {
		return "FishStockUser [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", username=" + username + ", password=" + password + ", companiesWatched=" + companiesWatched + "]";
	}
	
}
