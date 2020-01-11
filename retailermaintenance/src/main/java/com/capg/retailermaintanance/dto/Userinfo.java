package com.capg.retailermaintanance.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="userinfo")
public class Userinfo {
	
	@Column
	@Id
	@GeneratedValue
    private int userid;
	@Column
    private String name;
	@Column(unique= true,nullable=false)
    private String email;
	@Column
    private String password;
}
