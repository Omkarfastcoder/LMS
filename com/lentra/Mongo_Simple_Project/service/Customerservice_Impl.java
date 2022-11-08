package com.lentra.Mongo_Simple_Project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lentra.Mongo_Simple_Project.Dao.Customerdao;
import com.lentra.Mongo_Simple_Project.entity.Customer;
import com.lentra.Mongo_Simple_Project.entity.User;

@Service
public class Customerservice_Impl implements Customerservice {
	@Autowired
	Customerdao dao;

	@Override
	public List<Customer> getAllCustomer() {
		return dao.findAll();
	}

	@Override
	public Customer getCustomerById(int id) {
		Optional<Customer> st = dao.findById(id);
		if (st.isPresent()) {
			return st.get();
		} else {
			return null;
		}

	}
	
	

	@Override
	public Customer updateCustomer(Customer cust) {
		Optional<Customer> st = dao.findById(cust.getId());
		Customer stud = new Customer();
		if (st.isPresent()) {
			stud = st.get();
			stud.setName(cust.getName());
			stud.setEmail(cust.getEmail());
			dao.save(stud);
		}
		return stud;
	}

	@Override
	public Customer addCustomer(Customer cust) {
		return dao.save(cust);
	}

	@Override
	public boolean deleteCustomer(int id) {
		Optional<Customer> st = dao.findById(id);
		if (st.isPresent()) {
			dao.delete(st.get());
			return true;
		} else {
			return false;
		}}
	
//	@Override
//	public String getbyEmail(String email) {
//		Customer usr= dao.findByEmail(email);
//		   if(usr.getEmail().equals(email)) {
//			   return 0;
//		   }else {
//		return 1;
//	}

//	}

	@Override
	public Customer getCustomerByEmailId(String emailid) {
		Optional<Customer> st = Optional.of(dao.findByEmail(emailid));
		if (st.isPresent()) {
			return st.get();
		} else {
			return null;
		} 
	}

	@Override
	public Map<String, Object> checkData(Customer customer) {
	List<Customer> cust = dao.findAll();
	Map<String, Object> map=new HashMap<>();
	for(Customer cus:cust) {
		if(cus.getName().equals(customer.getName()) && 
				cus.getEmail().equals(customer.getEmail()) &&
			  cus.getAdhar().equals(customer.getAdhar()) &&
			  cus.getAdhar().equals(customer.getAdhar())&&
			  cus.getGender().equals(customer.getGender())&&
			  cus.getBdate().equals(customer.getBdate())&&
			  cus.getAddress().equals(customer.getAddress())&&
			  cus.getEtype().equals(customer.getEtype())&&
			  cus.getSalary().equals(customer.getSalary())&&
			  cus.getRefrence().equals(customer.getRefrence())&&
			  cus.getPan().equals(customer.getPan())&&
			  cus.getMobile().equals(customer.getMobile()))
		{
    map.put("msg", "valid user");
    map.put("customer",cus);
    break;
		}
		else {
			map.put("msg", "invalid user");
			map.put("customer", null);
			}
		}
		return map;
	}}
