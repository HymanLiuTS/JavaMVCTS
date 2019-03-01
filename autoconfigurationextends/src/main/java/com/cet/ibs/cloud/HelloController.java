package com.cet.ibs.cloud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/login")
	public String index() {
		return "index";
	}
}
