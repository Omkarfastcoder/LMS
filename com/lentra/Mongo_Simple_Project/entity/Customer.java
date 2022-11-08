package com.lentra.Mongo_Simple_Project.entity;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Document(collection = "customer")
public class Customer {
	
	private int id;
	private String name;
	private String email;
	private String adhar;
	private String gender;
	private String bdate;
	private String address;
	private String etype;
	private String salary;
	private String refrence;
	private String pan;
	private  String mobile;
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(address, other.address) && Objects.equals(adhar, other.adhar)
				&& Objects.equals(bdate, other.bdate) && Objects.equals(email, other.email)
				&& Objects.equals(etype, other.etype) && Objects.equals(gender, other.gender) && id == other.id
				&& Objects.equals(mobile, other.mobile) && Objects.equals(name, other.name)
				&& Objects.equals(pan, other.pan) && Objects.equals(refrence, other.refrence)
				&& Objects.equals(salary, other.salary);
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, adhar, bdate, email, etype, gender, id, mobile, name, pan, refrence, salary);
	}
	
	
	
	

}
