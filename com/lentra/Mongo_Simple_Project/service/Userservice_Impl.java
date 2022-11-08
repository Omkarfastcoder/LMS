package com.lentra.Mongo_Simple_Project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lentra.Mongo_Simple_Project.Dao.Userdao;
import com.lentra.Mongo_Simple_Project.entity.User;

@Service
public class Userservice_Impl implements Userservice {
	@Autowired
	Userdao dao;

	@Override
	public User addUser(User user) {

		return dao.save(user);
	}

	@Override
	public User getUserById(String userid) {
		Optional<User> usr = dao.findById(userid);
		if (usr.isPresent()) {
			return usr.get();
		} else {
			return null;

		}

	}

@Override
	public User getUserbyEmailid(String emailid) {
		Optional<User>usr= dao.findById(emailid);
		   if(usr.isPresent()) {
			   return usr.get();
		   }else {
		return null;
	}
	}
}
	
