package org.pspf.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Message", description = "message model")
public class Message {
	
	private int code;
	private String message;
	
	public Message() {
		// TODO Auto-generated constructor stub
	}
	
	public Message(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}



	public final int getCode() {
		return code;
	}

	public final void setCode(int code) {
		this.code = code;
	}

	public final String getMessage() {
		return message;
	}

	public final void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
