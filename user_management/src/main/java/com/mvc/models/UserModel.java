package com.mvc.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "user")
public @Data class UserModel {

	// set primary key using @Id in user table
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String fname, lname, city, pass, email, mobile, uid;

	private boolean status;

}
