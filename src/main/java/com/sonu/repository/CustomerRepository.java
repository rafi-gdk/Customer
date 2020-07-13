package com.sonu.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sonu.beans.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer>{
	
	@Query(value="delete from Customer where customer_id=:customer_id",nativeQuery = true)
	public int deleteCustomer(Integer customer_id);
}
