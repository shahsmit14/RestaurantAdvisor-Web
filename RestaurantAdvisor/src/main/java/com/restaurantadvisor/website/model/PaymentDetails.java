package com.restaurantadvisor.website.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "PaymentDetails")
public class PaymentDetails {

	@Id
	@Column(name = "UserID", unique = true, nullable = false)
	@GeneratedValue(generator = "gen")
	@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "loginDetails"))
	private long userID;

	@Column(name = "CardType")
	private String cardType;

	@Column(name = "CardNumber")
	private long cardNumber;

	@Column(name = "ExpiryDate")
	private String expiryDate;

	@Column(name = "CCVNumber")
	private int ccvNumber;

	@Column(name = "CardName")
	private String cardName;

	@OneToOne
	@PrimaryKeyJoinColumn
	private LoginDetails loginDetails;

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getCcvNumber() {
		return ccvNumber;
	}

	public void setCcvNumber(int ccvNumber) {
		this.ccvNumber = ccvNumber;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public LoginDetails getLoginDetails() {
		return loginDetails;
	}

	public void setLoginDetails(LoginDetails loginDetails) {
		this.loginDetails = loginDetails;
	}

}
