package com.mvc.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.mvc.models.UserModel;

@Service
public class UserService {

	// Set Data in Session
	public void setSession(UserModel model, HttpSession session) {
		session.setAttribute("uid", model.getUid());
		session.setAttribute("name", model.getFname() + " " + model.getLname());
		session.setAttribute("city", model.getCity());
		session.setAttribute("email", model.getEmail());
		session.setAttribute("mobile", model.getMobile());
		//session.setMaxInactiveInterval(10000);
	}

}
