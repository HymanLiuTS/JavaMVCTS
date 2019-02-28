package com.cet.ibs.cloud;

import org.springframework.stereotype.Component;

public class SayHello {

	private String helloMsg = " spring boot";

	public String sayHello() {
		return "hello12" + helloMsg;
	}

	public String getHelloMsg() {
		return helloMsg;
	}

	public void setHelloMsg(String helloMsg) {
		this.helloMsg = helloMsg;
	}
}
