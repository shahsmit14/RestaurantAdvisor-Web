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
@Table(name = "MenuDetails")
public class MenuDetails {

	@Id
	@GeneratedValue
	@Column(name = "MenuDetailsId")
	private long menuDetailsId;

	@Column(name = "Item")
	private String item;

	@Column(name = "Description")
	private String description;

	@Column(name = "Price")
	private float price;

	@Column(name = "Status")
	private String status;

	@Column(name = "TimeStamp")
	private Date timeStamp;

	@ManyToOne
	@JoinColumn(name = "UserID")
	private LoginDetails loginDetails;

	// OrderDetails One to Many
	@OneToMany(mappedBy = "menuDetails")
	private Set<OrderDetails> orderDetails;

	public long getMenuDetailsId() {
		return menuDetailsId;
	}

	public void setMenuDetailsId(long menuDetailsId) {
		this.menuDetailsId = menuDetailsId;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public LoginDetails getLoginDetails() {
		return loginDetails;
	}

	public void setLoginDetails(LoginDetails loginDetails) {
		this.loginDetails = loginDetails;
	}

	public Set<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

}
