package com.restaurantadvisor.website.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "UserReviews")
public class UserReviews {

	@Id
	@GeneratedValue
	@Column(name = "UserReviewId")
	private long userReviewId;
	
	@Column(name = "ReviewHeadline")
	private String reviewHeadline;
	
	@Column(name = "ReviewDescription")
	private String reviewDescription;
	
	@Column(name = "Rating")
	private float rating;
	
	@Column(name = "RatingTimeStamp")
	private Date ratingTimeStamp;
	
	@ManyToOne
	@JoinColumn(name = "ReviewerUserID")
	private LoginDetails reviewerLoginDetails;
	
	@ManyToOne
	@JoinColumn(name = "ReviewedUserID")
	private LoginDetails reviewedLoginDetails;

	public long getUserReviewId() {
		return userReviewId;
	}

	public void setUserReviewId(long userReviewId) {
		this.userReviewId = userReviewId;
	}

	public String getReviewHeadline() {
		return reviewHeadline;
	}

	public void setReviewHeadline(String reviewHeadline) {
		this.reviewHeadline = reviewHeadline;
	}

	public String getReviewDescription() {
		return reviewDescription;
	}

	public void setReviewDescription(String reviewDescription) {
		this.reviewDescription = reviewDescription;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public Date getRatingTimeStamp() {
		return ratingTimeStamp;
	}

	public void setRatingTimeStamp(Date ratingTimeStamp) {
		this.ratingTimeStamp = ratingTimeStamp;
	}

	public LoginDetails getReviewerLoginDetails() {
		return reviewerLoginDetails;
	}

	public void setReviewerLoginDetails(LoginDetails reviewerLoginDetails) {
		this.reviewerLoginDetails = reviewerLoginDetails;
	}

	public LoginDetails getReviewedLoginDetails() {
		return reviewedLoginDetails;
	}

	public void setReviewedLoginDetails(LoginDetails reviewedLoginDetails) {
		this.reviewedLoginDetails = reviewedLoginDetails;
	}
	
	
}
