package com.example.demo.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Tweet;
import com.example.demo.domain.Twitter;

@Service
public class SearchService {

	private Twitter twitter;

	@Autowired
	public SearchService(Twitter twitter) {
		this.twitter = twitter;
	}

	public List<Tweet> search(String searchType,List<String> keywords){
		return null;
	}
}
