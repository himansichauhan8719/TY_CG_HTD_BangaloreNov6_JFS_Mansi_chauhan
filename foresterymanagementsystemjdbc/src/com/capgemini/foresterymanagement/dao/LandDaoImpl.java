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
import com.capgemini.foresterymanagement.bean.LandBean;
import com.capgemini.foresterymanagement.factory.FactoryDetails;

public class LandDaoImpl implements LandDao {
	FileReader reader;
	Properties prop;
	ResultSet rs;
	 LandBean  bean = FactoryDetails.getLandBean();
	 Scanner sc = new Scanner(System.in);
	 
	 public LandDaoImpl(){
		 try {
			 reader = new FileReader("land.properties");
			 prop = new Properties();
			 prop.load(reader);
			  
			// class.forName(prop.getProperty("driver"));
			 
		 }catch(Exception e) {
			 
		 }
	 }

	@Override
	public void getAllLands() {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpass"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("showallland"));
				) {
			ResultSet rs=pstmt.executeQuery();
			System.out.println("============Land Details============\n");

			if(rs.next()==true) {
				while(rs.next()) {
					System.out.println(" Land id : "+rs.getInt(1));
					System.out.println(" Land value: "+rs.getInt(2));
					System.out.println(" Land Location: "+rs.getString(3));
					
					System.out.println(".......................................\n");
				}
			}else {
				System.err.println("There are no land details to display..!");
			}

		}catch (Exception e) {
			String msg=e.getMessage();
			System.err.println("oops..!There is problem in getting all the contracts: "+msg);
		}
		
	}

	@Override
	public boolean addLand(LandBean land) {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpass"));
				PreparedStatement pstmt1=con.prepareStatement(prop.getProperty("insertquery"));
				) {

			pstmt1.setInt(1,bean.getLandId());
			pstmt1.setInt(2, bean.getLandValue());
			pstmt1.setString(3, bean.getLandLoc());
				
			int result=pstmt1.executeUpdate();

			if(result>0) {
				System.out.println("Land with land id : "+bean.getLandId()+" added successfuly. (please Remember This) \n" );
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
	public boolean deleteLand(int custId) {
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
	public boolean modifyLand(int custId, LandBean land) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dburl"),prop.getProperty("dbuser"),prop.getProperty("dbpass"));
				PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(prop.getProperty("updatequery"))){
			
			
			System.out.println("Enter Land id : ");
			int landId = sc.nextInt();
			System.out.println(" Enter Land value : ");
			int landVal = sc.nextInt();
			System.out.println(" Enter Land Location : ");
			String landLoc = sc.nextLine();
			
			
			pstmt.setInt(1, landId);
			pstmt.setInt(2, landVal);
			pstmt.setString(3, landLoc);
			
			
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
