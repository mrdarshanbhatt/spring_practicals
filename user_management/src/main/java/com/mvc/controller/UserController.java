package com.mvc.controller;

import static java.lang.String.valueOf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.factory.Design;
import com.mvc.factory.Keyword;
import com.mvc.factory.Regex;
import com.mvc.models.PasswordModel;
import com.mvc.models.UserModel;
import com.mvc.repository.PassWordRepository;
import com.mvc.repository.UserRepository;
import com.mvc.service.PasswordManager;
import com.mvc.service.SendMailService;
import com.mvc.service.UserService;

@Controller
public class UserController {

	@Autowired
	SendMailService mailService;

	@Autowired
	PasswordManager passManage;

	@Autowired
	PassWordRepository passRepo;

	@Autowired
	UserRepository userRepo;

	@Autowired
	UserService userService;

	String exception = null;

	// Display home Page all Functionality are show
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String login() {

		return "home.jsp";

	}

	// Login user with login status
	@PostMapping(value = "/login")
	public ModelAndView home(@RequestParam String uid, @RequestParam String pass, HttpSession session) {
		try {

			UserModel model = userRepo.findByUid(uid);

			// set Data in session Object
			userService.setSession(model, session);

			// Check login status
			if (model.isStatus()) {
				return new ModelAndView("Reponse.jsp").addObject(Keyword.MESSAGE, Design.LOGIN);
			} else if (PasswordManager.decryption(model.getPass()).equals(pass)) {
				model.setStatus(true);
				userRepo.save(model);
				return new ModelAndView("success.jsp").addObject(Keyword.MESSAGE,
						"Hi, " + model.getFname() + " " + model.getLname() + " You logged in to UserManagment v1.1");
			}
			return new ModelAndView("loginerror.jsp");

		} catch (Exception e) {
			e.printStackTrace();
			exception = e.getMessage();
		}
		return new ModelAndView("Reponse.jsp").addObject(Keyword.MESSAGE, exception);
	}

	// If user is login but account is not found then create/addUser through this
	@PostMapping(value = "/addUser")
	public ModelAndView addUser(UserModel model) {
		try {
			List<String> validationMsg = passManage.passwordValidation(model.getPass());

			// Check Password Format
			if (!validationMsg.isEmpty()) {
				return new ModelAndView("Reponse.jsp").addObject(Keyword.MESSAGE, validationMsg);
			}

			// Check email
			if (!model.getEmail().toString().matches(Regex.email)) {
				return new ModelAndView("Reponse.jsp").addObject(Keyword.MESSAGE, Design.ERROR_EMAIL);
			}

			// Check UserId
			if (!String.valueOf(model.getUid()).matches(Regex.uid)) {
				return new ModelAndView("Reponse.jsp").addObject(Keyword.MESSAGE, Design.ERROR_USER_ID);
			}

			// Check Mobile Number
			if (!model.getMobile().matches(Regex.mobile)) {
				return new ModelAndView("Reponse.jsp").addObject(Keyword.MESSAGE, Design.ERROR_MOBILE);
			}

			final String encyPass = PasswordManager.encryption(model.getPass().toString());

			UserModel userModel = new UserModel();
			userModel.setFname(model.getFname());
			userModel.setLname(model.getLname());
			userModel.setMobile(model.getMobile());
			userModel.setPass(encyPass);
			userModel.setCity(model.getCity());
			userModel.setEmail(model.getEmail());
			userModel.setUid(model.getUid());
			userModel.setStatus(false);
			userRepo.save(userModel);

			PasswordModel passModel = new PasswordModel();
			passModel.setUid(model.getUid());
			passModel.setCurrentPass(encyPass);
			passModel.setUpdateCount(0);
			passRepo.save(passModel);

			// send mail
			Map<String, Object> emailMap = new HashMap<>();
			emailMap.put(Keyword.EMAIL, model.getEmail());
			emailMap.put(Keyword.SUBJECT, "Welcome to Usermanagement v1.1");
			emailMap.put(Keyword.MESSAGE, "Hello," + model.getFname() + " " + model.getLname()
					+ "Your Account Successfully Created in UserManagment v1.1");
			mailService.sendMail(emailMap);

			return new ModelAndView("Reponse.jsp").addObject(Keyword.MESSAGE,
					model.getFname() + " " + model.getLname());
		} catch (Exception e) {
			exception = e.getMessage();
		}
		return new ModelAndView("Reponse.jsp").addObject(Keyword.MESSAGE, exception);
	}

	// Find user using UserId
	@PostMapping(value = "/findUser")
	public ModelAndView findOne(@RequestParam String uid, HttpSession session) {
		try {
			System.out.println(session.isNew());
			if (session.isNew()) {
				return new ModelAndView("Reponse.jsp").addObject(Keyword.MESSAGE, Design.SESSION_EXPIRED);
			}
			UserModel models = userRepo.findByUid(uid);
			if (models == null) {
				return new ModelAndView("Reponse.jsp").addObject(Keyword.MESSAGE, Design.ERROR);
			}
			return new ModelAndView("getUser.jsp").addObject(Keyword.MESSAGE,
					"UserId : " + models.getUid() + "<br> User : " + models.getFname() + " " + models.getLname());
		} catch (Exception e) {
			exception = e.getMessage();
		}
		return new ModelAndView("Reponse.jsp").addObject(Keyword.MESSAGE, exception);
	}

	// Delete user through UserId
	@PostMapping(value = "/deleteUser")
	public ModelAndView deleteUser(@RequestParam String uid, HttpSession session) {
		try {
			if (session == null) {
				return new ModelAndView("Reponse.jsp").addObject(Keyword.MESSAGE, Design.SESSION_EXPIRED);
			}
			UserModel userModel = userRepo.findByUid(uid);
			if (userModel == null) {
				return new ModelAndView("Reponse.jsp").addObject(Keyword.MESSAGE, Design.ERROR);
			}
			userRepo.delete(userModel);
			return new ModelAndView("Reponse.jsp").addObject(Keyword.MESSAGE,
					userModel.getFname() + " " + userModel.getLname());
		} catch (Exception e) {
			exception = e.getMessage();
		}
		return new ModelAndView("Reponse.jsp").addObject(Keyword.MESSAGE, exception);
	}

	@PostMapping(value = "/updateUser")
	public ModelAndView updateUser(UserModel model, HttpSession session) {
		try {

			// Check session
			if (session.isNew()) {
				return new ModelAndView("Reponse.jsp").addObject(Keyword.MESSAGE, Design.SESSION_EXPIRED);
			}

			UserModel userModel = userRepo.findByUid(valueOf(model.getUid()));
			// Find no any account
			if (userModel == null) {
				return new ModelAndView("Reponse.jsp").addObject(Keyword.MESSAGE, Design.ERROR_ACCOUNT);
			}

			// Check Email Format
			if (!model.getEmail().matches(Regex.email)) {
				return new ModelAndView("Reponse.jsp").addObject(Keyword.MESSAGE, "Please Enter Proper Email...");
			}

			// Check Mobile Number Format
			if (!model.getMobile().matches(Regex.mobile)) {
				return new ModelAndView("Reponse.jsp").addObject(Keyword.MESSAGE,
						"Please Enter Proper Mobile Number...");
			}

			// Check Password
			if (!PasswordManager.decryption(userModel.getPass().toString()).equals(model.getPass())) {
				return new ModelAndView("Reponse.jsp").addObject(Keyword.MESSAGE,
						"Your UserId or Password Incorrect...");
			}
			// Check Login status
			if (!userModel.isStatus()) {
				return new ModelAndView("Reponse.jsp").addObject(Keyword.MESSAGE, Design.ERROR_LOGIN);
			}

			userModel.setCity(model.getCity());
			userModel.setEmail(model.getEmail());
			userModel.setFname(model.getFname());
			userModel.setLname(model.getLname());
			userModel.setMobile(model.getMobile());
			userModel.setPass(PasswordManager.encryption(model.getPass().toString()));
			userRepo.save(userModel);

			// For sending mail when user account Update
			Map<String, Object> emailMap = new HashMap<>();
			emailMap.put(Keyword.EMAIL, userModel.getEmail());
			emailMap.put(Keyword.SUBJECT, "Security Alert from UserMangment v1.1");
			emailMap.put(Keyword.MESSAGE,
					"Your Account Updated by " + userModel.getFname() + " " + userModel.getLname());
			mailService.sendMail(emailMap);

			return new ModelAndView("update.jsp").addObject(Keyword.MESSAGE, model.getFname() + " " + model.getLname());
		} catch (Exception e) {
			exception = e.getMessage();
		}
		return new ModelAndView("Reponse.jsp").addObject(Keyword.MESSAGE, exception);
	}

	@PostMapping(value = "/updatePass")
	public ModelAndView postMethodName(PasswordModel passModel) {

		UserModel userModel = userRepo.findByUid(passModel.getUid());
		PasswordModel model = passRepo.findByUid(passModel.getUid());

		if (userModel == null) {
			return new ModelAndView("Reponse.jsp").addObject(Keyword.MESSAGE, Design.ERROR_ACCOUNT);
		}

		List<String> validationMsg = passManage.passwordValidation(passModel.getNewPass());
		// Check Password Format
		if (!validationMsg.isEmpty()) {
			return new ModelAndView("Reponse.jsp").addObject(Keyword.MESSAGE, validationMsg);
		}

		if (!passModel.getNewPass().equals(passModel.getConfirmPass())) {
			return new ModelAndView("Reponse.jsp").addObject(Keyword.MESSAGE,
					"Your confirm password not match with new passwoed...");
		}

		// Current Password
		final String currentPass = PasswordManager.decryption(model.getCurrentPass());

		// if Password Both Current Password then, update new password.
		if (!currentPass.equals(passModel.getCurrentPass())) {
			return new ModelAndView("Reponse.jsp").addObject(Keyword.MESSAGE, "Your current password is incorrect...");
		}

		if (!(model.getUpdateCount() < 4)) {
			return new ModelAndView("Reponse.jsp").addObject(Keyword.MESSAGE, "Password Update Limit Finished...");
		}

		// send mail When Password Update by user
		Map<String, Object> emailMap = new HashMap<>();
		emailMap.put(Keyword.EMAIL, userModel.getEmail());
		emailMap.put(Keyword.SUBJECT, "Security Alert from UserMangment v1.1");
		emailMap.put(Keyword.MESSAGE, "Your Account Password Updated by " + userModel.getFname() + " "
				+ userModel.getLname() + "\n\nYou Change The password " + model.getUpdateCount() + 1 + " Times");
		mailService.sendMail(emailMap);

		model.setCurrentPass(PasswordManager.encryption(passModel.getNewPass()));
		model.setNewPass(PasswordManager.encryption(passModel.getNewPass()));
		model.setConfirmPass(PasswordManager.encryption(passModel.getConfirmPass()));
		model.setUpdateCount(model.getUpdateCount() + 1);
		passRepo.save(model);

		return new ModelAndView("success.jsp").addObject(Keyword.MESSAGE,
				"Hi, " + userModel.getFname() + " " + userModel.getLname() + " Your Password is Updated"
						+ " <br><br>You change the password " + model.getUpdateCount() + " Times");
	}

	// Logout User and session Destroyed
	@PostMapping(value = "/logout")
	public ModelAndView logout(HttpSession session) {
		try {
			if (session.isNew()) {
				return new ModelAndView("Reponse.jsp").addObject(Keyword.MESSAGE, Design.SESSION_EXPIRED);
			}
			UserModel userModel = userRepo.findByUid(session.getAttribute("uid").toString());
			userModel.setStatus(false);
			session.invalidate();
			userRepo.save(userModel);
			return new ModelAndView("logout.jsp").addObject(Keyword.MESSAGE,
					userModel.getFname() + " " + userModel.getLname());

		} catch (Exception e) {
			exception = e.getMessage();
		}
		return new ModelAndView("Reponse.jsp").addObject(Keyword.MESSAGE, exception);
	}
}
