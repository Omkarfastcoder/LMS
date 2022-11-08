package com.lentra.Mongo_Simple_Project.service;

import java.util.List;
import java.util.Map;

import com.lentra.Mongo_Simple_Project.entity.Customer;
import com.lentra.Mongo_Simple_Project.entity.User;



public interface Customerservice {
	
	public List<Customer> getAllCustomer();
	public Customer getCustomerById(int id);
	public Customer updateCustomer(Customer customer);
	public Customer addCustomer(Customer costomer);
	public boolean deleteCustomer(int id);
	//String getbyEmail(String email);
	public Customer getCustomerByEmailId(String emailid);
	public Map<String, Object> checkData(Customer customer);


}
