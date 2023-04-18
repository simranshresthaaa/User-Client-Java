package com.ums.client;

import java.util.Scanner;

import com.ums.dao.UserDAO;
import com.ums.dao.impl.UserDAOImpl;

public class UserClient {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserDAO daoImpl = new UserDAOImpl();
		while (true) {
			System.out.println("---------------------------------------");
			System.out.println("        1) Create Account");
			System.out.println("        2) Login");
			System.out.println("        3) Forgot Password");
			System.out.println("        4) Exit");
			System.out.println("---------------------------------------");

			System.out.println("Enter the choice");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				daoImpl.register();
				break;
			case 2:
				System.out.println("Enter email");
				String email = sc.next();
				System.out.println("Enter password");
				String password = sc.next();
				boolean flag = daoImpl.verifyEmailAndPassword(email, password);
				if (flag) {
					System.out.println("Valid User");
				} else {
					System.out.println("Invalid User");
				}
				break;
			case 3:
				System.out.println("Enter email");
				String mail = sc.next();
				String pass = daoImpl.forgotPassword(mail);
				if (pass != null)
					System.out.println("Passowrd: " + pass);
				else
					System.out.println("Email does not exist");
				break;
			case 4:
				System.out.println("Thank you for using this system.");
				System.exit(0);
			default:
				System.out.println("Choose between 1 to 4");
			}// end of switch
		} // while

	}
}