package com.sonu.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Complaint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	Integer complaint_id;
	
	@Column
	String  complaints;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customers;
	
	public Complaint() {}
	
	public Complaint(String complaints) {
		super();
		this.complaints = complaints;
	}

	public Integer getComplaint_id() {
		return complaint_id;
	}

	public void setComplaint_id(Integer complaint_id) {
		this.complaint_id = complaint_id;
	}

	public String getComplaints() {
		return complaints;
	}

	public void setComplaints(String complaints) {
		this.complaints = complaints;
	}

	public Customer getCustomers() {
		return customers;
	}

	public void setCustomers(Customer customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Complaint [complaint_id=" + complaint_id + ", complaints=" + complaints + ", customers=" + customers
				+ "]";
	}

}