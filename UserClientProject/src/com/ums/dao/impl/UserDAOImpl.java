package com.ums.dao.impl;

import java.util.ArrayList;
import java.util.Scanner;

import com.ums.dao.UserDAO;
import com.ums.pojo.User;

public class UserDAOImpl implements UserDAO {
	Scanner sc = new Scanner(System.in);
	ArrayList<User> addUsers = new ArrayList<>();

	@Override
	public void register() {
		int k = 1;
		while (k == 1) {
			System.out.println("Enter user id");
			int uid = sc.nextInt();
			System.out.println("Enter first name");
			String fname = sc.next();
			System.out.println("Enter last name");
			String lname = sc.next();
			System.out.println("Enter email");
			String email = sc.next();
			System.out.println("Enter password");
			String password = sc.next();
			User user = new User(uid, fname, lname, email, password);
			addUsers.add(user);
			System.out.println("User registered ");
			System.out.println("Do you want to register 1)Yes 2)No");
			k = sc.nextInt();

		}
	}

	@Override
	public boolean verifyEmailAndPassword(String email, String password) {
		boolean flag = false;
		for (User user : addUsers) {
			if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public String forgotPassword(String email) {
		String pass=null;
		for(User user:addUsers) {
			if(user.getEmail().equals(email)) {
				pass = user.getPassword();
			}
		}
		return pass;
	}
	
	}
