package com.example.demo.search;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.domain.Tweet;

public class SearchControolerMockTest {
	
	@Autowired
	private WebApplicationContext wac;

	@Mock
	private SearchService searchService;

	@InjectMocks
	private SearchControoler searchContrller;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(searchContrller).setRemoveSemicolonContent(false).build();
		//mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void should_search() throws Exception {
		List<Tweet> result = new ArrayList<Tweet>();
		for (int i = 1; i <= 10; i++) {
			Tweet tweet = new Tweet();
			tweet.setId(i);
			tweet.setName("Tweet" + i);
			tweet.setAge(10 + i);
			result.add(tweet);
		}
		
		List<String> keywords=new ArrayList<String>(){
			{
				this.add("java");
			}
		};
		
		//定义调用服务接口时的返回值
		when(searchService.search("popular", keywords)).thenReturn(result);
		//检查上面定义的返回值是否一致
		this.mockMvc.perform(get("/api/search/popular;keywords=java"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().json("[{\"name\":\"Tweet1\",\"age\":11},{\"name\":\"Tweet2\",\"age\":12},{\"name\":\"Tweet3\",\"age\":13},{\"name\":\"Tweet4\",\"age\":14},{\"name\":\"Tweet5\",\"age\":15},{\"name\":\"Tweet6\",\"age\":16},{\"name\":\"Tweet7\",\"age\":17},{\"name\":\"Tweet8\",\"age\":18},{\"name\":\"Tweet9\",\"age\":19},{\"name\":\"Tweet10\",\"age\":20}]"));
		
		verify(searchService,times(1)).search("popular", keywords);
	}

}
