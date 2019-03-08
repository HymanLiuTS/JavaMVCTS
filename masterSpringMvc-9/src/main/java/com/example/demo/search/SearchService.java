package com.example.demo.search;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Tweet;
import com.example.demo.domain.Twitter;

@Service
public class SearchService implements TweetSearch{

	private Twitter twitter;

	@Autowired
	public SearchService(Twitter twitter) {
		this.twitter = twitter;
	}

	public List<Tweet> search(String searchType, List<String> keywords) {

		List<Tweet> result = new ArrayList<Tweet>();
		for (int i = 1; i <= 10; i++) {
			Tweet tweet = new Tweet();
			tweet.setId(i);
			tweet.setName("Tweet" + i);
			tweet.setAge(10 + i);
			result.add(tweet);
		}
		return result;
	}

	
}
