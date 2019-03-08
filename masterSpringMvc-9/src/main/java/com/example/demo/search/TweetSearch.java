package com.example.demo.search;

import java.util.List;

import com.example.demo.domain.Tweet;

public interface TweetSearch {
	List<Tweet> search(String searchType, List<String> keywords);
}
