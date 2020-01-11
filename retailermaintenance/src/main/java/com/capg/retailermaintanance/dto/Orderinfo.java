package com.capg.retailermaintanance.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

 
	@Data
	@Entity
	@Table(name="orderinfo")
	public class Orderinfo {
		@Column
		@Id
		@GeneratedValue
		private int orderid;
		@Column
		private int proid;
		@Column
		private int userid;
	}

