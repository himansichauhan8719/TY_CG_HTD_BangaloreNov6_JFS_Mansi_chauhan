package com.capgemini.forestrymanagement.forestryapp;

import java.util.ArrayList;
import java.util.Scanner;

import com.capgemini.forestrymanagement.forestrybean.ContractBean;
import com.capgemini.forestrymanagement.forestrydao.ContractDAO;
import com.capgemini.forestrymanagement.main.Home;
import com.capgemini.forestrymanagement.util.ForestryManagementDAO;

public class ContractApp {

	private static ContractDAO dao=ForestryManagementDAO.getContractDAO();

	public static void contractApp() {
		Scanner scn = new Scanner(System.in);
		int a=0;
		do {
			System.out.println("Press 1 to Add Contract: ");
			System.out.println("Press 2 to Delete Contract: ");
			System.out.println("Press 3 to View All Contract: ");
			System.out.println("Press 4 to Back ");
			System.out.println("Please enter your choice..");
			a = scn.nextInt();
			switch (a) {
			case 1:
				ContractBean bean = new ContractBean();
				System.out.println("Add contract Details....");
				System.out.println("Enter contractNo: ");
				bean.setContractNo(scn.nextInt());
				System.out.println("Enter customerId: ");
				bean.setCustomerId(scn.nextInt());
				System.out.println("Enter productId: ");
				bean.setProductId(scn.nextInt());
				System.out.println("Enter haulierId: ");
				bean.setHaulierId(scn.nextInt());
				System.out.println("Enter deliveryDate: ");
				bean.setDeliveryDate(scn.next());
				System.out.println("Enter deliveryDay: ");
				bean.setDeliveryDay(scn.nextInt());
				System.out.println("Enter quantity: ");
				bean.setQuantity(scn.nextInt());
				dao.addContractor(bean);
				break;
			case 2:
				System.out.println("Delete Contract:");
				System.out.println("Please enter the contract No which you want to delete..");
				int contractNo=scn.nextInt();
				dao.deleteContractor(contractNo);
				break;
			case 3:
				System.out.println("All Contract Details are listed below::");
				ArrayList<ContractBean> showAllContract = dao.showAllContract();
				for (ContractBean contractBean : showAllContract) {
					System.out.println(contractBean);
				}
				break;

			case 4:
				System.out.println("Back to Home..");
				break;

			default: System.out.println("Please enter valid choice.");
			break;
			}
		}while(a!=4);
		Home.home();
	}
}