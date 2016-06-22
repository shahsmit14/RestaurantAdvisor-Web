package com.restaurantadvisor.website.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "LoginDetails")
public class LoginDetails {

	@Id
	@GeneratedValue
	@Column(name = "UserID")
	private long userID;

	@Column(name = "UserName")
	private String userName;

	@Column(name = "Password")
	private String password;

	@Column(name = "Status")
	private String status;

	@ManyToOne
	@JoinColumn(name = "RoleID")
	private UserRole userRole;

	@OneToOne(mappedBy = "loginDetails", cascade = CascadeType.ALL)
	private UserDetails userDetails;

	@OneToOne(mappedBy = "loginDetails", cascade = CascadeType.ALL)
	private HotelDetails hotelDetails;

	@OneToOne(mappedBy = "loginDetails", cascade = CascadeType.ALL)
	private AddressDetails addressDetails;

	@OneToOne(mappedBy = "loginDetails", cascade = CascadeType.ALL)
	private PaymentDetails paymentDetails;

	// MenuDetail One to Many
	@OneToMany(mappedBy = "loginDetails")
	private Set<MenuDetails> menuDetails;

	// OrderTransaction One to Many
	@OneToMany(mappedBy = "customerLoginDetails")
	private Set<OrderTransaction> customerOrderTransactions;

	/*
	 * @ManyToOne
	 * 
	 * @Column(name = "CustomerUserName")
	 * 
	 * @JoinColumn(name = "UserName") private LoginDetails customerLoginDetails;
	 */

	@OneToMany(mappedBy = "hotelLoginDetails")
	private Set<OrderTransaction> hotelOrderTransactions;

	/*
	 * @ManyToOne
	 * 
	 * @Column(name = "HotelUserName")
	 * 
	 * @JoinColumn(name = "UserName") private LoginDetails hotelLoginDetails;
	 */

	// UserReview Reviewer One to Many
	@OneToMany(mappedBy = "reviewerLoginDetails")
	private Set<UserReviews> reviewerUserReviews;

	// UserReview Reviewed One to Many
	@OneToMany(mappedBy = "reviewedLoginDetails")
	private Set<UserReviews> reviewedUserReviews;

	// //MessageDetails Sender One to Many
	// @OneToMany(mappedBy = "SenderUserName")
	// private Set<MessageDetails> senderMessageDetails;
	//
	// //MessageDetails receiver One to Many
	// @OneToMany(mappedBy = "ReceiverUserName")
	// private Set<MessageDetails> receiverMessageDetails;

	public LoginDetails() {

	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public HotelDetails getHotelDetails() {
		return hotelDetails;
	}

	public void setHotelDetails(HotelDetails hotelDetails) {
		this.hotelDetails = hotelDetails;
	}

	public AddressDetails getAddressDetails() {
		return addressDetails;
	}

	public void setAddressDetails(AddressDetails addressDetails) {
		this.addressDetails = addressDetails;
	}

	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

	public Set<MenuDetails> getMenuDetails() {
		return menuDetails;
	}

	public void setMenuDetails(Set<MenuDetails> menuDetails) {
		this.menuDetails = menuDetails;
	}

	public Set<OrderTransaction> getCustomerOrderTransactions() {
		return customerOrderTransactions;
	}

	public void setCustomerOrderTransactions(
			Set<OrderTransaction> customerOrderTransactions) {
		this.customerOrderTransactions = customerOrderTransactions;
	}

	public Set<OrderTransaction> getHotelOrderTransactions() {
		return hotelOrderTransactions;
	}

	public void setHotelOrderTransactions(
			Set<OrderTransaction> hotelOrderTransactions) {
		this.hotelOrderTransactions = hotelOrderTransactions;
	}

	public Set<UserReviews> getReviewerUserReviews() {
		return reviewerUserReviews;
	}

	public void setReviewerUserReviews(Set<UserReviews> reviewerUserReviews) {
		this.reviewerUserReviews = reviewerUserReviews;
	}

	public Set<UserReviews> getReviewedUserReviews() {
		return reviewedUserReviews;
	}

	public void setReviewedUserReviews(Set<UserReviews> reviewedUserReviews) {
		this.reviewedUserReviews = reviewedUserReviews;
	}

	// public Set<MessageDetails> getSenderMessageDetails() {
	// return senderMessageDetails;
	// }
	//
	// public void setSenderMessageDetails(Set<MessageDetails>
	// senderMessageDetails) {
	// this.senderMessageDetails = senderMessageDetails;
	// }
	//
	// public Set<MessageDetails> getReceiverMessageDetails() {
	// return receiverMessageDetails;
	// }
	//
	// public void setReceiverMessageDetails(Set<MessageDetails>
	// receiverMessageDetails) {
	// this.receiverMessageDetails = receiverMessageDetails;
	// }

}
