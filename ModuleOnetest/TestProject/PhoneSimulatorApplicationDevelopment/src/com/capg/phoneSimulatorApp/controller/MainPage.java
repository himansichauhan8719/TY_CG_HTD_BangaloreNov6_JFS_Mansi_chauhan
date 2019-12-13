package com.capg.phoneSimulatorApp.controller;
import java.util.List;
import java.util.Scanner;

import com.capg.phoneSimulatorApp.bean.ContactBean;
import com.capg.phoneSimulatorApp.dao.ContactDao;
import com.capg.phoneSimulatorApp.factory.ContactPage;

public class MainPage {
	
		public static void main(String[] args) {
			Scanner sc= new Scanner(System.in);
			ContactDao dao= ContactPage.contactDaoImpl();
			while(true) {
				System.out.println("**WELCOME USER**");
	
				System.out.println(" 1.view all contacts");
				System.out.println("2.search contact");
				System.out.println("3.contact operations");
				int choice=sc.nextInt();
				switch(choice) {
				case 1:
					List<ContactBean> l1= dao.viewAllContacts();
					if(l1!=null) {
						for (ContactBean contact : l1) {
							System.out.println(contact);
						}
					} else {
						System.out.println("no data");
					}
					break;
				case 2:
					System.out.println("enter name to call or text");
					String name=sc.next();
					ContactBean con=dao.showContact(name);
					if(con!=null) {
						System.out.println(" number is "+con.getNumber());
						System.out.println(" group name is "+con.getGroup());
						System.out.println(" for call");
						System.out.println(" for message");
						System.out.println("for option");
						int n=sc.nextInt();
						switch(n) {
						case 1:
							System.out.println(" in calling");
							sc.next();
							break;
						case 2:
							System.out.println("enter here msg to send");
							sc.next();
							System.out.println("msg sent");
							break;
						case 3:
							MainPage.main(args);
							break;
						default:
							System.out.println("enter valid option");
							break;
						}
					} else {
						System.out.println("contact not found");
					}
					break;
				case 3:
					ContactCon.main(args);
					break;
				default:
					System.out.println("enter valid option");
					break;
				}
			}
		}

}
