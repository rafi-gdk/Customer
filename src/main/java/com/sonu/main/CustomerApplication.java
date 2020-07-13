package com.sonu.main;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sonu.beans.Address;
import com.sonu.beans.Complaint;
import com.sonu.beans.Customer;
import com.sonu.beans.Product;
import com.sonu.service.CustomerService;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sonu.service","com.sonu.controllers"})
@EntityScan(basePackages = {"com.sonu.beans"})
@EnableJpaRepositories(basePackages = {"com.sonu.repository"})
public class CustomerApplication implements CommandLineRunner{

	@Autowired
	CustomerService customerService;

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerService.addCustomer(new Customer("Sonu",Arrays.asList(990899899,330002,242422),new Address("15-2-620","301/1","58/1","Sripuram Colony","Telangana", 500036),Arrays.asList(new Complaint("Test"),new Complaint("Test1")),Arrays.asList(new Product("Shampoo",100.00))));
		customerService.addCustomer(new Customer("Rafi",Arrays.asList(990899899,360002,242422),new Address("15-2-621","301/1","58/1","Sripuram Colony","Telangana", 500036),Arrays.asList(new Complaint("Test"),new Complaint("Test2")),Arrays.asList(new Product("Soap",101.00))));
		customerService.addCustomer(new Customer("Chotu",Arrays.asList(99089988,340002,242422),new Address("15-2-622","301/1","58/1","Sripuram Colony","Telangana", 500036),Arrays.asList(new Complaint("Test"),new Complaint("Test3")),Arrays.asList(new Product("Shampoo",100.00))));
	}
}

