package com.cet.ibs.cloud.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Result {

	private Boolean succeed;

	private String message;

	private Object data;
	
	public Result() {
		
	}

	public Result(Boolean succeed, String message, Object data) {
		this.succeed = succeed;
		this.message = message;
		this.data = data;
	}

	public Boolean getSucceed() {
		return succeed;
	}

	public void setSucceed(Boolean succeed) {
		this.succeed = succeed;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
