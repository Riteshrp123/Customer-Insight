package com.xworkz.customerinsigt.dto;

public enum AccountStatus {
	
	BLOCKED("blocked"),UNBLOCKED("unblocked");
   
	String value;
	
	private AccountStatus(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}

