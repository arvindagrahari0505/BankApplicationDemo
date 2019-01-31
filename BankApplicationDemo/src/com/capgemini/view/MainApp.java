package com.capgemini.view;

import java.util.Scanner;

import com.capgemini.bl.MyBank;
import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InsufficientOpeningBalanceException;
import com.capgemini.exception.InvalidAccountNumberException;


public class MainApp {

	public static Scanner sc = new Scanner(System.in);
	public static MyBank myBank = new MyBank();
	public static void main(String[] args) {
		showMenu();

	}

	private static void showMenu() {
		
		int choice;
		System.out.println("****************Welcome to my bank account project***************");
		while(true) {
			System.out.println("1.Create a new account");
			System.out.println("2.Deposit to account");
			System.out.println("3.Withdraw from account");
			System.out.println("4.Fund Transfer");
			System.out.println("5.Get Balance Details");
			System.out.println("6.Get Account Details");
			System.out.println("7.Exit");

			System.out.print("Enter your choice : ");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:createNewAccount();
			       break;
			case 2:deposit();
		       break;
			case 3:withdraw();
			       break;
			case 4:fundTransfer();
			       break;
			case 5:getBalance();
			       break;
			case 6:getAccountDetails();
			       break;
			case 7:System.out.println("**********Please visit again in My Bank***************\nThank You!!");
				   System.exit(0);
			       break;
			default:System.out.println("***********You enter a wrong choice !!***************");
			
			}
		}
	}
	
	private static void createNewAccount() {
		System.out.print("Enter your name : ");
		String name = sc.next();
		System.out.print("Enter opening amount you want to deposit : ");
		double amount = sc.nextDouble();
		try {
			System.out.println(myBank.createAccount(name,amount));
		}
		catch(InsufficientOpeningBalanceException iop) {
			System.out.println(iop.getMessage());
		}
	}

	private static void deposit() {
		System.out.print("Enter your account number : ");
		long accountNumber = sc.nextLong();
		System.out.print("Enter the amount you want to deposit in your account : ");
		double amount = sc.nextDouble();
		
		try {
			System.out.println(myBank.deposit(accountNumber,amount));
		}
		catch(InvalidAccountNumberException ia) {
			System.out.println(ia.getMessage());
		}
	}

	private static void withdraw() {
		System.out.print("Enter your account number : ");
		long accountNumber = sc.nextLong();
		System.err.print("Enter the amount you want to withdraw from your account : ");
		double amount = sc.nextDouble();
		
		try {
			System.out.println(myBank.withdraw(accountNumber,amount));
		}
		catch(InvalidAccountNumberException ia) {
			System.out.println(ia.getMessage());
		}
		catch(InsufficientBalanceException ib) {
			System.out.println(ib.getMessage());
		}
		
	}
	
	private static void fundTransfer() {
		System.out.print("Enter your account number : ");
		long fromAccountNumber = sc.nextLong();
		System.out.print("Enter account number to which you want to transfer : ");
		long toAccountNumber = sc.nextLong();
		System.out.print("Enter amount to transfer : ");
		double amount = sc.nextDouble();
		
		try {
			System.out.println(myBank.fundTransfer(fromAccountNumber,toAccountNumber,amount));
		}
		catch(InvalidAccountNumberException ia) {
			System.out.println(ia.getMessage());
		}
		catch(InsufficientBalanceException ib) {
			System.out.println(ib.getMessage());
		}
	}

	private static void getBalance() {
		System.out.print("Enter your account number : ");
		long accountNumber = sc.nextLong();
		
		try {
			System.out.println(myBank.getBalance(accountNumber));
		}
		catch(InvalidAccountNumberException ia) {
			System.out.println(ia.getMessage());
		}
		
	}

	private static void getAccountDetails() {
		System.out.print("Enter your account number : ");
		long accountNumber = sc.nextLong();
		try {
			System.out.println(myBank.getAccountDetails(accountNumber));
		}
		catch(InvalidAccountNumberException ia) {
			System.out.println(ia.getMessage());
		}
	}

}
