package com.sonu.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer product_id; 

	@Column
	private String product_name;

	@Column
	private Double product_price;

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "products")
	List<Customer> customers;
	
	public Product() {}

	public Product(String product_name, Double product_price) {
		super();
		this.product_name = product_name;
		this.product_price = product_price;
	}

	public Product(String product_name, Double product_price, List<Customer> customers) {
		super();
		this.product_name = product_name;
		this.product_price = product_price;
		this.customers = customers;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public Double getProduct_price() {
		return product_price;
	}

	public void setProduct_price(Double product_price) {
		this.product_price = product_price;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
}