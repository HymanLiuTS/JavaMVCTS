package com.cet.ibscloud.search.cache;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cet.ibscloud.search.LightTweets;

@Service
public class SearchCache {

	@Cacheable("searches")
	public List<LightTweets> fetch(String searchType, String keyword) throws InterruptedException {
		List<LightTweets> tweets = new ArrayList<LightTweets>();
		for (int i = 0; i < 10; i++) {
			LightTweets lightTweets = new LightTweets();
			Thread.sleep(1000);
			lightTweets.setName("type" + i);
			lightTweets.setAge(10 + i);
			tweets.add(lightTweets);
		}
		return tweets;
	}

}
