package com.capgemini.foresterymanagement.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.foresterymanagement.bean.ContractBean;
import com.capgemini.foresterymanagement.bean.CustomerBean;
import com.capgemini.foresterymanagement.factory.FactoryDetails;

public class CustomerDaoImpl implements CustomerDao{
	
	FileReader reader;
	Properties prop;
	ResultSet rs;
	 CustomerBean  bean = FactoryDetails.getCustomerBean();
	 Scanner sc = new Scanner(System.in);
	 
	 public CustomerDaoImpl(){
		 try {
			 reader = new FileReader("customer.properties");
			 prop = new Properties();
			 prop.load(reader);
			  
			// class.forName(prop.getProperty("driver"));
			 
		 }catch(Exception e) {
			 
		 }
	 }

	@Override
	public boolean addCustomer(CustomerBean bean) {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt1=con.prepareStatement(prop.getProperty("query"));
				) {

			pstmt1.setInt(1, bean.getCustId());
			pstmt1.setString(2, bean.getCustName());
			pstmt1.setString(3, bean.getCustAdd());
			pstmt1.setString(4, bean.getCustTown());
			pstmt1.setInt(5, bean.getCustZip());
			pstmt1.setString(6, bean.getCustEmail());
			pstmt1.setLong(7, bean.getCustPhone());
			
			int custRe=pstmt1.executeUpdate();

			if(custRe>0) {
				System.out.println("Contract with CID: "+bean.getCustId()+" added successfuly. (please Remember This) \n" );
				return true;

			}else {
				System.err.println("something went wrong please try again later..!\n");
				return false;
			}
		} catch (SQLException e) {
			String msg=e.getMessage();
			System.err.println("Problem in adding Contract: "+msg);
			return false;
		}

	}
		
	

	@Override
	public void showAllCustomers() {
			try (Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
					prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
					PreparedStatement pstmt=con.prepareStatement(prop.getProperty("showallcustomer"));) {
				ResultSet rs=pstmt.executeQuery();
				System.out.println("============CUSTOMER DEATAILS============\n");

				if (rs.next()==true) {
					while(rs.next()) {
						System.out.println("Customer Id: "+rs.getString(1));
						System.out.println("Customer Name: "+rs.getString(2));
						System.out.println("customer Address: "+rs.getString(3));
						System.out.println("Customer Town: "+rs.getString(4));
						System.out.println("Customer Zip code: "+rs.getInt(5));
						System.out.println("Customer Email: "+rs.getString(6));
						System.out.println("Customer Phone: "+rs.getString(7));
						System.out.println(".......................................\n");
					}
				} else {
					System.err.println("There are no CONTRACTs to display..!");
				}

			}catch (Exception e) {
				String msg=e.getMessage();
				System.err.println("oops..!There is problem in getting all the contracts: "+msg);
			}
		}

	@Override
	public boolean removeCustomer(int custId) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dburl"),prop.getProperty("dbuser"),prop.getProperty("dbpass"));
				PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(prop.getProperty("deletequery"))){
			
			pstmt.setInt(1, custId);
			
			int i = pstmt.executeUpdate();
			if(i>0) {
				return true;
			}else {
				return false;
			}
			
		}catch(Exception e) {
			
		}
		return false;
	
	}

	@Override
	public boolean modifyCustomer(int custId) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dburl"),prop.getProperty("dbuser"),prop.getProperty("dbpass"));
				PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(prop.getProperty("updatequery"))){
			
			
			System.out.println("Enter Customer id : ");
			int custid = sc.nextInt();
			System.out.println(" Enter Customer Name : ");
			String custName = sc.nextLine();
			System.out.println(" Enter Customer Address : ");
			String custadd = sc.nextLine();
			System.out.println(" Enter Customer Town : ");
			String custTown = sc.nextLine();
			System.out.println(" Enter Customer Zip Code : ");
			int custzip = sc.nextInt();
			System.out.println(" Enter Customer email : ");
			String custEmail = sc.nextLine();
			System.out.println(" Enter Customer phone  : ");
			String custPhone = sc.nextLine();
			
			pstmt.setInt(1, custid);
			pstmt.setString(2, custName);
			pstmt.setString(3, custadd);
			pstmt.setString(4, custTown);
			pstmt.setInt(5, custzip);
			pstmt.setString(6, custEmail);
			pstmt.setString(7, custPhone);
			
			int k = pstmt.executeUpdate();
			if(k>0) {
				
				return true;
			}else {
				 return false;
			}
			
		}catch(Exception e) {
			
		}
		return false;
	}

	
}
