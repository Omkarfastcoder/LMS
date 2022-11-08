package com.lentra.Mongo_Simple_Project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lentra.Mongo_Simple_Project.Dao.Userdao;
import com.lentra.Mongo_Simple_Project.entity.User;
import com.lentra.Mongo_Simple_Project.service.Userservice;

@RestController
@RequestMapping("/User")
@CrossOrigin(origins = "http://localhost:4200")
public class Usercontroller {

	@Autowired
	private Userservice service;
	
	@Autowired
	public Userdao dao;

	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User uk) {

		User ud = service.addUser(uk);
		if (ud != null) {
			return new ResponseEntity<User>(ud, HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(ud, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("{userid}")
	public ResponseEntity<User> getUserById(@PathVariable String userid) {
		User usr = service.getUserById(userid);
		if (usr != null) {
			return new ResponseEntity<User>(usr, HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(usr, HttpStatus.NO_CONTENT);
		}
	}

//	@RequestMapping("/login/{emailid}'and'{password}")
//	public int login(@PathVariable String emailid, @PathVariable String password)
//	{
//		// 0-success 1 userid null 2 passwaord null 3 clientname null 4 password wrong 5
//		// multiple acc
//		// -1 exceptions
//		try {
//			if (emailid == null || emailid.length() == 0)
//				return 1;
//			if (password == null || password.length() == 0)
//				return 2;
//
//			int cnt = dao.countByEmailid(emailid);
//			if (cnt > 1)
//				return 5;
//			User borrower = dao.findByEmailid(emailid);
//
//			if(borrower==null)
//				return 3;
//			if (!borrower.getEmailid().equals(emailid))
//				return 3;
//
//			if (!borrower.getPassword().equals(password))
//				return 4;
//
//			return 0;
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			return -1;
//		}
//	}
	
	@PostMapping("/check")
	public ResponseEntity<?>loginUser(@RequestBody User userdata)
	{
		User user=dao.findByEmailid(userdata.getEmailid());
		if(user.getPassword().equals(userdata.getPassword()))
			return ResponseEntity.ok(user);
		return (ResponseEntity<?>) ResponseEntity.internalServerError();
		
		
	}

}
