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
@Table(name = "HotelDetails")
public class HotelDetails {

	@Id
	@Column(name = "UserID", unique = true, nullable = false)
	@GeneratedValue(generator = "gen")
	@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "loginDetails"))
	private long userID;

	@Column(name = "HotelName")
	private String hotelName;

	@Column(name = "TagLine")
	private String tagLine;

	@Column(name = "Description")
	private String description;

	@Column(name = "HotelType")
	private String hotelType;

	@Column(name = "CostFor2")
	private int costFor2;

	@Column(name = "AverageRating")
	private double averageRating;

	@Column(name = "HotelMobileContact")
	private String hotelMobileContact;

	@Column(name = "HotelEmailContact")
	private String hotelEmailContact;

	@OneToOne
	@PrimaryKeyJoinColumn
	private LoginDetails loginDetails;


	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getTagLine() {
		return tagLine;
	}

	public void setTagLine(String tagLine) {
		this.tagLine = tagLine;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHotelType() {
		return hotelType;
	}

	public void setHotelType(String hotelType) {
		this.hotelType = hotelType;
	}

	public String getHotelMobileContact() {
		return hotelMobileContact;
	}

	public void setHotelMobileContact(String hotelMobileContact) {
		this.hotelMobileContact = hotelMobileContact;
	}

	public String getHotelEmailContact() {
		return hotelEmailContact;
	}

	public void setHotelEmailContact(String hotelEmailContact) {
		this.hotelEmailContact = hotelEmailContact;
	}

	public int getCostFor2() {
		return costFor2;
	}

	public void setCostFor2(int costFor2) {
		this.costFor2 = costFor2;
	}

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

	public LoginDetails getLoginDetails() {
		return loginDetails;
	}

	public void setLoginDetails(LoginDetails loginDetails) {
		this.loginDetails = loginDetails;
	}

}
