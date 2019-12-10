package com.capgemini.forestrymanagement.main;

import java.util.Scanner;

import com.capgemini.forestrymanagement.forestryapp.ContractApp;
import com.capgemini.forestrymanagement.forestryapp.CustomerApp;
import com.capgemini.forestrymanagement.forestryapp.ProductApp;

public class Home {
	public static void home() {
		Scanner sct = new Scanner(System.in);
		int ct = 0;
		do {
			System.out.println("1.Contractor/ 2.Customer/ 3.Product");
			System.out.println("Please enter your choice..");
			ct=sct.nextInt();
			switch(ct) {
			case 1:
				ContractApp.contractApp();
				break;
				
			case 2:
				CustomerApp.customerApp();
				break;
				
			case 3:
				ProductApp.productApp();
				break;

			default:
				break;
			}
		}while(true);
		
	}
}
