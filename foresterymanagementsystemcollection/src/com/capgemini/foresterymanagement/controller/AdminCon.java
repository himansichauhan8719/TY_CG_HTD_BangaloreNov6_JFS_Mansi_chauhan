package com.capgemini.foresterymanagement.controller;
import java.util.*;

import com.capgemini.foresterymanagement.bean.AdminBean;
import com.capgemini.foresterymanagement.dao.AdminDao;
import com.capgemini.foresterymanagement.dao.AdminDaoImpl;
import com.capgemini.foresterymanagement.factory.FactoryDetails;
import com.capgemini.foresterymanagement.services.AdminServ;

public class AdminCon {

	private static final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})";
	
	static AdminServ serv=  FactoryDetails.objectAdminServ();
	
	public static void adminMain() {
		AdminDao admin=new AdminDaoImpl();
		AdminBean ad=new AdminBean();
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("                            :::WElCOME ADMIN::::");

				System.out.println("                            ::::ADMIN LOGIN::::   ");
				System.out.println("Enter your userName: ");
				String uname=sc.next();
				System.out.println("Enter your password: ");
				String pswd=sc.next();
				boolean login= admin.login(uname, pswd );
				if(login==true) {
		
		          App.main(null);
				}else {
					System.err.println("Invalid UserName or Password To Login..!");
				}
				break;
			}
}

	
}