package com.cg.bam.dao;

import java.util.ArrayList;

import com.cg.bam.dto.Customer;
import com.cg.bam.dto.Transaction;
import com.cg.bam.exception.BankAccountException;

public interface BankAccountDAO {

	public void createAccount(Customer customer);
	
	public void deposit(String mobileNo, double amount);
	
	public void withdraw(String mobileNo, double amount);
	
	public double checkBalance(String mobileNo);
	
	public void fundTransfer(String sender, String reciever, double amount);
	
	public boolean validateAccount(String mobileNo) throws BankAccountException;
	
	public void getTransactionList(String mobileNo);
	
}
