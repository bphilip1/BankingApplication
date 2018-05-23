package com.revature.prompts;

import java.util.Scanner;

import com.revature.bankDao.BankDao;
import com.revature.bankDao.BankSerializer;

public class UserOptions implements Prompt{
	
	Scanner scan = new Scanner(System.in);
	private BankDao bd = new BankSerializer();
	@Override
	public Prompt run() {

		System.out.println("Enter 1 to Deposit:");
		System.out.println("Enter 2 to Withdraw:");
		System.out.println("Enter 3 to View Balance:");
		System.out.println("Enter 4 to View Transaction History:");
		String input = scan.nextLine();
		switch (input) {
		case "1":
			System.out.println("Enter the amount you would like to deposit:");
			bd.update();
			break;
		case "2":
			System.out.println("Enter the amount you would like to withdraw:");
			bd.update();
			break;
		case "3":
			
			break;
		case "4":
			
			break;

		default:
			break;
		}
		return this;
	}
	
}
