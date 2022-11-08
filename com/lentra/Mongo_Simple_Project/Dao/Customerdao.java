package com.lentra.Mongo_Simple_Project.Dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lentra.Mongo_Simple_Project.entity.Customer;
import com.lentra.Mongo_Simple_Project.entity.User;


@Repository
public interface Customerdao extends MongoRepository<Customer, Integer> {
	int countByEmail(String email);
	
	Customer findByEmail(String email);
}
