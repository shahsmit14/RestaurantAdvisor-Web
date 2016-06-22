package com.restaurantadvisor.website.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "OrderTransaction")
public class OrderTransaction {

	@Id
	@GeneratedValue
	@Column(name = "OrderId")
	private long orderId;
	
	@Column(name = "TotalCost")
	private float totalCost;
	
	@Column(name = "OrderStatus")
	private String orderStatus;
	
	@Column(name = "OrderTimeStamp")
	private Date orderTimeStamp;
	
	@ManyToOne
	@JoinColumn(name = "CustomerUserID")
	private LoginDetails customerLoginDetails;
	
	@ManyToOne
	@JoinColumn(name = "HotelUserID")
	private LoginDetails hotelLoginDetails;
	
	//OrderDetails One to Many
	@OneToMany(mappedBy = "orderTransaction")
	private Set<OrderDetails> orderDetails;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getOrderTimeStamp() {
		return orderTimeStamp;
	}

	public void setOrderTimeStamp(Date orderTimeStamp) {
		this.orderTimeStamp = orderTimeStamp;
	}

	public LoginDetails getCustomerLoginDetails() {
		return customerLoginDetails;
	}

	public void setCustomerLoginDetails(LoginDetails customerLoginDetails) {
		this.customerLoginDetails = customerLoginDetails;
	}

	public LoginDetails getHotelLoginDetails() {
		return hotelLoginDetails;
	}

	public void setHotelLoginDetails(LoginDetails hotelLoginDetails) {
		this.hotelLoginDetails = hotelLoginDetails;
	}

	public Set<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	
	
	
}
