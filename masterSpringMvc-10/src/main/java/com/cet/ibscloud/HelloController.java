package com.cet.ibscloud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cet.ibscloud.search.LightTweets;
import com.cet.ibscloud.search.cache.SearchCache;

@Controller
public class HelloController {
	
	@Autowired
	private SearchCache searchCache;

	@RequestMapping("/")
	public String hello() {
		return "index";
	}

	@ResponseBody
	@RequestMapping("/search")
	public List<LightTweets> search(@RequestParam String searchType,@RequestParam String keyword) throws InterruptedException {
		
		return searchCache.fetch(searchType, keyword);
	}

}
