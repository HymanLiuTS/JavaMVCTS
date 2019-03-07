package com.example.demo.authentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	@RequestMapping("/login")
	public String authenticate() {
		return "login";
	}

	@RequestMapping(value = "/loginver", method = RequestMethod.POST)
	public String login(String username,String password) {
		return "succeed";
	}

	@RequestMapping("/profile")
	@ResponseBody
	public String getProfile() {
		return "profile";
	}
}
