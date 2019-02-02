package com.example.demo.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.Tweet;

@Controller
public class SearchControoler {

	private SearchService serviceService;

	@Autowired
	public SearchControoler(SearchService serviceService) {
		this.serviceService = serviceService;
	}

	
	@RequestMapping("/search/{searchType}")
	public ModelAndView search(@PathVariable String searchType, @MatrixVariable List<String> keywords) {

		List<Tweet> tweets = serviceService.search(searchType, keywords);
		ModelAndView mav = new ModelAndView("resultPage");
		mav.addObject("tweets", tweets);
		return mav;

	}
}
