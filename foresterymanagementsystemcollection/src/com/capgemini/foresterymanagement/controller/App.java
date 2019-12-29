package com.capgemini.foresterymanagement.controller;

import java.util.Scanner;

import com.capgemini.foresterymanagement.dao.ContractDao;
import com.capgemini.foresterymanagement.dao.ContractDaoImpl;

public class App{
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		ContractDao dao=new ContractDaoImpl();
		while(true) {
			System.out.println("                            :::: HOME PAGE::::");
			System.out.println(" press 1. CUSTOMER DETAILS");
			System.out.println(" press 2. CONTRACT DETAILS");
			System.out.println(" press 3. LAND DETAILS");
			System.out.println(" press 4. PRODUCT DETAILS");
			System.out.println(" press 5. LOGOUT ");

			int options=sc.nextInt();
			switch (options) {
			case 1:
				CustomerCon.main();
				break;

			case 2:
				ContractCon.main();
				break;
				
			case 3:
				Land.main();
				
			case 4:
				ProductCon.main();
				
			case 5: 
				App.main(args);
				break;
				
			default:
				System.out.println("Enter Correct One ");
				break;
			}
		}
	}
}

