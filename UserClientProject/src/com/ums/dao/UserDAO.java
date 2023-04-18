package com.ums.dao;

public interface UserDAO {
	public void register();
	public boolean verifyEmailAndPassword(String email, String password);
	public String forgotPassword(String email);

}
