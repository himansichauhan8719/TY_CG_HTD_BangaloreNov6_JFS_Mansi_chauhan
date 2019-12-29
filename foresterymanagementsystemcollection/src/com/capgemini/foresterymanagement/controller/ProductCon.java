package com.capgemini.foresterymanagement.controller;

import java.util.Scanner;

import com.capgemini.foresterymanagement.bean.ProductBean;
import com.capgemini.foresterymanagement.factory.FactoryDetails;
import com.capgemini.foresterymanagement.services.ProductServ;

public class ProductCon {
	static	ProductServ services= FactoryDetails.objectProductServices();
	public static void main() {
		Scanner sc= new Scanner(System.in);
		while(true) {
			System.out.println("****PRODUCT OPERATONS****");
			System.out.println("--------------");
			System.out.println("Select the option to perform operations");
			System.out.println("Option 1: Add product details");
			System.out.println("Option 2: Remove product details");
			System.out.println("Option 3: Modify product details");
			System.out.println("option 4: display all product details");
			System.out.println("Option 5: Display product details");
			System.out.println("Option 6: Home");
			String ch=null;
			char c = 'y';
			while(c=='y') {
				ch= sc.next();
				if(ForesteryValidation.isNumber(ch)) {
					c='n';
				} else {
					System.err.println("enter only numbers");
				}
			} 
			Integer choice = Integer.parseInt(ch);
			switch(choice) {

			case 1:
				ProductBean lbean = new ProductBean();
				System.out.println("Add Details of product");
				System.out.println("-------------------");
				System.out.println("Enter product id");
				String id=null;
				char c1='y';
				while(c1=='y') {
					id= sc.next();
					if(ForesteryValidation.isNumber(id)) {
						c1='n';
					} else {
						System.err.println("enter only numbers");
					}
				} 
				lbean.setProId(Integer.parseInt(id));
				System.out.println("Enter product name");
				String name=null;
				char n='y';
				while(n=='y') {
					name= sc.next();
					if(ForesteryValidation.isStringAlphabet(name)) {
						n='n';
					} else {
						System.err.println("enter only alphabets");
					}
				} 
				lbean.setProName(name);
				System.out.println("Enter product units");
				String units=null;
				char u='y';
				while(u=='y') {
					units= sc.next();
					if(ForesteryValidation.isStringAlphabet(units)) {
						u='n';
					} else {
						System.err.println("enter only alphabets");
					}
				} 
				lbean.setUnits(units);
				System.out.println("Enter product quantity");
				String quantity=null;
				char q='y';
				while(q=='y') {
					quantity= sc.next();
					if(ForesteryValidation.isNumber(quantity)) {
						q='n';
					} else {
						System.err.println("enter only numbers");
					}
				} 
				lbean.setProQuantity(Integer.parseInt(quantity));
				services.addProduct(lbean);
				break;
			case 2:
				System.out.println("Enter product id to remove details ");
				String id1=null;
				char c2='y';
				while(c2=='y') {
					System.out.println("Enter product id");
					id1= sc.next();
					if(ForesteryValidation.isNumber(id1)) {
						c2='n';
					} else {
						System.err.println("enter only numbers");
					}
				} 
				services.removeProduct(Integer.parseInt(id1));
				break;
			case 3:
				System.out.println("Enter product id to modify details");
				String id2=null;
				char c3='y';
				while(c3=='y') {
					System.out.println("Enter product id");
					id2= sc.next();
					if(ForesteryValidation.isNumber(id2)) {
						c3='n';
					} else {
						System.err.println("enter only numbers");
					}
				} 
				Integer Id2= Integer.parseInt(id2);
				ProductBean prod= services.searchProduct(Id2);
				if(prod!=null) {
					System.out.println("enter quantity to update");
					String quantity1=null;
					char q1='y';
					while(q1=='y') {
						quantity1= sc.next();
						if(ForesteryValidation.isNumber(quantity1)) {
							q1='n';
						} else {
							System.err.println("enter only numbers");
						}
					} 
					prod.setProQuantity(Integer.parseInt(quantity1));
					services.updateProduct(0, prod);

				} else {
					System.out.println("product id not found");
				}
				break;
			case 4:
				System.out.println("---------");
				services.showAllProduct();
				break;
			case 5:
				System.out.println("Enter product id to show details");
				String id3=null;
				char c4='y';
				while(c4=='y') {
					System.out.println("Enter product id");
					id3= sc.next();
					if(ForesteryValidation.isNumber(id3)) {
						c4='n';
					} else {
						System.err.println("enter only numbers");
					}
				} 
				Integer search=Integer.parseInt(id3);
				ProductBean bean=services.searchProduct(search);
				if(bean!=null) {
					System.out.println(bean);
				} else {
					System.out.println("Product details not found");
				}
				break;
			case 6:
				AdminCon.adminMain();
				break;
			default:
				System.out.println("enter correct option");
				break;
			}
		}
	}
}
