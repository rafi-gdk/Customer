package com.sonu.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Lazy;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer customer_id; 

	@Column
	private String customer_name;

	@JsonIgnore
	@ElementCollection
	@Lazy
	private List<Integer> phone_number;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "addess_id")
	private Address address;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "customers")
	private List<Complaint> complaints;

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name = "Customers_Products",joinColumns = { @JoinColumn(name = "product_id") },inverseJoinColumns = { @JoinColumn(name = "customer_id") })
	private List<Product> products;

	public Customer() {}
	
	public Customer(String customer_name, List<Integer> phone_number, Address address, List<Complaint> complaints,
			List<Product> products) {
		super();
		this.customer_name = customer_name;
		this.phone_number = phone_number;
		this.address = address;
		this.complaints = complaints;
		this.products = products;
	}

	public Integer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public List<Integer> getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(List<Integer> phone_number) {
		this.phone_number = phone_number;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Complaint> getComplaints() {
		return complaints;
	}

	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_name=" + customer_name + ", phone_number="
				+ phone_number + ", address=" + address + ", complaints=" + complaints + ", products=" + products + "]";
	}
	
}