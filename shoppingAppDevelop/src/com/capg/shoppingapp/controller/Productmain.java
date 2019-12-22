package com.capg.shoppingapp.controller;

import java.util.Scanner;

public class Productmain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char ch = 'y';
		while (ch == 'y' || ch == 'y') {
			System.out.println("shopping application.......");
		System.out.println("press 1 to show all products...");
		System.out.println("press 2 to search for a product...");
		System.out.println("press 3 to exit");
		int choose = sc.nextInt();

		switch (choose) {
		case 1:
			ProductList plist = new ProductList();
			plist.list();
			System.out.println("do u want to countinue(y/n) ");
			ch = sc.next().charAt(0);
			break;
		case 2:
			ProductDetails pdetails=new ProductDetails();
			pdetails.search();
			pdetails.getProductName();
			System.out.println("do u want to countinue(y/n) ");
			ch = sc.next().charAt(0);
			break;
		case 3:
			System.exit(choose);
		}
	}
	}
}
