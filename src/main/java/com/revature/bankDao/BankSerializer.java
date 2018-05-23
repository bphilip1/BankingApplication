package com.revature.bankDao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;


public class BankSerializer implements BankDao{
		
	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean login(Account b) {			
				@SuppressWarnings("unchecked")
				List<Account> usersList = findAll();
				for(Account user: usersList) {
					if(user.getUsername().equals(b.getUsername())) {
						
						int userIndex = usersList.indexOf(user);
						System.out.println(userIndex);
						Account currentUser = usersList.get(userIndex);
						usersList.remove(userIndex);
						usersList.add(0,currentUser);
						return true;
					}
				}
		return false;
	}


	@Override
	public boolean saveUser(Account b) {
			try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/resources/accounts.txt"))){
				List<Account> usersList = findAll();			
				usersList.add(b);
				oos.writeObject(usersList);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
	}

	@SuppressWarnings("unchecked")
	public List<Account> findAll() {
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/accounts.txt"))) {

			return (List<Account>) ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
