package com.capgemini.beans;

public class Account {
	
	private long accountNumber;
	private String name;
	private double amount;
	
	
	@Override
	public String toString() {
		return "Your Account Number : " + accountNumber + "\nYour name : " + name + "\nYour amount : " + amount;
	}

	public Account() {
		super();
	}

	public Account(String name, long accountNumber, double amount) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.amount = amount;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
