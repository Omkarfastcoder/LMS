package com.lentra.Mongo_Simple_Project.Dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lentra.Mongo_Simple_Project.entity.User;
@Repository
public interface Userdao extends MongoRepository<User, String>{

	 int countByEmailid(String emailid);
	
	 User findByEmailid(String emailid);
}
