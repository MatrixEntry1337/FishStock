package com.KOIFish.FishStock.beans;

public class FishStockTransferCredentialsObject {
	
	private String username, password;

	public FishStockTransferCredentialsObject() { super(); }

	public FishStockTransferCredentialsObject(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }

	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
}
