package com.capgemini.forestrymanagement.forestryapp;

import java.util.ArrayList;
import java.util.Scanner;

import com.capgemini.forestrymanagement.forestrybean.ProductBean;
import com.capgemini.forestrymanagement.forestrydao.ProductDAO;
import com.capgemini.forestrymanagement.main.Home;
import com.capgemini.forestrymanagement.util.ForestryManagementDAO;

public class ProductApp {
	private static ProductDAO dao =  ForestryManagementDAO.getProductDAO();

	public static void productApp() {
			Scanner scn = new Scanner(System.in);
			int a = 0;
			do {
				System.out.println("Press 1 to Add Product: ");
				System.out.println("Press 2 to Delete Product: ");
				System.out.println("Press 3 to View All Product: ");
				System.out.println("Press 4 to modify Product: ");
				System.out.println("Press 5 to Back ");
				System.out.println("Please enter your choice..");
				a = scn.nextInt();
				switch (a) {
				case 1:
					ProductBean bean = new ProductBean();
					System.out.println("Add Product Details....");
					System.out.println("Enter Produdct Id:");
					bean.setProductid(scn.nextInt());
					System.out.println("Enter Produdct Name:");
					bean.setProductName(scn.next());
					System.out.println("Enter Produdct Description:");
					bean.setProductDesc(scn.next());
					dao.addProduct(bean);
					break;
				case 2:
					System.out.println("Delete Product:");
					System.out.println("Please enter the Product Id which you want to delete..");
					int productid = scn.nextInt();
					dao.deleteProduct(productid);
					break;
				case 3:
					System.out.println("All Product Details are listed below::");
					ArrayList<ProductBean> productList = dao.showAllProduct();
					for (ProductBean productBean : productList) {
						System.out.println(productBean);
					}
					
					break;
				case 4:System.out.println("Please enter the Product Id which you want to modify..");
						productid=scn.nextInt();
						bean = dao.getProduct(productid);
						if(bean!=null) {
							dao.modifyProduct(bean);
						}else {
							System.out.println("Product not found with the requested Id..");
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
