package com.mvc.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "password")
public @Data class PasswordModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	// Here use lombok Library
	private String currentPass, newPass, confirmPass, uid;
	
	private int updateCount;

}
