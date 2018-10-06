package com.gk.app.exception;

import java.util.Date;
//this is a standard defination of exp that is defined by me to send the exp to user whenever a exp occurs.
//i.e. this format is used to send exp to user  i.e a exp standard for entire application.
public class ExpResponse {

	//timestamp
	//message
	//failed locatioin
	
	private Date timestamp;
	private String messageToUser;
	private String locationOfFailure;
	private String stackTrace;
	public ExpResponse(Date timestamp, String messageToUser,String stackTrace, String locationOfFailure) {
		super();
		this.timestamp = timestamp;
		this.messageToUser = messageToUser;
		this.locationOfFailure = locationOfFailure;
		this.stackTrace = stackTrace;
	}
	
	public String getStackTrace() {
		return stackTrace;
	}

	public Date getTimestamp() {
		return timestamp;
	}
	public String getMessageToUser() {
		return messageToUser;
	}
	public String getLocationOfFailure() {
		return locationOfFailure;
	}
}