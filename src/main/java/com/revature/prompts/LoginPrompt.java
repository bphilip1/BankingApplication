package com.revature.prompts;

import java.util.List;
import java.util.Scanner;

import com.revature.bankDao.BankDao;
import com.revature.bankDao.BankSerializer;
import com.revature.beans.Account;

public class LoginPrompt implements Prompt{
	private BankDao bd = new BankSerializer();
	
	public Prompt run() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the Nuttiest Bank in the world!!!");		
		System.out.println("Enter Username:");
		String username = scan.nextLine();
		System.out.println("Enter Password:");
		String pass = scan.nextLine();
		
		Account user = new Account(username,pass);
		boolean checkUser = bd.login(user);
		System.out.println(checkUser);
		if(checkUser) {
			System.out.println("IsUser");
			return new UserOptions();
		}else {

			return this;
		}
	}
}
