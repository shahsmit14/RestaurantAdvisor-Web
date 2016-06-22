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
@Table (name = "MessageDetails")
public class MessageDetails {

	@Id
	@GeneratedValue
	@Column(name = "MessageDetailsId")
	private long messageDetailsId;
	
	@Column(name = "MessageTitle")
	private String messageTitle;
	
	@Column(name = "MessageBody")
	private String messageBody;
	
	@Column(name = "MessageTimeStamp")
	private Date messageTimeStamp;
	
	@Column(name = "MessageStatus")
	private String messageStatus;
	
	@ManyToOne
	@JoinColumn(name = "SenderUserID")
	private LoginDetails senderLoginDetails;
	
	@ManyToOne
	@JoinColumn(name = "ReceiverUserID")
	private LoginDetails receiverLoginDetails;

	public long getMessageDetailsId() {
		return messageDetailsId;
	}

	public void setMessageDetailsId(long messageDetailsId) {
		this.messageDetailsId = messageDetailsId;
	}

	public String getMessageTitle() {
		return messageTitle;
	}

	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public Date getMessageTimeStamp() {
		return messageTimeStamp;
	}

	public void setMessageTimeStamp(Date messageTimeStamp) {
		this.messageTimeStamp = messageTimeStamp;
	}

	public String getMessageStatus() {
		return messageStatus;
	}

	public void setMessageStatus(String messageStatus) {
		this.messageStatus = messageStatus;
	}

	public LoginDetails getSenderLoginDetails() {
		return senderLoginDetails;
	}

	public void setSenderLoginDetails(LoginDetails senderLoginDetails) {
		this.senderLoginDetails = senderLoginDetails;
	}

	public LoginDetails getReceiverLoginDetails() {
		return receiverLoginDetails;
	}

	public void setReceiverLoginDetails(LoginDetails receiverLoginDetails) {
		this.receiverLoginDetails = receiverLoginDetails;
	}
	
}
