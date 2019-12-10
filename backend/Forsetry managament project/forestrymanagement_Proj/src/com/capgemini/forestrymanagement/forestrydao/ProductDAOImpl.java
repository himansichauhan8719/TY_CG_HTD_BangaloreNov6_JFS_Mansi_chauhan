package com.capgemini.forestrymanagement.forestrydao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.forestrymanagement.forestrybean.ContractBean;
import com.capgemini.forestrymanagement.forestrybean.CustomerBean;
import com.capgemini.forestrymanagement.forestrybean.ProductBean;

public class ProductDAOImpl implements ProductDAO{
	private List<ProductBean> product = new ArrayList();

	@Override
	public boolean addProduct(ProductBean productbean) {
		for ( ProductBean pb : product ) {
			if(pb.getProductid()==productbean.getProductid())	
			{
				return false;
			}
		}
		product.add(productbean);
		return true;
	}

	@Override
	public boolean modifyProduct(ProductBean productbean) {
		ProductBean pbean=get(productbean.getProductid());	
		if(bean!=null) {
			for (ProductBean productbean : product) {
				if(customerBean.getCustomerId()==bean.getCustomerId()) {
					cblist.remove(customerBean);
				}
			}
			bean.setCustomerName(custBean.getCustomerName());
			bean.setEmail(custBean.getEmail());
			bean.setPostalcode(custBean.getPostalcode());
			bean.setStreetAdd1(custBean.getStreetAdd1());
			bean.setStreetAdd2(custBean.getStreetAdd2());
			bean.setTelephoneNo(custBean.getTelephoneNo());
			bean.setTown(custBean.getTown());
			cblist.add(bean);
			System.out.println("record updated successfully...");
		}else {
			System.out.println("Either Customer not found or something went wrong.");
		}
		return false;
	}


	@Override
	public boolean deleteProduct(int productId) {
		
		return false;
	}

	@Override
	public ArrayList<ProductBean> showAllCustomer(ProductBean productbean) {
		// TODO Auto-generated method stub
		return null;
	}

}

