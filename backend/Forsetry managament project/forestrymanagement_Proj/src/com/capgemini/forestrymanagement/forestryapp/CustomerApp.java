package com.capgemini.forestrymanagement.forestryapp;

import java.util.ArrayList;
import java.util.Scanner;

import com.capgemini.forestrymanagement.forestrybean.CustomerBean;
import com.capgemini.forestrymanagement.forestrydao.CustomerDAO;
import com.capgemini.forestrymanagement.main.Home;
import com.capgemini.forestrymanagement.util.ForestryManagementDAO;

public class CustomerApp {
	private static CustomerDAO dao=ForestryManagementDAO.getCustomerDAO();
	
	public static void customerApp() {
		Scanner scn = new Scanner(System.in);
		int a = 0;
		do {
			System.out.println("Press 1 to Add Customer: ");
			System.out.println("Press 2 to Delete Customer: ");
			System.out.println("Press 3 to View All Customer: ");
			System.out.println("Press 4 to modify customer: ");
			System.out.println("Press 5 to Back ");
			System.out.println("Please enter your choice..");
			a = scn.nextInt();
			switch (a) {
			case 1:
				CustomerBean bean = new CustomerBean();
				System.out.println("Add Customer Details....");
				System.out.println("Enter customerId");
				bean.setCustomerId(scn.nextInt());
				System.out.println("Enter customerName");
				bean.setCustomerName(scn.next());
				System.out.println("Enter streetAdd1");
				bean.setStreetAdd1(scn.next());
				System.out.println("Enter streetAdd2");
				bean.setStreetAdd2(scn.next());
				System.out.println("Enter town");
				bean.setTown(scn.next());
				System.out.println("Enter postalcode");
				bean.setPostalcode(scn.nextInt());
				System.out.println("Enter email");
				bean.setEmail(scn.next());
				System.out.println("Enter telephoneNo");
				bean.setTelephoneNo(scn.nextInt());
				dao.addCustomer(bean);
				break;
			case 2:
				System.out.println("Delete Customer:");
				System.out.println("Please enter the Customer Id which you want to delete..");
				int customerId = scn.nextInt();
				dao.deleteCustomer(customerId);
				break;
			case 3:
				System.out.println("All Customer Details are listed below::");
				ArrayList<CustomerBean> custList=dao.showAllCustomer();
				for (CustomerBean customerBean : custList) {
					System.out.println(customerBean);
				}
				
				break;
			case 4:System.out.println("Please enter the Product Id which you want to modify..");
					int custId=scn.nextInt();
					bean = dao.getCustomer(custId);
					if(bean!=null) {
						System.out.println("Please enter following detail in order to modify the Customer..");
						System.out.println("Enter customerName");
						bean.setCustomerName(scn.next());
						System.out.println("Enter streetAdd1");
						bean.setStreetAdd1(scn.next());
						System.out.println("Enter streetAdd2");
						bean.setStreetAdd2(scn.next());
						System.out.println("Enter town");
						bean.setTown(scn.next());
						System.out.println("Enter postalcode");
						bean.setPostalcode(scn.nextInt());
						System.out.println("Enter email");
						bean.setEmail(scn.next());
						System.out.println("Enter telephoneNo");
						bean.setTelephoneNo(scn.nextInt());
						dao.modifyCustomer(bean);
					}else {
						System.out.println("Customer not found with the requested Id..");
					}
				break;
			case 5:
				System.out.println("Back to Home..");
				break;

			default:
				System.out.println("Please enter valid choice.");
				break;
			}
		} while (a != 5);
		Home.home();
	}
}
