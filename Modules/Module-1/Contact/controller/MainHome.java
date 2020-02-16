package com.capgemini.contact.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.contact.bean.ContactBean;
import com.capgemini.contact.factory.Factory;
import com.capgemini.contact.services.ContactServices;

public class MainHome {
	public static void  mainHome() {
		ContactServices serv =  Factory.getServ1();
		ContactBean bean =  Factory.getBean();
		Scanner sc = new Scanner(System.in);
		char a = 'y';
		while (a == 'y') {
		System.out.println("1.List of Contacts\n2.Search\n3.options");
		int i = sc.nextInt();
		switch (i) {
		case 1:
			System.out.println("List Of All Contacts");
		
			System.out.println("All Contacts");
			List< ContactBean> l2 = (serv.allContact());
			if(l2 != null) {
				System.out.println(l2);
				
			} else {
				System.out.println("No Contacts Present ");
			}
			
			break;
			
		case 2 :
			System.out.println("Search Contact");
		
			System.out.println("Enter Contact Name To Search ");
			bean.setName(sc.next());
			List< ContactBean> l1 = (serv.searchContact(bean.getName()));
			System.out.println(l1);
			
			String a1 = "y"; 
			while(a1=="y") {
			System.out.println("1.Call\n2.Message\n3.back");
			int x = sc.nextInt();
			switch (x) {
			case 1:
				System.out.println("Calling");
				System.out.println("\nEnter any key to exit :");
				a1 = sc.next();
				
				break;
			case 2:
				System.out.println("Message");
				System.out.println("\nEnter any key to exit :");
				a1 = sc.next();
			break;
			
			case 3:
				a1 = "m";
				break;
				
			default:
				System.out.println("Invalid Choice");
				break;
			}
			}
		break;
		
		case 3:
			System.out.println("Options");
			ContactController.contactController();
			break;
			
		default:
			System.out.println("Invalid Choice :(");
			break;
		}
		}
	}

}
