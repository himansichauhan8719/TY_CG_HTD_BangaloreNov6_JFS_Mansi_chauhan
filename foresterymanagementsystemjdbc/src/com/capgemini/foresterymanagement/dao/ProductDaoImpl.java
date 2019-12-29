package com.capgemini.foresterymanagement.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.foresterymanagement.bean.ProductBean;
import com.capgemini.foresterymanagement.factory.FactoryDetails;

public class ProductDaoImpl implements ProductDao{
	FileReader reader;
	Properties prop;
	ResultSet rs;
	 ProductBean  bean = FactoryDetails.getProductBean();
	 Scanner sc = new Scanner(System.in);
	 
	 public ProductDaoImpl(){
		 try {
			 reader = new FileReader("product.properties");
			 prop = new Properties();
			 prop.load(reader);
			 
		 }catch(Exception e) {
			 
		 }
	 }

	@Override
	public void showAllProduct() {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("getQuery"));
				) {
			ResultSet rs=pstmt.executeQuery();
			System.out.println("============Product Details============\n");

			if(rs.next()==true) {
				while(rs.next()) {
					System.out.println("Product id: "+rs.getInt(1));
					System.out.println("Product name: "+rs.getInt(2));
					System.out.println("product Quantity: "+rs.getString(3));
					System.out.println(" product Cost : "+rs.getInt(4));
					
					System.out.println(".......................................\n");
				}
			}else {
				System.err.println("There are no product to display..!");
			}

		}catch (Exception e) {
			String msg=e.getMessage();
			System.err.println("oops..!There is problem in getting all the contracts: "+msg);
		}
		
	}

	@Override
	public boolean updateProduct(int custId,ProductBean pbean) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dburl"),prop.getProperty("dbuser"),prop.getProperty("dbpass"));
				PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(prop.getProperty("updatequery"))){
			
			
			System.out.println("Enter Product id : ");
			int proid = sc.nextInt();
			System.out.println(" Enter Product Name : ");
			String proName = sc.nextLine();
			System.out.println(" Enter Product Quantity : ");
			int proquantity = sc.nextInt();
			System.out.println(" Enter Product Cost : ");
			int proCost = sc.nextInt();
			
			
			pstmt.setInt(1, proid);
			pstmt.setString(2, proName);
			pstmt.setInt(3, proquantity);
			pstmt.setInt(4, proCost);
			
			
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

	@Override
	public boolean deleteProduct(int custId) {
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
	public boolean addProduct(ProductBean pbean) {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt1=con.prepareStatement(prop.getProperty("iQuery"));
				) {

			pstmt1.setInt(1, bean.getProId());
			pstmt1.setString(2, bean.getProName());
			pstmt1.setInt(3, bean.getProQuantity());
			pstmt1.setInt(4, bean.getProCost());
			
			
			int proRe=pstmt1.executeUpdate();

			if(proRe>0) {
				System.out.println("Product with product id: "+bean.getProId()+" added successfuly. (please Remember This) \n" );
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
	public ProductBean searchProduct(int custId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
