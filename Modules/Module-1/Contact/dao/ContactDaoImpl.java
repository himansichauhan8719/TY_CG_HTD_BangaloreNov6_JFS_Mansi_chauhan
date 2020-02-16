package com.capgemini.contact.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.contact.bean.ContactBean;
import com.capgemini.contact.factory.Factory;
import com.mysql.jdbc.PreparedStatement;

public class ContactDaoImpl implements ContactDao {

	FileReader reader;
	Properties prop;
	ContactBean bean = Factory.getBean();
	Scanner sc = new Scanner(System.in);
	 public ContactDaoImpl() {
		try {
			reader = new FileReader("db.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public boolean addContact(ContactBean bean) {
		
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"), prop.getProperty("dbPass"));
				PreparedStatement pstmt =  (PreparedStatement) conn.prepareStatement(prop.getProperty("insertquery"))){
			pstmt.setString(1, bean.getName());
			pstmt.setInt(2, bean.getNumber());
			pstmt.setString(3, bean.getGroup());
			int i = pstmt.executeUpdate();
			if(i>0) {
				System.out.println("Added Successfully :) ");
				return true;	
			} else {
				
				return false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean deleteContact(String name) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"), prop.getProperty("dbPass"));
				PreparedStatement pstmt =  (PreparedStatement) conn.prepareStatement(prop.getProperty("deletequery"))){
			pstmt.setString(1, name);
			int i = pstmt.executeUpdate();
			if(i>0) {
				return true;	
			} else {
				
				return false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean editContact(String name) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"), prop.getProperty("dbPass"));
				PreparedStatement pstmt =  (PreparedStatement) conn.prepareStatement(prop.getProperty("update"))){
			System.out.println("Enter The  new Contact No: ");
			int i = sc.nextInt();
			System.out.println("Ente The new Group Name :");
			String j = sc.next();
			pstmt.setInt(1, i);
			pstmt.setString(2, j);
			pstmt.setString(3, name);
			int k = pstmt.executeUpdate();
			if(k>0) {
				return true;	
			} else {
				
				return false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public List<ContactBean> searchContact(String name) {
		
		List<ContactBean> l1 =  new ArrayList<ContactBean>();
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"), prop.getProperty("dbPass"));
				PreparedStatement pstmt =  (PreparedStatement) conn.prepareStatement(prop.getProperty("search"))){
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			ContactBean b =  new ContactBean();
			while(rs.next()) {
				b.setName(rs.getString(1));
				b.setNumber(rs.getInt(2));
				b.setGroup(rs.getString(3));
				
			}
			l1.add(b);
			
			return l1;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<ContactBean> allContact() {
		List<ContactBean> l1 =  new ArrayList<ContactBean>();
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"), prop.getProperty("dbPass"));
				PreparedStatement pstmt =  (PreparedStatement) conn.prepareStatement(prop.getProperty("all"))){
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ContactBean b =  new ContactBean();
				b.setName(rs.getString(1));
				b.setNumber(rs.getInt(2));
				b.setGroup(rs.getString(3));
				l1.add(b);
				
			}
			return l1;
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
