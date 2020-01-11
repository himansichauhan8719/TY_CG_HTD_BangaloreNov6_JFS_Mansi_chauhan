package com.capg.retailermaintanance.service;

import com.capg.retailermaintanance.dto.Orderinfo;
import com.capg.retailermanagement.dao.OrderDao;

public class OrderServImpl implements OrderServ {

	private OrderDao odao;
	
	@Override
	public Orderinfo getOrder(int id) {
		// TODO Auto-generated method stub
		return odao.getOrder(id);
	}

}
