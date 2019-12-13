package com.capg.phoneSimulatorApp.factory;


	import com.capg.phoneSimulatorApp.dao.ContactDao;
import com.capg.phoneSimulatorApp.dao.ContactDaoImpl;


	public class ContactPage {


		public static ContactDao contactDaoImpl() {
		 ContactDao dao= new ContactDaoImpl();
			return dao;
		}

	}

