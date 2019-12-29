package com.capgemini.foresterymanagement.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.foresterymanagement.bean.AdminBean;
import com.capgemini.foresterymanagement.bean.ContractBean;
import com.capgemini.foresterymanagement.dao.ContractDao;
import com.capgemini.foresterymanagement.dao.ProductDao;
import com.capgemini.foresterymanagement.dao.ProductDaoImpl;
import com.capgemini.foresterymanagement.factory.FactoryDetails;
import com.capgemini.foresterymanagement.services.AdminServ;
import com.capgemini.foresterymanagement.services.ContractServ;

public class ContractCon {
	static	ContractServ services = FactoryDetails.objectContractServices();
	    static AdminServ services1 = FactoryDetails.objectAdminServ();
	public static void main() {
		Scanner sc= new Scanner(System.in);
		while(true) {
			System.out.println("*******Welcome client*********");
			System.out.println("Enter username");
			String user=sc.next();
			System.out.println("enter password");
			String pass=sc.next();
			
	if (services1.login(user,pass)) {
		
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
						services1.login(user,password);
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
						services.showAllContractor();
						break;
					
					
					case 5:
						CustomerCon.main();
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
						AdminCon.adminMain();
					}
				}
		}
	}

}


//	public static void contract() {
//		ContractDao cdao=FactoryDetails.objectContractDao();
//		ProductDao proBean=new ProductDaoImpl();
//		Scanner sc=new Scanner(System.in);
//		while (true) {
//			System.out.println("********************WELCOME CUSTOMER TO CONTRACT HOUSE********************");
//			System.out.println("*Enter 1 to add the Contract");
//			System.out.println("*Enter 2 to search the Contract");
//			System.out.println("*Enter 3 to update the Contract");
//			System.out.println("*Enter 4 to remove the Contract");
//			System.out.println("*Enter 5 to get all the Contract");
//			System.out.println("*Enter 6 to Logout");
//			int option=sc.nextInt();
//
//
//			switch (option) {
//			case 1:
//				ContractBean cb=new ContractBean();
//
//				boolean stay4=true;
//				while(stay4) {
//					try{
//						System.out.println("enter the Customer ID: ");
//						cb.setCustId(sc.nextInt());
//						stay4=false;
//					}catch (Exception e) {
//						System.err.println("Enter The Valid Integer For Quantity");
//						stay4=true;
//					}
//				}
//
//				
//
//				boolean stay7=true;
//				while(stay7) {
//					try{
//						System.out.println("enter the Product ID: ");
//						int proId=sc.nextInt();
//						if(proId==00000) {
//							ContractCon.contract();
//						}
//						boolean product=proBean.isThereProductId(proId);
//						if(product) {
//						cb.setProdId(proId);
//						stay7=false;
//						
//						}else {
//							System.err.println("Ooops!! This product is out of Stock, try other product-Id's");
//						}
//					}catch (Exception e) {
//						System.err.println("Enter The Valid Integer For Quantity");
//						stay7=true;
//					}
//				}
//
//
//				System.out.println("enter the haulier ID: ");
//				cb.setHaulId(sc.next());
//
//				boolean stay1=true;
//				while(stay1) {
//					System.out.println("enter the delivery date in YYYY/MM/DD fromat: ");
//					String date = sc.next();
//
//					String regex = "^[0-9]{4}/(1[0-2]|0[1-9])/(3[01]"
//							+ "|[12][0-9]|0[1-9])$"; 
//					Pattern pattern = Pattern.compile(regex); 
//					Matcher matcher = pattern.matcher((CharSequence)date);
//					if(matcher.matches()) {
//						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
//						LocalDateTime now = LocalDateTime.now(); 
//						String date2=dtf.format(now);
//						if(date.compareTo(date2)<0||date.compareTo(date2)==0){
//							System.err.println("Please enter the Future Date... ");
//							stay1=true;
//						}else {
//							cb.setDeliDate(date);
//							stay1=false;
//						}
//
//					}else {
//						System.err.println("Please Enter The Valid DATE-FORMATE..!");
//						stay1=true;
//					}
//
//				}
//
////				boolean stay2=true;
////				while(stay2) {
////					System.out.println("Enter The Delivery Day: ");
////					String DAY=sc.next();
////					if(DAY.equals("sunday")||DAY.equals("monday")||DAY.equals("tuesday")||DAY.equals("wednesday")||DAY.equals("thursday")||DAY.equals("friday")||DAY.equals("saturday")||
////							DAY.equals("SUNDAY")||DAY.equals("MONDAY")||DAY.equals("TUESDAY")||DAY.equals("WEDNESDAY")||DAY.equals("THURSDAY")||DAY.equals("FRIDAY")||DAY.equals("SATURDAY")) 
////					{
////						cb.setDeliveryDay(DAY);
////						stay2=false;
////					}else {
////						System.err.println("Please enter the valid DAY...!");
////						stay2=true;
////					}
////				}
//				boolean stay3=true;
//				while(stay3) {
//					try{
//						System.out.println("enter the quantiy required: ");
//						cb.setQuantity(sc.nextInt());
//						stay3=false;
//					}catch (Exception e) {
//						System.err.println("Enter The Valid Integer For Quantity");
//						stay3=true;
//					}
//				}
//
//				if(cdao.addContract(cb)) {
//					System.out.println("contract added successfully..!");
//				}else {
//					System.err.println("somthing went wrong buddy, try again..!");
//				}
//				break;
//
//			case 2:
//				System.out.println("enter the contractID to search Contract: ");
//
//				try{
//					int ctid=sc.nextInt();
//					ContractBean cdetails=cdao.searchContarctor(ctid);
//					System.out.println("The details of Contract with "+ctid+" is:");
//					System.out.println(cdetails);
//				}catch (Exception e) {
//					System.out.println("Please enter the valid contract ID: ");
//				}
//				break;
//			case 3:
//				ContractorBean cb2=new ContractorBean();
//				int ctid = 0;
//				boolean stop5=true;
//				while(stop5) {
//					try{
//						System.out.println("enter the Contract ID To Update:: ");
//						ctid=sc.nextInt();
//						stop5=false;
//					}catch (Exception e) {
//						System.err.println("Enter The Valid Integer For Quantity");
//						stop5=true;
//					}
//				}
//
//				boolean stop4=true;
//				while(stop4) {
//					try{
//						System.out.println("enter the Customer ID To Update: ");
//						cb2.setCustomerId(sc.nextInt());
//						stop4=false;
//					}catch (Exception e) {
//						System.err.println("Enter The Valid Integer For Quantity");
//						stop4=true;
//					}
//				}
//
//
//				boolean stop7=true;
//				while(stop7) {
//					try{
//						System.out.println("enter the Product ID To Update:: ");
//						cb2.setProductId(sc.nextInt());
//						stop7=false;
//					}catch (Exception e) {
//						System.err.println("Enter The Valid Integer For Quantity");
//						stop7=true;
//					}
//				}
//
//
//				System.out.println("enter the haulier ID To Update: ");
//				cb2.setHaulierId(sc.next());
//
//				boolean stop1=true;
//				while(stop1) {
//					System.out.println("enter the delivery date in YYYY/MM/DD fromat To Update: ");
//					String date = sc.next();
//
//					String regex = "^[0-9]{4}/(1[0-2]|0[1-9])/(3[01]"
//							+ "|[12][0-9]|0[1-9])$"; 
//					Pattern pattern = Pattern.compile(regex); 
//					Matcher matcher = pattern.matcher((CharSequence)date);
//					if(matcher.matches()) {
//						cb2.setDeliveryDate(date);
//						stop1=false;
//					}else {
//						System.err.println("Please Enter The Valid DATE-FORMATE..!");
//						stop1=true;
//					}
//
//				}
//
////				boolean stop2=true;
////				while(stop2) {
////					System.out.println("Enter The Delivery Day To Update: ");
////					String DAY=sc.next();
////					if(DAY.equals("sunday")||DAY.equals("monday")||DAY.equals("tuesday")||DAY.equals("wednesday")||DAY.equals("thursday")||DAY.equals("friday")||DAY.equals("saturday")||
////							DAY.equals("SUNDAY")||DAY.equals("MONDAY")||DAY.equals("TUESDAY")||DAY.equals("WEDNESDAY")||DAY.equals("THURSDAY")||DAY.equals("FRIDAY")||DAY.equals("SATURDAY")) 
////					{
////						cb2.setDeliveryDay(DAY);
////						stop2=false;
////					}else {
////						System.err.println("Please enter the valid DAY...!");
////						stop2=true;
////					}
////				}
//
//				boolean stop3=true;
//				while(stop3) {
//					try{
//						System.out.println("enter the quantiy required To Update: ");
//						cb2.setQunatity(sc.nextInt());
//						stop3=false;
//					}catch (Exception e) {
//						System.err.println("Enter The Valid Integer For Quantity");
//						stop3=true;
//					}
//				}
//				cdao.updateContarctor(ctid,cb2);
//				break;
//
//			case 4:
//
//				try{
//					System.out.println("Enter The Contract ID to delete the account:");
//					int cidToDelete=sc.nextInt();
//					boolean delete=cdao.deletecontarctor(cidToDelete);
//					if(delete) {
//						System.out.println("The specified Contrcat got deleted");
//					}else {
//						System.err.println("Please enter the valid contractID, problem in deletion");
//					}
//				}catch (Exception e) {
//					System.err.println("Please enter the valid contractID:");
//				}
//				break;
//			case 5:
//				cdao.getAllContarctor();
//				break;
//			case 6:
//				FmHome.main(null);
//
//			}
//		}
//	}
//
//
//}
