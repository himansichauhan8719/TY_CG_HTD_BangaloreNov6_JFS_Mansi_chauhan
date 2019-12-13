package com.capg.phoneSimulatorApp.controller;

import java.util.List;
import java.util.Scanner;

import com.capg.phoneSimulatorApp.bean.ContactBean;
import com.capg.phoneSimulatorApp.dao.ContactDao;
import com.capg.phoneSimulatorApp.factory.ContactPage;


public class ContactCon {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		ContactDao dao= ContactPage.contactDaoImpl();
		while(true) {
			System.out.println("Enter option to perform operations");
			System.out.println(" 1.Insert contact\n 2.Delete contact\n 3.Update contact\n 4.view all contacts\n "
					+ "5.Go back");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter the contact details to insert");
				ContactBean con = new ContactBean();
				System.out.println("Enter the name ");
				con.setName(sc.next());
				System.out.println("enter the phone number");
				con.setNumber(sc.nextInt());
				System.out.println("enter the group name");
				con.setGroup(sc.next());
				if(dao.contactInsert(con)) {
					System.out.println("contact inserted");
				} else {
					System.out.println("contact not inserted");
				}
				break;
			case 2:
				System.out.println("enter contact name to delete");
				String name=sc.next();
				if(dao.contactdelete(name)) {
					System.out.println("contact deleted");
				} else {
					System.out.println("contact not found");
				}
				break;
			case 3:
				System.out.println("enter the contact name to update");
				String name1=sc.next();
				ContactBean con2=dao.showContact(name1);
				if(con2!=null) {
					System.out.println("enter the new number to update ");
					int num=sc.nextInt();
					if(dao.contactupdate(name1, num)) {
						System.out.println("contact updated");
					} else {
						System.out.println("contact not updated");
					} 
				} else {
					System.out.println("contact not found");
				}
				break;
			case 4:
				List<ContactBean> l1= dao.viewAllContacts();
				if(l1!=null) {
					for (ContactBean contact : l1) {
						System.out.println(contact);
					}
				} else {
					System.out.println("no data");
				}
				break;
			case 5:
				MainPage.main(args);
				break;
			default:
				System.out.println("enter valid option");
				break;
			}
		}

	}

}