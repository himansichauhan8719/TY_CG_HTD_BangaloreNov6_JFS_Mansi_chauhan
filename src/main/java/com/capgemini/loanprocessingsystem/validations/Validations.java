package com.capgemini.loanprocessingsystem.validations;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Validations {

	public static boolean isNumber(int id) {
		String number = Integer.toString(id);
		return number.matches("[0-9]+");
	}
	public static boolean isChar(String name) {
		return name.matches("[a-zA-Z][a-zA-Z ]+[a-zA-Z]$");
	}
	public static boolean aadhar(String number) {
		return number.matches("[0-9]{12}");
	}
	public static boolean phone(String phone) {
		return phone.matches("[789]{1}[0-9]{9}");
	}
	public static boolean email(String email) {
		return email.matches("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$");
	}
	public static boolean validateTown(String town) {
		return town.matches("[a-zA-Z]+");
	}
	public static boolean validatePostal(int post) {
		String postal=Integer.toString(post);
		return postal.matches("[0-9]{6}");
	}
	public static boolean date(String date) {
		String interviewDate = "[0-9] {2}[/][0-9] {2}[/][0-9] {4}";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");
		Date date1 = new Date();
		String today = simpleDateFormat.format(date1);
		if(date.matches(interviewDate)) {
			int count = today.compareTo(date);
			if(count>0) {
				System.out.println("Date should be greater than current date");
				return false;
			}else {
				return true;
			}
		}else {
		return false;

	}
		
	}
	public static boolean isDouble(double number) {
		String d=Double.toString(number);
		return d.matches("[0-9]+(\\.){0,1}[0-9]*");
	}
	public static boolean address(String address) {
		return address.matches("\\A(\\d+[a-zA-Z]{0,1}\\s{0,1}[-]{1}\\s{0,1}\\d*[a-zA-Z]{0,1}|\\d+[a-zA-Z-]{0,1}\\d*[a-zA-Z]{0,1})\\s*+(.*)");
	}
}
