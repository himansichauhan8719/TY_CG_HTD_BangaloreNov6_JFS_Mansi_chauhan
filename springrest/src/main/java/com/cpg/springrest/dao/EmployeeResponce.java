package com.cpg.springrest.dao;

import java.util.List;

import com.cpg.springrest.dto.EmployeeBean;

import lombok.Data;

@Data
public class EmployeeResponce {
	
	private int statusCode;
	private String message;
	private String discription;
	private List<EmployeeBean> beans;

}
