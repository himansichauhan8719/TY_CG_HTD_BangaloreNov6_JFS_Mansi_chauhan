package com.capg.shoppingapp.controller;

import java.util.Scanner;

import com.capg.shoppingapp.bean.Product;
import com.capg.shoppingapp.dao.ShoppingCurd;
import com.capg.shoppingapp.factory.FactoryProduct;
import com.capg.shoppingapp.services.Productservices;

public class ProductDetails {
	Product bean=new Product();
	Scanner sc=new Scanner(System.in);
	ShoppingCurd dao=FactoryProduct.instanceOfProductDaoImpl();
	Productservices services=FactoryProduct.objectofProductservices();
	public void search() {


		System.out.println("Enter productname....");
		bean.setProName(sc.next());
		Product bean1=services.getProduct(bean.getProName());
		if(bean1!=null) {
			System.out.println("productid:"+bean1.getProId());
			System.out.println("productname"+bean1.getProName());
			System.out.println("productcost"+bean1.getProCost());
			System.out.println("productcolor:"+bean1.getProColor());
			System.out.println("productdescription:"+bean1.getDescription());
			System.out.println("Number of products:"+bean1.getNumOfpro());
		}else {
			System.out.println("given product details not found..");
		}
	}
	public void getProductName() {
		char ch='y';
		while(ch=='y'||ch=='y') {
			System.out.println("press 1 to Buy a product...");
			System.out.println("Enter 2 to search again...");
			System.out.println("Enter 3 to go back to menu...");

			int choice=sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("press any key and please enter the following details...");
				String s1=sc.next();
				System.out.println("Enter cardNumber....");
				long i=sc.nextLong();
				System.out.println("Enter cvv...");
				int cvv=sc.nextInt();
				System.out.println("your product has been delivered soon...Thank you..!!");
				System.out.println("do u want to countinue(y/n) ");
				ch = sc.next().charAt(0);
				break;

			case 2:
				ProductDetails pd=new ProductDetails();
				pd.search();
				System.out.println("do u want to countinue(y/n) ");
				ch = sc.next().charAt(0);
				break;
			case 3:
				Productmain p=new Productmain();
				p.main(null);
				System.out.println("do u want to countinue(y/n) ");
				ch = sc.next().charAt(0);
				break;
			}

		}
	}

}
