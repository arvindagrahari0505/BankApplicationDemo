package com.capgemini.bl;

import java.util.LinkedList;

import com.capgemini.beans.Account;
import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InsufficientOpeningBalanceException;
import com.capgemini.exception.InvalidAccountNumberException;

public class MyBank {

	public LinkedList<Account> listAccount = new LinkedList<Account>();
	private long accountNumberCounter=1001;
	
	public String createAccount(String name, double amount) throws InsufficientOpeningBalanceException {
		if(amount>=500) {
			Account account = new Account(name,accountNumberCounter,amount);
			listAccount.add(account);
			accountNumberCounter++;
			return "Your Account is created sucessfully.\nYour account number is "+(accountNumberCounter-1);
		}
		throw new InsufficientOpeningBalanceException();
	}
	public Account searchAccount(long accountNumber) throws InvalidAccountNumberException {
		for(Account account: listAccount) {
			if(accountNumber==account.getAccountNumber()) {
				return account;
			}
		}
		throw new InvalidAccountNumberException();
	}
	public String deposit(long accountNumber, double amount) throws InvalidAccountNumberException {
		Account account = searchAccount(accountNumber);
		account.setAmount(account.getAmount()+amount);
		return "You balance is updated sucessfully.\nCurrent Balance in your account is : "+account.getAmount();
	}

	public String withdraw(long accountNumber, double amount) throws InvalidAccountNumberException, InsufficientBalanceException {
		Account account = searchAccount(accountNumber);
		if((account.getAmount()-amount)>=0) {
			account.setAmount(account.getAmount()-amount);
			return "You balance is updated sucessfully.\nCurrent Balance in your account is : "+account.getAmount();
		}
		throw new InsufficientBalanceException();
	}
	
	public String fundTransfer(long fromAccountNumber, long toAccountNumber, double amount) throws InvalidAccountNumberException, InsufficientBalanceException {
		Account fromAccount = searchAccount(fromAccountNumber);
		Account toAccount = searchAccount(toAccountNumber);
		if((fromAccount.getAmount()-amount)>=0) {
			fromAccount.setAmount(fromAccount.getAmount()-amount);
			toAccount.setAmount(toAccount.getAmount()+amount);
			return amount+" transfered to account "+toAccountNumber+" sucessfully.";
		}
		throw new InsufficientBalanceException();
	}

	public String getBalance(long accountNumber) throws InvalidAccountNumberException {
		Account account = searchAccount(accountNumber);
		return "Current Balance in your account is : "+account.getAmount();
	}

	public Account getAccountDetails(long accountNumber) throws InvalidAccountNumberException {
		Account account = searchAccount(accountNumber);
		return account;
	}
	

}
