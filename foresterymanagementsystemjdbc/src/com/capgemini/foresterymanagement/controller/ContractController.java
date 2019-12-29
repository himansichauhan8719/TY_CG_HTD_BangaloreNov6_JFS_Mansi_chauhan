package com.capgemini.foresterymanagement.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.foresterymanagement.bean.AdminBean;
import com.capgemini.foresterymanagement.bean.ContractBean;
import com.capgemini.foresterymanagement.bean.CustomerBean;
import com.capgemini.foresterymanagement.dao.ContractDao;
import com.capgemini.foresterymanagement.dao.ProductDao;
import com.capgemini.foresterymanagement.factory.FactoryDetails;

import com.capgemini.foresterymanagement.services.AdminServices;

import com.capgemini.foresterymanagement.services.ContractServices;

public class ContractController {

	static	ContractServices services = FactoryDetails.getContractServ();
    static AdminServices services1 = FactoryDetails.getAdminserv();
public static void main() {
	Scanner sc= new Scanner(System.in);
	while(true) {
		System.out.println("*******Welcome client*********");
		System.out.println("Enter username");
		String user=sc.next();
		System.out.println("enter password");
		String pass=sc.next();
		
if (services1.loginAdmin(user,pass)) {
	
	while(true) {
		System.out.println("--------------");
		System.out.println("Select the option to perform operations");
		System.out.println("Option 1:Change password");
		System.out.println("Option 2: Add contract");
		System.out.println("Option 3: Remove contract");
		System.out.println("Option 4: show all contracts");
		System.out.println("Option 6: Customer operations");
		System.out.println("Option 7: Home");
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
					System.out.println("Enter new password");
					String password=sc.next();
					AdminBean bean= new AdminBean();
				    bean.setName(user);	
				   bean.setPassword(password);
					services1.loginAdmin(user,password);
					break;
				case 2:
					ContractBean con = new ContractBean();
					System.out.println("Add Contract Details of contract");
					System.out.println("-------------------");
					System.out.println("Enter contract id");
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
					Integer id = Integer.parseInt(ch1);
					con.setContNo(id);
					System.out.println("Enter customer id");
					String ch2=null;
					char c2 = 'y';
					while(c2=='y') {
						ch2= sc.next();
						if(ForesteryValidation.isNumber(ch2)) {
							c2='n';
						} else {
							System.err.println("enter numbers only");
						}
					} 
					Integer id1 = Integer.parseInt(ch2);
					con.setCustId(id1);
					System.out.println("Enter product id");
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
					Integer id2 = Integer.parseInt(ch3);
					con.setProdId(id2);
					System.out.println("Enter quantity");
					String quantity=null;
					char q1 = 'y';
					while(q1=='y') {
						quantity= sc.next();
						if(ForesteryValidation.isNumber(quantity)) {
							q1='n';
						} else {
							System.err.println("enter numbers only");
						}
					} 
					con.setQuantity(Integer.parseInt(quantity));
					System.out.println("Enter delivery date in dd/mm/yyyy format");
					String date=null;
					char d = 'y';
					while(d=='y') {
						date= sc.next();
						if(ForesteryValidation.dateValidation(date)) {
							System.err.println("enter valid date in dd/mm/yyyy format only");
						} else {
							d='n';
						}
					} 
					con.setDeliDate(date);
					services.addContract(con);		

					break;
				case 3:
					System.out.println("Enter contract id to remove contract ");
					String ch5=null;
					char c5 = 'y';
					while(c5=='y') {
						ch5= sc.next();
						if(ForesteryValidation.isNumber(ch5)) {
							c5='n';
						} else {
							System.err.println("enter numbers only");
						}
					} 
					Integer id4 = Integer.parseInt(ch5);
					services.removeContract(id4);
					break;
				case 4:
					System.out.println("---------");
					services.showAllContract();
					break;
				
				
				case 5:
					CustomerController.main();
					break;
				case 6:
					String args[]=null;
					App.main(args);
					break;
				default:
					System.out.println("enter correct option");
					break;
				}

			}} else {
				System.out.println("enter valid credentials");
				System.out.println("Dont have an account? type yes to ask admin to create account type anything to try again");
				String reply=sc.next();
				if(reply.equals("yes")) {
					Admincontroller.adminMain();
				}
			}
	}
}

}
