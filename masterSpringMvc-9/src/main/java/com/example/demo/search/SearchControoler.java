package com.example.demo.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.Tweet;

@RestController
@RequestMapping("/api/search")
public class SearchControoler implements TweetSearch {

	private TweetSearch tweetSearch;

	@Autowired
	public SearchControoler(TweetSearch tweetSearch) {
		this.tweetSearch = tweetSearch;
	}

	@RequestMapping(value = "/{searchType}", method = RequestMethod.GET)
	public List<Tweet> search(@PathVariable String searchType, @MatrixVariable List<String> keywords) {
		List<Tweet> tweets = tweetSearch.search(searchType, keywords);
		return tweets;
	}

}
