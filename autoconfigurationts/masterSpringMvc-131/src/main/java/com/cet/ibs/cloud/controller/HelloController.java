package com.cet.ibs.cloud.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import codenest.autoconfigdemo.demo.SayHello;

@Controller
public class HelloController {

	@Resource
	private SayHello sayHello;

	public SayHello getSayHello() {
		return sayHello;
	}

	public void setSayHello(SayHello sayHello) {
		this.sayHello = sayHello;
	}

	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	@ResponseBody
	public String test2() {
		String hello=this.sayHello.getHelloMsg();
		String str = this.sayHello.sayHello();
		return str;
	}
}
