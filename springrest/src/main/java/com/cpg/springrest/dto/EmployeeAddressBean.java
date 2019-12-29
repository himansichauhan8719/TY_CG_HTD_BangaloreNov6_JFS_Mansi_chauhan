package com.cpg.springrest.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="employee_address_info")
public class EmployeeAddressBean {

	@Id
	@Column
	@GeneratedValue
	private int id;
	@Column(nullable = false)
	private String addType;
	@Column
	private String add1;
	@Column
	private String add2;
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="emp_id",referencedColumnName = "id")
	private EmployeeBean bean;
}













