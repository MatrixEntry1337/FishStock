package com.KOIFish.FishStock.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * Bean that holds user info
 * 
 * @author Ilya Siarheyeu
 *
 */
@Entity
@Table(name="Fish_Users")
public class FishStockUser {
	@Id
	@Column(name="UserId", nullable=false)
	private int id;
	
	@Column(name="FirstName", nullable=false, length=50)
	private String firstName;
	
	@Column(name="LastName", nullable=false, length=50)
	private String lastName;
	
	@Column(name="Email", nullable=false, length=100)
	private String email;
	
	@Column(name="Username", nullable=false, length=20)
	@JsonIgnore
	private String username;
	
	@Column(name="Password", nullable=false, length=150)
	@JsonIgnore
	private String password;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="user")
	private Set<FishStockTimePeriod> companiesWatched = new HashSet<>();
	
	
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

	public Set<FishStockTimePeriod> getCompaniesWatched() { return companiesWatched; }
	public void setCompaniesWatched(Set<FishStockTimePeriod> companiesWatched) { this.companiesWatched = companiesWatched; }

	@Override
	public String toString() {
		return "FishStockUser [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", username=" + username + ", password=" + password + ", companiesWatched=" + companiesWatched + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		FishStockUser other = (FishStockUser) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
}
