package com.lentra.Mongo_Simple_Project.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lentra.Mongo_Simple_Project.Dao.Customerdao;
import com.lentra.Mongo_Simple_Project.Dao.Userdao;
import com.lentra.Mongo_Simple_Project.entity.Customer;
import com.lentra.Mongo_Simple_Project.entity.User;
import com.lentra.Mongo_Simple_Project.service.Customerservice;

@RestController
@RequestMapping("/Customer")
@CrossOrigin(origins = "http://localhost:4200")
public class Customercontroller {
	@Autowired
	Customerservice service;
	@Autowired
	public Customerdao dao;

	@PostMapping("/save")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer cust) {

		Customer stud = service.addCustomer(cust);
		if (stud != null) {
			return new ResponseEntity<Customer>(stud, HttpStatus.OK);
		} else {
			return new ResponseEntity<Customer>(stud, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomer() {
		List<Customer> stud = service.getAllCustomer();
		if (stud != null) {
			return new ResponseEntity<List<Customer>>(stud, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Customer>>(stud, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("log/login/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
		Customer stud = service.getCustomerById(id);
		if (stud != null) {
			return new ResponseEntity<Customer>(stud, HttpStatus.OK);
		} else {
			return new ResponseEntity<Customer>(stud, HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer cust) {
		Customer stud = service.updateCustomer(cust);
		if (stud != null) {
			return new ResponseEntity<Customer>(stud, HttpStatus.OK);
		} else {
			return new ResponseEntity<Customer>(stud, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int id) {
		if (service.deleteCustomer(id)) {
			return new ResponseEntity<String>("Customer Deleted Successfully....!", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Customer Not_Found......!", HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/login/{email}")
	public ResponseEntity<Customer> login(@PathVariable String email) {

		Customer borrower = dao.findByEmail(email);

		if (!borrower.getEmail().equals(email)) {

			return new ResponseEntity<Customer>(borrower, HttpStatus.OK);
		} else {
			return new ResponseEntity<Customer>(borrower, HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/logina")
	public ResponseEntity<Customer> logina(@RequestBody Customer customer) {

		Customer borrower = dao.findByEmail(customer.getEmail());

		if (!borrower.getEmail().equals(customer.getEmail())) {
//				return 1;
//			else
//				return 2;
			return new ResponseEntity<Customer>(borrower, HttpStatus.OK);
		} else {
			return new ResponseEntity<Customer>(borrower, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/dedupe")
	public ResponseEntity<?> loginCustomer(@RequestBody Customer cust) {
		Customer user = dao.findByEmail(cust.getEmail());
		if (user != null)

			return ResponseEntity.ok(user);
		else
			return (ResponseEntity<?>) ResponseEntity.internalServerError();

	}

	@GetMapping("{email}")
	public ResponseEntity<Customer> getCustomerByEmailId(@PathVariable String email) {
		Customer stud = service.getCustomerByEmailId(email);
		if (stud != null) {
			return new ResponseEntity<Customer>(stud, HttpStatus.OK);
		} else {
			return new ResponseEntity<Customer>(stud, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/check")
	public ResponseEntity<Customer> getCustomerByEmailId(@RequestBody Customer cust) {
		Customer stud = dao.findByEmail(cust.getEmail());
		if (stud != null) {
			return new ResponseEntity<Customer>(stud, HttpStatus.OK);
		} else {
			return new ResponseEntity<Customer>(stud, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/checking")
	public ResponseEntity<Map<String, Object>> checkLogin(@RequestBody Customer cust) {
		Map<String, Object> map = service.checkData(cust);
		if (map != null) {
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} else {
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}}
	

