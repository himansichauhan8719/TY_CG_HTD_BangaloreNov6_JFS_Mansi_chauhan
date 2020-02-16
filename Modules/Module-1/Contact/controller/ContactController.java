package com.capgemini.contact.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.contact.bean.ContactBean;
import com.capgemini.contact.factory.Factory;
import com.capgemini.contact.services.ContactServices;

public class ContactController {
	public static void contactController() {
		
		ContactServices serv = Factory.getServ1();
		ContactBean bean = Factory.getBean();
		Scanner sc = new Scanner(System.in);
		char aa = 'y' ;
		while(aa == 'y') {
			
		System.out.println("1.Add Contacts\n2.Delete Contact\n3.Edit Contact:\n4.Back");
		int i = sc.nextInt();
		switch ( i) {
		case 1:
			System.out.println("Enter The Contact Name:");
			bean.setName(sc.next());
			System.out.println("Enter Mobile No :");
			bean.setNumber(sc.nextInt());
			System.out.println("Enter the Group :");
			bean.setGroup(sc.next());
			if(serv.addContact(bean)) {
				System.out.println("success");
			}else {
				System.out.println("Something Went Wrong");
			}
			
			break;
		
		case 2 :
			System.out.println("Enter The Contact Name To Delete :");
			bean.setName(sc.next());
			if (serv.deleteContact(bean.getName())) {
				System.out.println("Successfully Deleted :)");
			} else {
				System.out.println("Something Went Wrong :(");
			}
			break;
		
			
		case 3 :
			System.out.println("Enter Contact Name To Edit : ");
			bean.setName(sc.next());
			
			if (serv.editContact(bean.getName())) {
				System.out.println("Edit Successfully :)");
			} else {
				System.out.println("Something Went Wrong :(");
			}
			break;
		
		case 4:
			aa = 'm';
			break;

			
//		case 5: System.out.println("All Contacts");
//		List< ContactBean> l2 = (serv.allContact());
//		System.out.println(l2);
//		break;
		
		default :
			System.out.println("Invalid Choice :(");
			break;
		}
	}
	}
}
