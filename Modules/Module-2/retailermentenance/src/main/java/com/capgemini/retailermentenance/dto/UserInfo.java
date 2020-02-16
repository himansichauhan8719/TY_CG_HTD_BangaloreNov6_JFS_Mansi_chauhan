package com.capgemini.retailermentenance.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;

@Data
@Entity
@Table(name="user_info")
public class UserInfo {

		@Column
		@Id
		@GeneratedValue
		private int Id;
		@Column
		private String name;
		@Column(unique=true)
		private String email;
		@Column
		private String password;
		
		@Exclude
		@OneToMany(cascade=javax.persistence.CascadeType.ALL)
	    @JoinColumn(name="userId")
	    private List<ProductInfo> product;
	 
	

}
