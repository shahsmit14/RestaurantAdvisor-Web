package com.restaurantadvisor.website.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OrderDetails")
public class OrderDetails {

	@Id
	@GeneratedValue
	@Column(name = "OrderDetailsId")
	private long orderDetaislId;
	
	@Column(name = "Quantity")
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name = "OrderId")
	private OrderTransaction orderTransaction;
	
	@ManyToOne
	@JoinColumn(name = "MenuDetailsId")
	private MenuDetails menuDetails;

	public long getOrderDetaislId() {
		return orderDetaislId;
	}

	public void setOrderDetaislId(long orderDetaislId) {
		this.orderDetaislId = orderDetaislId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public OrderTransaction getOrderTransaction() {
		return orderTransaction;
	}

	public void setOrderTransaction(OrderTransaction orderTransaction) {
		this.orderTransaction = orderTransaction;
	}

	public MenuDetails getMenuDetails() {
		return menuDetails;
	}

	public void setMenuDetails(MenuDetails menuDetails) {
		this.menuDetails = menuDetails;
	}
	
	
}
