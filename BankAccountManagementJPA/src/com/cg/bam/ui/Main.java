package com.cg.bam.ui;

import java.util.Scanner;

import com.cg.bam.dto.Customer;
import com.cg.bam.exception.BankAccountException;
import com.cg.bam.service.BankAccountServiceImpl;

public class Main {
	static BankAccountServiceImpl service = new BankAccountServiceImpl();
	static Customer customer;
	static Scanner sc = new Scanner(System.in);

	private static String name;
	private static String mobileNo;
	private static float age;
	private static double amount;
	public static void main(String args[]) throws BankAccountException{



		int choice = 0;//
		do{
			System.out.println("1.Add Customer");//
			System.out.println("2.Deposit amount");//
			System.out.println("3.Withdraw Amount");//
			System.out.println("4.Fund transfer");//
			System.out.println("5.Check balance");//
			System.out.println("6.Print Transaction");//
			System.out.println("7.Exit");//
			System.out.println("Enter your choice : ");//
			choice = sc.nextInt();//

			switch(choice){//
			case 1 : addCustomer(); break;
			case 2 : depositAmount(); break;
			case 3 : withdrawAmount(); break;
				
			case 4 :
				String mobileNoReciever;
				do{
					System.out.println("Enter your mobile number : ");
					mobileNo = sc.next();

					System.out.println("Enter the amount you want to transfer : ");
					amount = sc.nextDouble();

					System.out.println("Enter receivers mobile number : ");
					mobileNoReciever = sc.next();
					if(mobileNo.equals(mobileNoReciever)){								
						System.out.println("Both numbers are same!\nPlease enter unique numbers...");
						continue;
					}
					if(service.validateMoileNo(mobileNo) && service.validateMoileNo(mobileNoReciever) && service.validateAmount(amount)){
						if(service.validateAccount(mobileNoReciever) && service.validateAccount(mobileNo))
							break;
					}
				}while(true);
				service.fundTransfer(mobileNo, mobileNoReciever, amount);

				break;

			case 5 :
				do{
					System.out.println("Enter the moible id to check balance");
					mobileNo = sc.next();
					if(service.validateMoileNo(mobileNo)){
						if(service.validateAccount(mobileNo))																	
							break;
						else
							System.err.println("Mobile number not found.\nPlease enter correct mobile number.");
					}
					else{
						System.err.println("Invalid mobile number!\nEnter valid mobile nummber\nAccount should be present with the number you are entering..\nNumber should be of length 10 \n And must contain only digits");
					}
				}while(true);

				System.out.println("Current Amount is Rs."+service.checkBalance(mobileNo));

				break;

			case 6 :
				do{
					System.out.println("Enter the moible id to get transaction");
					mobileNo = sc.next();
					if(service.validateMoileNo(mobileNo)){
						if(service.validateAccount(mobileNo))																	
							break;
						else
							System.err.println("Mobile number not found.\nPlease enter correct mobile number.");
					}
					else{
						System.err.println("Invalid mobile number!\nEnter valid mobile nummber\nAccount should be present with the number you are entering..\nNumber should be of length 10 \n And must contain only digits");
					}
				}while(true);

				service.getTransactionList(mobileNo);
				break;

			case 7 :
				System.out.println("Ok bye");
				break;
			default : System.out.println("Invalid input!");
			}

		}while(choice != 7);

	}


	


	private static int addCustomer() throws BankAccountException {
		customer = new Customer();						

		System.out.println("Enter customer name : ");
		name = sc.next();
		if(!service.validateName(name))
		{
			System.err.println("Invalid Name!\nName should start with capital letter \nIt should not contain numbers\nLength should be minimum 4 and maximum 10\n");
			return 0;
		}
		else
			System.out.println("Enter mobile no. : ");
		mobileNo = sc.next();
		if(!service.validateMoileNo(mobileNo))
		{
			System.err.println("Invalid Mobile Number!\nNumber should be of length 10 \n And must contain only digits");
			return 0;
		}
		else if(service.validateAccount(mobileNo))
		{
			System.err.println("Account already exist with this number!\nPlease try again!!");
			return 0;
		}
		else				
			System.out.println("Enter age : ");
		age = sc.nextFloat();
		if(service.validateAge(age))
		{
			System.out.println("Enter initial amount : ");
			return 0;
		}
		amount = sc.nextDouble();
		if(!service.validateAmount(amount))
		{
			System.err.println("Invalid Amount!\nAmount shoulb be minimum Rs.500\nSgould contain only digits");
			return 0;
		}
		else
		{
			customer.setName(name);
			customer.setMobileNo(mobileNo);
			customer.setAge(age);
			customer.setInitialBalance(amount);

			service.createAccount(customer);
		}
		return 0;
	}

	private static int depositAmount() throws BankAccountException {

		System.out.println("Enter your mobile number : ");
		mobileNo = sc.next();
		if(!service.validateMoileNo(mobileNo))
		{
			System.err.println("Invalid Mobile Number!\nNumber should be of length 10 \n And must contain only digits");
			return 0;
		}
		else if(!service.validateAccount(mobileNo))
		{
			System.err.println("Account already exist with this number!\nPlease try again!!");
			return 0;
		}
		else
			System.out.println("Enter the amount you want to deposit");
		amount = sc.nextDouble();
		if(!service.validateAmount(amount))
		{
			System.err.println("Invalid Amount!\nAmount shoulb be minimum Rs.500\nSgould contain only digits");
			return 0;
		}
		else
			service.deposit(mobileNo, amount);	
		return 0;
	}
	
	private static int withdrawAmount() throws BankAccountException {
		
			System.out.println("Enter your mobile number : ");
			mobileNo = sc.next();
			if(!service.validateMoileNo(mobileNo))
			{
				System.err.println("Invalid Mobile Number!\nNumber should be of length 10 \n And must contain only digits");
				return 0;
			}
			else if(!service.validateAccount(mobileNo))
			{
				System.err.println("Account already exist with this number!\nPlease try again!!");
				return 0;
			}
			System.out.println("Enter the amount you want to withdraw : ");			
			amount = sc.nextDouble();
			if(service.validateMoileNo(mobileNo) && service.validateAmount(amount)){
				if(service.validateAccount(mobileNo))
					return 0;
			}
			else service.withdraw(mobileNo, amount);
			return 0;
		
		
	}
}