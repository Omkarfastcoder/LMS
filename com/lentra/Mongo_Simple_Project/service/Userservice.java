package com.lentra.Mongo_Simple_Project.service;
import com.lentra.Mongo_Simple_Project.entity.User;

public interface Userservice {
	

	public User addUser(User user);
	//public User getUserById(User user);
	 public User getUserById(String userid);
	public User getUserbyEmailid(String emailid);
	}
