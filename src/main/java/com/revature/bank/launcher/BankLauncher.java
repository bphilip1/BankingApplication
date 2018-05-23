package com.revature.bank.launcher;

import com.revature.bankDao.BankDao;
import com.revature.bankDao.BankSerializer;
import com.revature.beans.Account;
import com.revature.prompts.LoginPrompt;
import com.revature.prompts.Prompt;
import com.revature.prompts.UserOptions;

public class BankLauncher {
	public static void main(String[] args) {
		BankDao bd = new BankSerializer();
		Prompt p = new LoginPrompt();
		Account account1 = new Account("squirrelson","1234");
		Account account2 = new Account("acorns","123");
		Account account3 = new Account("mrSquirrel","12345");
		Account account4 = new Account("squirrelton","ilovenuts");
		bd.saveUser(account1);
		bd.saveUser(account2);		
		bd.saveUser(account3);
		bd.saveUser(account4);
//		p.run();
		while(true) {			
			p=p.run();
		}
		//System.out.println(bd.findAll());
	}  
}
