package com.capgemini.foresterymanagement.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.foresterymanagement.bean.ContractBean;
import com.capgemini.foresterymanagement.factory.FactoryDetails;

public class ContractDaoImpl implements ContractDao {
	FileReader reader;
	Properties prop;
	ResultSet rs;
	 ContractBean  bean = FactoryDetails.getContractBean();
	 Scanner sc = new Scanner(System.in);
	 
	 public ContractDaoImpl(){
		 try {
			 reader = new FileReader("contractor.properties");
			 prop = new Properties();
			 prop.load(reader);
			  
			// class.forName(prop.getProperty("driver"));
			 
		 }catch(Exception e) {
			 
		 }
	 }
	 
	@Override
	public boolean addContract(ContractBean bean) {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpass"));
				PreparedStatement pstmt1=con.prepareStatement(prop.getProperty("query"));
				) {

			pstmt1.setInt(1,bean.getContNo());
			pstmt1.setInt(2, bean.getCustId());
			pstmt1.setInt(3, bean.getProdId());
			pstmt1.setInt(4, bean.getHaulId());
			pstmt1.setString(5, bean.getDeliDate());
			pstmt1.setInt(6, bean.getQuantity());			
			int result2=pstmt1.executeUpdate();

			if(result2>0) {
				System.out.println("Contract with CID: "+bean.getContNo()+" added successfuly. (please Remember This) \n" );
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
	public boolean removeContract(int prodId) {
		 
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dburl"),prop.getProperty("dbuser"),prop.getProperty("dbpass"));
				PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(prop.getProperty("deletequery"))){
			
			pstmt.setInt(1, prodId);
			
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
	public void showAllContract() {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("showallcontract"));
				) {
			ResultSet rs=pstmt.executeQuery();
			System.out.println("============CONTRACT DEATAILS============\n");

			if(rs.next()==true) {
				while(rs.next()) {
					System.out.println("CONTRACT ID: "+rs.getInt(1));
					System.out.println("CUSTOMER ID: "+rs.getInt(2));
					System.out.println("PRODUCT ID: "+rs.getInt(3));
					System.out.println("HAULIER ID: "+rs.getString(4));
					System.out.println("DELIVERY DATE: "+rs.getString(5));
					System.out.println("DEMANDED QUNATITY: "+rs.getInt(6));
					System.out.println(".......................................\n");
				}
			}else {
				System.err.println("There are no CONTRACTs to display..!");
			}

		}catch (Exception e) {
			String msg=e.getMessage();
			System.err.println("oops..!There is problem in getting all the contracts: "+msg);
		}
	}
	
	@Override
	public boolean modifyContract(int prodId,ContractBean bean) {
		  
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dburl"),prop.getProperty("dbuser"),prop.getProperty("dbpass"));
				PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(prop.getProperty("updatequery"))){
			
			System.out.println("Enter your Contract no : ");
			int contno = sc.nextInt();
			System.out.println("Enter Customer id : ");
			int custid = sc.nextInt();
			System.out.println(" Enter haulier id : ");
			int haulid = sc.nextInt();
			System.out.println(" Enter delivery date : ");
			String delidate = sc.nextLine();
			System.out.println(" Enter delivery day : ");
			String deliday = sc.nextLine();
			System.out.println(" Enter quantity : ");
			int quantity = sc.nextInt();
			
			pstmt.setInt(1, prodId);
			pstmt.setInt(2, contno);
			pstmt.setInt(3, custid);
			pstmt.setInt(4, haulid);
			pstmt.setString(5, delidate);
			pstmt.setString(6, deliday);
			pstmt.setInt(7, quantity);
			
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
