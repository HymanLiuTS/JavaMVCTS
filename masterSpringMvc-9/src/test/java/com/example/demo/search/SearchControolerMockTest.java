package com.example.demo.search;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.domain.Tweet;

public class SearchControolerMockTest {

	@Mock
	private SearchService searchService;

	@InjectMocks
	private SearchControoler searchContrller;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(searchContrller).setRemoveSemicolonContent(false).build();
	}

	@Test
	public void should_search() {
		when(searchService.search("popular", new ArrayList<String>())).thenReturn(new ArrayList<Tweet>() {});
		this.mockMvc.perform(get("/api/search/popular;keywords=java"))
		.andExpect(status().isOk())
		.andExpect(matcher)
	}

}
