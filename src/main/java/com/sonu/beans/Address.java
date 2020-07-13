package com.sonu.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer addess_id;
	
	@Column
	private String house_number;
	
	@Column
	private String flat_number;
	
	@Column
	private String plot_number;
	
	@Column
	private String street;
	
	@Column
	private String state;
	
	@Column
	private Integer pin;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "address")
	private Customer customer;
	
	public Address() {}
	
	public Address(String house_number, String flat_number, String plot_number, String street, String state,
			Integer pin) {
		super();
		this.house_number = house_number;
		this.flat_number = flat_number;
		this.plot_number = plot_number;
		this.street = street;
		this.state = state;
		this.pin = pin;
	}
	public Integer getAddess_id() {
		return addess_id;
	}
	public void setAddess_id(Integer addess_id) {
		this.addess_id = addess_id;
	}
	public String getHouse_number() {
		return house_number;
	}
	public void setHouse_number(String house_number) {
		this.house_number = house_number;
	}
	public String getFlat_number() {
		return flat_number;
	}
	public void setFlat_number(String flat_number) {
		this.flat_number = flat_number;
	}
	public String getPlot_number() {
		return plot_number;
	}
	public void setPlot_number(String plot_number) {
		this.plot_number = plot_number;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getPin() {
		return pin;
	}
	public void setPin(Integer pin) {
		this.pin = pin;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Address [addess_id=" + addess_id + ", house_number=" + house_number + ", flat_number=" + flat_number
				+ ", plot_number=" + plot_number + ", street=" + street + ", state=" + state + ", pin=" + pin
				+ ", customer=" + customer + "]";
	}
	
}