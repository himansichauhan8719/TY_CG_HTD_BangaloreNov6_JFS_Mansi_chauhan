package com.capg.shoppingapp.dao;


import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.capg.shoppingapp.bean.Product;

public class ShoppingCurdImpl implements ShoppingCurd {
	FileReader reader;
	Properties prop;
	Product pro;
	Scanner sc=new Scanner(System.in);

	public ShoppingCurdImpl() {
		try {

			reader=new FileReader("db.properties");
			prop=new Properties();
			prop.load(reader);
			//Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> list=new ArrayList<Product>();
		try(Connection con=DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(prop.getProperty("query"))){
			while(rs.next()) {
				pro=new Product();
				pro.setProId(rs.getInt(1));
				pro.setProName(rs.getString(2));
				pro.setProCost(rs.getString(3));
				pro.setProColor(rs.getString(4));
				pro.setDescription(rs.getString(5));
				pro.setNumOfpro(rs.getInt(6));
				list.add(pro);

			}
			return list;
		}catch(Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Product getProduct(String proName) {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("showAllProduct"));
				){	
			pstmt.setString(1, proName);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				pro=new Product();
				pro.setProId(rs.getInt(1));
				pro.setProName(rs.getString(2));
				pro.setProCost(rs.getString(3));
				pro.setProColor(rs.getString(4));
				pro.setDescription(rs.getString(5));
				pro.setNumOfpro(rs.getInt(6));
			}
			return pro;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	

	
	
}