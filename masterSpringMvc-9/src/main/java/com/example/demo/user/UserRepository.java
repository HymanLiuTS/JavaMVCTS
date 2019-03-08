package com.example.demo.user;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Tweet;
import com.example.demo.error.EntityNotFoundException;

@Repository
public class UserRepository {

	private final Map<String, Tweet> userMap = new ConcurrentHashMap<>();


	public Tweet save(Tweet tweet) {
		userMap.put(tweet.getName(), tweet);
		return tweet;
	}

	public Collection<Tweet> query() {
		return userMap.values();
	}

	public Tweet findOne(String name) throws EntityNotFoundException {
		if (userMap.containsKey(name) == false)
			throw new EntityNotFoundException("未找到" + name);
		return userMap.get(name);
	}

	public void reset(List<Tweet> tweets) {
		userMap.clear();
		for (Tweet tweet : tweets) {
			save(tweet);
		}
	}
}
