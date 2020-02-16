package com.capgemini.retailermentenance.response;

import java.util.List;

import com.capgemini.retailermentenance.dto.ProductInfo;

import lombok.Data;

@Data
public class ProductResponse {
		private int statusCode;
		private String message;
		private String description;
		private List<ProductInfo> product;

}
