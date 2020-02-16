package com.capgemini.retailermentenance.response;

import java.util.List;

import com.capgemini.retailermentenance.dto.ProductInfo;
import com.capgemini.retailermentenance.dto.UserInfo;

import lombok.Data;

@Data
public class UserResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<UserInfo> user;
}
