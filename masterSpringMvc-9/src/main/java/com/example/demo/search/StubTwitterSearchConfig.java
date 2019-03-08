package com.example.demo.search;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.demo.domain.Tweet;

@Configuration
public class StubTwitterSearchConfig {

	@Primary
	@Bean
	public TweetSearch tweetSearch() {
		return (searchType, keywords) -> Arrays.asList(new Tweet("name1"), new Tweet("name2"));
	}

}
