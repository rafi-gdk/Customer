package com.sonu.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonu.beans.Customer;
import com.sonu.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	Logger log=LoggerFactory.getLogger(CustomerController.class);

	@GetMapping(value="/get-customer/{customer_id}",produces = "application/json")
	public Customer getCustomer(@PathVariable("customer_id") Integer customer_id)
	{
		return customerService.getCustomer(customer_id);
	}
	@PostMapping(value="/add-customer" , produces = "application/json")
	public Customer getCustomer(@RequestBody Customer customer)
	{
		return customerService.addCustomer(customer);
	}
	@GetMapping(value="/{keyValue}",produces = "application/json")
	public String getJSONObject(@PathVariable("keyValue") Integer keyValue)
	{
		return customerService.getJSONObject(keyValue);
	}
	
}
