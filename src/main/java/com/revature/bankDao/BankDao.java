package com.revature.bankDao;

import java.util.List;

import com.revature.beans.Account;


public interface BankDao {
	boolean update(); 
	boolean saveUser(Account b);
	boolean login(Account b);
	List<Account> findAll();
}
