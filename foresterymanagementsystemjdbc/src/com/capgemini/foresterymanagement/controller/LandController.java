package com.capgemini.foresterymanagement.controller;

import java.util.Scanner;

import com.capgemini.foresterymanagement.bean.LandBean;
import com.capgemini.foresterymanagement.factory.FactoryDetails;
import com.capgemini.foresterymanagement.services.LandServices;

public class LandController {

	static LandServices services=FactoryDetails.getLandServ();
	public static void main() {
		Scanner sc= new Scanner(System.in);
		while(true) {
			System.out.println("****LAND OPERATIONS****");
			System.out.println("--------------");
			System.out.println("Select the option to perform operations");
			System.out.println("Option 1: Add land details");
			System.out.println("Option 2: Remove land details");
			System.out.println("option 3: display all land details");
			System.out.println("Option 4: Home");
			String ch=null;
			char c = 'y';
			while(c=='y') {
				ch= sc.next();
				if(ForesteryValidation.isNumber(ch)) {
					c='n';
				} else {
					System.err.println("enter numbers only");
				}
			} 
			Integer choice = Integer.parseInt(ch);
			
			switch(choice) {

			case 1:
				LandBean lbean= new LandBean();
				System.out.println("Add Details of land");
				System.out.println("-------------------");
				System.out.println("Enter land id");
				String ch1=null;
				char c1 = 'y';
				while(c1=='y') {
					ch1= sc.next();
					if(ForesteryValidation.isNumber(ch1)) {
						c1='n';
					} else {
						System.err.println("enter numbers only");
					}
				} 
				Integer id1 = Integer.parseInt(ch1);
				lbean.setLandId(id1);
				System.out.println("Enter land location");
				String ch2=null;
				char c2 = 'y';
				while(c2=='y') {
					ch2= sc.next();
					if(ForesteryValidation.isStringAlphabet(ch2)) {
						c2='n';
					} else {
						System.err.println("enter alphabets only");
					}
				} 
				lbean.setLandLoc(ch2);
				System.out.println("Enter land value");
				String ch3=null;
				char c3 = 'y';
				while(c3=='y') {
					ch3= sc.next();
					if(ForesteryValidation.isNumber(ch3)) {
						c3='n';
					} else {
						System.err.println("enter numbers only");
					}
				} 
				Integer value = Integer.parseInt(ch3);
				lbean.setLandValue(value);
				System.out.println("Enter acquired date in dd/mm/yyyy format");
				String date=null;
				char d = 'y';
				while(d=='y') {
					date= sc.next();
					if(ForesteryValidation.dateValidation(date)) {
						d='n';
					} else {
						System.err.println("enter date in dd/mm/yyyy format only");
					}
				} 
				lbean.setLandLoc(date);
				services.addLand(lbean);

				break;
			case 2:
				System.out.println("Enter land id to remove details ");
				String ch6=null;
				char c6 = 'y';
				while(c6=='y') {
					ch6= sc.next();
					if(ForesteryValidation.isNumber(ch6)) {
						c6='n';
					} else {
						System.err.println("enter numbers only");
					}
				} 
				Integer Id1 = Integer.parseInt(ch6);
				services.deleteLand(Id1);
				break;
//			case 3:
//				System.out.println("enter land id to modify details");
//				String ch4=null;
//				char c4= 'y';
//				while(c4=='y') {
//					ch4= sc.next();
//					if(ForesteryValidation.isNumber(ch4)) {
//						c4='n';
//					} else {
//						System.err.println("enter numbers only");
//					}
//				} 
//				Integer Id2 = Integer.parseInt(ch4);
//				LandBean beanl= services.modifyLand(Id2, lbean);
//				if(beanl!=null) {
//					System.out.println("Enter land value to update");
//					String ch5=null;
//					char c5 = 'y';
//					while(c5=='y') {
//						ch5= sc.next();
//						if(ForesteryValidation.isNumber(ch5)) {
//							c5='n';
//						} else {
//							System.err.println("enter numbers only");
//						}
//					} 
//					Integer value1 = Integer.parseInt(ch5);
//					beanl.setLandValue(value1);
//					services.modifyLand(value1,beanl);
//					System.out.println("details updated");
//				}
//				else {
//					System.out.println("land id not found");
//				}
//				break;
			case 3:
				System.out.println("---------");
				services.getAllLands();
				break;
			
			case 4:
				Admincontroller.adminMain();
				break;
				
			default:
				System.out.println("enter correct option");
				break;
			}
		}



	}
}
